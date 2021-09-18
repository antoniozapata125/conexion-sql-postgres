package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import Datos.postgres;
import Datos.sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.PreparedStatement;

@SpringBootApplication
public class ConexionApplication {

	public static void main(String[] args) throws SQLException{
		SpringApplication.run(ConexionApplication.class, args);
		Scanner scn = new Scanner(System.in);
		Conexione conexione = new Conexione();
		
		
		
		char DataBase;
		System.out.println("Seleccione la base de datos a registrar:");
		System.out.println("PostgreSQL = o 	SQL Server = q");

		System.out.print("Base de Datos: ");
		DataBase = scn.next().charAt(0);

		if (DataBase == 'o' | DataBase == 'q') {
			
			
		//PostgreSQL
			if (DataBase == 'o') {
				postgres postgre = new postgres();
				System.out.println("Base de Datos PostgreSQL");
				Connection cnPostgres = conexione.getConexion("POSTGRES");

				// PostgreSQL
				if (cnPostgres != null) {
					System.out.println("Conectado a Postgres");
					String nombre;
					int idestudiante;

					System.out.println("   Ingrese id: ");
					System.out.print(" -");
					idestudiante = scn.nextInt();

					System.out.println("   Ingrese nombre: ");
					System.out.print(" -");
					nombre = scn.next();

					postgre.RegistrarDatos(nombre, idestudiante);

					System.out.println("Datos registrados correctamente");
				}
		    } 
			
			//SQL server
			if (DataBase == 'q') {
				
				sql SqlServer = new sql();
				System.out.println("Base de Datos SQL Server");
				Connection cnServer = conexione.getConexion("SQLSERVER");

				// SQLServer
				if (cnServer != null) {

					System.out.println("Conectado a SQLServer");
					
					int telefono;
					String apellido;
					String nombre;
					int cod_alumno;
					
					
					System.out.println("   Ingrese nombre: ");
					System.out.print(" -");
					nombre = scn.next();
					
					System.out.println(" Ingrese el apellido: ");
					System.out.println(" -");
					apellido = scn.next();
					
					System.out.println(" Ingrese el numero: ");
					System.out.println(" -");
					telefono= scn.nextInt();
					
					System.out.println("   Ingrese cod_alumno: ");
					System.out.print(" -");
					cod_alumno = scn.nextInt();
					
					SqlServer.RegistrarDatos(cod_alumno, apellido, nombre,telefono);

					System.out.println("Datos registrados correctamente");
				}
			} 
			
		}else {
			System.out.println("Base de datos seleccionada no coincide, por favor ingrese una opción valida.");
			
		
			}
		}

	}


