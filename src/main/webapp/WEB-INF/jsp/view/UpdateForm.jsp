<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<title>Update Contact form</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
	

<body>


<div class="container">
  	
  	
  	
  	<f:form action="${pageContext.request.contextPath}/updateContact" method="POST" modelAttribute="ContactModel">

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
					<div class="col" style="visibility: hidden">
						<label>Id</label>
						<f:input path="id" type="text" class="form-control"
							placeholder="Nom du contact" />
						<f:errors path="id" class="text-danger" />
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
					<button type="submit" class="btn btn-primary">Update</button>
					<button type="reset" class="btn btn-secondary">Rest</button>
				</div>
  	</f:form>
  	
  	
</div>




</body>
</html>