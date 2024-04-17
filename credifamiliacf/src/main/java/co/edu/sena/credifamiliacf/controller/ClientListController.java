package co.edu.sena.credifamiliacf.controller;

import co.edu.sena.credifamiliacf.model.Client;
import co.edu.sena.credifamiliacf.persistence.ConnectionJDBC;

import java.io.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "clientList", value = "/client-list")
public class ClientListController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ConnectionJDBC conn = new ConnectionJDBC();
        List<Client> listaUsuarios = getAllUsers();
        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("listaUsuarios",listaUsuarios);

        response.sendRedirect("usuarios.jsp");

        conn.closeConnection();
    }
    //dao facade factory
    public List<Client> getAllUsers() {
        List<Client> clientList = new ArrayList<>();
        Connection connection = ConnectionJDBC.getConnection();

        try {
            String query = "SELECT * FROM clientes";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("numero_documento");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                LocalDate fechaNacimiento = resultSet.getDate("fecha_nacimiento").toLocalDate();
                String ciudad = resultSet.getString("ciudad");
                String correoElectronico = resultSet.getString("correo_electronico");
                String telefono = resultSet.getString("telefono");
                String ocupacion = resultSet.getString("ocupacion");

                Client user = new Client(id, nombre,apellido,fechaNacimiento,ciudad,correoElectronico,telefono,ocupacion);
                clientList.add(user);
            }

            // Cierra recursos
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientList;
    }


}