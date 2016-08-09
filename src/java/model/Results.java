/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Thuy Ha
 */

@Entity
@Table(name="RESULTS1")
@AssociationOverrides({
		@AssociationOverride(name = "pk.student", 
			joinColumns = @JoinColumn(name = "student_id")),
		@AssociationOverride(name = "pk.course", 
			joinColumns = @JoinColumn(name = "course_id")) })
public class Results implements Serializable {

    private ResultsPK pk = new ResultsPK();
    
    private int mark1;
    private int mark2;

    public Results() {
    }

    public Results(int mark1, int mark2) {
        this.mark1 = mark1;
        this.mark2 = mark2;
    }

    
    @EmbeddedId
    public ResultsPK getPk() {
        return pk;
    }

    public void setPk(ResultsPK pk) {
        this.pk = pk;
    }
    
    @Transient
    public Student getStudent() {
            return getPk().getStudent();
    }

    public void setStudent(Student student) {
            getPk().setStudent(student);
    }

    @Transient
    public Course getCourse() {
            return getPk().getCourse();
    }

    public void setCourse(Course course) {
            getPk().setCourse(course);
    }
    
    @Column(name = "mark1")
    public int getMark1() {
        return mark1;
    }

    public void setMark1(int mark1) {
        this.mark1 = mark1;
    }

    @Column(name = "mark2")
    public int getMark2() {
        return mark2;
    }

    public void setMark2(int mark2) {
        this.mark2 = mark2;
    }

    @Override
    public String toString() {
        return "Results{" + "pk= (" + pk.getStudent().getStudent_id()+ pk.getCourse().getCourse_id()+ ") , mark1=" + mark1 + ", mark2=" + mark2 + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.pk);
        hash = 37 * hash + this.mark1;
        hash = 37 * hash + this.mark2;
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
        final Results other = (Results) obj;
        if (this.mark1 != other.mark1) {
            return false;
        }
        if (this.mark2 != other.mark2) {
            return false;
        }
        if (!Objects.equals(this.pk, other.pk)) {
            return false;
        }
        return true;
    }
    

   

    
    
    
    
    

}