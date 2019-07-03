<%@page import="it.corsoWebapp.model.UtenteVo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%
	UtenteVo u = (UtenteVo)request.getAttribute("idUtente");
%>
<title>Dettagli utente <%=u.getNickname()%></title>
</head>
<body>
	<h1 style="color: purple"><b>Dettagli dell'utente:</b></h1>
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Nickname</th>
					<th>Nome</th>
					<th>Cognome</th>
					<th>Mail</th>
					<th>Password</th>
				</tr>
			</thead> 
			<tbody>
				<tr>
					<td><%=u.getId_utente()%></td>
					<td><%=u.getNickname()%></td>
					<td><%=u.getNome()%></td>
					<td><%=u.getCognome()%></td>
					<td><%=u.getMail()%></td>
					<td><%=u.getPassword()%></td>
				</tr>
		</tbody>
	</table>
</body>
</html>