<%-- 
    Document   : phoneDetails
    Created on : Nov 4, 2020, 10:24:10 PM
    Author     : rajanbastakoti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detail of the phone</title>
    </head>
    <body>
        <h1>${chosen.family} ${chosen.model} Details</h1>
        
        <!-- displaying details of the chosen phone-->
        
        <table border ="2">
            <tr>
                <td>Brand</td>
                <td>${chosen.brand}</td>
            </tr>
            <tr>
                <td>Family</td>
                <td>${chosen.family}</td>
            </tr>
            <tr>
                <td>Model</td>
                <td>${chosen.model}</td>
            </tr>
            <tr>
                <td>price</td>
                <td>${chosen.price}</td>
            </tr>
            <tr>
                <td>IMEI</td>
                <td>${chosen.imei}</td>
            </tr>
        </table>
        
            
        <!-- sending the chosen phone to cartServlet to add in to the cart-->
        <form action ="cartServlet" >
            <input type="submit" value="Add To Cart"/>                        
            <input type="hidden" name="BRAND" value="${chosen.brand}"/>
            <input type="hidden" name="IMEI" value="${chosen.imei}"/>
        </form>  
       
    </body>
</html>
