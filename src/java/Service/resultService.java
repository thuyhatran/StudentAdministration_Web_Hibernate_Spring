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
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author thuyha
 */
public class resultService implements resultServiceInterface{
    
    private static resultDao rlsDao;
    
    public resultService() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        rlsDao = context.getBean(resultDao.class);
    }
        

    @Override
    public void insert(Results entity) {
        rlsDao.insert(entity);
    }

    @Override
    public void update(Results entity) {
        rlsDao.update(entity);
    }

    @Override
    public Results selectById(int st_id, int crs_id) {
        Results st = rlsDao.selectById(st_id, crs_id);
        return st; 
    }

    @Override
    public void delete(int st_id, int crs_id) {
	Results st = rlsDao.selectById(st_id, crs_id);
	rlsDao.delete(st);

    }

    @Override
    public List<Results> select() { 
        List<Results> results = rlsDao.select();  
        return results;
    }

    @Override
    public void deleteStudent(int st_id) {
        
        List<Results> results = rlsDao.selectStudent(st_id);
        for (Results result: results ){
            System.out.println(result);
            rlsDao.delete(result);
        }        
        System.out.println("Delle all recourd of  student id=" + st_id);
    }

    @Override
    public void deleteCourse(int course_id) {

        List<Results> results = rlsDao.selectCourse(course_id);
        for (Results result: results ){
            System.out.println(result);
            rlsDao.delete(result);
        }

    }
    
        @Override
    public void write_to_file(String filename)  {
      
        rlsDao.write_to_file(filename);
       
    }

    @Override
    public void insert_from_file(String filename) {
      
        rlsDao.insert_from_file(filename);

    } 
    
    
    
}
