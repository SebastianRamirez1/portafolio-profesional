import conexion.ConexionDB;
import dao.ClienteDAO;
import model.Cliente;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        Connection conexion = ConexionDB.obtenerConexion();

        if (conexion != null) {
            System.out.println("Conexion correcta");
        } else {
            System.out.println("No fue posible");
        }

        Cliente cliente = new Cliente("Laura", "Martinez", "laura@email.com", "3001234567");

        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.insertarCliente(cliente);
    }
}
