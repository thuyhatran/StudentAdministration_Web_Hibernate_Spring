<%-- 
    Document   : email_form
    Created on : Jun 6, 2016, 3:20:51 PM
    Author     : Thuy Ha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Email</title>
        <link rel="stylesheet" type="text/css" href="<c:url value="/CSSs/email_form.css"/>">
    </head>
    <body>
        
        <header> 
          <c:import url="/includes/header.jsp" />        
        </header>
        <c:import url="../includes/homepage_link.jsp" />   <br>
        
        <form action="<c:url value="/StudentController"/>" method="post">
            
            
            <label>To:</label>
            <input type ="text" name="email" id="email" value="${param.email}"><br><br>
            <label>Subject:</label>
            <input type="text" name="subject" id="subject" > <br><br>      
            <textarea name="content" id="content" style="width:450px;height:150px;"></textarea><br> <br>
            <input type="submit" name="submit" value ="Send">
        </form>
        
        <footer>
             <c:import url="/includes/footer.jsp" />
        </footer>
        
    </body>
</html>
