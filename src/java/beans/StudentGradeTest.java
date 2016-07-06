/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Administrator
 */
public class StudentGradeTest {
    private int student_id;
    private String first_name;
    private String course;
    private int mark1;
    private int mark2;

    public StudentGradeTest() {
    }

    public StudentGradeTest(int student_id, String first_name, String course, int mark1, int mark2) {
        this.student_id = student_id;
        this.first_name = first_name;
        this.course = course;
        this.mark1 = mark1;
        this.mark2 = mark2;
    }

    
    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getMark1() {
        return mark1;
    }

    public void setMark1(int mark1) {
        this.mark1 = mark1;
    }

    public int getMark2() {
        return mark2;
    }

    public void setMark2(int mark2) {
        this.mark2 = mark2;
    }
    
    
    
    
    
    
}
