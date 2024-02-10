package snippet;

import java.util.ArrayList;

public class PintarHTML {
	public static String crearTabla(ArrayList<Contacto> c) {
	    String tabla = "<table>\r\n"
	            + "        <tr>\r\n"
	            + "            <th>Nombre</th>\r\n"
	            + "            <th>Apellido</th>\r\n"
	            + "            <th>Teléfono</th>\r\n"
	            + "            <th>Acciones</th>\r\n"
	            + "        </tr>";

	    for (Contacto contacto : c) {
	        tabla += "<tr><td>" + contacto.getName() +
	                "</td><td>" + contacto.getSurname() +
	                "</td><td>" + contacto.getPhone() +
	                "</td><td><form action=\"AgendaServlet\" method=\"post\">" +
	                "<input type=\"hidden\" name=\"accion\" value=\"eliminar\">" +
	                "<input type=\"hidden\" name=\"phone\" value=\"" + contacto.getPhone() + "\">" +
	                "<input type=\"image\" src=\"Media/bin.png\" alt=\"Eliminar\" style=\"height: 70px;\"\">" +
	                "</form></td></tr>";
	    }
	    tabla += "</table>";
	    return tabla;
	}



    public static String crearTabla(ArrayList<Contacto> c, String buscado) {
        String tabla = "<table>\r\n"
                + "        <tr>\r\n"
                + "            <th>Nombre</th>\r\n"
                + "            <th>Apellido</th>\r\n"
                + "            <th>Teléfono</th>\r\n"
                + "            <th>Acciones</th>\r\n"
                + "        </tr>";

        for (Contacto contacto : c) {
            if (contacto.getName().equalsIgnoreCase(buscado)) {
                tabla += "<tr><td>" + contacto.getName() +
                        "</td><td>" + contacto.getSurname() +
                        "</td><td>" + contacto.getPhone() +
                        "</td><td><a href=delete?phone=" + contacto.getPhone() +
                        "><img src=\"Media/bin.png\" alt=\"Eliminar\" style=\"height: 70px;\"\">" +
                        "</a></td></tr>";
            }
        }
        tabla += "</table>";
        return tabla;
    }

}
