<%-- 
    Document   : menu
    Created on : 1-Jun-2016, 3:46:40 PM
    Author     : thuyha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
   <!-- <link rel="stylesheet" type="text/css" href="CSSs/main_styles.css"> -->
   
   <link rel="stylesheet" type="text/css" href="<c:url value="/CSSs/main_styles.css"/>">
   
   <title>Student Administration</title>
    
</head>

<body>
    <header> 
          <c:import url="/includes/header.jsp" />
        
    </header>
    
    <section>
        
        <%-- <c:import url="/includes/menu.jsp" /> --%>
        
        <h2 style="text-align: center; color:green">Student Administration</h2>
        <div class="dropdown">
          <button class="dropbtn">Student</button>
          <div class="dropdown-content">
              
            <a href="<c:url value ='/StudentController'>            
                   <c:param name="action" value ="StudentForm" />
                   </c:url>">Student Form</a>
            
                    
            <a href="<c:url value ='/StudentController'>            
                   <c:param name="action" value ="ListAll" />
                   </c:url>">Student List</a>
            
            <a href="<c:url value ='/StudentController'>            
                   <c:param name="action" value ="StudentsGrade" />
                   </c:url>">Student Grade</a> 
              
          </div>
        </div>

        <div class="dropdown">
          <button class="dropbtn">Course</button>
          <div class="dropdown-content">
             <a href="<c:url value ='/CourseController'>            
                   <c:param name="action" value ="CourseForm" />
                   </c:url>">Course Form</a>
              
            <a href="<c:url value ='/CourseController'>            
                   <c:param name="action" value ="ListAll" />
                   </c:url>">Course List</a>
              
          </div>
        </div> 

        <div class="dropdown">
          <button class="dropbtn">Result</button>
          <div class="dropdown-content">
              
             <a href="<c:url value ='/ResultController'>            
                   <c:param name="action" value ="ResultForm" />
                   </c:url>">Result Update</a>
              
            <a href="<c:url value ='/ResultController'>            
                   <c:param name="action" value ="ListAll" />
                   </c:url>">Results</a>
            
          </div>
        </div> 
        
        <div class="dropdown">
          <button class="dropbtn">
         <a style="text-decoration: none; color:white" href="<c:url value ='/JSPs/import_form.jsp' />">Import/Export</a> 
              </button>
          
        </div> 
       

       </section>
    <footer>
        <c:import url="/includes/footer.jsp" />
    </footer>
</body>
</html>
