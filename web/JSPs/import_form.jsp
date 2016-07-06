<%-- 
    Document   : import_form
    Created on : 14-Jun-2016, 11:01:39 AM
    Author     : thuyha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Import Data</title>
        <link rel="stylesheet" type="text/css" href="<c:url value="/CSSs/import_form.css"/>">
    </head>
    <body>
         <header> 
          <c:import url="/includes/header.jsp" />        
        </header>
          <form action ="<c:url value="/SaveFileController"/>" method ="post">
            
            <c:import url="/includes/homepage_link.jsp" />   <br>
            
            <h3 style="text-align: center">Check the Table(s) you want to Import/Export</h3> 
            
            <table>
                <tr>
                    <td><input type="checkbox" name="imptStudent" id ="imptStudent" value="Student">Student</td>
                    <td>File Name: <input type="Text" name="fnStudent" > </td>
                </tr>
                <tr>
                    <td><input type="checkbox" name="imptCourse" id ="imptCourse" value="Course">Course</td>
                    <td>File Name: <input type="Text" name="fnCourse" > </td>
                </tr>
                <tr>
                    <td><input type="checkbox" name="imptResult" id ="imptResult" value="Result">Result</td>
                    <td>File Name: <input type="Text" name="fnResult" > </td>
                </tr>
               
            </table>
            <br>
            <fieldset style="border:none">
                <input type ="submit" name ="submit" id="export" value="Export">
                <input type ="submit" name ="submit" id="import" value="Import"> 
            </fieldset>
            <br><br>
        </form>
    </body>
    
    <footer>
         <c:import url="/includes/footer.jsp" />
    </footer>
    
</html>
