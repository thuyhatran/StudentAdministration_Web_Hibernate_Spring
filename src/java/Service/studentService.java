/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import JDBC_Connection.JDBC_StudentConnect;
import beans.Student;
import daoimplement.studentDao;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;

/**
 *
 * @author Administrator
 */
public class studentService implements studentServiceInterface{
    
    private static studentDao stDao;

    public studentService() {
        stDao = new studentDao();
    }
    
  @Override
    public void insert(Student entity) {
        stDao.openCurrentSessionwithTransaction();
        stDao.insert(entity);
        stDao.closeCurrentSessionwithTransaction();
    }

    @Override
    public void update(Student entity) {
        stDao.openCurrentSessionwithTransaction();
        stDao.update(entity);
        stDao.closeCurrentSessionwithTransaction();  
    }

    @Override
    public Student selectById(int id) {
        stDao.openCurrentSession();
        Student st = stDao.selectById(id);
        stDao.closeCurrentSession();
        return st; 
    }

    @Override
    public void delete(int id) {
        stDao.openCurrentSessionwithTransaction();
	Student st = stDao.selectById(id);
	stDao.delete(st);
	stDao.closeCurrentSessionwithTransaction();
    }

    @Override
    public List<Student> select() {
        stDao.openCurrentSession();
        List<Student> students = stDao.select();
	stDao.closeCurrentSession();
        return students;
    }
    
     @Override
    public int getNewStudentID() {
        
        stDao.openCurrentSession();
        int curID = stDao.getNewStudentID();
        stDao.closeCurrentSession();
        
        return curID;    
    }
    
    
    @Override
    public void write_to_file(String filename)  {
       
    }

    @Override
    public void insert_from_file(String filename) {
     
    } 

   
    
    
    
         
}
