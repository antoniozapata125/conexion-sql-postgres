package conexiones;
import inter.iconexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class sqlserver implements iconexion {
	private static Connection instancia;

	private static String DB_URL = "jdbc:sqlserver://localhost\\LAPTOP-KASV1AK1:1433;databaseName=Datos";
	private static String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String USER = "UsuarioSQL";
	private static String PASS = "321";

	@Override
	public Connection conectar() {
		try {

			if (instancia == null) {
				Class.forName(DRIVER);
				instancia = DriverManager.getConnection(DB_URL, USER, PASS);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException("Conexión fallida", e);
		}
		return instancia;
	}

	@Override
	public void desconectar() {
		try {
			Connection conn = conectar();
			conn.close();
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}

	}

}
