package com.qualitasCrud.dao;

import com.qualitasCrud.bean.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersonaDao {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/java";
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

    public static void save(Usuario u)
            throws SQLException, ClassNotFoundException {
        openConnection();
        String sql = "INSERT INTO usuarios(nombre, email) " + "values (?, ?);";
        PreparedStatement pstm = c.prepareStatement(sql);
        pstm.setString(1, u.getNombre());
        pstm.setString(2, u.getEmail());
        pstm.executeUpdate();
        closeConnection();
    }
}
