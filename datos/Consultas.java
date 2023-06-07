package datos;

import control.Cliente;
import control.Producto;

import java.sql.*;

public class Consultas {

    // Metodo que muestra la tabla de clientes
    public static String mostrarCliente() {
        Connection conexion = null;
        Statement sentenciaSQL = null;
        ResultSet rs;
        String sql = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/practicabd", "pablo", "123456");

            sentenciaSQL = conexion.createStatement();

            sql = "SELECT * FROM `cliente`";

            rs = sentenciaSQL.executeQuery(sql);
            while (rs.next()) {
                System.out.println("idCliente: " + rs.getInt("id") + ", nombre: " + rs.getString("nombre"));
            }

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                sentenciaSQL.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return sql;
    }

    // Metodo que muestra la tabla de Productos
    public static String mostrarProducto() {

        Connection conexion = null;
        Statement sentenciaSQL = null;
        ResultSet rs;
        String sql = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/practicabd", "pablo", "123456");

            sentenciaSQL = conexion.createStatement();
            sql = "SELECT * FROM `producto`";

            rs = sentenciaSQL.executeQuery(sql);
            while (rs.next()) {

                System.out.println("idProducto: " + rs.getInt("id") + ", nombre: " + rs.getString("nombre"));
            }

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                sentenciaSQL.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return sql;
    }

    // Metodo que calcula el total de los clientes
    public static String totalClientes() {
        // TODO Auto-generated method stub
        Connection conexion = null;
        Statement sentenciaSQL = null;
        String sql = "";
        ResultSet rs;

        try {
            // conectar con la base de datos
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/practicabd", "pablo", "123456");

            sentenciaSQL = conexion.createStatement();

            sql = "SELECT COUNT(*) FROM cliente";

            rs = sentenciaSQL.executeQuery(sql);

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

    // Metodo que te da los clientes asociados al nombre del producto introducido
    public static String darClientes(Producto miProducto) {

        Connection conexion = null;
        Statement sentenciaSQL = null;
        ResultSet rs;
        String sql = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/practicabd", "pablo", "123456");

            sentenciaSQL = conexion.createStatement();

            sql = " select * from producto\n" +
                    " inner join cliente_producto on cliente_producto.producto_id = producto.id\n" +
                    " inner join cliente on cliente.id = cliente_producto.cliente_id\n" +
                    " where producto.nombre like '" + miProducto.getNombre() + "'";

            rs = sentenciaSQL.executeQuery(sql);

            while (rs.next()) {
                System.out.println("id: " + rs.getInt("cliente.id") + ", nombre: " + rs.getString("cliente.nombre"));
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

    // Metodo que te da los productos asociados al nombre del cliente introducido
    public static String darProductos(Cliente miCliente) {

        Connection conexion = null;
        Statement sentenciaSQL = null;
        ResultSet rs;
        String sql = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/practicabd", "pablo", "123456");

            sentenciaSQL = conexion.createStatement();

            sql = " select * from producto\n" +
                    " inner join cliente_producto on cliente_producto.producto_id = producto.id\n" +
                    " inner join cliente on cliente.id = cliente_producto.cliente_id\n" +
                    " where cliente.nombre like '" + miCliente.getNombre() + "'";

            rs = sentenciaSQL.executeQuery(sql);

            while (rs.next()) {
                System.out.println("id: " + rs.getInt("producto.id") + ", nombre: " + rs.getString("producto.nombre"));
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

    // Metodo que te muestra el producto mas comprado
    public static String productoUsado() {
        // TODO Auto-generated method stub
        Connection conexion = null;
        Statement sentenciaSQL = null;
        String sql = "";
        ResultSet rs;

        try {
            // conectar con la base de datos
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/practicabd", "pablo", "123456");

            sentenciaSQL = conexion.createStatement();

            sql = "select nombre from producto\n" +
                    "inner join cliente_producto on cliente_producto.producto_id = producto.id\n" +
                    "group by producto_id order by count(*) desc limit 1";

            rs = sentenciaSQL.executeQuery(sql);

            while (rs.next()) {
                System.out.println("nombre: " + rs.getString("producto.nombre"));
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

    // Metodo que te muestra los clientes que no tienen ningun producto asociado
    public static String clienteSinProducto() {
        // TODO Auto-generated method stub
        Connection conexion = null;
        Statement sentenciaSQL = null;
        String sql = "";
        ResultSet rs;

        try {
            // conectar con la base de datos
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/practicabd", "pablo", "123456");

            sentenciaSQL = conexion.createStatement();

            sql = "select nombre from cliente where id not in (select cliente_id from cliente_producto)";

            rs = sentenciaSQL.executeQuery(sql);

            while (rs.next()) {
                System.out.println("nombre: " + rs.getString("cliente.nombre"));
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
