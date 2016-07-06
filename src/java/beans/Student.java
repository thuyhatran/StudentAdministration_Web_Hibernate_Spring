/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.FetchMode;
import org.hibernate.annotations.Fetch;

/**
 *
 * @author Administrator
 */



@Entity
@Table(name="STUDENT1")
public class Student implements Serializable {
    @Id                      
    private int student_id;
    
    @Column(name="first_name", length=40)
    private String first_name;
    
    @Column(name="last_name", length=40)
    private String last_name;
    
    @Column(name="gender", length=1)
    private String gender;
    
    @Column(name="start_date")
    private String start_date;
    
    @Column(name="email", length=40)
    private String email;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
   // @Fetch(FetchMode.SELECT)
    private Set<Results> results;

    
    
   //contructors

    public Student(int student_id, String first_name, String last_name, String gender, String start_date, String email) {
        this.results = new HashSet<Results>();
        this.student_id = student_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.start_date = start_date;
        this.email = email;
    }
    
      public Student(String first_name, String last_name, String gender, String start_date, String email) {
        this.results = new HashSet<Results>();
        
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.start_date = start_date;
        this.email = email;
    }

       public Student(int student_id,String first_name, String last_name) {
        this.results = new HashSet<Results>();
        this.student_id = student_id;
        this.first_name = first_name;
        this.last_name = last_name;

    }
       
      
    public Student() {
        this.results = new HashSet<Results>();
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

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    public Set<Results> getResults() {
        return results;
    }

    public void setResults(Set<Results> results) {
        this.results = results;
    }

    
    
    
    
    @Override
    public String toString() {
        return "Student{" + "student_id=" + student_id + ", first_name=" + first_name + ", last_name=" + last_name + ", gender=" + gender + ", start_date=" + start_date + ", email=" + email + '}';
    }

    
    



    
}
