<%@page pageEncoding="UTF-8" isErrorPage="true" contentType="text/html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
  	<meta charset="UTF-8">
    <title>Java EE</title>
  </head>
  <body>
  	<ul>
  		<li><a href="<c:url value="/rendezvous"/>">Prendre rendez-vous</a></li>
  		<li><a href="<c:url value="/attente"/>">Voir la file d'attente</a></li>
  	</ul>
  </body>
</html>