package co.edu.sena;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        Conexion conexion = new Conexion();
        Connection connection = conexion.getConnection();


        conexion.closeConnection();

    }
}