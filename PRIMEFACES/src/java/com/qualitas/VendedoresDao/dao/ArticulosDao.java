package com.qualitas.VendedoresDao.dao;

import com.qualitas.FacturaPF.Articulo;
import com.qualitas.FacturaPF.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticulosDao {
    
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

    public static List<Articulo> findAll()
            throws ClassNotFoundException, SQLException {
        List<Articulo> articulos = new ArrayList<>();
        openConnection();
        String sql = "SELECT * FROM  articulos ;";
        PreparedStatement pstm = c.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        
        while (rs.next()) {
            Articulo articulo = new Articulo();
            articulo.setId(rs.getInt("id"));
            articulo.setDescripcion(rs.getString("descripcion"));
            articulo.setPrecio(rs.getFloat("precio"));
            articulo.setExistencia(rs.getInt("existencia"));
            articulos.add(articulo);
        }
        closeConnection();
        return articulos;
    }
}
