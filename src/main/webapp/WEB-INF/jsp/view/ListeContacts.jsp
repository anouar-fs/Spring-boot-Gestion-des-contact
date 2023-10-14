<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<title>List des Contacts</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">

</head>
<body>

<div class="container">

			
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page"
						href="${pageContext.request.contextPath}/showForm">Home</a></li>





					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/showForm">Add Contact
					</a></li>


					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/manageContacts">Manage
							Contacts </a></li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/manageGroupe">Manage
							Groupes </a></li>


					<li class="nav-item"><form
							action="${pageContext.request.contextPath}/serachContact"
							class="d-flex" method="POST">
							<input name="resaerchParam" class="form-control me-2" type="search"
								placeholder="Search" aria-label="Search">
							<select  name="resaerchMethode" class="form-select" aria-label="Default select example">
  								<option value="nom">Nom</option>
  								<option value="Professionel">Numero Professionel</option>
  								 <option value="Personelle">Numero Personelle</option>
							</select>
							
							<button class="btn btn-outline-success" type="submit">Search</button>
						</form></li>
				</ul>



			</div>

		</nav>


			<table class="table">
				<thead>
					<tr>
						<th scope="col">Nom</th>
						<th scope="col">Prenom</th>
						<th scope="col">Telephone Personelle</th>
						<th scope="col">Telephone Professionel</th>
						<th scope="col">Email Personnelle</th>
						<th scope="col">Email Professionel</th>
						<th scope="col">adresse</th>
					</tr>
				</thead>
				<c:forEach items="${ContactList}" var="c">
					<tr>
						<td><c:out value="${c.nom}" /></td>
						<td><c:out value="${c.prenom}" /></td>
						<td><c:out value="${c.telephone1}" /></td>
						<td><c:out value="${c.telephone2}" /></td>
						<td><c:out value="${c.emailPersonnel}" /></td>
						<td><c:out value="${c.emailProfessionnel}" /></td>
						<td><c:out value="${c.adresse}" /></td>
						
						<%--<td>
							<ul>
								<c:forEach items="${p.community}" var="c">
									<li><c:out value="${c}" /></li>
								</c:forEach>
							</ul>
						</td>
 --%>
						<td>
							<ul>
								<li><a href="deleteContact/${c.id}">Delete</a></li>

								<li><a href="UpdateForm/${c.id}">Update</a></li>
							</ul>
						</td>

					</tr>

				</c:forEach>

			</table>
		</div>
	



</body>
</html>