package br.com.financeiro.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	//NOME DO USUARIO MYSQL
	private static final String USERNAME = "root";
	
	//SENHA DO USUARIO MYSQL
	private static final String PASSWORD = "12345678";
	
	//CAMINHO DO BANCO DE DADOS, PORTA E NOME
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/financeiro";
	
	/*
	 * CONEXÃO DO BANCO DE DADOS
	 */
	
	
	public static Connection createConnectionToMySql() throws SQLException, ClassNotFoundException {
		//CARREGAMENTO DA CLASSE PELA JVM
		//Class.forName("com.mysql.jdb.Driver");
		
		//CRIAÇÃO DA CONEXAO COM O BANCO DE DADOS
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
		
		
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//RECUPERAR CONEXAO COM O BANCO CASO EXISTA
		Connection con = createConnectionToMySql();
		
		if(con != null) {
			System.out.println("Conexão obtida com sucesso!");
			con.close();
		}
	}
	
	

}
