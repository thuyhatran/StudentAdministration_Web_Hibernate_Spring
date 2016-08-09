/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Service.resultService;
import Service.studentService;
import model.Student;
import model.StudentsGrade;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//for email send
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;


/**
 *
 * @author thuyha
 */
public class StudentControllerMethods {
    //from menu

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    static public void newStudentCalled(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         //studentService stService = new studentService();
        studentService stService = new studentService(); 
              
        int student_id = stService.getNewStudentID();

       request.setAttribute("student_id", student_id);
       request.setAttribute("stid_readonly","readonly");  //set student_id field to readonly
//                request.setAttribute("new_disabled", "disabled");
//                request.setAttribute("insert_disabled", "");
//                request.setAttribute("update_disabled", "disabled");
//                request.setAttribute("search_disabled", "disabled");
//                request.setAttribute("delete_disabled", "disabled");
                
               
    }
    
    
     //from menu

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    static public void studentFormCalled(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

                request.setAttribute("stid_readonly","");  //set student_id field to readonly
                request.setAttribute("new_disabled", "");
                request.setAttribute("insert_disabled", "disabled");
                request.setAttribute("update_disabled", "disabled");
                request.setAttribute("search_disabled", "");
                request.setAttribute("delete_disabled", "disabled");
                
                
   
    }
    
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    static public void listAllCalled(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        studentService stService = new studentService();  
        List<Student> students = new ArrayList<>();     
        students =  stService.select();

        request.setAttribute("students", students);
        
    }
    
    //from student_list

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    
    static public void deleteCalled(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
            int student_id = Integer.parseInt(request.getParameter("student_id"));
            
            //delete all result of this student
            resultService rslSer = new resultService();
            rslSer.deleteStudent(student_id);
            
            //delete this student
            studentService stService = new studentService();
            stService.delete(student_id);
            
            
                    
            //Prepared for refresh page with student's list
            List<Student> students = new ArrayList<>();
            students =  stService.select();
            
            request.setAttribute("students", students);
       
        
    }
    
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    static public void editCalled(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
            
            //Get information of the student tha has the student_id getting from student_list 
            //and then send this information to student_form to do the modification
            
            //get student's info
            int student_id = Integer.parseInt(request.getParameter("student_id"));
            studentService stService = new studentService();            
            Student student = (Student)stService.selectById(student_id);                
            // set attribute 
            request.setAttribute("student_id", student_id);
            request.setAttribute("stid_readonly","readonly");  //set student_id field to readonly
            
            String date = student.getStart_date();
            String day = date.split("-")[0];
            String month = date.split("-")[1];
            String year = date.split("-")[2];
            
            
            request.setAttribute("day", day);
            request.setAttribute("month", month);
            request.setAttribute("year", year);
            request.setAttribute("student", student);
            
            request.setAttribute("new_disabled", "disabled");
            request.setAttribute("insert_disabled", "disabled");
            request.setAttribute("update_disabled", "");
            request.setAttribute("search_disabled", "disabled");
            request.setAttribute("delete_disabled", "");

    }
    
    
       
    //---- for doPost----

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    static public void emailSendCalled(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            
        System.out.println("Calling emailSendCalled");
            
        //Get information of the student tha has the student_id getting from student_list 
        //and then send this information to student_form to do the modification

        //get student's info

        String email_address = request.getParameter("email");
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");

        final String username="javacourse2016@gmail.com";
        final String password ="";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        //Session session = Session.getDefaultInstance(props);
        Session session = Session.getInstance(props,
        new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                }
          });   

        try {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("javacourse2016@gmail.com"));
                message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(email_address));
                message.setSubject(subject);
                message.setText(content);

                Transport.send(message);

                System.out.println("Done");

        } catch (MessagingException e) {
                throw new RuntimeException(e);
        }

        //Prepared for refresh page with student's list
        studentService stService = new studentService();
        List<Student> students = new ArrayList<>();
        
        students =  stService.select();
        

        request.setAttribute("students", students);
            
        System.out.println("Done emailSendCalled");  
    }
    
    //---- for doGet -----

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    static public void studentGradeCalled(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
   
            
            studentService stService = new studentService();
   
            //Prepared for refresh page with student's list
            List<StudentsGrade> stdGrade =  stService.getGrades();// = new ArrayList<>();
        
            request.setAttribute("studentsGrade", stdGrade);
                 
    }

     
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    static public void transcriptCalled(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int student_id = Integer.parseInt(request.getParameter("student_id"));
        studentService stService = new studentService();
        
        List<StudentsGrade> students = stService.getTranscript(student_id);
        
        //if (students.size()>0){  
           request.setAttribute("student_id",student_id);
//            request.setAttribute("first_name", students.get(0).getFirst_name());
//            request.setAttribute("last_name", students.get(0).getLast_name());
//            request.setAttribute("gender", students.get(0).getGender());
            request.setAttribute("students", students);
        //}
        
     }
    
    //---- for doPost----

    /**
     *
     * @param request
     * @param response
     */
    static public void insertClicked(HttpServletRequest request, HttpServletResponse response){
     
            int student_id = Integer.parseInt(request.getParameter("student_id"));
            String firstName = request.getParameter("first_name");
            String lastName = request.getParameter("last_name");
            String gender = request.getParameter("gender");
            String email = request.getParameter("email");
            
            String day = request.getParameter("day");
            String month = request.getParameter("month");
            String year = request.getParameter("year");
            
            if(day.equals("")) day ="01";
            if (month.equals("")) month="01";
            if (year.equals("")) year="1900";
            
            Student st = new Student(student_id,firstName,lastName,gender,day+"-"+month+"-"+year,email);
            System.out.println(st);
            studentService stService = new studentService();
       
             stService.insert(st);

            //prepared to forward to student_list
            List<Student> students = new ArrayList<>();
            students =  stService.select();
            request.setAttribute("students", students);
            

        
        
    }
    
    /**
     *
     * @param request
     * @param response
     */
    static public void deleteClicked(HttpServletRequest request, HttpServletResponse response){
       
            int student_id = Integer.parseInt(request.getParameter("student_id"));
            
            //delete all result of this course
            resultService rslSer = new resultService();
            rslSer.deleteStudent(student_id);
            
            studentService stService = new studentService();
//            stService.delete(student_id);

            //prepared to forward to student_list
            List<Student> students = new ArrayList<>();
            students =  stService.select();
            request.setAttribute("students", students);
            
      
        
        
    }
    
    /**
     *
     * @param request
     * @param response
     */
    static public void searchClicked(HttpServletRequest request, HttpServletResponse response) {
        
            String st_student_id = request.getParameter("student_id");
            
                       
            Student student = null;
            
            if (!(st_student_id.equals(""))){
                int student_id = Integer.parseInt(st_student_id);
                studentService stService = new studentService();

     
                student=(Student) stService.selectById(student_id);
              
                
                
                if (student ==null){
                    
                    //JFrame parent = new JFrame();
                    //JOptionPane.showMessageDialog(null, "Not found!");
    
                    request.setAttribute("insert_disabled", "disabled");
                    request.setAttribute("update_disabled","disabled");
                    request.setAttribute("delete_disabled","disabled");
                    
                }else{
                
                    String date = student.getStart_date();
                    String day = date.split("-")[0];
                    String month = date.split("-")[1];
                    String year = date.split("-")[2];

                    request.setAttribute("day", day);
                    request.setAttribute("month", month);
                    request.setAttribute("year", year);

                    request.setAttribute("student_id", student_id);
                    request.setAttribute("student", student);
                    request.setAttribute("insert_disabled", "disabled");
                    request.setAttribute("stid_readonly","");
                }
            }else{
                
                 request.setAttribute("insert_disabled", "disabled");
                 request.setAttribute("update_disabled","disabled");
                 request.setAttribute("delete_disabled","disabled");
                
            }
 
    }
    
    /**
     *
     * @param request
     * @param response
     */
    static public void updateClicked(HttpServletRequest request, HttpServletResponse response){
       
            int student_id = Integer.parseInt(request.getParameter("student_id"));
            String firstName = request.getParameter("first_name");
            String lastName = request.getParameter("last_name");
            String gender = request.getParameter("gender");
            String email = request.getParameter("email");
            
            String day = request.getParameter("day");
            String month = request.getParameter("month");
            String year = request.getParameter("year");
            
            Student st = new Student(student_id,firstName,lastName,gender,day+"-"+month+"-"+year,email);
            System.out.println(st);
            studentService stService = new studentService();
       
             stService.update(st);

            //prepared to forward to student_list
            List<Student> students = new ArrayList<>();
            students =  stService.select();
            request.setAttribute("students", students);
            
           
        
    }
    
    
   
    
 
}
