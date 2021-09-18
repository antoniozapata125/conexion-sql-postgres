package conexiones;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import inter.iconexion;

public class postgresql implements iconexion {
	private static Connection instancia;
	private static String DB_URL = "jdbc:postgresql://localhost:5433/estudiantes";
	private static String DRIVER = "org.postgresql.Driver";
	private static String USER = "postgres";
	private static String PASS = "50288840";

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


