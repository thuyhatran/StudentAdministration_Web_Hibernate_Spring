/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import model.Results;
import model.Results_view;
import daoimplement.resultDao;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author thuyha
 */
public class resultViewService implements resultViewServiceInterface{
    
    private static resultDao rlsDao;
    
    public resultViewService() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        rlsDao = context.getBean(resultDao.class);
    }
        
    @Override
    public Results_view selectById(int st_id, int crs_id) {
  
        Results st = rlsDao.selectById(st_id, crs_id);
        Results_view rls_view = new Results_view(st);
        return rls_view; 
    }



    @Override
    public List<Results_view> select() {
        List<Results> results = rlsDao.select();
        
        List<Results_view> results_view = new ArrayList<>();
        Results_view result_view = null;
        for (Results result:results){
                  result_view = new Results_view(result);
                  results_view.add(result_view);
        }
        return results_view;
    }

}
