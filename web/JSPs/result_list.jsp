<%-- 
    Document   : course_list
    Created on : Jun 10, 2016, 2:03:20 PM
    Author     : Thuy Ha
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course List</title>
    </head>
    <body>
        <header>
             <link rel="stylesheet" type="text/css" href="CSSs/result_list.css">
             <c:import url="/includes/header.jsp" />
        </header>
        
        <a style="color:green" href="JSPs/main.jsp">Home Page</a><br><br>
        
        <h2 style="text-align: center">STUDENT RESULTS</h2>
               
        <table>
                   <tr>
                       <th>Student ID</th>
                       <th>Course ID</th>
                       <th>Mark 1</th>
                       <th>Mark 2</th>
                       
                       <th colspan="2">Action</th>
                   </tr>
               <c:forEach var="st" items="${results}">
                   <tr>
                       <td><c:out value ="${st.student_id}" /></td>
                       <td><c:out value ="${st.course_id}" /></td>
                       <td><c:out value ="${st.mark1}" /></td>
                       <td><c:out value ="${st.mark2}" /></td>
                      
                       <td><a href="<c:url value ='/ResultController'>
                              <c:param name="student_id" value ="${st.student_id}" />
                              <c:param name="course_id" value ="${st.course_id}" />
                              <c:param name="action" value ="Edit" />
                              </c:url>">Edit</a></td>
                       
                       <td><a href="<c:url value ='/ResultController'>
                              <c:param name="student_id" value ="${st.student_id}" />
                              <c:param name="course_id" value ="${st.course_id}" />
                              <c:param name="action" value ="Delete" />
                              </c:url>">Delete</a></td>                                        

                   </tr>

               </c:forEach>

        </table>
        <br>
    </body>
    
    <footer>
        <c:import url="/includes/footer.jsp" />
    </footer>
        
</html>
