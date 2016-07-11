/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 *
 * @author thuyha
 * This class presents Result Primary keys
 */
@Embeddable
public class ResultsPK implements Serializable{
//    protected int student_id;
//    protected int course_id;

    private Student student;
    private Course course;

//    public ResultsPK(int student_id, int course_id){
//         this.student = new Student(student_id);
//        this.course = new Course(course_id);
//    }
//    
//    public ResultsPK(){
//       
//    }
    
//
//    public ResultsPK(Student student, Course course) {
//        this.student = student;
//        this.course = course;
//    }

   
    
    
    
    @ManyToOne
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @ManyToOne
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.student);
        hash = 97 * hash + Objects.hashCode(this.course);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ResultsPK other = (ResultsPK) obj;
        if (!Objects.equals(this.student, other.student)) {
            return false;
        }
        if (!Objects.equals(this.course, other.course)) {
            return false;
        }
        return true;
    }
    
   
    
    
    
}
