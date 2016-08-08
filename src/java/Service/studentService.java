/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;


import beans.Student;
import beans.StudentsGrade;
import daoimplement.studentDao;
import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Administrator
 */
public class studentService implements studentServiceInterface{
    
    private static studentDao stDao;

    public studentService() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        stDao = context.getBean(studentDao.class);
    }
    
  @Override
    public void insert(Student entity) {
        stDao.insert(entity);
    }

    @Override
    public void update(Student entity) {
        stDao.update(entity);
    }

    @Override
    public Student selectById(int id) {
        Student st = stDao.selectById(id);
        return st; 
    }

    @Override
    public void delete(int id) {
	Student st = stDao.selectById(id);
	stDao.delete(st);
    }

    @Override
    public List<Student> select() {
        List<Student> students = stDao.select();
        return students;
    }
    
     @Override
    public int getNewStudentID() {
        int curID = stDao.getNewStudentID();
        return curID;    
    }

    
    @Override
    public void write_to_file(String filename)  {
        stDao.write_to_file(filename);
    }

    @Override
    public void insert_from_file(String filename) {
        stDao.insert_from_file(filename);
    } 

    @Override
    public List<StudentsGrade> getGrades() {
        List<StudentsGrade> student_Grades = stDao.getGrades();
        return student_Grades;
    }

    @Override
    public List<StudentsGrade> getTranscript(int student_id) {
        List<StudentsGrade> student_Grades = stDao.getTranscript(student_id);
        return student_Grades;
    }
         
}
