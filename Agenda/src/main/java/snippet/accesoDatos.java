package snippet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class accesoDatos {
    private static String ruta = "C:\\Users\\pilar\\eclipse-workspace\\Agenda\\src\\main\\webapp\\datos.csv";

    public static void insertarContacto(Contacto c) throws IOException {
        try (FileWriter fw = new FileWriter(ruta, true)) {
            String linea = c.getName() + "," + c.getSurname() + "," + c.getPhone() + "\n";
            fw.write(linea);
        }
    }

    public static void borrarContacto(String contacto) throws IOException {
        List<Contacto> contactos = recuperarContactos();
        contactos.removeIf(c -> c.getPhone().equals(contacto));
        escribirContactos(contactos);
    }

    public static List<Contacto> recuperarContactos() {
        ArrayList<Contacto> lista = new ArrayList<>();
        try (FileReader fr = new FileReader(ruta);
             BufferedReader br = new BufferedReader(fr)) {

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String nombre = datos[0];
                String apellido = datos[1];
                String telefono = datos[2];
                Contacto c = new Contacto(nombre, apellido, telefono);
                lista.add(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }

    private static void escribirContactos(List<Contacto> contactos) throws IOException {
        try (FileWriter fw = new FileWriter(ruta)) {
            for (Contacto c : contactos) {
                String linea = c.getName() + "," + c.getSurname() + "," + c.getPhone() + "\n";
                fw.write(linea);
            }
        }
    }
}