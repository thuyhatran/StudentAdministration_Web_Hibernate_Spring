/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimplement;

import beans.Student;
import beans.StudentsGrade;
import daointerface.daointerface;
import daointerface.studentInterface;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Administrator
 */

public class studentDao implements studentInterface {
    
    private Session currentSession;
	
    private Transaction currentTransaction;
    
    public studentDao() {
    }

    public Session openCurrentSession() {
        currentSession = HibernateUtil.getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionwithTransaction() {
        currentSession = HibernateUtil.getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }
    
    //Get new Student_id to create new Student row
    @Override
    public int getNewStudentID() {    
        
        String hql = "SELECT max(student_id) FROM Student";
        Query query = getCurrentSession().createQuery(hql);
        List<Integer> Id = query.list();
        
        int curID =1;
        
        if (!(Id.get(0)==null)){
            curID = Id.get(0) +1 ;      
        }
        
        return curID;          
    }
    
    // Insert new Student : entity
    @Override
    public void insert(Student entity) {      
        getCurrentSession().saveOrUpdate(entity);     
    }

    // update student that has student_id  = id
    @Override
    public void update(Student entity) {       
        getCurrentSession().saveOrUpdate(entity);       
    }

    //Select student that has student_id = id
    @Override
    public Student selectById(int id) {   
        Student st = (Student) getCurrentSession().get(Student.class, id);    
        return st; 
    }

    // Delete student st
    @Override
    public void delete(Student st) {        	
	getCurrentSession().delete(st);	
    }
    //Select all Student information in STudent table
    @Override
    public List<Student> select() {
        List<Student> students = (List<Student>) getCurrentSession().createQuery("from Student").list();
        return students;
    }
    

  
    
      //Method for student only
    //Get all Grade of students
    @Override
     public List<StudentsGrade> getGrades() {
        List<StudentsGrade> stdGrad_list;
       
        String hql = "Select st.student_id,st.first_name,st.last_name, st.gender, "
                + "crs.course_name, rls.mark1, rls.mark2 "
                + "from Student as st left join st.results as rls left join rls.pk.course as crs" ;
      
        Query query = getCurrentSession().createQuery(hql);  
        List<Object[]> studentGrades = query.list();

       
        StudentsGrade stdGrad = null;
        stdGrad_list = new ArrayList<StudentsGrade>();
                 
       
        for (Object[] obj:studentGrades){
            int student_id = (int)obj[0];
            String first_name =  (String) obj[1];
            String last_name =  (String) obj[2];
            String gender = (String) obj[3];
            
             if ((obj[4]==null )||(obj[5]==null)||(obj[6]==null)){
                stdGrad = new StudentsGrade(student_id,first_name,last_name,gender);
            }else{
                String course_name = (String)obj[4];
                int  mark1 = (int) obj[5];
                int  mark2 = (int) obj[6];
                stdGrad = new StudentsGrade(student_id,first_name,last_name,gender,course_name,mark1,mark2 );
                stdGrad.CaculateGrade();
            }

            stdGrad_list.add(stdGrad);
                             
        }
         

        return stdGrad_list;
        
    }
     
     //Get Transcript of student that has student_id  = student_id
    @Override
      public List<StudentsGrade> getTranscript(int student_id)  {
          List<StudentsGrade> stdGrad_list;
       
        String hql = "Select st.student_id,st.first_name,st.last_name, st.gender, "
                + "crs.course_name, rls.mark1, rls.mark2 "
                + "from Student as st left join st.results as rls left join rls.pk.course as crs"
                + " where st.student_id = " + student_id ;
      
        Query query = getCurrentSession().createQuery(hql);  
        List<Object[]> studentGrades = query.list();

       
        StudentsGrade stdGrad = null;
        stdGrad_list = new ArrayList<StudentsGrade>();
                 
       
        for (Object[] obj:studentGrades){
           // int student_id = (int)obj[0];
            String first_name =  (String) obj[1];
            String last_name =  (String) obj[2];
            String gender = (String) obj[3];
            
            if ((obj[4]==null )||(obj[5]==null)||(obj[6]==null)){
                stdGrad = new StudentsGrade(student_id,first_name,last_name,gender);
            }else{
                String course_name = (String)obj[4];
                int  mark1 = (int) obj[5];
                int  mark2 = (int) obj[6];
                stdGrad = new StudentsGrade(student_id,first_name,last_name,gender,course_name,mark1,mark2 );
                stdGrad.CaculateGrade();
            }
            

            stdGrad_list.add(stdGrad);
                             
        }

        return stdGrad_list;   
    }
  
      //Write all data of Student Table to a text file named filename
      @Override
        public void write_to_file(String filename)  {
                
            //Create a file
            File file = new File(filename);
            if (!file.exists()){
                File citydir = new File(file.getParent());
                if (!citydir.exists())
                    citydir.mkdirs();
                
                try {
                    file.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(studentDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            //write to file
            PrintWriter fout = null;
            
            try {
                fout = new PrintWriter( new BufferedWriter (new FileWriter(file)));
            } catch (IOException ex) {
                Logger.getLogger(studentDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
              //Get information from Database
            
                       
            String hql = "SELECT st FROM Student st";
            Query query = getCurrentSession().createQuery(hql);
            List<Student> students = query.list();
            
            
            for (Student st:students){
                int id          = st.getStudent_id();
                String firstname   = st.getFirst_name();
                String lastname    = st.getLast_name();
                String gender      = st.getGender();
                String startdate   = st.getStart_date();
                String email   = st.getEmail();
                
                fout.println(id+","+firstname +","+lastname+","+gender+","+startdate+","+email);
            }
            
            fout.close();
            
    }
      
      
    //Import all data of Course Table from a text file named filename

    @Override
    public void insert_from_file(String filename) {
       File file = new File(filename);
       BufferedReader fin = null;
        
        if (!file.exists()){
            System.out.println("File not exists!");
        }else{
            System.out.println("Insert data from file ....");
            
            try {
                fin = new BufferedReader( new FileReader(file));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(studentDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String line = null;
            try {
                line = fin.readLine();
            } catch (IOException ex) {
                Logger.getLogger(studentDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
             
            while (line!=null){
                //slipt line data and add fields to Person object 
                                
                String[] components = line.split(",");
                                
                int student_id = Integer.parseInt(components[0]);
                String first_name = components[1];
                String last_name = components[2];    
                String gender = components[3];
                String start_date = components[4];
                String email = components[5];
                              
                Student std = new Student(student_id,first_name,last_name,gender,start_date,email);
                
                System.out.println("Student import: " + std);
                //insert to database
                this.insert(std);
                
                 //read next line
                try {
                    line = fin.readLine();
                } catch (IOException ex) {
                    Logger.getLogger(studentDao.class.getName()).log(Level.SEVERE, null, ex);
                }            
            }
            
            //close file
            try {                
                fin.close();
            } catch (IOException ex) {
                Logger.getLogger(studentDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.println("end of inserting");
            
        }
    } 
    
    
    
         
    
}
