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
  	
  	
  	<f:form action="addContact" method="POST" modelAttribute="ContactModel">

				<div class="row mt-5 mb-5">
					<div class="col">
						<label>Nom</label>
						<f:input path="nom" type="text" class="form-control"
							placeholder="Nom du contact" />
						<f:errors path="nom" class="text-danger" />
					</div>
					
				

					<div class="col">
						<label>Prenom</label>
						<f:input path="prenom" type="text" class="form-control"
							placeholder="prenom du contat" />
						<f:errors path="prenom" class="text-danger" />
					</div>
					
					
					
					
					<div class="row mt-5">
					<div class="col">
						<label>Telephone Personnel</label>
						<f:input path="telephone1" type="text" class="form-control"
							placeholder="Telephone Personnel" />
						<f:errors path="telephone1" class="text-danger" />
					</div>

					<div class="col">
						<label>Telephone Professionel</label>
						<f:input path="telephone2" type="text" class="form-control"
							placeholder="Telephone Professionel" />
						<f:errors path="telephone2" class="text-danger" />
					</div>
				</div>
					
					<div class="row mt-5">
					<div class="col">
						<label>email Personnel</label>
						<f:input path="emailPersonnel" type="text" class="form-control"
							placeholder="email Personnel" />
						<f:errors path="emailPersonnel" class="text-danger" />
					</div>

					<div class="col">
						<label>Email Professionel</label>
						<f:input path="emailProfessionnel" type="text" class="form-control"
							placeholder="emailProfessionnel" />
						<f:errors path="emailProfessionnel" class="text-danger" />
					</div>
				</div>
					
					
					
					<div class="row mt-5">
					<div class="col">
						<label>Address</label>
						<f:input path="adresse" type="text" class="form-control"
							placeholder="Adresse" />
						<f:errors path="adresse" class="text-danger" />
					</div>

					<div class="col">
						<label>genre</label>
						<f:select path="genre" items="${GenderList}" class="form-control" />
						<f:errors path="genre" class="text-danger" />
					</div>
				</div>
					
				</div>
  	
  	
  				<div style="text-align: right">
					<button type="submit" class="btn btn-primary">Register</button>
					<button type="reset" class="btn btn-secondary">Rest</button>
				</div>
  	</f:form>
  	
  	
</div>




<div class="container">

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
						</td>--%>
					</tr>

				</c:forEach>

			</table>
		</div>


</body>
</html>