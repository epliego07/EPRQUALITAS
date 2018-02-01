package com.qualitas.VendedoresDao.dao;

import com.qualitas.FacturaPF.Vendedores;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendedoresDao {

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
/**
 * busca un vendedor con base en el nombre de ususauriio y contraseña
 * @param usuario nombre del usuario vendedor
 * @param contrasenia contraseña del vendedor
 * @return si el usuario y contraseña coresponden , se devuelve la instancia completa.
 * en caso contrario null
 * @throws ClassNotFoundException si el controlador no esta definido
 * @throws SQLException si alguna operacion on la BD es erronea
 */
    public static Vendedores find(String usuario, String contrasenia)
            throws ClassNotFoundException, SQLException {
        Vendedores vendedor = null;
        openConnection();
        String sql = "SELECT * FROM  vendedores WHERE usuario=? AND contrasenia=md5(?) ;";
        PreparedStatement pstm = c.prepareStatement(sql);
        pstm.setString(1, usuario);
        pstm.setString(2, contrasenia);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            vendedor = new Vendedores();
            vendedor.setId(rs.getInt("id"));
            vendedor.setNombre(rs.getString("nombre"));
            vendedor.setUsuario(rs.getString("usuario"));
            vendedor.setContrasenia(rs.getString("contrasenia"));

        }
        closeConnection();
        return vendedor;
    }
}
