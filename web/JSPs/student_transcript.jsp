<%-- 
    Document   : student_transcript
    Created on : Jun 3, 2016, 4:02:44 PM
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
             <link rel="stylesheet" type="text/css" href="CSSs/student_transcript.css">
             <c:import url="/includes/header.jsp" />
        </header>
        <c:import url="/includes/homepage_link.jsp" />  
        <p id="college">YOYO College<br>
        2576 rue Sherbrooke West, Montreal - (514)-555-7777</p>
        
        <h1 id="transcript"> TRANSCRIPT</h1> 
        <table>
           <tr>
               <th>ID:</th> 
               <td><c:out value ="${student_id}" /></td>
            </tr>
            <tr>
               <th>Name:</th> 
               <td><c:out value ="${students[0].first_name}" /> &nbsp; <c:out value ="${students[0].last_name}" /></td>
            </tr>
            
            <tr>
                <th>Gender:</th>
                <td><c:out value ="${students[0].gender}" /></td>
            </tr>           
        </table> 
        
        <table>
            <tr>
                <th>Course</th>
                <th>Mark 1</th>
                <th>Mark 2</th>
                <th>Grade</th>

            </tr>
        <c:forEach var="st" items="${students}">
            <tr>
                <td><c:out value ="${st.course}" /></td>
                <td><c:out value ="${st.mark1}" /></td>
                <td><c:out value ="${st.mark2}" /></td>
                <td><c:out value ="${st.grade}" /></td>

            </tr>

       </c:forEach>

        </table>
        
        <script>
                    var d=new Date();    
                    document.getElementById("day").value = d.getDate();
                    document.getElementById("month").value = d.getMonth()+1;
                    document.getElementById("year").value = d.getFullYear();
        </script>
                
        <p id="date"><script>document.write('Montreal, ' + d.getDate()+'/' + d.getMonth()+1 +'/'+ d.getFullYear());  </script> </p>
        
    </body>
    
    <footer>
        <c:import url="/includes/footer.jsp" />
    </footer>
        
</html>