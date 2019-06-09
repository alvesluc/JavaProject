package informacoes;

import java.io.File;
import java.util.Scanner;

import caixa.Operacoes;
import fornecedores.Fornecedor;
import pessoas.AlteraPessoa;
import pessoas.Increment;
import pessoas.ListaInfo;
import pessoas.ListaPessoa;
import pessoas.RemovePessoa;
import pessoas.Usuario;

public class Principal {

	public static void main(String[] args) {
		
		//Inicialização de variáveis globais.
		float contaTotal = 0;
		String categoria = "";
		int verif;

		Scanner leitor = new Scanner(System.in);

		System.out.println("Bem Vindo ao CyberCafé!");
		
		
		do {
			verif = Usuario.fazerLogin();
			if(verif == 1) {
				
				System.out.println("Login realizado com sucesso!\n");
					
			String opcaoMenu;
			do {
				System.out.println(
						"Qual Função deseja ultilizar?" + 
						"\n*------------MENU-------------*" +
						"\n|1 - Ir às compras	      |" +
						"\n|2 - Informações    	      |" +
						"\n|3 - Reabastecimento 	      |" +
						"\n|0 - Sair		      |"+
						"\n*-----------------------------*");

				opcaoMenu = leitor.nextLine();

				switch (opcaoMenu) {
				case "1":
					System.out.println("Informe a categoria do produto: ");
					ListaCategoria.listaCategoria();
					categoria = leitor.nextLine();
					contaTotal = contaTotal + SystemVenda.vender(categoria);
					System.out.println("A conta final foi: " + contaTotal);
					Operacoes.totalCaixa(contaTotal);
					break;
				case "2":
					System.out.println(
							"\nQual função deseja utilizar?" + 
							"\n*------------MENU-------------*" +
							"\n|1 - Adicionar	              |" +
							"\n|2 - Remover    	      |" +
							"\n|3 - Alterar 	              |" +
							"\n|4 - Listar                   |"+
							"\n|5 - Ultima compra|"+
							"\n|0 - Sair		      |"+
							"\n*-----------------------------*");

					System.out.println("O que você deseja fazer?");
					int opcaoFuncao = (int) Integer.parseInt(leitor.nextLine());
					
					switch (opcaoFuncao) {
					case 1:
						System.out.println(
								"O que você deseja adcionar?" + 
								"\n*------------MENU-------------*" +
								"\n|1 - Produto	              |" +
								"\n|2 - Categoria    	      |" +
								"\n|3 - Cliente 	              |" +
								"\n|4 - Fornecedor		      |"+
								"\n|0 - Sair		        |"+
								"\n*-----------------------------*");

						opcaoFuncao = (int) Integer.parseInt(leitor.nextLine());
						
						if(opcaoFuncao == 1) {
							ListaCategoria.listaCategoria();
							AdcProdManual.adcionaProduto();
						}else if(opcaoFuncao == 2) {
							AdcCategoria.adcionaCategoria();
						}else if(opcaoFuncao == 3) {
							Increment.Cadastrar();
						}else if(opcaoFuncao == 4) {
							Fornecedor.adcionarFornecedor();
						}else if(opcaoFuncao == 0) {
							System.out.println("Voltando para o menu...");
							break;
						}else {
							System.out.println("Opção inválida!");
						}
						
						break;
					case 2:
						System.out.println(
								"O que você deseja remover?" + 
								"\n*------------MENU-------------*" +
								"\n|1 - Produto	              |" +
								"\n|2 - Categoria    	      |" +
								"\n|3 - Cliente 	              |" +
								"\n|4 - Fornecedor		      |"+
								"\n|5 - Gerar lucro           |"+
								"\n|0 - Sair		        |" +
								"\n*-----------------------------*");

						opcaoFuncao = (int) Integer.parseInt(leitor.nextLine());
						
						if(opcaoFuncao == 1) {
							ListaCategoria.listaCategoria();
							
							System.out.println("Informe a categoria do produto a ser removido: ");
							categoria = leitor.nextLine();
							File directory = new File("CATEGORIA/" + categoria + "/");
							int fileCount = (int) directory.list().length;

							for (int i = 1; i <= fileCount; i++) {
								String id = Integer.toString(i);
								ListaProd.listar(categoria, id);
							}

							System.out.println("Remover produto: ");
							int id = Integer.parseInt(leitor.nextLine());
							RemoveProd.remove(categoria, id);
							
						}else if(opcaoFuncao == 2) {
							ListaCategoria.listaCategoria();
							System.out.println("Informe a categoria que será removida: ");
							String categoriaR = leitor.nextLine();
							RemoveCategoria.removeCategoria(categoriaR);
							
						}else if(opcaoFuncao == 3) {

							System.out.println("O cliente a ser alterado é identificado por: "
									+ "\n1 - CPF"
									+ "\n2 - CNPJ");
							int documento = (int) Integer.parseInt(leitor.nextLine());
							if (documento == 1) {
								ListaInfo.listaInfoCPF();
								System.out.println("Informe o CPF do cliente que você deseja alterar as informações.");
								String cpf = leitor.nextLine();
								RemovePessoa.removePessoaF(cpf);
								
							}else if (documento == 2) {
								ListaInfo.listaInfoCNPJ();
								System.out.println("Informe o CNPJ do cliente que você deseja ver as informações.");
								String cnpj = leitor.nextLine();
								RemovePessoa.removePessoaJ(cnpj);
							}
							
						}else if(opcaoFuncao == 4) {
							Fornecedor.listaFornecedores();
							System.out.println("Informe o fornecedor que será removido: ");
							String fornecedorR = leitor.nextLine();
							Fornecedor.removeFornecedor(fornecedorR);
						}else if(opcaoFuncao == 0) {
							System.out.println("Voltando para o menu...");
							break;
						}else {
							System.out.println("Opção inválida!");
						}
						
						break;
					case 3:
						System.out.println(
								"O que você deseja alterar?" + 
								"\n*------------MENU-------------*" +
								"\n|1 - Produto	              |" +
								"\n|2 - Categoria    	      |" +
								"\n|3 - Cliente 	              |" +
								"\n|4 - Fornecedor		      |"+
								"\n|0 - Sair		       |"+
								"\n*-----------------------------*");

						opcaoFuncao = (int) Integer.parseInt(leitor.nextLine());
						
						if(opcaoFuncao == 1) {
							ListaCategoria.listaCategoria();
							AlteraProd.alteraProd();
						}else if(opcaoFuncao == 2) {
							ListaCategoria.listaCategoria();
							System.out.println("Informe a categoria a ser alterada: ");
							String categoriaA = leitor.nextLine();
							AlteraCategoria.alteraCategoria(categoriaA);
						}else if(opcaoFuncao == 3) {
							System.out.println("O cliente a ser alterado é identificado por: "
									+ "\n1 - CPF"
									+ "\n2 - CNPJ");
							int documento = (int) Integer.parseInt(leitor.nextLine());
							if (documento == 1) {
								ListaInfo.listaInfoCPF();
								System.out.println("Informe o CPF do cliente que você deseja alterar as informações.");
								String cpf = leitor.nextLine();
								AlteraPessoa.alteraPessoaF(cpf);
								
							}else if (documento == 2) {
								ListaInfo.listaInfoCNPJ();
								System.out.println("Informe o CNPJ do cliente que você deseja ver as informações.");
								String cnpj = leitor.nextLine();
								AlteraPessoa.alteraPessoaJ(cnpj);
								
							}
						}else if(opcaoFuncao == 4) {
							
							Fornecedor.listaFornecedores();
							System.out.println("Informe o fornecedor a ser alterado: ");
							String fornecedorA = leitor.nextLine();
							Fornecedor.alteraFornecedor(fornecedorA);
							
						}else if(opcaoFuncao == 0) {
							System.out.println("Voltando para o menu...");
							break;
						}else {
							System.out.println("Opção inválida!");
						}
						
						break;
					case 4:
						System.out.println(
								"O que você deseja listar?" + 
								"\n*------------MENU-------------*" +
								"\n|1 - Produtos	              |" +
								"\n|2 - Categorias    	      |" +
								"\n|3 - Clientes	              |" +
								"\n|4 - Fornecedor		      |"+
								"\n|0 - Sair		      |"+
								"\n*-----------------------------*");

						System.out.println("O que você deseja fazer?");
						opcaoFuncao = (int) Integer.parseInt(leitor.nextLine());
						if(opcaoFuncao == 1) {
							
							System.out.println("Informe a categoria dos produtos a serem listados: ");
							ListaCategoria.listaCategoria();
							String categoriaL = leitor.nextLine();
							File directory = new File("CATEGORIA/" + categoriaL + "/");
				
							int fileCount = (int)directory.list().length;			
							for(int i = 1; i <= fileCount; i++) {
								String id = Integer.toString(i);
								ListaProd.listar(categoriaL, id);
								
							}

						}else if(opcaoFuncao == 2) {
							System.out.println("Essas são as categorias existentes:\n");
							ListaCategoria.listaCategoria();
						}else if(opcaoFuncao == 3) {
							System.out.println("Escolha o identificador do cliente: "
									+ "\n1 - CPF"
									+ "\n2 - CNPJ");
							int documento = (int) Integer.parseInt(leitor.nextLine());
							if (documento == 1) {
								ListaInfo.listaInfoCPF();
								System.out.println("Informe o CPF do cliente que você deseja ver as informações.");
								String cpf = leitor.nextLine();
								ListaPessoa.listaPF(cpf);
							}else if (documento == 2) {
								ListaInfo.listaInfoCNPJ();
								System.out.println("Informe o CNPJ do cliente que você deseja ver as informações.");
								String cnpj = leitor.nextLine();
								ListaPessoa.listaPJ(cnpj);
							}
						}else if(opcaoFuncao == 4) {
							System.out.println("Esses são os fornecedores existentes:\n");
							Fornecedor.listaFornecedores();
						}else if(opcaoFuncao == 0) {
							System.out.println("Voltando para o menu...");
							break;
						}else {
							System.out.println("Opção inválida!");
						}
					case 0:	
						System.out.println("\nVoltando ao menu principal...");
						break;
					default:
						System.out.println("Opção inválida!");
						break;
					}
					
					break;
				case "3":
					Fornecedor.compraFornecedor();
					break;

				case "0":
					System.out.println("Você saiu.");

					break;

				default:

					System.out.println("Opção inválida!");
					break;
				}
			} while (!opcaoMenu.equals("0"));
			Operacoes.valorCaixa();
		
		}
		else {
			System.out.println("Credenciais inválidas!");
		}
		}while(verif != 1);
		leitor.close();
	}
}
