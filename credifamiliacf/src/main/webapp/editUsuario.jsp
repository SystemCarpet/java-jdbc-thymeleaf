<%@ page import="co.edu.sena.credifamiliacf.model.Client" %><%--
  Created by IntelliJ IDEA.
  User: Javier
  Date: 23/04/2024
  Time: 6:24 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Editar usuario</title>
</head>
<body>
<%
    Client cliente = (Client) request.getSession().getAttribute("cliente");
%>

<h1>Editar cliente: <%= cliente.getNombre() +" "+ cliente.getApellidos() %></h1>

</body>
</html>
