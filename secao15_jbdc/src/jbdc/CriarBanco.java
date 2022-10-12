package jbdc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class CriarBanco {
	public static void main(String[] args) throws SQLException {
		final String url = "jdbc:mysql://localhost?verifyServerCertificate=false&useSSL=true";
		final String usuario = "root";
		final String senha = "root";
		
		Connection conexao = DriverManager
				.getConnection(url, usuario, senha);
		
		Statement stmt = conexao.createStatement();
		
		//A partir do statement, crio o comando sql para criar o banco		
		stmt.execute("CREATE DATABASE IF NOT EXISTS curso_java");	
		
		
		
		System.out.println("Banco criado");
		conexao.close();	
		
				
	}

}
