/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author thuyha
 * this class presents the grade of students
 */
public class StudentsGrade {
     private int student_id;
    private String first_name;
    private String last_name;
    private String gender;
    private String course;
    private int mark1;
    private int mark2;
    private char grade;



    public StudentsGrade() {
    }

    public StudentsGrade(int student_id, String first_name, String last_name, String gender, String course, int mark1, int mark2, char grade) {
        this.student_id = student_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.course = course;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.grade = grade;
    }
    
    
    
    public StudentsGrade(int student_id, String first_name, String last_name, String gender, String course, int mark1, int mark2) {
        this.student_id = student_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.course = course;
        this.mark1 = mark1;
        this.mark2 = mark2;
    }

    

    
    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
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

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }
    
      
   //This methode calculates the note based on the 2 marks 
   public void CaculateGrade(){
       
        //Calculate the average
        double avg = (double)(mark1+ mark2)/2;
        //Calculate the note
        char note;
        if (avg <40)         //if     avg of 2 marks <40 then note = E 
            note = 'E';      
        else if (avg <60)   //if 40=<avg of 2 marks <60 then note = D
            note = 'D';
        else if (avg<70)    //if 60=<avg of 2 marks <70 then note = C
            note = 'C';
        else if (avg<90)    //if 70=<avg of 2 marks <90 then note = B
            note = 'B';
        else
            note = 'A';     //if   avg of 2 marks >=90 then note = A
        
        this.grade = note;
    }
        
}
