package jbdc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {
	public static void main(String[] args) throws SQLException {
		
		//?verifyServerCertificate e ?useSSL parâmetros para verificar certif. e conexão segura
		String url = "jdbc:mysql://localhost?verifyServerCertificate=false&useSSL=true";
		//final para constante
		final String usuario = "root";
		final String senha = "root";
		
		//driver do mysql
		//exceção checada - precisa ser checada (throws)
		Connection conexao = DriverManager
				.getConnection(url, usuario, senha); 
		
		System.out.println("Conexão efetuada com sucesso!");
		conexao.close();
		
	}

}