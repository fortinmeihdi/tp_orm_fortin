<%@page pageEncoding="UTF-8" isErrorPage="true" contentType="text/html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
  <head>
  	<meta charset="UTF-8">
    <title>Java EE</title>
    <style type="text/css">
		table {
			border-collapse: collapse;
		}
		
		th, td {
			border: 1px solid gray;
			padding: .5em;
		}
		
		tbody > tr:nth-child(even) {
			background-color: rgb(240,240,240);
		}
		
		.error {
			color: red;
		}
    </style>
  </head>
  <body>
  	<c:if test="${not empty file}">
  		<div>
		  	<form method="post">
		  		<input type="hidden" name="action" value="suivant">
		  		<button type="submit">Passer au suivant</button>
		  	</form>
  		</div>
  	</c:if>
  	<c:if test="${filePleine}">
  		<div class="error">La file d'attente est actuellement pleine. Vous ne pouvez pas prendre de rendez-vous supplémentaire</div>
  	</c:if>
  	<table>
  		<thead>
  			<tr>
  				<th>Numéro</th>
  				<th>Nom</th>
  				<th>Urgent</th>
  			</tr>
  		</thead>
  		<tbody>
  			<c:forEach var="rdv" items="${file}">
  				<tr>
  					<td><fmt:formatNumber value="${rdv.numero}"/></td>
  					<td><c:out value="${rdv.civilite} ${rdv.prenom} ${rdv.nom}"/></td>
  					<td>${rdv.urgent ? "oui" : "non"}</td>
  				</tr>
  			</c:forEach>
  		</tbody>
  	</table>

	<div>
	  	<ul>
		  	<c:if test="${not filePleine}">
	  			<li><a href="<c:url value="/rendezvous"/>">Prendre rendez-vous</a></li>
	  		</c:if>
	  		<li><a href="<c:url value="/"/>">Retour à l'accueil</a></li>
	  	</ul>
	</div>

  </body>
</html>
