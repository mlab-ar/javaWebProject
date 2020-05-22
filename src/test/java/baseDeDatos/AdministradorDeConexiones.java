package baseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;

public class AdministradorDeConexiones {
	Connection con;
    String url = "jdbc:mysql://localhost/carro";
    String user = "root";
    String pass = "";

    public Connection obtenerConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
        }
        return con;
    }
}
