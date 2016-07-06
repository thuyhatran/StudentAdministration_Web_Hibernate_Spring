<%-- 
    Document   : student_list
    Created on : Jun 3, 2016, 3:15:55 PM
    Author     : Thuy Ha
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
        
        <a style="color:green" href="JSPs/main.jsp">Home Page</a><br><br>
        
        <h2 style="text-align: center">LIST OF STUDENTS</h2>
               
        <table>
                   <tr>
                       <th>ID</th>
                       <th>First Name</th>
                       <th>Last Name</th>
                       <th>Gender</th>
                       <th>Email</th>
                       <th>Start Date</th>
                       <th colspan="4">Action</th>
                   </tr>
               <c:forEach var="st" items="${students}">
                   <tr>
                       <td><c:out value ="${st.student_id}" /></td>
                       <td><c:out value ="${st.first_name}" /></td>
                       <td><c:out value ="${st.last_name}" /></td>
                       <td><c:out value ="${st.gender}" /></td>
                       <td><c:out value ="${st.email}" /></td>
                       <td><c:out value ="${st.start_date}" /></td>
                       <td><a href="<c:url value ='/StudentController'>
                              <c:param name="student_id" value ="${st.student_id}" />
                              <c:param name="action" value ="Edit" />
                              </c:url>">Edit</a></td>
                       
                       <td><a href="<c:url value ='/StudentController'>
                              <c:param name="student_id" value ="${st.student_id}" />
                              <c:param name="action" value ="Delete" />
                              </c:url>">Delete</a></td>
                       
                        <td>
                            <a href="<c:url value ="/JSPs/email_form.jsp?email=${st.email}"/>">Email</a>
                            
                           <%-- <a href="<c:url value ='/StudentController'>  
                             <c:param name="email" value ="${st.email}" /> 
                              <c:param name="action" value ="Email" />
                              </c:url>">Email</a>  --%>
                            
                            <%-- <a href="<c:url value ="/JSPs/email_form.jsp">
                               <c:param name="email" value ="${st.email}" />
                             </c:url>">Email</a>  --%>

                        </td>
                         
  
                        <td><a href="<c:url value ='/StudentController'>
                              <c:param name="student_id" value ="${st.student_id}" />                             
                              <c:param name="action" value ="Transcript" />
                              </c:url>">Transcript</a></td>

                   </tr>

               </c:forEach>

        </table>
        <br>
    </body>
    
    <footer>
        <c:import url="/includes/footer.jsp" />
    </footer>
        
</html>