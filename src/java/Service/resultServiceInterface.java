/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import beans.Results;
import java.util.List;

/**
 *
 * @author thuyha
 */
public interface resultServiceInterface {
    
    public void insert(Results entity);
	
    public void update(Results entity);
	
    public Results selectById(int st_id, int crs_id);
	
    public void delete(int st_id, int crs_id);
    
    public void deleteStudent(int id);
    public void deleteCourse(int id);
    
    public List<Results> select();
    
    public void write_to_file(String filename);
    public void insert_from_file(String filename);
    
}
