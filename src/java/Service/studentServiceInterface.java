/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import beans.Student;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface studentServiceInterface {
    
    public void insert(Student entity);
	
    public void update(Student entity);
	
    public Student selectById(int id);
	
    public void delete(int id);
	
    public List<Student> select();
    
    public int getNewStudentID();
	
    public void write_to_file(String filename);
    public void insert_from_file(String filename);
    
}
