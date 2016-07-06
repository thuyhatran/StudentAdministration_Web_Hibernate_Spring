/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Service.courseService;
import Service.resultService;
import beans.Course;
import beans.Results;
import daoimplement.courseDao;
import daoimplement.resultDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class ResultControllerMethods {
    
    //from menu
    static public void resultFormCalled(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //This code to create value for combobox
//        courseDao stDao = new courseDao();
//        ArrayList<Integer> CourseIDs = null;
//        
//        try {
//            
//            CourseIDs = stDao.getAllCourseID();
//            
//        } catch (SQLException | ClassNotFoundException ex) {
//            Logger.getLogger(ResultControllerMethods.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        request.setAttribute("CourseIDs",CourseIDs);

        request.setAttribute("stid_readonly","");  //set course_id field to readonly
        request.setAttribute("new_disabled", "");
        request.setAttribute("insert_disabled", "disabled");
        request.setAttribute("update_disabled", "disabled");
        request.setAttribute("search_disabled", "");
        request.setAttribute("delete_disabled", "disabled");

    }
    
    static public void newResultCalled(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

                request.setAttribute("new_disabled", "disabled");
                request.setAttribute("insert_disabled", "");
                request.setAttribute("update_disabled", "disabled");
                request.setAttribute("search_disabled", "disabled");
                request.setAttribute("delete_disabled", "disabled");
                
               
    }
    
    static public void listAllCalled(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        resultService rlsService = new resultService();
        List<Results> results = new ArrayList<>();     
        results =  rlsService.select();
        request.setAttribute("results", results);  
    }
    
    //from course_list
    
    static public void deleteCalled(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int student_id = Integer.parseInt(request.getParameter("student_id"));
        int course_id = Integer.parseInt(request.getParameter("course_id"));
        
        resultService crsService = new resultService();
        crsService.delete(student_id,course_id);
                      
        //Prepared for refresh page with result's list
        List<Results> results = new ArrayList<>();
        results =  crsService.select();

        request.setAttribute("results", results);
            
        
      
    }
    
    static public void editCalled(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
            
            //Get information of the course tha has the course_id getting from course_list 
            //and then send this information to course_form to do the modification
            
            //get course's info
            int student_id = Integer.parseInt(request.getParameter("student_id"));
            int course_id = Integer.parseInt(request.getParameter("course_id"));
            resultService rslService = new resultService();            
            Results result = rslService.selectById(student_id,course_id);                
            // set attribute 
             
            request.setAttribute("result",result); 
            request.setAttribute("id_readonly","readonly");  //set course_id field to readonly          
            
            request.setAttribute("new_disabled", "disabled");
            request.setAttribute("insert_disabled", "disabled");
            request.setAttribute("update_disabled", "");
            request.setAttribute("search_disabled", "disabled");
            request.setAttribute("delete_disabled", "");
                
            
       
        
    }

    

    //---- for doPost----
    static public void insertClicked(HttpServletRequest request, HttpServletResponse response){

            int student_id = Integer.parseInt(request.getParameter("student_id"));
            int course_id = Integer.parseInt(request.getParameter("course_id"));
            int mark1 = Integer.parseInt(request.getParameter("mark1"));
            int mark2 = Integer.parseInt(request.getParameter("mark2"));
            
         
            
            Results rsl = new Results(student_id,course_id,mark1,mark2);
            System.out.println(rsl);
            resultService rslDao = new resultService();
       
             rslDao.insert(rsl);

            //prepared to forward to course_list
            List<Results> results = new ArrayList<>();
            results =  rslDao.select();
            request.setAttribute("results", results);
         
    }
    
    
      static public void deleteClicked(HttpServletRequest request, HttpServletResponse response){

            int student_id = Integer.parseInt(request.getParameter("student_id"));
            int course_id = Integer.parseInt(request.getParameter("course_id"));
            
             //delete all result of this course
            resultService rslDao = new resultService();
            rslDao.delete(student_id,course_id);

            //prepared to forward to course_list
            List<Results> results = new ArrayList<>();
            results =  rslDao.select();
            request.setAttribute("results", results);
       
    }
    
    static public void searchClicked(HttpServletRequest request, HttpServletResponse response) {
       
        //This creates value for combobox
//            courseDao stDao_t = new courseDao();
//            ArrayList<Integer> CourseIDs = null;
//
//            try {
//
//                CourseIDs = stDao_t.getAllCourseID();
//
//            } catch (SQLException | ClassNotFoundException ex) {
//                Logger.getLogger(ResultControllerMethods.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            request.setAttribute("CourseIDs",CourseIDs);
        


        
            String st_student_id = request.getParameter("student_id");
            String st_course_id = request.getParameter("course_id");
                                 
            Results result = null;
  
            
            if (!((st_student_id.equals(""))&&(st_course_id.equals("")))){
                
                System.out.println("not null");
                int student_id = Integer.parseInt(st_student_id);
                int course_id = Integer.parseInt(st_course_id);
                resultService rslDao = new resultService();

                
                    result= rslDao.selectById(student_id,course_id);
                
                
                if (result ==null){
                    
                    //JFrame parent = new JFrame();
                    //JOptionPane.showMessageDialog(null, "Not found!");
                 
                    request.setAttribute("insert_disabled", "disabled");
                    request.setAttribute("update_disabled","disabled");
                    request.setAttribute("delete_disabled","disabled");
                    
                }else{
                            
                    //request.setAttribute("course_id", course_id);
                    request.setAttribute("result", result);
                    request.setAttribute("insert_disabled", "disabled");
                    request.setAttribute("stid_readonly","");
                }

            }else{
                 request.setAttribute("insert_disabled", "disabled");
                 request.setAttribute("update_disabled","disabled");
                 request.setAttribute("delete_disabled","disabled");
                
            }
        
            
        
        
        
    }
    
    static public void updateClicked(HttpServletRequest request, HttpServletResponse response){
        
            
            
            int student_id = Integer.parseInt(request.getParameter("student_id"));
            int course_id = Integer.parseInt(request.getParameter("course_id"));
            int mark1 = Integer.parseInt(request.getParameter("mark1"));
            int mark2 = Integer.parseInt(request.getParameter("mark2"));
 
            Results rsl = new Results(student_id,course_id,mark1,mark2);
            System.out.println(rsl);
            resultService rslDao = new resultService();
      
            rslDao.update(rsl);

             //prepared to forward to course_list
            List<Results> results = new ArrayList<>();
            results =  rslDao.select();
            request.setAttribute("results", results);
                        
                      
    }

    
}
