package com.sebastian.gestionclientes.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConexionDB {

    private static final String URL = "jdbc:mysql://localhost:3306/portafolio_java_clientes";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    private ConexionDB() {
    }

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
