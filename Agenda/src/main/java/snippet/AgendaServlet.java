package snippet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class ServletNuevo
 */
public class AgendaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AgendaServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String accion = request.getParameter("accion");
	    
	    if (accion != null && accion.equals("insertar")) {
	        String name = request.getParameter("name");
	        String surname = request.getParameter("surname");
	        String phone = request.getParameter("phone");
	        Contacto nuevoContacto = new Contacto(name, surname, phone);
	        accesoDatos.insertarContacto(nuevoContacto);
	        List<Contacto> contacts = accesoDatos.recuperarContactos();
	        request.setAttribute("lista", contacts);
	    }else if(accion.equals("buscar")){
	    	String nombre = request.getParameter("nombre_buscado");
	    	List<Contacto> contacts = accesoDatos.recuperarContactos();
	        request.setAttribute("lista", contacts);
	        request.setAttribute("nombre_buscado", nombre);
	    	request.getRequestDispatcher("Buscar.jsp").forward(request, response);
	    }else if(accion.equals("eliminar")){
	    	String phoneToDelete = request.getParameter("phone");
	        if (phoneToDelete != null && !phoneToDelete.isEmpty()) {
	            String numberDelete = phoneToDelete;
	            accesoDatos.borrarContacto(numberDelete);
	        }
	        response.sendRedirect(request.getContextPath() + "/enviar.jsp");
	        return;
	    }
	    	List<Contacto> contacts = accesoDatos.recuperarContactos();
	        request.setAttribute("lista", contacts);
	    	request.getRequestDispatcher("mostrar.jsp").forward(request, response); // MOSTRAR
	    
        
	}

}





