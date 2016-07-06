/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimplement;

import JDBC_Connection.JDBC_StudentConnect;
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
    
    @Override
    public void insert(Student entity) {      
        getCurrentSession().saveOrUpdate(entity);     
    }

    @Override
    public void update(Student entity) {       
        getCurrentSession().saveOrUpdate(entity);       
    }

    @Override
    public Student selectById(int id) {   
        Student st = (Student) getCurrentSession().get(Student.class, id);    
        return st; 
    }

    @Override
    public void delete(Student st) {        	
	getCurrentSession().delete(st);	
    }

    @Override
    public List<Student> select() {
        List<Student> students = (List<Student>) getCurrentSession().createQuery("from Student").list();
        return students;
    }
    
    
    
    
    
    @Override
    public void write_to_file(String filename)  {
        try {
            //Get information from Database
            String query = "Select student_id, first_name, last_name, gender, to_char(start_date,'DD-MM-YYYY'), email from student";
            Statement statement = JDBC_StudentConnect.getConnection().createStatement();
            ResultSet rlst =  statement.executeQuery(query);
            
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
            int id;
            String firstname;
            String lastname;
            String gender;
            String startdate, email;
            PrintWriter fout = null;
            
            try {
                fout = new PrintWriter( new BufferedWriter (new FileWriter(file)));
            } catch (IOException ex) {
                Logger.getLogger(studentDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            while (rlst.next()){
                id          = rlst.getInt("student_id");
                firstname   = rlst.getString("first_name");
                lastname    = rlst.getString("last_name");
                gender      = rlst.getString("gender");
                startdate   = rlst.getString("to_char(start_date,'DD-MM-YYYY')");
                email   = rlst.getString("email");
                fout.println(id+","+firstname +","+lastname+","+gender+","+startdate+","+email);
            }
            
            fout.close();
            rlst.close();
            statement.close();
            JDBC_StudentConnect.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(studentDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(studentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
