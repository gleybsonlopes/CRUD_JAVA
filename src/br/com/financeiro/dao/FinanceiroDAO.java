package br.com.financeiro.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.financeiro.factory.ConnectionFactory;
import br.com.financeiro.model.ClientePf;
import br.com.financeiro.model.ClientePj;

public class FinanceiroDAO {
	
	//CRUD
	
	public void save(ClientePf clientepf) {

		String sql = "INSERT INTO clientes(nome, cpf, endereco,"
				+ "telefone, dataCadastro, movimentacao) VALUES(?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//CRIAR CONEXAO COM O BANCO
			conn = ConnectionFactory.createConnectionToMySql();
			
			
			//CRIAR O PreparedStatement, PARA EXECUTAR UMA QUERY
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			//ADICIONA OS VALORES ESPERADOS PELA QUERY
			pstm.setString(1, clientepf.getNome());
			pstm.setString(2, clientepf.getCpf());
			pstm.setString(3, clientepf.getEndereco());
			pstm.setString(4, clientepf.getTelefone());
			pstm.setDate(5, new Date(clientepf.getDataCadastro().getTime()));
			pstm.setLong(6, clientepf.getMovimentacao());
			
			//EXECUTA A QUERY
			pstm.execute();
			System.out.println("Cadastro Pessoa Fisica inserido com sucesso!");
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			//FECHAR CONEXOES
			
			try {
				if(pstm != null) {
					pstm.close();
					
				}
				if(conn != null) {
					conn.close();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		
			
		}
		
	};
	
	public void save(ClientePj clientepj) {


		String sql = "INSERT INTO clientes(nome, cnpj, endereco,"
				+ "telefone, dataCadastro, movimentacao) VALUES(?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//CRIAR CONEXAO COM O BANCO
			conn = ConnectionFactory.createConnectionToMySql();
			
			
			//CRIAR O PreparedStatement, PARA EXECUTAR UMA QUERY
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			//ADICIONA OS VALORES ESPERADOS PELA QUERY
			pstm.setString(1, clientepj.getNome());
			pstm.setString(2, clientepj.getCnpj());
			pstm.setString(3, clientepj.getEndereco());
			pstm.setString(4, clientepj.getTelefone());
			pstm.setDate(5, new Date(clientepj.getDataCadastro().getTime()));
			pstm.setLong(6, clientepj.getMovimentacao());
			
			//EXECUTA A QUERY
			pstm.execute();
			System.out.println("Cadastro Pessoa Juridica inserido com sucesso!");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//FECHAR CONEXOES
			
			try {
				if(pstm != null) {
					pstm.close();
					
				}
				if(conn != null) {
					conn.close();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	};
	
	public void update(ClientePf clientePf) {




		
		String sql = "UPDATE clientes SET nome = ?, cpf = ?, endereco = ?, telefone = ?, dataCadastro = ?, movimentacao = ? "+
		"WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//CRIAR CONEXAO COM O BANCO
			conn = ConnectionFactory.createConnectionToMySql();
			
			//CRIAR CLASSE PARA EXECUTAR A QUERY
			pstm = conn.prepareStatement(sql);
			
			//ADICIONAR OS VALORES PARA ATUALIZAR
			pstm.setString(1, clientePf.getNome());
			pstm.setString(2, clientePf.getCpf());
			pstm.setString(3, clientePf.getEndereco());
			pstm.setString(4, clientePf.getTelefone());
			pstm.setDate(5, new Date(clientePf.getDataCadastro().getTime()));
			pstm.setLong(6, clientePf.getMovimentacao());
			
			//QUAL O ID DO REGISTRO QUE DESEJA ATUALIZAR?
			pstm.setInt(7, clientePf.getId());
			
			//EXECUTAR A QUERY
			pstm.execute();
			System.out.println("Registro atualizado com sucesso! ");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	


	public void deleteByID(int id) {
		String sql = "DELETE FROM clientes WHERE id = ?";
		Connection conn = null;
		
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySql();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			pstm.execute();
			System.out.println("Registro deletado com sucesso do banco de dados!");
			
		} catch (Exception e) {
			System.out.println("Esse registro não existe no banco de dados");
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				System.out.println("Esse registro não existe no banco de dados");
				e2.printStackTrace();
			}
		}
		
	}

	public List<ClientePf> getClientePf(){

		String sql = "SELECT * FROM clientes";
		
		List<ClientePf> clientespf = new ArrayList<ClientePf>();
		Connection conn = null;
		PreparedStatement pstm = null;
		
		//CLASSE QUE RECUPERA DADOS DO BANCO "select	"
		ResultSet rst = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySql();
			
			pstm = conn.prepareStatement(sql);
			
			rst = pstm.executeQuery();
			
			while (rst.next()) {
				
				ClientePf clientePf = new ClientePf();
				
				//RECUPERAR ID
				clientePf.setId(rst.getInt("id"));
				
				//RECUPERAR NOME
				clientePf.setNome(rst.getString("nome"));
				
				//RECUPERAR CPF
				clientePf.setCpf(rst.getString("cpf"));
				
				//RECUPERAR ENDEREÇO
				clientePf.setEndereco(rst.getString("endereco"));
				
				//RECUPERAR TELEFONE
				clientePf.setTelefone(rst.getString("telefone"));
				
				//RECUPERAR DATA DE CADASTRO
				clientePf.setDataCadastro(rst.getDate("datacadastro"));
				
				//RECUPERAR DA MOVIMENTACAO
				clientePf.setMovimentacao(rst.getLong("movimentacao"));
				
				clientespf.add(clientePf);
							
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rst != null) {
					rst.close();
					
				}if(pstm != null) {
					pstm.close();
				}if(conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();			
				}
		}
		return clientespf;
	} 
	
	public List<ClientePj> getClientePj(){



		String sql = "SELECT * FROM clientes";
		
		List<ClientePj> clientespj = new ArrayList<ClientePj>();
		Connection conn = null;
		PreparedStatement pstm = null;
		
		//CLASSE QUE RECUPERA DADOS DO BANCO "select	"
		ResultSet rst = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySql();
			
			pstm = conn.prepareStatement(sql);
			
			rst = pstm.executeQuery();
			
			while (rst.next()) {
				
				ClientePj clientePj = new ClientePj();
				
				//RECUPERAR ID
				clientePj.setId(rst.getInt("id"));
				
				//RECUPERAR NOME
				clientePj.setNome(rst.getString("nome"));
				
				//RECUPERAR CPF
				clientePj.setCnpj(rst.getString("cnpj"));
				
				//RECUPERAR ENDEREÇO
				clientePj.setEndereco(rst.getString("endereco"));
				
				//RECUPERAR TELEFONE
				clientePj.setTelefone(rst.getString("telefone"));
				
				//RECUPERAR DATA DE CADASTRO
				clientePj.setDataCadastro(rst.getDate("datacadastro"));
				
				//RECUPERAR A MOVIMENTACAO
				clientePj.setMovimentacao(rst.getLong("movimentacao"));
				
				clientespj.add(clientePj);
							
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rst != null) {
					rst.close();
					
				}if(pstm != null) {
					pstm.close();
				}if(conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();			
				}
		}
		return clientespj;
	
	
}
	
	
	public void update(ClientePj clientePj) {


		
		String sql = "UPDATE clientes SET nome = ?, cnpj = ?, endereco = ?, telefone = ?, dataCadastro = ?, movimentacao = ? "+
		"WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//CRIAR CONEXAO COM O BANCO
			conn = ConnectionFactory.createConnectionToMySql();
			
			//CRIAR CLASSE PARA EXECUTAR A QUERY
			pstm = conn.prepareStatement(sql);
			
			//ADICIONAR OS VALORES PARA ATUALIZAR
			pstm.setString(1, clientePj.getNome());
			pstm.setString(2, clientePj.getCnpj());
			pstm.setString(3, clientePj.getEndereco());
			pstm.setString(4, clientePj.getTelefone());
			pstm.setDate(5, new Date(clientePj.getDataCadastro().getTime()));
			pstm.setLong(6, clientePj.getMovimentacao());
			
			//QUAL O ID DO REGISTRO QUE DESEJA ATUALIZAR?
			pstm.setInt(7, clientePj.getId());
			
			//EXECUTAR A QUERY
			pstm.execute();
			System.out.println("Registro atualizado com sucesso! ");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
}
