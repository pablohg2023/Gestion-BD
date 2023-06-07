package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import control.Cliente;
import control.Producto;
public class Update {

    // Metodo que actualiza el producto
    public static String actualizarProducto(Producto miProducto) {

        Connection conexion = null;
        Statement sentenciaSQL = null;
        int resultado=0;
        String sql = "";
        try {
            // conectar con la base de datos
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/practicabd", "pablo", "123456");

            sentenciaSQL = conexion.createStatement();

            sql = "UPDATE producto set nombre = '" + miProducto.getNombre() + "' where id = " + miProducto.getId();

            resultado = sentenciaSQL.executeUpdate(sql);

            if (resultado>=1) {
                System.out.println("Tabla actualizada");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            // System.out.println("Error");
        } finally {
            try {
                sentenciaSQL.close();
                conexion.close();
            } catch (SQLException e) {
                // TODO Bloque catch generado automáticamente
                e.printStackTrace();
            }
        }
        return sql;
    }

    // Metodo que actualiza el cliente
    public static String actualizarCliente(Cliente miCliente) {

        Connection conexion = null;
        Statement sentenciaSQL = null;
        int resultado=0;
        String sql = "";
        try {
            // conectar con la base de datos
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/practicabd", "pablo", "123456");

            sentenciaSQL = conexion.createStatement();

            sql = "UPDATE cliente set nombre = '" + miCliente.getNombre() + "' where id = " + miCliente.getId();

            resultado = sentenciaSQL.executeUpdate(sql);

            if (resultado>=1) {
                System.out.println("Tabla actualizada");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            // System.out.println("Error");
        } finally {
            try {
                sentenciaSQL.close();
                conexion.close();
            } catch (SQLException e) {
                // TODO Bloque catch generado automáticamente
                e.printStackTrace();
            }
        }
        return sql;
    }

}
