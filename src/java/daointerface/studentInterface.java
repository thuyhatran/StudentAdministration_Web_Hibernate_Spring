/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daointerface;

import model.Student;
import model.StudentsGrade;
import java.util.List;

/**
 *
 * @author thuyha
 */
public interface studentInterface {
    
    public void insert(Student entity);
	
    public void update(Student entity);
	
    public Student selectById(int id);
	
    public void delete(Student entity);
    	
    public List<Student> select();
    
    public int getNewStudentID();
    
    public List<StudentsGrade> getGrades();
    public List<StudentsGrade> getTranscript(int student_id) ;
	
    public void write_to_file(String filename);
    public void insert_from_file(String filename);
    
}
