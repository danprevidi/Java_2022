package jbdc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class NovaPessoa {
	public static void main(String[] args) throws SQLException {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Infomr o nome: ");
		String nome = entrada.nextLine();
		
		Connection conexao = FabricaConexao.getConexao();
		
		String sql = "INSERT INTO pessoas (nome) VALUES (?)";
		
		//O preparestatement a partir dele passa parâmetros na consulta. É uma forma segura de não sofrer ataques do tipo "sql injection, 
		//dessa forma você garante que o sql será lido como string e não como um comando
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		
		// 1 é o parametro ?
		stmt.setString(1, nome);
		
		
		stmt.execute();
		
		System.out.println("Pessoa incluida com sucesso!");
		
		entrada.close();
	}

}
