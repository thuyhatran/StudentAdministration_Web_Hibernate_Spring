<%-- 
    Document   : course_form
    Created on : Jun 10, 2016, 2:03:07 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Form</title>
        <link rel="stylesheet" type="text/css" href="CSSs/course_form.css"> 
    </head>
    <body>
        
      <header> 
          <c:import url="../includes/header.jsp" />        
        </header>
        
        <form action="CourseController" method="post">
            
            <c:import url="/includes/homepage_link.jsp" />   <br>
                       
            <fieldset>
                <legend style="color:rgb(122,41,70);">Course Informations</legend><br>
                    <label for "course_id">Course ID:</label>
                   <input type="text" name="course_id" id="course_id" value="${course_id}" ${id_readonly}
                           pattern="[0-9]{1,2}" placeholder="1-2 digits"> 
                    
                   <%--                  
                    <select  name="course_id" id="course_id" value="${course_id}" ${id_readonly}
                             pattern="[0-9]{1,2}" placeholder="1-2 digits">
                        
                        <c:forEach var="courseID" items="${CourseIDs}">
                            <option><c:out value="${courseID}"/></option>
                        </c:forEach>
                    
                    </select> --%>

                    <br><br>
                    <label for "course_name">Course Name:</label>
                    <input type="text" name="course_name" id="course_name" value="${course.course_name}" >
                    <br><br>
                    
            </fieldset>

                    <fieldset id="buttons">
                        <input type="submit" name="submit" id="new"    value="New" ${new_disabled}
                               >
                        <input type="submit" name="submit" id="insert" value="Insert" ${insert_disabled}
                               >
                        <input type="submit" name="submit" id="update" value="Update" ${update_disabled}>
                        <input type="submit" name="submit" id="delete" value="Delete" ${delete_disabled}>
                        <input type="submit" name="submit" id="search" value="Search" ${search_disabled}>
                        <input type="reset" id="reset" value="Reset"><br>
                               
                    </fieldset>

            </form>
                        
      <!--    <script>
                var d=new Date();    
                document.getElementById("day").value = d.getDate();
                document.getElementById("month").value = d.getMonth()+1;
                document.getElementById("year").value = d.getFullYear();
          </script>
   
          <script>
              function new_clicked(){
                  document.getElementById("new").disabled = true;
                  document.getElementById("insert").disabled = false;
                  document.getElementById("update").disabled = true;
                  document.getElementById("delete").disabled = true;
                  document.getElementById("search").disabled = true;
              }
              function insert_clicked(){
                  document.getElementById("new").disabled = false;
                  document.getElementById("insert").disabled = true;
                  document.getElementById("update").disabled = true;
                  document.getElementById("delete").disabled = true;
                  document.getElementById("search").disabled = true;
              }
          
          </script>
      -->         
   
    
         </body>
    
    
    <footer>
         <c:import url="/includes/footer.jsp" />
    </footer>
    
</html>
