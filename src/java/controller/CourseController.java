/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thuy Ha
 */
@WebServlet(name = "CourseController", urlPatterns = {"/CourseController"})
public class CourseController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CourseController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CourseController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        //processRequest(request, response);
        
           String action = request.getParameter("action");

        String url;
        switch (action){
            case "CourseForm":  //Call from menu
                CourseControllerMethods.courseFormCalled(request, response);
                url ="/JSPs/course_form.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
                break;
            case "ListAll":  //Call from menu
               CourseControllerMethods.listAllCalled(request, response);
               url ="/JSPs/course_list.jsp";
               getServletContext().getRequestDispatcher(url).forward(request, response);
                break;
                
            case "Delete":  //Call from student_list
                CourseControllerMethods.deleteCalled(request, response);
                url ="/JSPs/course_list.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
                break;
            case "Edit":  //Call from student_list
                CourseControllerMethods.editCalled(request, response);
                url ="/JSPs/course_form.jsp";
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
        //processRequest(request, response);
        
            String submit = request.getParameter("submit");
            
            System.out.print("------- submit : "+submit+"------------");
            String url ;
            
            switch (submit){
                               
                case "New":                    
                    CourseControllerMethods.newCourseCalled(request, response);
                    url ="/JSPs/course_form.jsp";
                    getServletContext().getRequestDispatcher(url).forward(request, response);
                    break;
                    
                case "Insert":                    
                    CourseControllerMethods.insertClicked(request, response);
                    url ="/JSPs/course_list.jsp";
                    getServletContext().getRequestDispatcher(url).forward(request, response);
                    break;

                case "Delete":
                    CourseControllerMethods.deleteClicked(request, response);
                    url ="/JSPs/course_list.jsp";
                    getServletContext().getRequestDispatcher(url).forward(request, response);
                    break;

                case "Update":
                    CourseControllerMethods.updateClicked(request, response);
                    url ="/JSPs/course_list.jsp";
                    getServletContext().getRequestDispatcher(url).forward(request, response);
                    break;

                case "Search":
                    CourseControllerMethods.searchClicked(request, response);
                    url ="/JSPs/course_form.jsp";
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
