<%@page import="it.gestionetelevisori.model.Televisore"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pagina riepilogo rimozione</title>
</head>
<body>
<table class="center">
		<thead>
			<tr>
				<th>Marca</th>
				<th>Modello</th>
				<th>Prezzo</th>
				<th>Codice</th>
				<th>Pollici</th>
			</tr>
		</thead>
		<tr>
			<%
			Televisore televisorePaginaDettaglio = (Televisore) request.getAttribute("televisoreDaInviareAPaginaDettalio");
			%>
			<td><%=televisorePaginaDettaglio.getMarca()%></td>
			<td><%=televisorePaginaDettaglio.getModello()%></td>
			<td><%=televisorePaginaDettaglio.getPrezzo()%></td>
			<td><%=televisorePaginaDettaglio.getCodice()%></td>
			<td><%=televisorePaginaDettaglio.getPollici()%></td>
			</tr>
	</table>
	<br>
	<form action="ExecuteDeleteServlet" method="post">
		<label>Sicuro di voler rimuovere?</label>
		<br>
		<input type ="hidden" name= "idTelevisore" value = <%= televisorePaginaDettaglio.getId() %>>
		<input type="submit" name = "confermaRimozione" value = "SI">
	</form>
	<a href = "searchForm.jsp">Home</a>
</body>
</html>