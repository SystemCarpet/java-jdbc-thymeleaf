package co.edu.sena.credifamiliacf.controller;

import co.edu.sena.credifamiliacf.model.City;
import co.edu.sena.credifamiliacf.model.Client;
import co.edu.sena.credifamiliacf.persistence.ConnectionJDBC;

import java.io.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "clientAdd", value = "/client-add")
public class ClientAddController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ConnectionJDBC conn = new ConnectionJDBC();
        List<City> ciudades = getAllCitys();
        HttpSession miSesion = req.getSession();
        miSesion.setAttribute("ciudades",ciudades);

        resp.sendRedirect("newUsuario.jsp");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String numeroDocumento = req.getParameter("numero_documento");
        String nombre = req.getParameter("nombre");
        String apellidos = req.getParameter("apellido");
        String fechaNacimiento = req.getParameter("fecha_nacimiento");
        String ciudad = req.getParameter("ciudades");
        String correo = req.getParameter("correo_electronico");
        String telefono = req.getParameter("telefono");
        String ocupacion = req.getParameter("ocupaciones");

        Client nuevoCliente= new Client();
        City clientCity = new City();
        nuevoCliente.setNumeroDocumento(Integer.parseInt(numeroDocumento));
        nuevoCliente.setNombre(nombre);
        nuevoCliente.setApellidos(apellidos);
        nuevoCliente.setFechaNacimiento(LocalDate.parse( fechaNacimiento));
        clientCity.setId(Integer.parseInt(ciudad));
        nuevoCliente.setCiudad(clientCity);
        nuevoCliente.setCorreoElectronico(correo);
        nuevoCliente.setTelefono(telefono);
        nuevoCliente.setOcupacion(ocupacion);

        saveUser(nuevoCliente);
        resp.sendRedirect("index.jsp");

    }

    //dao facade factory
    private List<City> getAllCitys() {
        List<City> cityList = new ArrayList<>();
        Connection connection = ConnectionJDBC.getConnection();

        try {
            String query = "SELECT * FROM ciudad";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre_ciudad");

                City ciudad = new City(id,nombre);
                cityList.add(ciudad);
            }

            // Cierra recursos
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cityList;
    }

    private void saveUser(Client cliente){
        Connection connection = ConnectionJDBC.getConnection();
        try {
            String query = "INSERT INTO clientes (numero_documento, nombre, apellido, fecha_nacimiento, ciudad_id, correo_electronico, telefono, ocupacion, viable) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(query);

            pstmt.setInt(1, cliente.getNumeroDocumento());
            pstmt.setString(2, cliente.getNombre());
            pstmt.setString(3, cliente.getApellidos());
            pstmt.setDate(4, java.sql.Date.valueOf(cliente.getFechaNacimiento()));
            pstmt.setInt(5, cliente.getCiudad().getId());
            pstmt.setString(6, cliente.getCorreoElectronico());
            pstmt.setString(7, cliente.getTelefono());
            pstmt.setString(8, cliente.getOcupacion());
            //logica de negocio brr
            LocalDate fechaActual = LocalDate.now();
            int edad = Period.between(cliente.getFechaNacimiento(), fechaActual).getYears();
            if (edad >= 18 && edad <=65){
                pstmt.setBoolean(9, true);
            }else {
                pstmt.setBoolean(9, false);
            }




            // Ejecutar la instrucción SQL
            pstmt.executeUpdate();


        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}