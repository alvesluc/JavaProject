package pessoas;

import java.io.File;
import java.util.Scanner;

public class Increment {

	public static void Cadastrar() {

		Pessoa pessoa = new Pessoa();
		@SuppressWarnings("resource")
		Scanner logar = new Scanner(System.in);
		PessoaFisica pessoaf = new PessoaFisica();
		PessoaJuridica pessoaj = new PessoaJuridica();
		Endereco endereco = new Endereco();

		System.out.println("Informe os seguintes dados: ");
		System.out.println("\t\tSeu nome: ");
		String nomePessoa = logar.nextLine();
		
		System.out.println("Email: ");
		String emailPessoa = logar.nextLine();
		
		System.out.println("\t\tCelular: ");
		String celularPessoa = logar.nextLine();
		
		System.out.println("Agora vou precisar do seu endereço.");

		System.out.println("Estado: ");
		String uf = logar.nextLine();

		System.out.println("Cidade: ");
		String cidade = logar.nextLine();

		System.out.println("Rua: ");
		String rua = logar.nextLine();

		System.out.println("Bairro: ");
		String bairro = logar.nextLine();

		System.out.println("Número: ");
		Short numero = Short.parseShort(logar.nextLine());

		System.out.println("CEP: ");
		String cep = logar.nextLine();

		System.out.println("Complemento: ");
		String complemento = logar.nextLine();


		System.out.println("Selecione o tipo de pessoa:" + "\n1 - Pessoa Física" + "\n2 - Pessoa Jurídica");
		int tipoPessoa = Integer.parseInt(logar.nextLine());
		int fileCount = 0;
		
		if (tipoPessoa == 1) {
			File directory = new File("Fontes/Cliente/CPF/");
			fileCount = directory.list().length;
			System.out.println("File Count:" + fileCount);

		} else if (tipoPessoa == 2) {
			File directory = new File("Fontes/Cliente/CNPJ/");
			fileCount = directory.list().length;
			System.out.println("File Count:" + fileCount);

		}

		

		if (tipoPessoa == 1) {
			String usar = pessoaf.indruzirDados(++fileCount, nomePessoa, emailPessoa, celularPessoa, uf, cidade, rua, bairro, numero, cep, complemento);
			boolean gravou = ArquivoSerializadoUtil.gravaPessoaSerializado(1, tipoPessoa, usar, pessoaf);

			if (gravou) {
				System.out.println("Arquivo gravado com sucesso!");
			}
			boolean finalizar = ArquivoSerializadoUtil.gravaPessoaSerializado(2, tipoPessoa, usar, endereco);

			if (finalizar) {
				System.out.println("Cadastro realizado com êxito.");
			}

		} else if (tipoPessoa == 2) {
			
			String usar = pessoaj.indruzirDados(++fileCount, nomePessoa, emailPessoa, celularPessoa, uf, cidade, rua, bairro, numero, cep, complemento);
			boolean gravou = ArquivoSerializadoUtil.gravaPessoaSerializado(1, tipoPessoa, usar, pessoaj);

			if (gravou) {
				System.out.println("Arquivo gravado com sucesso!");
			}
			
			boolean finalizar = ArquivoSerializadoUtil.gravaPessoaSerializado(2, tipoPessoa, usar, endereco);

			if (finalizar) {
				System.out.println("Cadastro realizado com êxito.");
			}

		}


	}

}
