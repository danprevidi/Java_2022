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
		
		//O preparestatement a partir dele passa par�metros na consulta. � uma forma segura de n�o sofrer ataques do tipo "sql injection, 
		//dessa forma voc� garante que o sql ser� lido como string e n�o como um comando
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		
		// 1 � o parametro ?
		stmt.setString(1, nome);
		
		
		stmt.execute();
		
		System.out.println("Pessoa incluida com sucesso!");
		
		entrada.close();
	}

}
