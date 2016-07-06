/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimplement;


import JDBC_Connection.JDBC_StudentConnect;
import beans.Course;
import beans.Results;
import beans.Student;
import daointerface.courseInterface;
import daointerface.daointerface;
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
public class courseDao implements courseInterface<Course>{
    
       private Session currentSession;
	
    private Transaction currentTransaction;
    
    public courseDao() {
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
    public int getNewCourseID() {    
        
        String hql = "SELECT max(course_id) FROM Course";
        Query query = getCurrentSession().createQuery(hql);
        List<Integer> Id = query.list();
        
        int curID =1;
        
        if (!(Id.get(0)==null)){
            curID = Id.get(0) +1 ;      
        }

        
        return curID;
              
    }
    
//     public ArrayList<Integer> getAllCourseID() throws SQLException, ClassNotFoundException{
//        
//        ArrayList<Integer> allCourseID = new ArrayList<>();
//        
//        int curID = 1;
//        try (Statement statement = JDBC_StudentConnect.getConnection().createStatement()) {
//            String query  = "Select course_id from course";
//            
//            try (ResultSet rslSet = statement.executeQuery(query)) {
//                while (rslSet.next()){
//                    
//                    curID = rslSet.getInt("course_id");
//                    
//                    allCourseID.add(curID);;
//                    
//                }
//                rslSet.close();
//            }
//            
//        }
//        
//        JDBC_StudentConnect.closeConnection();
//        
//        
//        return allCourseID;
//              
//    }
     

    @Override
    public void insert(Course entity) {
       
        getCurrentSession().saveOrUpdate(entity);
       
    }

    @Override
    public void update(Course entity) {
        
        getCurrentSession().saveOrUpdate(entity);
        
    }

    @Override
    public Course selectById(int id) {
       
        Course st = (Course) getCurrentSession().get(Course.class, id);
       
        return st; 
    }

    @Override
    public void delete(Course st) {        	
	getCurrentSession().delete(st);	
    }

    @Override
    public List<Course> select() {
        
        List<Course> students = (List<Course>) getCurrentSession().createQuery("from Course").list();
	
        return students;
    }
    
    
    @Override
    public void write_to_file(String filename) {
        //Get information from Database
        String query = "Select * from Course";
        try (Statement statement = JDBC_StudentConnect.getConnection().createStatement()) {
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
                    Logger.getLogger(courseDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            //write to file
            
            int course_id;
            String course_name;
            PrintWriter fout = null;
            try {
                fout = new PrintWriter( new BufferedWriter (new FileWriter(file)));
            } catch (IOException ex) {
                Logger.getLogger(courseDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (rlst.next()){
                
                course_id   = rlst.getInt("course_id");
                course_name    = rlst.getString("course_name");
                
                fout.println(course_id +","+course_name);
            }
            fout.close();
            rlst.close();
        JDBC_StudentConnect.closeConnection();
    }      catch (SQLException ex) {
               Logger.getLogger(courseDao.class.getName()).log(Level.SEVERE, null, ex);
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(courseDao.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(courseDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String line = null;
            try {
                line = fin.readLine();
            } catch (IOException ex) {
                Logger.getLogger(courseDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
             
            while (line!=null){
                //slipt line data and add fields to Person object 
                                
                String[] components = line.split(",");
                                
               
                int course_id = Integer.parseInt(components[0]);
                String course_name = components[1];    
                                          
                Course course = new Course(course_id,course_name);
                
                //insert to database
                this.insert(course);
                
                 //read next line
                try {
                    line = fin.readLine();
                } catch (IOException ex) {
                    Logger.getLogger(courseDao.class.getName()).log(Level.SEVERE, null, ex);
                }            
            }
            
            //close file
            try {                
                fin.close();
            } catch (IOException ex) {
                Logger.getLogger(courseDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.println("end of inserting");
            
        }
    }

   
}    

  
    

