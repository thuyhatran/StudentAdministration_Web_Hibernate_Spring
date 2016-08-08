/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Service.courseService;
import Service.resultService;
import Service.studentService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thuyha
 */
@WebServlet(name = "SaveFileController", urlPatterns = {"/SaveFileController"})
public class SaveFileController extends HttpServlet {

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
            out.println("<title>Servlet SaveFileController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SaveFileController at " + request.getContextPath() + "</h1>");
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
         


        String imptStudent = request.getParameter("imptStudent");
        String imptCourse = request.getParameter("imptCourse");
        String imptResult = request.getParameter("imptResult");
        
        String fnStudent = request.getParameter("fnStudent");
        String fnCourse = request.getParameter("fnCourse");
        String fnResult = request.getParameter("fnResult");
        
        String submit = request.getParameter("submit");
        
        switch (submit){
            case "Export":
                
                System.out.println("Student: " + imptStudent);
                System.out.println("Course: " + imptCourse);
                System.out.println("Result: " + imptResult);
                
                if (imptStudent!=null){

                        studentService stService = new studentService();
                        if (fnStudent!=null)
                            stService.write_to_file(fnStudent);
                        else
                            stService.write_to_file("C:/import/student.txt");
                   
                }

                 if (imptCourse!=null){
                
                        courseService stService = new courseService();
                        if (fnCourse!=null)
                            stService.write_to_file(fnCourse);
                        else
                            stService.write_to_file("C:/import/course.txt");
                   
                }

                  if (imptResult!=null){
                   
                        resultService stService = new resultService();
                        if (fnResult!=null)
                            stService.write_to_file(fnResult);
                        else
                            stService.write_to_file("C:/import/result.txt");
                   
                }
                  
            break;
        
            case "Import":
                
                 if (imptStudent!=null){
                     System.out.println("Student: " + imptStudent);
                     studentService stService = new studentService();
                     if (fnStudent!=null)
                         stService.insert_from_file(fnStudent);
                     else
                         System.out.println("File "+ fnStudent+" not found");
                }

                 if (imptCourse!=null){
                  
                        System.out.println("Course: " + imptCourse);

                        courseService stService = new courseService();
                        if (fnCourse!=null)
                            stService.insert_from_file(fnCourse);
                        else
                            System.out.println("File "+ fnCourse+" not found");
                   
                }

                  if (imptResult!=null){
                 
                        System.out.println("Result: " + imptResult);

                        resultService stService = new resultService();
                        if (fnResult!=null)
                            stService.insert_from_file(fnResult);
                        else
                            System.out.println("File "+ fnResult+" not found");
                    
                }

               
                break;
        }
         
        
        String url ="/JSPs/main.jsp";
        getServletContext().getRequestDispatcher(url).forward(request, response);
        
   
    }


}
