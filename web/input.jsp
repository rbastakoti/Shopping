<%-- 
    Document   : input
    Created on : Dec 4, 2020, 1:17:56 AM
    Author     : rajanbastakoti
--%>
<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import = "Backend.Errorsphone" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Phones!!</title>
    </head>
    <body>
        <h1>Use the form to add Phones to the system</h1>
        
        <form action="ErrorValid">
            
        Brand:
            <select name="brand">
                
            <option value="choose" <c:if test="${param.brand =='choose'}">
                            selected="true"
                        </c:if>
                   >choose</option> 
            
            <option value="Apple" <c:if test="${param.brand =='Apple'}">
                            selected="true"
                        </c:if>
                    
                  >Apple</option> 
            
            <option value ="LG" <c:if test="${param.brand =='LG'}">
                            selected="true"
                        </c:if>
                   
                    >LG</option>
            
            <option value ="Samsung" <c:if test="${param.brand =='Samsung'}">
                            selected="true"
                        </c:if>
                    
                    >SAMSUNG</option>
        </select>
          
       <c:if test="${error.brandMissing}">
            Please select a brand
        </c:if>
            
        <br/>
            
                
        <br/>
        
        Family:<input type="text" name="family" 
                      value ="${param.family}"
                      />
        
        <c:if test="${error.familyMissing}">
            Please enter the Brand family.
        </c:if>
            
            
            <br/>
            
         Model year:  
         
             <select name="model">
            <option value="choose"
                    <c:if test="${param.model =='choose'}">
                            selected="true"
                        </c:if>
                    >choose</option>
            <option value="2017"
                    <c:if test="${param.model =='2017'}">
                            selected="true"
                        </c:if>
                    >2017</option>
            <option value ="2018"
                    <c:if test="${param.model =='2018'}">
                            selected="true"
                        </c:if>
                    >2018</option>
            <option value ="2020"
                    <c:if test="${param.model =='2020'}">
                            selected="2020"
                        </c:if>
                    >2020</option>
        </select>
        
         
        <c:if test="${error.modelMising}">
            Please select the model year.
        </c:if>
            
            <br/>
            
        IMEI Number (13 digit serial) : <input type="text" name ="imei"
                                               value="${param.imei}"
                             />
         <c:if test="${error.imeilegal}">
             Please enter valid IMEI with 13 digits.
         </c:if>
             
             <br/>
             
        Price: <input type="text" name="price"
                      value ="${param.price}"
                      />
        
        <c:if test="${error.priceNonnumeric}">
            Please enter the price.
        </c:if>
            
        <c:if test="${error.pricelow}">
            Price Must be greater than 0!
        </c:if>
             
            <br/>
            
        <input type="submit" value="Add"/>
        
            
            
        </form>
    </body>
</html>
