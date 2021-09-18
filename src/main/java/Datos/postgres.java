package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import com.example.demo.Conexione;


public class postgres {
	
	
	public void RegistrarDatos(String nombre, int idestudiante) throws SQLException {

		Conexione conexione = new Conexione();
		Connection conexion = null;
		Connection cnPostgres = conexione.getConexion("POSTGRES");

		try {

			PreparedStatement st = cnPostgres.prepareStatement("insert into estudiante(idestudiante,nombre) " + "values(?,?)");

			st.setInt(1, idestudiante);
			st.setString(2, nombre);

			st.execute();
			st.close();

		} catch (Exception e) {

			e.getMessage();

		} finally {

			if (conexion != null) {

				if (!conexion.isClosed()) {

					conexion.close();
				}
			}
		}
	}
}
