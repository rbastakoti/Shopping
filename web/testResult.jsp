<%-- 
    Document   : testResult
    Created on : Oct 20, 2020, 4:51:48 PM
    Author     : rajanbastakoti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result Pages</title>
    </head>
    <body>
        
        <c:if test="${empty phonebox}">
        <c:redirect url="/TestServelet"/>
        
    </c:if>
        <h2>Available phones</h2>
        <!-- create table to display data-->
        <table border ="2">
            <tr>
                <th>BRAND</th>
                <th>IMEI</th>
                 
            </tr>
            <!--iterate though the list and use expression language to retrieve values-->
            <c:forEach var="phone" items="${phonebox.phones}">
                <tr>
                    <td> ${phone.brand}</td>
                     <td> ${phone.imei}</td>        
                
                <!-- passing the IMEI and BRand to the servletdetails -->
                    <td>
                        <form action ="ServletDetails" >
                            <input type="submit" value="Details"/>                        
                            <input type="hidden" name="BRAND" value="${phone.brand}"/>
                            <input type="hidden" name="IMEI" value="${phone.imei}"/>
                        </form>            
                    </td>
                </tr>
            </c:forEach>
                
                <h3><a href="input.jsp">Add more Phones</a></h3>
        </table>
    </body>
</html>
