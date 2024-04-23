<%@ page import="co.edu.sena.credifamiliacf.model.City" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Javier
  Date: 17/04/2024
  Time: 5:39 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nuevo usuario</title>
</head>
<body>
<h1>
    Añadir usuario
</h1>

<form action="client-add" method="POST">
        <label for="numero_documento">Número de Documento:</label><br>
        <input type="number" id="numero_documento" name="numero_documento" required><br><br>

        <label for="nombre">Nombre:</label><br>
        <input type="text" id="nombre" name="nombre" maxlength="50" required><br><br>

        <label for="apellido">Apellido:</label><br>
        <input type="text" id="apellido" name="apellido" maxlength="50" required><br><br>

        <label for="fecha_nacimiento">Fecha de Nacimiento:</label><br>
        <input type="date" id="fecha_nacimiento" name="fecha_nacimiento" required><br><br>

        <label for="ciudades_group">ID de Ciudad:</label><br>
    <select name="ciudades" id="ciudades_group">
        <%
            List<City> listaCiudades = (List) request.getSession().getAttribute("ciudades");
            for (City ciudad: listaCiudades){


        %>

        <option value="<%= ciudad.getId()%>"><%= ciudad.getNombreCiudad() %></option>
        <%
            }
        %>
    </select><br>

        <label for="correo_electronico">Correo Electrónico:</label><br>
        <input type="email" id="correo_electronico" name="correo_electronico" maxlength="50" required><br><br>

        <label for="telefono">Teléfono:</label><br>
        <input type="tel" id="telefono" name="telefono" maxlength="10"><br><br>

        <label for="ocupacion">Ocupación:</label><br>
    <select name="ocupaciones" id="ocupacion">
        <option value="empleado">Empleado</option>
        <option value="independiente">Independiente</option>
        <option value="pensionado">Pensionado</option>
    </select>

        <input type="submit" value="Enviar">
    </form>
<a href="/credifamiliacf/">volver</a>
</body>
</html>
