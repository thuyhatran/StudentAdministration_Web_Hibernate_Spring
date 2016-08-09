/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import model.Results;
import model.Results_view;
import java.util.List;

/**
 *
 * @author thuyha
 */
public interface resultViewServiceInterface {
 
	
    public Results_view selectById(int st_id, int crs_id);
	
 
    
    public List<Results_view> select();
    
    
    
    
}
