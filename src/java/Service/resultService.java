/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import beans.Course;
import beans.Results;
import beans.Student;
import daoimplement.resultDao;
import java.util.List;

/**
 *
 * @author thuyha
 */
public class resultService implements resultServiceInterface{
    
    private static resultDao stDao;
    
    public resultService() {
        stDao = new resultDao();
    }
        

    @Override
    public void insert(Results entity) {
        stDao.openCurrentSessionwithTransaction();
        stDao.insert(entity);
        stDao.closeCurrentSessionwithTransaction();
        
        
        
         
        
        
    }

    @Override
    public void update(Results entity) {
        stDao.openCurrentSessionwithTransaction();
        stDao.update(entity);
        stDao.closeCurrentSessionwithTransaction();  
    }

    @Override
    public Results selectById(int st_id, int crs_id) {
        stDao.openCurrentSession();
        Results st = stDao.selectById(st_id, crs_id);
        stDao.closeCurrentSession();
        return st; 
    }

    @Override
    public void delete(int st_id, int crs_id) {
         stDao.openCurrentSessionwithTransaction();
	Results st = stDao.selectById(st_id, crs_id);
	stDao.delete(st);
	stDao.closeCurrentSessionwithTransaction();
    }

    @Override
    public List<Results> select() {
         stDao.openCurrentSession();
        List<Results> results = stDao.select();
	stDao.closeCurrentSession();
        
        return results;
    }

    @Override
    public void deleteStudent(int st_id) {
        stDao.openCurrentSessionwithTransaction();
        List<Results> results = stDao.selectStudent(st_id);
        for (Results result: results ){
            System.out.println(result);
            stDao.delete(result);
        }
	stDao.closeCurrentSessionwithTransaction();
        
        System.out.println("Delle all recourd of  student id=" + st_id);
    }

    @Override
    public void deleteCourse(int course_id) {
        
        stDao.openCurrentSessionwithTransaction();
        List<Results> results = stDao.selectCourse(course_id);
        for (Results result: results ){
            System.out.println(result);
            stDao.delete(result);
        }
	stDao.closeCurrentSessionwithTransaction();
        
    }
    
        @Override
    public void write_to_file(String filename)  {
        stDao.openCurrentSession();
        stDao.write_to_file(filename);
        stDao.closeCurrentSession();  
        
       
    }

    @Override
    public void insert_from_file(String filename) {
        stDao.openCurrentSessionwithTransaction();
        stDao.insert_from_file(filename);
        stDao.closeCurrentSessionwithTransaction(); 
     
    } 
    
    
    
}
