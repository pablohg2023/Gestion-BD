package datos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import control.Cliente;
import control.Producto;

public class Insertar{

    // Metodo que inserta un producto dado en la tabla producto
    public static String insertarProducto(Producto miProducto) {
        Connection conexion = null;
        Statement sentenciaSQL = null;
        String sql = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/practicabd", "pablo", "123456");

            sentenciaSQL = conexion.createStatement();

            sql = "INSERT INTO producto(nombre) VALUES ('" + miProducto.getNombre() + "')";

            System.out.println(sql);

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                sentenciaSQL.close();
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return sql;
    }

    // Metodo que inserta un producto y un cliente dado en la tabla ClienteProducto
    public static String insertarClienteProducto(Cliente miCliente, Producto miProducto) {
        Connection conexion = null;
        Statement sentenciaSQL = null;
        String sql = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/practicabd", "pablo", "123456");

            sentenciaSQL = conexion.createStatement();

            sql = "INSERT INTO cliente_producto(cliente_id,producto_id) VALUES (" + miCliente.getId() + ", " + miProducto.getId() + ")";

            System.out.println(sql);

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                sentenciaSQL.close();
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return sql;
    }

    // Metodo que inserta un cliente dado en la tabla cliente
    public static String insertarCliente(Cliente miCliente) {
        Connection conexion = null;
        Statement sentenciaSQL = null;
        String sql = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/practicabd", "pablo", "123456");

            sentenciaSQL = conexion.createStatement();

            sql = "INSERT INTO cliente(nombre) VALUES ('" + miCliente.getNombre() + "')";
            System.out.println(sql);

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                sentenciaSQL.close();
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return sql;
    }
}
