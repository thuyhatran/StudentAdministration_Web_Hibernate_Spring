/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daointerface;

import java.util.List;

/**
 *
 * @author thuyha
 */
public interface resultsInterface<T> {
    
    public void insert(T entity);
	
    public void update(T entity);
	
    public T selectById(int st_id, int crs_id);
	
    public void delete(T entity);
    	
    public List<T> select();
    
    public void write_to_file(String filename);
    public void insert_from_file(String filename);
    
}
