package com.qualitas.VendedoresDao.dao;

import com.qualitas.FacturaPF.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientesDao {
    
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/factura_pf";
    private static final String USER = "root";
    private static final String PASSWORD = "epliego";
    
    private static Connection c;
    
    private static void openConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        c = DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    private static void closeConnection()
            throws SQLException {
        c.close();
    }

    public static List<Cliente> findAll()
            throws ClassNotFoundException, SQLException {
        List<Cliente> clientes = new ArrayList<>();
        openConnection();
        String sql = "SELECT * FROM  clientes ;";
        PreparedStatement pstm = c.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        
        while (rs.next()) {
            Cliente cliente = new Cliente();
            cliente.setId(rs.getInt("id"));
            cliente.setNombre(rs.getString("nombre"));
            cliente.setRfc(rs.getString("rfc"));
            cliente.setDireccion(rs.getString("direccion"));
            cliente.setEmail(rs.getString("email"));
            clientes.add(cliente);
        }
        closeConnection();
        return clientes;
    }
}
