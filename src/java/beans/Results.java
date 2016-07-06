/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Administrator
 */

@Entity
@Table(name="RESULTS1")
public class Results implements Serializable {

    
    @Id
    private int student_id;
    
//    @ManyToOne
//    @JoinColumn(name = "student_id")
//    private Student student;
    
       
    @Id
    private int course_id;
    
//    @ManyToOne
//    @JoinColumn(name = "course_id")
//    private Course course;
    
    
    @Column(name = "mark1")  
    private int mark1;
    @Column(name = "mark2")
    private int mark2;

    public Results() {
    }

//    public Results(int student_id, int course_id, int marks1, int marks2) {
//        student.setStudent_id(student_id); 
//        course.setCourse_id(course_id);
//        this.mark1 = marks1;
//        this.mark2 = marks2;
//    }

    public Results(int student_id, int course_id, int mark1, int mark2) {
        this.student_id = student_id;
        this.course_id = course_id;
        this.mark1 = mark1;
        this.mark2 = mark2;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }
    
    
    

//    public void setStudent_id(int student_id) {
//        student.setStudent_id(student_id); 
//    }
//
//    public void setCourse_id(int course_id) {
//        course.setCourse_id(course_id);
//    }

    public void setMark1(int marks1) {
        this.mark1 = marks1;
    }

    public void setMark2(int marks2) {
        this.mark2 = marks2;
    }

    //Getters
//    public int getStudent_id() {
//        return student.getStudent_id();
//    }
//
//    public int getCourse_id() {
//        return course.getCourse_id();
//    }

    public int getStudent_id() {
        return student_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public int getMark1() {
        return mark1;
    }

    public int getMark2() {
        return mark2;
    }

    
//    public Student getStudent() {
//        return student;
//    }
//
//    public void setStudent(Student student) {
//        this.student = student;
//    }
//
//    public Course getCourse() {
//        return course;
//    }
//
//    public void setCourse(Course course) {
//        this.course = course;
//    }

    @Override
    public String toString() {
        return "Results{" + "student_id=" + student_id + ", course_id=" + course_id + ", mark1=" + mark1 + ", mark2=" + mark2 + '}';
    }
    


    
    
    
}
