<%-- 
    Document   : Cart
    Created on : Nov 4, 2020, 11:19:39 PM
    Author     : rajanbastakoti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <!-- Checking if the cart is empty-->
      <c:choose> 
        <c:when test ="${empty shoppingCart}">
            <b>Shopping Cart is empty.</b>
        </c:when> 
        <c:otherwise>
            <table border ="2">
                <th>Phone Model</th>
                <th>Price</th>
                
              <c:forEach var="myCart" items="${shoppingCart.phones}">
            <tr>
                <td>${myCart.family} ${myCart.model}</td>
                <td>${myCart.price}</td>
        <!-- sending the items to deleteIems servlet to delete chosen item from the car-->        
                <td>
                    <form action ="deleteItems" >
                        <input type="submit" value="delete"/>                        
                        <input type="hidden" name="BRAND" value="${myCart.brand}"/>
                        <input type="hidden" name="IMEI" value="${myCart.imei}"/>
                    </form>            
                </td>
        </tr>    
            </c:forEach>
        <!-- display total price of the of the shopping cart-->
        <td>TOTAL:</td>
        <td>${shoppingCart.total()}</td>
            </table>
        </c:otherwise>
      </c:choose>
      <!-- takes us to the phone list page so that we can choose more items-->
      <a href="testResult.jsp" >Add More Phones </a>
      
    </body>
</html>
