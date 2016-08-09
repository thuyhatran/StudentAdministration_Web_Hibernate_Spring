/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Service.courseService;
import Service.resultService;
import Service.studentService;
import model.Course;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 *
 * @author thuyha
 */
public class CourseControllerMethods {
    //from menu
    static public void newCourseCalled(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         studentService stService = new studentService(); 
              
        int student_id = stService.getNewStudentID();
        
        System.out.println("New  Student  ID : " + student_id);

        
        courseService crsService = new courseService();
                
        int course_id = crsService.getNewCourseID();

        System.out.println("New Course ID : " + course_id);
        

       request.setAttribute("course_id", course_id);
       request.setAttribute("stid_readonly","readonly");  //set course_id field to readonly
       request.setAttribute("new_disabled", "disabled");
       request.setAttribute("insert_disabled", "");
       request.setAttribute("update_disabled", "disabled");
       request.setAttribute("search_disabled", "disabled");
       request.setAttribute("delete_disabled", "disabled");
                
               
    }
    
    
     //from menu
    static public void courseFormCalled(HttpServletRequest request, HttpServletResponse response)
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
//            Logger.getLogger(CourseControllerMethods.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        request.setAttribute("CourseIDs",CourseIDs);

        request.setAttribute("stid_readonly","");  //set course_id field to readonly
        request.setAttribute("new_disabled", "");
        request.setAttribute("insert_disabled", "disabled");
        request.setAttribute("update_disabled", "disabled");
        request.setAttribute("search_disabled", "");
        request.setAttribute("delete_disabled", "disabled");

                
   
    }
    
    
    static public void listAllCalled(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        courseService crsService = new courseService();
        
        List<Course> courses = new ArrayList<>();     
              
        courses =  crsService.select();
       
        request.setAttribute("courses", courses);
        
    }
    
    //from course_list
    
    static public void deleteCalled(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
            int course_id = Integer.parseInt(request.getParameter("course_id"));
            
            //delete all result of this course
            resultService rslSer = new resultService();
            rslSer.deleteCourse(course_id);
            
            //delete this course
            courseService crsService = new courseService();
            crsService.delete(course_id);
                      
            //Prepared for refresh page with course's list
            List<Course> courses = new ArrayList<>();
            courses =  crsService.select();
            
            request.setAttribute("courses", courses);
            
      
        
    }
    
    static public void editCalled(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            
            //Get information of the course tha has the course_id getting from course_list 
            //and then send this information to course_form to do the modification
            
            //get course's info
            int course_id = Integer.parseInt(request.getParameter("course_id"));
            courseService crsService = new courseService();            
            Course course = crsService.selectById(course_id);                
            // set attribute 
            request.setAttribute("course_id", course_id);            
            request.setAttribute("course",course); 
            request.setAttribute("id_readonly","readonly");  //set course_id field to readonly          
            
            request.setAttribute("new_disabled", "disabled");
            request.setAttribute("insert_disabled", "disabled");
            request.setAttribute("update_disabled", "");
            request.setAttribute("search_disabled", "disabled");
            request.setAttribute("delete_disabled", "");

    }
    

    //---- for doPost----
    static public void insertClicked(HttpServletRequest request, HttpServletResponse response){
        
            int course_id = Integer.parseInt(request.getParameter("course_id"));
            String course_name = request.getParameter("course_name");
         
            
            Course crs = new Course(course_id,course_name);
            System.out.println(crs);
            courseService crsDao = new courseService();
       
             crsDao.insert(crs);

            //prepared to forward to course_list
            List<Course> courses = new ArrayList<>();
            courses =  crsDao.select();
            request.setAttribute("courses", courses);
      
    }
    
    
      static public void deleteClicked(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
      
//            int course_id = Integer.parseInt(request.getParameter("course_id"));
//            
//             //delete all result of this course
////            resultService rslSer = new resultService();
////            rslSer.deleteCourse(course_id);
//            
//            //delete this course
//            courseService crsService = new courseService();
//            crsService.delete(course_id);
//
//            //prepared to forward to course_list
//            List<Course> courses = new ArrayList<>();
//            courses =  crsService.select();
//            request.setAttribute("courses", courses);

               deleteCalled(request,response);
            
            
        
            
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
//                Logger.getLogger(CourseControllerMethods.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            request.setAttribute("CourseIDs",CourseIDs);
        
        
        
        
            String st_course_id = request.getParameter("course_id");
                                 
            Course course = null;
  
            
            if (!(st_course_id.equals(""))){
                int course_id = Integer.parseInt(st_course_id);
                courseService crsService = new courseService();

                course=(Course) crsService.selectById(course_id);
                
                if (course ==null){
                    
                    //JFrame parent = new JFrame();
                    //JOptionPane.showMessageDialog(null, "Not found!");
                 
                    request.setAttribute("insert_disabled", "disabled");
                    request.setAttribute("update_disabled","disabled");
                    request.setAttribute("delete_disabled","disabled");
                    
                }else{
                            
                    request.setAttribute("course_id", course_id);
                    request.setAttribute("course", course);
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
       
            int course_id = Integer.parseInt(request.getParameter("course_id"));
            String course_name = request.getParameter("course_name");
            
            Course st = new Course(course_id,course_name);
            System.out.println(st);
            courseService crsService = new courseService();
      
             crsService.update(st);

             //prepared to forward to course_list
            List<Course> courses = new ArrayList<>();
            courses =  crsService.select();
            request.setAttribute("courses", courses);
                    
    }

}
