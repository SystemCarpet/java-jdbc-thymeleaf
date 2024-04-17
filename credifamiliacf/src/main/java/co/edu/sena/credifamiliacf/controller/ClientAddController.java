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

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    //dao facade factory


}