 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<h1>Employees List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Ids</th><th>Firstnames</th><th>Lastnames</th></tr>  
   <!-- Cyklus forEach. Pro kazdy objekt emp (sklada se z id, name, salary, designation) jsou moznosti (edit, delete) -->
   <c:forEach var="emp" items="${list}">   
   <tr>  
   	<td>${emp.id}</td>  
   	<td>${emp.firstname}</td>  
   	<td>${emp.lastname}</td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
