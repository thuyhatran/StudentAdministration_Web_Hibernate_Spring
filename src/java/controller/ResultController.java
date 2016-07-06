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
 * @author Administrator
 */
@WebServlet(name = "ResultController", urlPatterns = {"/ResultController"})
public class ResultController extends HttpServlet {

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
            out.println("<title>Servlet ResultController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ResultController at " + request.getContextPath() + "</h1>");
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
       // processRequest(request, response);
       
       
      
          String action = request.getParameter("action");

        String url;
        switch (action){
            case "ResultForm":  //Call from menu
                ResultControllerMethods.resultFormCalled(request, response);
                url ="/JSPs/result_form.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
                break;
            case "ListAll":  //Call from menu
               ResultControllerMethods.listAllCalled(request, response);
               url ="/JSPs/result_list.jsp";
               getServletContext().getRequestDispatcher(url).forward(request, response);
                break;
                
            case "Delete":  //Call from student_list
                ResultControllerMethods.deleteCalled(request, response);
                url ="/JSPs/result_list.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
                break;
            case "Edit":  //Call from student_list
                ResultControllerMethods.editCalled(request, response);
                url ="/JSPs/result_form.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
                break;
                
                  
                
//            case "SaveToFile":
//                ResultControllerMethods.importStudentCalled(request, response);
//                url ="/JSPs/main.jsp";
//                getServletContext().getRequestDispatcher(url).forward(request, response); 
//                break;
                
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
      //  processRequest(request, response);
      
        String submit = request.getParameter("submit");
            
            System.out.print("------- submit : "+submit+"------------");
            String url ;
            
            switch (submit){
                               
                case "New":                    
                    ResultControllerMethods.newResultCalled(request, response);
                    url ="/JSPs/result_form.jsp";
                    getServletContext().getRequestDispatcher(url).forward(request, response);
                    break;
                    
                case "Insert":                    
                    ResultControllerMethods.insertClicked(request, response);
                    url ="/JSPs/result_list.jsp";
                    getServletContext().getRequestDispatcher(url).forward(request, response);
                    break;

                case "Delete":
                    ResultControllerMethods.deleteClicked(request, response);
                    url ="/JSPs/result_list.jsp";
                    getServletContext().getRequestDispatcher(url).forward(request, response);
                    break;

                case "Update":
                    ResultControllerMethods.updateClicked(request, response);
                    url ="/JSPs/result_list.jsp";
                    getServletContext().getRequestDispatcher(url).forward(request, response);
                    break;

                case "Search":
                    ResultControllerMethods.searchClicked(request, response);
                    url ="/JSPs/result_form.jsp";
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
