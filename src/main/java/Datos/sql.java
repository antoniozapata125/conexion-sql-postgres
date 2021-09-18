package Datos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.example.demo.Conexione;



public class sql {
	
	public void RegistrarDatos(int cod_alumno,String nombre,String apellido,int telefono ) throws SQLException {
	Conexione conexione = new Conexione();
	Connection conexion = null;
	Connection cnServer = conexione.getConexion("SQLSERVER");

	try {

		PreparedStatement st = cnServer.prepareStatement("insert into estudiante(cod_alumno,nombre,apellido,telefono) " + "values(?,?,?,?)");

		st.setInt(1, cod_alumno);
		st.setString(2, nombre);
		st.setString(3, apellido);
		st.setInt(4, telefono);
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

	






