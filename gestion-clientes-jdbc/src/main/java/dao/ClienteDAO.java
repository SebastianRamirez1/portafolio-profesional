package dao;

import conexion.ConexionDB;
import model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {

    public void insertarCliente(Cliente cliente){
        String sql = "INSERT INTO clientes(nombre,apellido,correo,telefono) VALUES(?,?,?,?)";

        try{
            Connection conexion = ConexionDB.obtenerConexion();
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getCorreo());
            ps.setString(4, cliente.getTelefono());

            int filasAfectadas = ps.executeUpdate();

            if(filasAfectadas > 0){
                System.out.println("Cliente agregado correctamente");
            }
            ps.close();
            conexion.close();
        }catch(SQLException e){
            System.out.println("Error al insertar clientes: " + e.getMessage());
        }

    }
}
