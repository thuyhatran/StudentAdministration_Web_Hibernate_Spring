/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;


import beans.Course;
import daoimplement.courseDao;
import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Administrator
 */
public class courseService implements courseServiceInterface{
    
    private static courseDao crsDao;

    public courseService() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        crsDao = context.getBean(courseDao.class);
    }
    
  @Override
    public void insert(Course entity) {
        
        crsDao.insert(entity);
      
    }

    @Override
    public void update(Course entity) {
       
        crsDao.update(entity);
       
    }

    @Override
    public Course selectById(int id) {
       
        Course st = (Course) crsDao.selectById(id);
     
        return st; 
    }

    @Override
    public void delete(int id) {
       
	Course st = crsDao.selectById(id);
	crsDao.delete(st);
	
    }

    @Override
    public List<Course> select() {
       
        List<Course> course = crsDao.select();
	
        return course;
    }
    
       @Override
    public int getNewCourseID() {
        
       
        int curID = crsDao.getNewCourseID();
       
        
        return curID;
        
    }
    
    @Override
    public void write_to_file(String filename)  {
        
        crsDao.write_to_file(filename);
      
       
    }

    @Override
    public void insert_from_file(String filename) {
        
        crsDao.insert_from_file(filename);
        
     
    } 
    
    
}
