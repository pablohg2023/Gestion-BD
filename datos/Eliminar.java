package datos;

import control.Cliente;
import control.Producto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Eliminar {

    // Metodo que elimina el producto segun el nombre que introduce el usuario
    public static String eliminarProducto(Producto miProducto) {

        Connection conexion = null;
        Statement sentenciaSQL = null;
        int resultado=0;
        String sql = "";
        try {
            // conectar con la base de datos
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/practicabd", "pablo", "123456");

            sentenciaSQL = conexion.createStatement();

            sql = "DELETE FROM producto WHERE nombre = '" + miProducto.getNombre() + "'";

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

    // Metodo que elimina el cliente segun el nombre que introduce el usuario
    public static String eliminarCliente(Cliente miCliente) {

        Connection conexion = null;
        Statement sentenciaSQL = null;
        int resultado=0;
        String sql = "";
        try {
            // conectar con la base de datos
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/practicabd", "pablo", "123456");

            sentenciaSQL = conexion.createStatement();

            sql = "DELETE FROM cliente WHERE nombre = '" + miCliente.getNombre() + "'";

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
