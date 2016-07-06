<%-- 
    Document   : students_grade
    Created on : 8-Jun-2016, 4:36:25 PM
    Author     : thuyha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student List</title>
    </head>
    <body>
        <header>
             <link rel="stylesheet" type="text/css" href="CSSs/student_list.css">
             <c:import url="/includes/header.jsp" />
        </header>
        
        
        <c:import url="/includes/homepage_link.jsp" />          
        <h2 style="text-align:center">STUDENTS GRADE</h2>
               
        <table>
                   <tr>
                       <th>ID</th>
                       <th>First Name</th>
                       <th>Last Name</th>
                       <th>Gender</th>
                       <th>Course</th>
                       <th>Mark 1</th>
                       <th>Mark 2</th>
                       <th>Grade</th>
                       
                   </tr>
               <c:forEach var="st" items="${studentsGrade}">
                   <tr>
                       <td><c:out value ="${st.student_id}" /></td>
                       <td><c:out value ="${st.first_name}" /></td>
                       <td><c:out value ="${st.last_name}" /></td>
                       <td><c:out value ="${st.gender}" /></td>
                       <td><c:out value ="${st.course}" /></td>
                       <td><c:out value ="${st.mark1}" /></td>
                       <td><c:out value ="${st.mark2}" /></td>
                       <td><c:out value ="${st.grade}" /></td>
                      
                   </tr>

               </c:forEach>

        </table>
    </body>
    
    <footer>
        <c:import url="/includes/footer.jsp" />
    </footer>
        
</html>
