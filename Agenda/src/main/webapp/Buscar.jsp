<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="snippet.Contacto" %>
<%@ page import="snippet.PintarHTML" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mostrar Contacto Buscado</title>
    <style>
        table {
            border-collapse: collapse;
            width: 50%;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #dddddd;
            padding: 8px;
        }
    </style>
</head>
<body>

    <h2>Lista de Contactos</h2>

    <%
    ArrayList<Contacto> contacts = (ArrayList<Contacto>)request.getAttribute("lista");
    String name = (String)request.getAttribute("nombre_buscado");
    String tabla_html = PintarHTML.crearTabla(contacts, name);
    out.println(tabla_html);
	%>

</body>
</html>
