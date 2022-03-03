<%@page import="it.gestionetelevisori.model.Televisore"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pagina dei risultati</title>
<style type="text/css">
table, th, td {
	border: 1px solid black;
}

th, td {
	padding: 10px;
}

.center {
	margin-left: auto;
	margin-right: auto;
}
</style>

</head>
<body>
	<table class="center">
		<thead>
			<tr>
				<th>Marca</th>
				<th>Modello</th>
				<th>Prezzo</th>
				<th>Azione</th>
			</tr>
		</thead>

		<%
			List<Televisore> risultatoDaServlet = (List<Televisore>) request.getAttribute("listByExample");
			for(Televisore item : risultatoDaServlet){
		%>
		<tr>
			<td><%= item.getMarca() %></td>
			<td><%= item.getModello() %></td>
			<td><%= item.getPrezzo() %></td>
		</tr>
		<%
		}
		%>

	</table>
	<br>
	<a href="PrepareInsertServlet">Inserisci</a>
</body>
</html>