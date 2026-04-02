package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    private static final String URL = "jdbc:mysql://localhost:3306/portafolio_java_clientes";
    private static final String USER  = "root";
    private static final String PASSWORD = "admin";

    public static Connection obtenerConexion(){
        Connection conexion = null;

        try{
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexion exitosa.");
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }

        return conexion;
    }
}
