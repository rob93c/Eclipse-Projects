<%@page import="java.util.List"%>
<%@page import="it.corsoWebapp.model.UtenteVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista degli utenti</title>
</head>
<body>
	<% List<UtenteVo> listaUtenti = (List<UtenteVo>) request.getAttribute("listaUtenti"); %>
	<div>
		<%
			if(listaUtenti != null && !listaUtenti.isEmpty()) {
		%>
		<h1 style="color: purple"><b>Lista degli utenti:</b></h1>
		<table>
			<thead>
				<tr>
					<th>Nickname</th>
					<th>Nome</th>
					<th>Cognome</th>
					<th>Mail</th>
				</tr>
			</thead> 
			<tbody>
				<%
					for (UtenteVo u: listaUtenti) {
				%>
				<tr>
					<td><a href="getUtenteByPK?idUtente=<%=u.getidUtente()%>"><%=u.getidUtente()%></a></td>
					<td><%=u.getNome()%></td>
					<td><%=u.getCognome()%></td>
					<td><%=u.getMail()%></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
		<% 
		} else {
		%>
		<p>Nessun utente presente</p>

		<%
			} 
		%>
	</div>
</body>
</html>