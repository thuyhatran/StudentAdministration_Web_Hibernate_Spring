/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import model.Course;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface courseServiceInterface {
    
    public void insert(Course entity);
	
    public void update(Course entity);
	
    public Course selectById(int id);
	
    public void delete(int id);
	
    public List<Course> select();
    
     public int getNewCourseID();
	
    public void write_to_file(String filename);
    public void insert_from_file(String filename);
    
}
