package br.com.financeiro.model;

import java.util.Date;

public class ClientePf {
	
	
	private int id;
	private String nome;
	private String cpf;
	private String endereco;
	private String telefone;
	private Date dataCadastro;
	private long movimentacao;
	
	
	
	
	public long getMovimentacao() {
		return movimentacao;
	}
	public void setMovimentacao(long movimentacao) {
		this.movimentacao = movimentacao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	

}
