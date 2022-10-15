package jbdc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AtualizaPessoasDesafio {
	public static void main(String[] args) throws SQLException {
		
		Connection conexao = FabricaConexao.getConexao();
		String sql = "SELECT * FROM pessoas WHERE nome LIKE ?";
		String sqlup = "UPDATE pessoas set nome = ? WHERE codigo = ?";
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Busque um registro para alterar: ");
		String valor = entrada.nextLine();
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, "%" + valor + "%");
		ResultSet resultado = stmt.executeQuery();
		
		List<Pessoa> pessoas = new ArrayList<>();

		while (resultado.next()) {
			int codigo = resultado.getInt("codigo");
			String nome = resultado.getString("nome");
			pessoas.add(new Pessoa(codigo, nome));			
			
		}
		for (Pessoa p : pessoas) {
			System.out.println(p.getCodigo() + " - " + p.getNome());
		}
			
		PreparedStatement stmtup = conexao.prepareStatement(sqlup);	
		
		System.out.println("Digite o codigo para alterar: ");
		int codigo = entrada.nextInt();
		entrada.nextLine();
		
		System.out.println("Digite o novo nome:");
		String novonome = entrada.nextLine();		
		
	
		stmtup.setString(1, novonome);
		stmtup.setInt(2, codigo);
		
		stmtup.execute();
		
		System.out.println("Alterado com sucesso!");
		
		
		stmtup.close();
		conexao.close();
		
		
	}			

}
