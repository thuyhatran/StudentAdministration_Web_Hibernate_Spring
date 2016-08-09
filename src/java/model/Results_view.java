/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Thuy Ha
 * This class is created to have a compatible with current VIEW (JSPs file)
 */
public class Results_view {
    private int student_id;
    private int course_id;
    private int mark1;
    private int mark2;

    public Results_view() {
    }
    
    public Results_view(int student_id, int course_id, int marks1, int marks2) {
        this.student_id = student_id;
        this.course_id = course_id;
        this.mark1 = marks1;
        this.mark2 = marks2;
    }
    
    public Results_view(Results result){
        this.student_id = result.getStudent().getStudent_id();
        this.course_id = result.getCourse().getCourse_id();
        this.mark1 = result.getMark1();
        this.mark2 = result.getMark2();
    }
    
    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public void setMark1(int marks1) {
        this.mark1 = marks1;
    }

    public void setMark2(int marks2) {
        this.mark2 = marks2;
    }

    //Getters
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
    
    public void copyFromResults(Results result){
        this.student_id = result.getStudent().getStudent_id();
        this.course_id = result.getCourse().getCourse_id();
        this.mark1 = result.getMark1();
        this.mark2 = result.getMark2();
    }
    
    
    
}
