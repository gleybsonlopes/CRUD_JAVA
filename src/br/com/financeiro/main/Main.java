package br.com.financeiro.main;

import java.util.Date;
import java.util.Scanner;

import br.com.financeiro.dao.FinanceiroDAO;
import br.com.financeiro.model.ClientePf;
import br.com.financeiro.model.ClientePj;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		FinanceiroDAO financeiroDao = new FinanceiroDAO();

		menuInicial();

	}

	private static void menuInicial() {

		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		int opcao;

		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("=-=-=-=-=-=-=- BEM VINDO =-=-=-=-=-=-=-");
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("=-=--=- Listar todos clientes - 1 -=-=-");
		System.out.println("=-=--=-=- Listar clientes PF - 2 -=-=-=");
		System.out.println("=-=--=-= Listar clientes PJ - 3 -=-=-=-");
		System.out.println("=--=-= Cadastrar Cliente PF - 4 -=-==-=");
		System.out.println("=--=-= Cadastrar Cliente PJ - 5 -=-==-=");
		System.out.println("=--=-= Atualizar Cliente PF - 6 -=-=-=-");
		System.out.println("=--=-= Atualizar Cliente PJ - 7 -=-=-=-");
		System.out.println("=--=-=-= Deletar Cliente - 8 -=-=-=-=-=");
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("\n");
		opcao = entrada.nextInt();

		switch (opcao) {
		case 1: {
			System.out.println("-=-=-= CLIENTES CADASTRADOS -=-=-=");
			listarClientesPorCpf();
			listarClientesPorCnpj();
			System.out.println("\n");
			menuInicial();

		}
			break;
		case 2: {
			System.out.println("-=-=-= CLIENTES PF CADASTRADOS -=-=-=");
			listarClientesPorCpf();
			System.out.println("\n");
			menuInicial();
		}
			break;
		case 3: {
			System.out.println("-=-=-= CLIENTES PJ CADASTRADOS -=-=-=");
			listarClientesPorCnpj();
			System.out.println("\n");
			menuInicial();
		}
			break;
		case 4: {
			cadastroDeClientePf();
			System.out.println(" ");
			menuInicial();
			
		}
		case 5: {
			cadastroDeClientePj();
			System.out.println(" ");
			menuInicial();
			
		}
		case 6: {
			atualizarClientePf();
			menuInicial();
			
		}
		case 7: {
			atualizarClientePj();
			menuInicial();
					
		}
		case 8: {
			deletarPorId();
			menuInicial();
		}
			break;
		default:

		}

	}

	private static void cadastroDeClientePf() {

		FinanceiroDAO financeiroDao = new FinanceiroDAO();
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);

		ClientePf c1 = new ClientePf();

		System.out.println("Digite o Nome do cliente: ");
		c1.setNome(entrada.nextLine());
		System.out.println();

		System.out.println("Digite o CPF do cliente: ");
		c1.setCpf(entrada.nextLine());
		System.out.println();

		System.out.println("Digite o Endereço do cliente: ");
		c1.setEndereco(entrada.nextLine());
		System.out.println();

		System.out.println("Digite o Telefone do cliente: ");
		c1.setTelefone(entrada.nextLine());
		System.out.println();

		c1.setDataCadastro(new Date());
		
		System.out.println("Digite a movimentacao do cliente R$: ");
		c1.setMovimentacao(entrada.nextLong());
		System.out.println();
		
		
		financeiroDao.save(c1);

	}
	private static void cadastroDeClientePj() {

		FinanceiroDAO financeiroDao = new FinanceiroDAO();
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);

		ClientePj c1 = new ClientePj();

		System.out.println("Digite o Nome do cliente: ");
		c1.setNome(entrada.nextLine());
		System.out.println();

		System.out.println("Digite o CNPJ do cliente: ");
		c1.setCnpj(entrada.nextLine());
		System.out.println();

		System.out.println("Digite o Endereço do cliente: ");
		c1.setEndereco(entrada.nextLine());
		System.out.println();

		System.out.println("Digite o Telefone do cliente: ");
		c1.setTelefone(entrada.nextLine());
		System.out.println();

		c1.setDataCadastro(new Date());
		
		System.out.println("Digite a movimentacao do cliente R$: ");
		c1.setMovimentacao(entrada.nextLong());
		System.out.println();
		
		financeiroDao.save(c1);

	}

	private static void listarClientesPorCpf() {


		FinanceiroDAO financeiroDao = new FinanceiroDAO();

		for (ClientePf c : financeiroDao.getClientePf()) {

			if (c.getCpf() != null) {
				System.out.println(" \n");
				System.out.println(" -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=- ");

				System.out.println(" \n");

				System.out.println("ID: " + c.getId() + "\n" + "Nome: " + c.getNome() + "\n" + "CPF: " + c.getCpf()
						+ "\n" + "Endereço: " + c.getEndereco() + "\n" + "Telefone: " + c.getTelefone() + "\n" + "Movimentação R$: " + c.getMovimentacao());

			}

		}

	}

	private static void listarClientesPorCnpj() {


		FinanceiroDAO financeiroDao = new FinanceiroDAO();
		for (ClientePj c : financeiroDao.getClientePj()) {

			if (c.getCnpj() != null) {
				System.out.println(" \n");
				System.out.println(" -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=- ");

				System.out.println(" \n");

				System.out.println("ID: " + c.getId() + "\n" + "Nome: " + c.getNome() + "\n" + "CNPJ: " + c.getCnpj()
						+ "\n" + "Endereço: " + c.getEndereco() + "\n" + "Telefone: " + c.getTelefone() + "\n" + "Movimentação R$: " + c.getMovimentacao());

			}
		}

	}

	private static void atualizarClientePf() {




		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		FinanceiroDAO financeiroDao = new FinanceiroDAO();
		ClientePf c1 = new ClientePf();

		System.out.println("-=-=-= CLIENTES PF CADASTRADOS -=-=-=");
		listarClientesPorCpf();
		System.out.println("\n");

		System.out.println("Digite o nome do cliente para atualizar: ");
		c1.setNome(entrada.nextLine());
		System.out.println();

		System.out.println("Digite o CPF para atualizar: ");
		c1.setCpf(entrada.nextLine());
		System.out.println();

		System.out.println("Digite o endereço para atualizar: ");
		c1.setEndereco(entrada.nextLine());
		System.out.println();

		System.out.println("Digite o telefone para atualizar: ");
		c1.setTelefone(entrada.nextLine());
		System.out.println();

		c1.setDataCadastro(new Date());
		
		System.out.println("Digite a movimentação para atualizar R$:  ");
		c1.setMovimentacao(entrada.nextLong());
		System.out.println();
		
		System.out.println("Digite o ID do cliente que deseja atualizar: ");
		c1.setId(entrada.nextInt());
		System.out.println();

		financeiroDao.update(c1);

	}
	
	private static void atualizarClientePj() {


		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		FinanceiroDAO financeiroDao = new FinanceiroDAO();
		ClientePj c1 = new ClientePj();

		System.out.println("-=-=-= CLIENTES PJ CADASTRADOS -=-=-=");
		listarClientesPorCnpj();
		System.out.println("\n");

		System.out.println("Digite o nome do cliente para atualizar: ");
		c1.setNome(entrada.nextLine());
		System.out.println();

		System.out.println("Digite o CNPJ para atualizar: ");
		c1.setCnpj(entrada.nextLine());
		System.out.println();

		System.out.println("Digite o endereço para atualizar: ");
		c1.setEndereco(entrada.nextLine());
		System.out.println();

		System.out.println("Digite o telefone para atualizar: ");
		c1.setTelefone(entrada.nextLine());
		System.out.println();

		c1.setDataCadastro(new Date());
		
		System.out.println("Digite a movimentação para atualizar R$: ");
		c1.setMovimentacao(entrada.nextLong());
		System.out.println();

		System.out.println("Digite o ID do cliente que deseja atualizar: ");
		c1.setId(entrada.nextInt());
		System.out.println();

		financeiroDao.update(c1);

	}


	private static void deletarPorId() {
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		FinanceiroDAO financeiroDao = new FinanceiroDAO();

		listarClientesPorCpf();
		listarClientesPorCnpj();

		System.out.println("Digite o ID do cliente que deseja deletar: ");
		financeiroDao.deleteByID(entrada.nextInt());
		menuInicial();

	}

}
