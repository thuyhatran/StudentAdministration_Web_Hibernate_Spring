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
        <link rel="stylesheet" type="text/css" href="CSSs/result_form.css"> 
    </head>
    <body>
        
      <header> 
          <c:import url="../includes/header.jsp" />        
        </header>
        
        <form name="result_form" action="ResultController" onsubmit="return verify_on_submit()" method="post" >
            
            <c:import url="/includes/homepage_link.jsp" />   <br>
                       
            <fieldset>
                <legend style="color:rgb(122,41,70);">Course Informations</legend><br>
                   
                <label for "student_id">Student ID:</label>
                <input type="text" name="student_id" id="student_id" value="${result.student_id}" ${id_readonly}
                           > <br><br>                   
                <label for "course_id">Course ID:</label>
                <input type="text" name="course_id" id="course_id" value="${result.course_id}" ${id_readonly}
                           > <br><br>
                <label for "mark1">Mark 1:</label>    
                <input type="number" name ="mark1" id="mark1" value="${result.mark1}"
                           pattern="[0-9]{,3}" placeholder="1-3 digits" min="0" max="100"> <br><br>
                <label for "mark2">Mark 2:</label> 
                <input type="number" name ="mark2" id="mark2" value="${result.mark2}"
                           pattern="[0-9]{,3}" placeholder="1-3 digits" min="0" max="100"> <br><br>
                                   
            </fieldset>

            <fieldset id="buttons">
                <input type="submit" name="submit" id="new"    value="New" ${new_disabled}
                       onclick="whichClicked = this.value">
                <input type="submit" name="submit" id="insert" value="Insert" ${insert_disabled}
                       onclick="whichClicked = this.value">
                <input type="submit" name="submit" id="update" value="Update" ${update_disabled}>
                <input type="submit" name="submit" id="delete" value="Delete" ${delete_disabled}>
                <input type="submit" name="submit" id="search" value="Search" ${search_disabled}
                      onclick="whichClicked = this.value" >
                <input type="reset" id="reset" value="Reset"><br>

            </fieldset>

            </form>
                      
                
                
            <script type="text/javascript">
                
                var whichClicked;
               function  verify_on_submit(){
                  
                  if (whichClicked!=="New"){
                   
                        var st_id = document.forms["result_form"]["student_id"].value;
                        var crs_id = document.forms["result_form"]["course_id"].value;

                        if ((st_id == null || st_id == "")||(crs_id == null || crs_id == "")  ){
                            alert("The student and course ID must be filled out");

                            return false;     
                        }
                    }
                   
               }
                
            </script>
   
        <!--     <script>
              function new_clicked(){
                  document.getElementById("new").disabled = true;
                  document.getElementById("insert").disabled = false;
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
