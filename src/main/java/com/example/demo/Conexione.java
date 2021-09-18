package com.example.demo;

import java.sql.Connection;

import conexiones.postgresql;
import conexiones.sqlserver;


public class Conexione {
	
	public Connection getConexion(String tipoDeConexion) {
		if(tipoDeConexion == null) {
			return null;
		} else if(tipoDeConexion.equalsIgnoreCase("POSTGRES")) {
			postgresql ps = new postgresql();
			return ps.conectar();
		} else if(tipoDeConexion.equalsIgnoreCase("SQLSERVER")) {
			sqlserver sql = new sqlserver();
			return sql.conectar();
		}
		
		return null;
		
	}
}

