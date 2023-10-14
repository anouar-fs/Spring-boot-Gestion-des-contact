<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<title>Contact form</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
	

<body>


<div class="container">
			
			
	<f:form action="/updateGroupe" method="post" modelAttribute="GroupeModel">
    	<%--<input type="hidden" name="groupId" value="${group.id}" /> --%>
    
    <h3>Update Group of Contacts </h3>
    
   
    <div class="col" style="visibility: hidden">
			<label>Id</label>
			<f:input path="id" type="text" class="form-control" />
	</div>	
	 <label>Nom Du Groupe</label>
			<f:input path="nom" type="text" class="form-control"
							placeholder="Nom du Groupe" />
    <label for="contacts">Select Contacts:</label>
     <select multiple name="contacts" id="contacts">
     	<c:forEach items="${ContactList}" var="contact">
            <option value="${contact.id}" selected="${true}">${contact.nom} ${contact.prenom} ${contact.telephone1}</option>
        </c:forEach>
    	<c:forEach items="${ContactList2}" var="contact">
            <option value="${contact.id}" >${contact.nom} ${contact.prenom} ${contact.telephone1}</option>
        </c:forEach>
    </select>
    
    	<button type="submit">Add Contacts</button>
	</f:form>
			
			
</div>


</body>
</html>