/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;

/**
 *
 * @author thuyha
 * Result Primary keys
 */
public class ResultsPK implements Serializable{
    protected int student_id;
    protected int course_id;

    public ResultsPK() {
    }

    public ResultsPK(int student_id, int course_id) {
        this.student_id = student_id;
        this.course_id = course_id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.student_id;
        hash = 73 * hash + this.course_id;
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
        if (this.student_id != other.student_id) {
            return false;
        }
        if (this.course_id != other.course_id) {
            return false;
        }
        return true;
    }
    
    
    
}
