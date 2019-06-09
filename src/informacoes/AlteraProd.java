package informacoes;

import java.io.File;
import java.util.Scanner;

public class AlteraProd extends Produto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void alteraProd() {

		String opcao;
		int x;
		Scanner leitor = new Scanner(System.in);

		do {

			System.out.println("Informe a categoria do produto a ser alterado.");
			String categoria = leitor.nextLine();
			
			File directory = new File("CATEGORIA/" + categoria + "/");
			int fileCount = (int) directory.list().length;

			for (int i = 1; i <= fileCount; i++) {
				String id = Integer.toString(i);
				ListaProd.listar(categoria, id);
			}
			
			System.out.println("Informe o ID do arquivo que voc� deseja alterar: ");
			String idLeitura = leitor.nextLine();

			Produto produtoLeitura = (Produto) ArquivoSerializadoUtilInformacoes.lerArquivoSerializado(categoria, idLeitura);
			Produto produtoAlterado = produtoLeitura;
			System.out.println("ID:         " + produtoLeitura.getId());
			System.out.println("Nome:       " + produtoLeitura.getNome());
			System.out.println("Pre�o:      " + produtoLeitura.getPrecovenda());
			System.out.println("Quantidade: " + produtoLeitura.getQtde_estoque());

			System.out.println("Alterar o arquivo " + produtoLeitura.getNome() + " ? (S/N)");

			opcao = leitor.nextLine();
			opcao = opcao.toUpperCase();

			if (opcao.equals("S") || opcao.equals("SIM") || opcao.equals("SS")) {
				
				System.out.println("Qual das seguintes informa��es voc� deseja alterar?" + "\n1- NOME"
						+ "\n2- PRE�O" + "\n3- QUANTIDADE");
				x = Integer.parseInt(leitor.nextLine());
				switch (x) {
				case 1:
					System.out.println("O nome atual �: " + produtoLeitura.getNome() + "\n" + "Insira o novo nome: ");
					String nome = leitor.nextLine();
					produtoAlterado.setNome(nome);
					System.out.println("Novo nome: " + produtoAlterado.getNome());
					break;
				case 2:
					System.out.println("O pre�o atual �: " + produtoLeitura.getPrecovenda() + "\n" + "Insira o novo pre�o: ");
					float precovenda = Float.parseFloat(leitor.nextLine());
					produtoAlterado.setPrecovenda(precovenda);
					System.out.println("Novo pre�o: " + produtoAlterado.getPrecovenda());
					break;
				case 3:
					System.out.println("O quantidade atual �: " + produtoLeitura.getQtde_estoque() + "\n" + "Insira o novo quantidade: ");
					int qtde_estoque = Integer.parseInt(leitor.nextLine());
					produtoAlterado.setQtde_estoque(qtde_estoque);
					System.out.println("Novo quantidade: " + produtoAlterado.getQtde_estoque());
					break;
				default:
					System.out.println("Por favor, selecione uma op��o v�lida.");
					x = 0;
					break;
				}
				boolean gravou = ArquivoSerializadoUtilInformacoes.gravaObjetoSerializado(categoria, produtoAlterado.getId(), produtoLeitura);

				if (gravou) {
					System.out.println("Produto alterado com sucesso!");
				} else {
					System.out.println("O produto n�o foi alterado.");
				}
			}

		} while (opcao.equals("N") || opcao.equals("NAO") || opcao.equals("NO") || opcao.equals("N�O")
				|| opcao.equals("�"));
	}

}
