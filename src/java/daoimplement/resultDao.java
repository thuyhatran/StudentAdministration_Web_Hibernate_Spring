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
import daointerface.daointerface;
import daointerface.resultsInterface;
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
public class resultDao implements resultsInterface<Results> {
    
    
       private Session currentSession;
	
    private Transaction currentTransaction;
    
    public resultDao() {
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
    public void insert(Results entity) {
       
        getCurrentSession().saveOrUpdate(entity);
       
    }

    @Override
    public void update(Results entity) {
        
        getCurrentSession().saveOrUpdate(entity);
        
    }

    @Override
    public Results selectById(int st_id, int crs_id) {
       
        //Results st = (Results) getCurrentSession().get(Results.class, st_id, crs_id);
        
        String hql = "FROM Results "
                + "where student_id = " + st_id + " and course_id = " + crs_id ;
        Query query = getCurrentSession().createQuery(hql);
        List<Results> results = query.list();
        
        Results result = null;
        
        if (!(results.get(0)==null)){
            result = results.get(0) ;      
        }

        return result; 
    }

    public List<Results> selectStudent(int st_id){
        
        String hql = "FROM Results "
                + "where student_id = " + st_id  ;
        Query query = getCurrentSession().createQuery(hql);
        List<Results> results = query.list();
                
        return results;         
    }
    
    public List<Results> selectCourse(int crs_id){
        
        String hql = "FROM Results "
                + "where course_id = " + crs_id  ;
        Query query = getCurrentSession().createQuery(hql);
        List<Results> results = query.list();
                
        return results;         
    }
    
    @Override
    public void delete(Results st) {        	
	getCurrentSession().delete(st);	
    }

    @Override
    public List<Results> select() {
        
        List<Results> results = (List<Results>) getCurrentSession().createQuery("from Results").list();
	
        return results;
    }
    
    
    

//    @Override
//    public void insert(Object ob) throws SQLException, ClassNotFoundException {
//        String query = "Insert into result (student_id, course_id, mark1, mark2) values (?,?,?,?)";
//        PreparedStatement preStatement = JDBC_StudentConnect.getConnection().prepareStatement(query);
//        preStatement.setInt(1, ((Results)ob).getStudent_id());
//        preStatement.setInt(2, ((Results)ob).getCourse_id());   
//        preStatement.setInt(3, ((Results)ob).getMark1());   
//        preStatement.setInt(4, ((Results)ob).getMark2());   
//        
//        preStatement.executeUpdate();
//        preStatement.close();
//        JDBC_StudentConnect.closeConnection();
//    }
//
//    //Delete many rows based on student_id pr course_id
//    //col_name must be "student_id" or "course_id"
//    public void delete(int id, String col_name) throws SQLException, ClassNotFoundException {
//        String query = "delete from result where " + col_name +" = " + id;
//        try (Statement statement = JDBC_StudentConnect.getConnection().createStatement()) {
//            statement.executeUpdate(query);
//        }
//        JDBC_StudentConnect.closeConnection();
//    }
//      
//    //Delete one row
//    public void delete(int student_id, int course_id) throws SQLException, ClassNotFoundException {
//        String query = "delete from result where student_id = " + student_id +" and course_id=" + course_id;
//        try (Statement statement = JDBC_StudentConnect.getConnection().createStatement()) {
//            statement.executeUpdate(query);
//        }
//        JDBC_StudentConnect.closeConnection();
//    }
//    
//   
//    
//    @Override
//    public void update(Object ob) throws SQLException, ClassNotFoundException {
//         String query = "Update result set mark1 = ?, set mark2 =? "
//                        + " where student_id = ? and course_id =?";
//        
//        try (PreparedStatement preStatement = JDBC_StudentConnect.getConnection().prepareStatement(query)) {
//            preStatement.setInt(1, ((Results)ob).getMark1());
//            preStatement.setInt(2, ((Results)ob).getMark2());
//            
//            preStatement.setInt(3, ((Results)ob).getStudent_id());
//            preStatement.setInt(4, ((Results)ob).getCourse_id());
//            
//            
//            preStatement.executeUpdate();
//        }
//        JDBC_StudentConnect.closeConnection();
//    }
//
//    @Override
//    public List<Object> select() throws SQLException, ClassNotFoundException {
//        
//         List<Results> results = new ArrayList<>();
//        Statement statement = JDBC_StudentConnect.getConnection().createStatement();
//        String query = "Select * "
//                + " from result order by student_id";
//        ResultSet rslSet = statement.executeQuery(query);
//        Results rls = null;
//        while (rslSet.next()){
//            rls = new Results();
//            rls.setStudent_id(rslSet.getInt("student_id"));
//            rls.setCourse_id(rslSet.getInt("course_id"));
//            rls.setMark1(rslSet.getInt("mark1"));
//            rls.setMark2(rslSet.getInt("mark2"));
//            
//            results.add(rls);            
//        }
//        
//        rslSet.close();
//        statement.close();
//        JDBC_StudentConnect.closeConnection();
//        return (List<Object>)(Object)results;
//    }
//
//     @Override
//    public Object selectById(int id) throws SQLException, ClassNotFoundException {
//        throw new UnsupportedOperationException("Don't need this"); //To change body of generated methods, choose Tools | Templates.
//    }
//    
//    
//    public Object selectById(int student_id, int course_id) throws SQLException, ClassNotFoundException {
//         Results rls=null;
//        try (Statement statement = JDBC_StudentConnect.getConnection().createStatement()) {
//            String query  = "Select student_id, course_id, mark1, mark2 "
//                    + "from result where student_id = " +student_id +" and course_id = "+course_id;
//            ResultSet rslSet = statement.executeQuery(query);
//            
//            while (rslSet.next()){
//                rls = new Results();
//                rls.setStudent_id(rslSet.getInt("student_id"));
//                rls.setCourse_id(rslSet.getInt("course_id"));  
//                rls.setMark1(rslSet.getInt("mark1")); 
//                rls.setMark2(rslSet.getInt("mark2")); 
//               
//            }
//            
//            rslSet.close();
//        }
//        JDBC_StudentConnect.closeConnection();
//        return rls;
//    }
//
//    @Override
//    public void write_to_file(String filename) throws SQLException, ClassNotFoundException {
//        //Get information from Database
//        String query = "Select * from result";
//        Statement statement = JDBC_StudentConnect.getConnection().createStatement();
//        ResultSet rlst =  statement.executeQuery(query);
//        
//        //Create a file       
//        File file = new File(filename);
//        if (!file.exists()){
//            File citydir = new File(file.getParent());
//            if (!citydir.exists())
//                citydir.mkdirs();
//            
//            try {
//                file.createNewFile();
//            } catch (IOException ex) {
//                Logger.getLogger(resultDao.class.getName()).log(Level.SEVERE, null, ex);
//            }         
//        }
//        
//        //write to file
//        int student_id;
//        int course_id;
//        int mark1;
//        int mark2;
//
//        PrintWriter fout = null;
//        
//        try {
//            fout = new PrintWriter( new BufferedWriter (new FileWriter(file)));
//        } catch (IOException ex) {
//            Logger.getLogger(resultDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//                
//        while (rlst.next()){
//            student_id  = rlst.getInt("student_id");
//            course_id   = rlst.getInt("course_id");
//            mark1      = rlst.getInt("mark1");
//            mark2      = rlst.getInt("mark2");
//         
//            fout.println(student_id+","+course_id +","+mark1+","+mark2);               
//        }
//       
//        fout.close();
//        rlst.close();
//        statement.close();
//        JDBC_StudentConnect.closeConnection();
//    }
//
//    @Override
//    public void insert_from_file(String filename) throws SQLException, ClassNotFoundException {
//       File file = new File(filename);
//       BufferedReader fin = null;
//        
//        if (!file.exists()){
//            System.out.println("File not exists!");
//        }else{
//            System.out.println("Insert data from file ....");
//            
//            try {
//                fin = new BufferedReader( new FileReader(file));
//            } catch (FileNotFoundException ex) {
//                Logger.getLogger(resultDao.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            
//            String line = null;
//            try {
//                line = fin.readLine();
//            } catch (IOException ex) {
//                Logger.getLogger(resultDao.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            
//             
//            while (line!=null){
//                //slipt line data and add fields to Person object 
//                                
//                String[] components = line.split(",");
//                                
//                int student_id = Integer.parseInt(components[0]);
//                int course_id = Integer.parseInt(components[1]);
//                int mark1 = Integer.parseInt(components[2]);    
//                int mark2 = Integer.parseInt(components[3]);
//
//                              
//                Results rls = new Results(student_id,course_id,mark1,mark2);
//                
//                //insert to database
//                this.insert(rls);
//                
//                 //read next line
//                try {
//                    line = fin.readLine();
//                } catch (IOException ex) {
//                    Logger.getLogger(resultDao.class.getName()).log(Level.SEVERE, null, ex);
//                }            
//            }
//            
//            //close file
//            try {                
//                fin.close();
//            } catch (IOException ex) {
//                Logger.getLogger(resultDao.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            
//            System.out.println("end of inserting");
//            
//        }
//    }
//
//    @Override
//    public void write_to_BinaryFile(String filename) throws SQLException, ClassNotFoundException {
//         try {
//            String query = "Select * from Result";
//            Statement statement = JDBC_StudentConnect.getConnection().createStatement();
//            ResultSet rlst =  statement.executeQuery(query);
//            
//            //Create a file
//            File file = new File(filename);
//            if (!file.exists()){
//                File citydir = new File(file.getParent());
//                if (!citydir.exists())
//                    citydir.mkdirs();
//                
//                try {
//                    file.createNewFile();
//                } catch (IOException ex) {
//                    Logger.getLogger(resultDao.class.getName()).log(Level.SEVERE, null, ex);
//                }                
//            }
//                                        
//            //write to file
//            int student_id; 
//            int course_id;
//            int mark1;
//            int mark2; 
//            DataOutputStream fout = null;
//            
//            try {
//                fout = new DataOutputStream(
//                        new BufferedOutputStream(
//                                new FileOutputStream(file)));
//            } catch (IOException ex) {
//                Logger.getLogger(resultDao.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            
//            while (rlst.next()){
//                try {
//                    
//                    student_id = rlst.getInt("student_id");
//                    course_id = rlst.getInt("course_id");
//                    mark1 = rlst.getInt("mark1");
//                    mark2 = rlst.getInt("mark2");
//                  
//                    fout.writeInt(student_id);
//                    fout.writeInt(course_id);
//                    fout.writeInt(mark1);
//                    fout.writeInt(mark2);
//                    
//                } catch (IOException ex) {
//                    Logger.getLogger(resultDao.class.getName()).log(Level.SEVERE, null, ex);
//                }                
//            }
//            
//            fout.close();
//            rlst.close();
//            statement.close();
//            JDBC_StudentConnect.closeConnection();
//        } catch (IOException ex) {
//            Logger.getLogger(resultDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    @Override
//    public void delete(int id) throws SQLException, ClassNotFoundException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

  

    
    
}
