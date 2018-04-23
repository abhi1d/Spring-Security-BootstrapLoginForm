<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "security" uri = "http://www.springframework.org/security/tags" %>


<html>
 <head>
    <title>Home Page</title>
   
 </head>
 <body>
  
   <h2>Hello wolrd </h2>
   <h3>Home Page!!!!!! helppp</h3>
   
   
   <hr>
     <!-- Display username and role -->
     <p>
         User:<security:authentication property="principal.username" />
         <br>
         <br>
         Role(s) <security:authentication property="principal.authorities"/>
      
     </p>
   
   <hr>
    <!-- Add a link to point to /leader ... this is for the managers -->
    <security:authorize access="hasRole('MANAGER')">
    <p>
     <a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
       (Only for Manager People)
    </p> 
    </security:authorize>
    
    <security:authorize access="hasRole('ADMIN')">
    <!-- Add a link to point to /systems ...this is for the admin -->
     <p>
     <a href="${pageContext.request.contextPath}/systems">IT Systems PEEPS</a>
       (Only for Manager People)
    </p> 
    </security:authorize>
    
    
   <hr>
   
   
   
   <!-- Add a logout button -->
   <form:form action="${pageContext.request.contextPath}/logout" method="POST">
        
          <input type = "submit" value= "Logout" />
   
   </form:form>
 </body>


</html>
