/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import daoimplement.courseDao;
import daoimplement.resultDao;
import daoimplement.studentDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
                
//                if (imptStudent!=null){
//
////                    try {
////                        studentDao stDao = new studentDao();
////                        if (fnStudent!=null)
////                            stDao.write_to_file(fnStudent);
////                        else
////                            stDao.write_to_file("C:/import/student.txt");
////                    } catch (SQLException | ClassNotFoundException ex) {
////                        Logger.getLogger(SaveFileController.class.getName()).log(Level.SEVERE, null, ex);
////                    }
//                }
//
//                 if (imptCourse!=null){
//                    try {
//                        courseDao stDao = new courseDao();
//                        if (fnCourse!=null)
//                            stDao.write_to_file(fnCourse);
//                        else
//                            stDao.write_to_file("C:/import/course.txt");
//                    } catch (SQLException | ClassNotFoundException ex) {
//                        Logger.getLogger(SaveFileController.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//
//                  if (imptResult!=null){
//                    try {
//                        resultDao stDao = new resultDao();
//                        if (fnResult!=null)
//                            stDao.write_to_file(fnResult);
//                        else
//                            stDao.write_to_file("C:/import/result.txt");
//                    } catch (SQLException | ClassNotFoundException ex) {
//                        Logger.getLogger(SaveFileController.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
                  
            break;
        
            case "Import":
                
//                 if (imptStudent!=null){
//                     System.out.println("Student: " + imptStudent);
//                     studentDao stDao = new studentDao();
//                     if (fnStudent!=null)
//                         stDao.insert_from_file(fnStudent);
//                     else
//                         System.out.println("File "+ fnStudent+" not found");
//                }
//
//                 if (imptCourse!=null){
//                    try {
//                        System.out.println("Course: " + imptCourse);
//
//                        courseDao stDao = new courseDao();
//                        if (fnCourse!=null)
//                            stDao.insert_from_file(fnCourse);
//                        else
//                            System.out.println("File "+ fnCourse+" not found");
//                    } catch (SQLException | ClassNotFoundException ex) {
//                        Logger.getLogger(SaveFileController.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//
//                  if (imptResult!=null){
//                    try {
//                        System.out.println("Result: " + imptResult);
//
//                        resultDao stDao = new resultDao();
//                        if (fnResult!=null)
//                            stDao.insert_from_file(fnResult);
//                        else
//                            System.out.println("File "+ fnResult+" not found");
//                    } catch (SQLException | ClassNotFoundException ex) {
//                        Logger.getLogger(SaveFileController.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }

               
                break;
        }
         
        
        String url ="/JSPs/main.jsp";
        getServletContext().getRequestDispatcher(url).forward(request, response);
        
   
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
