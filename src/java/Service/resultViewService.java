/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import beans.Results;
import beans.Results_view;
import daoimplement.resultDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thuyha
 */
public class resultViewService implements resultViewServiceInterface{
    
    private static resultDao stDao;
    
    public resultViewService() {
        stDao = new resultDao();
    }
        
    @Override
    public Results_view selectById(int st_id, int crs_id) {
        stDao.openCurrentSession();
        Results st = stDao.selectById(st_id, crs_id);
        stDao.closeCurrentSession();
        Results_view rls_view = new Results_view(st);
        return rls_view; 
    }



    @Override
    public List<Results_view> select() {
         stDao.openCurrentSession();
        List<Results> results = stDao.select();
	stDao.closeCurrentSession();
        
        List<Results_view> results_view = new ArrayList<>();
        Results_view result_view = null;
        for (Results result:results){
                  result_view = new Results_view(result);
                  results_view.add(result_view);
        }
        return results_view;
    }

    
    
    
    
}
