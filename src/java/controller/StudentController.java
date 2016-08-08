/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "StudentController", urlPatterns = {"/StudentController"})
public class StudentController extends HttpServlet {

//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet StudentController</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet StudentController at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
        
        String action = request.getParameter("action");

        String url;
        switch (action){
            case "StudentForm":  //Call from menu
                StudentControllerMethods.studentFormCalled(request, response);
                url ="/JSPs/student_form.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
                break;
            case "ListAll":  //Call from menu
               StudentControllerMethods.listAllCalled(request, response);
               url ="/JSPs/student_list.jsp";
               getServletContext().getRequestDispatcher(url).forward(request, response);
                break;
                
            case "Delete":  //Call from student_list
                StudentControllerMethods.deleteCalled(request, response);
                url ="/JSPs/student_list.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
                break;
            case "Edit":  //Call from student_list
                StudentControllerMethods.editCalled(request, response);
                url ="/JSPs/student_form.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
                break;
                
                          
            case "StudentsGrade":
                StudentControllerMethods.studentGradeCalled(request, response);
                url ="/JSPs/students_grade.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response); 
                break;
                
            case "Transcript":
                StudentControllerMethods.transcriptCalled(request, response);
                url ="/JSPs/student_transcript.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response); 
                break;
                
                
            default:
                url ="/JSPs/main.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
                
                    
        }
            
 
        
        
 
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
            
            String submit = request.getParameter("submit");
            
            System.out.print("------- submit : "+submit+"------------");
            
            switch (submit){
                case "Send":
                    //System.out.println("Before sending email");
                    StudentControllerMethods.emailSendCalled(request, response);
                   // System.out.println("After sending email");
                    String url ="/JSPs/student_list.jsp";
                    getServletContext().getRequestDispatcher(url).forward(request, response);
                    
                    break;
                    
                case "New":
                    
                    StudentControllerMethods.newStudentCalled(request, response);
                    url ="/JSPs/student_form.jsp";
                    getServletContext().getRequestDispatcher(url).forward(request, response);
                    break;
                    
                case "Insert":                    
                    StudentControllerMethods.insertClicked(request, response);
                    url ="/JSPs/student_list.jsp";
                    getServletContext().getRequestDispatcher(url).forward(request, response);
                    break;

                case "Delete":
                    StudentControllerMethods.deleteClicked(request, response);
                    url ="/JSPs/student_list.jsp";
                    getServletContext().getRequestDispatcher(url).forward(request, response);
                    break;

                case "Update":
                    //StudentControllerMethods.emailSendCalled(request, response);
                    StudentControllerMethods.updateClicked(request, response);
                    url ="/JSPs/student_list.jsp";
                    getServletContext().getRequestDispatcher(url).forward(request, response);
                    break;

                case "Search":
                    StudentControllerMethods.searchClicked(request, response);
                    url ="/JSPs/student_form.jsp";
                    getServletContext().getRequestDispatcher(url).forward(request, response);
                    break;

                default:
                    url ="/JSPs/main.jsp";
                    getServletContext().getRequestDispatcher(url).forward(request, response);    

                    
            }
   
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
