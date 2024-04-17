<%@ page import="java.util.List" %>
<%@ page import="co.edu.sena.credifamiliacf.model.Client" %><%--
  Created by IntelliJ IDEA.
  User: Javier
  Date: 17/04/2024
  Time: 6:54 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Listado de usuarios</title>
</head>
<body>
<h1>usuarios</h1>
<table>
    <thead>
    <tr>
        <th>Número de documento</th>
        <th>Nombre</th>
        <th>Apellidos</th>
        <th>Fecha de nacimiento</th>
        <th>Ciudad</th>
        <th>Correo electrónico</th>
        <th>Teléfono</th>
        <th>Ocupación</th>
    </tr>
    </thead>
    <tbody>
<%
    List<Client> listaDeUsuarios = (List) request.getSession().getAttribute("listaUsuarios");
    for (Client cliente: listaDeUsuarios){


%>
    <!-- Aquí se insertarán los datos de cada fila -->
    <tr>
        <td><%= cliente.getNumeroDocumento() %></td>
        <td><%= cliente.getNombre() %></td>
        <td><%= cliente.getApellidos() %></td>
        <td><%= cliente.getFechaNacimiento() %></td>
        <td><%= cliente.getCiudad().getNombreCiudad() %></td>
        <td><%= cliente.getCorreoElectronico() %></td>
        <td><%= cliente.getTelefono() %></td>
        <td><%= cliente.getOcupacion() %></td>
    </tr>
<%
    }
%>
    </tbody>
</table>
</body>
</html>
