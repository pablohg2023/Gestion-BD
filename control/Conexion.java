package control;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

    public static int insertarBD(String sql) {

        Connection conexion = null;
        Statement sentenciaSQL = null;
        int resultado=0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/practicabd", "pablo", "123456");

            sentenciaSQL = conexion.createStatement();

            resultado = sentenciaSQL.executeUpdate(sql);

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            // System.out.println("Error");
        } finally {
            try {
                sentenciaSQL.close();
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resultado;
    }
}
