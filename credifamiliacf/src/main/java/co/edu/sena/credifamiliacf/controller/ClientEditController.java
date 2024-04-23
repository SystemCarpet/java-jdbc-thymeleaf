package co.edu.sena.credifamiliacf.controller;


import co.edu.sena.credifamiliacf.model.City;
import co.edu.sena.credifamiliacf.model.Client;
import co.edu.sena.credifamiliacf.persistence.ConnectionJDBC;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

@WebServlet(name = "clientEdit", value = "/client-edit")
public class ClientEditController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("act");
        String id = req.getParameter("id");


                Client client = getClientById(id);

                HttpSession miSesion = req.getSession();
                miSesion.setAttribute("cliente",client);

                resp.sendRedirect("editUsuario.jsp");






    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    private Client getClientById(String id){
        Connection connection = ConnectionJDBC.getConnection();
        Client clienteById = new Client();
        try {
            String query = "select * from clientes where numero_documento ="+id+";";
            PreparedStatement pstmt = connection.prepareStatement(query);




            // Ejecutar la instrucción SQL
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                // Obtener los datos del cliente
                int numeroDocumento = rs.getInt("numero_documento");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                LocalDate fecha_nacimiento = rs.getDate("fecha_nacimiento").toLocalDate();
                int ciudad_id = rs.getInt("ciudad_id");
                String correo_electronico = rs.getString("correo_electronico");
                String telefono = rs.getString("telefono");
                String ocupacion = rs.getString("ocupacion");
                boolean viable = rs.getBoolean("viable");
                City ciudadClient = new City();
                ciudadClient.setId(ciudad_id);
                
                clienteById.setNumeroDocumento(numeroDocumento);
                clienteById.setNombre(nombre);
                clienteById.setApellidos(apellido);
                clienteById.setFechaNacimiento(fecha_nacimiento);
                clienteById.setCiudad(ciudadClient);
                clienteById.setCorreoElectronico(correo_electronico);
                clienteById.setTelefono(telefono);
                clienteById.setOcupacion(ocupacion);
                clienteById.setViabilidad(viable);
                


            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return clienteById;
    }
}
