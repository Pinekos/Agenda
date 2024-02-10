<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="snippet.Contacto" %>
<%@ page import="snippet.PintarHTML" %>
<%@ page import="snippet.accesoDatos" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mostrar Contactos</title>
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
    

    <form action="AgendaServlet?accion=eliminar" method="post">
        <input type="hidden" name="accion" value="eliminar">
        
        <%
        ArrayList<Contacto> contacts = (ArrayList<Contacto>) request.getAttribute("lista");
        String tabla_html = PintarHTML.crearTabla(contacts);
        out.println(tabla_html);
        %>
        
    </form>

</body>
</html>


