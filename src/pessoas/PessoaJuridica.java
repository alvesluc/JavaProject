package pessoas;

import java.util.Scanner;

public class PessoaJuridica extends Pessoa {
	private String cnpj;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public void introduzirCNPJ(String cnpj) {
		this.cnpj = cnpj;
	}
	

	public String indruzirDados(int id, String nome, String email, String celular, String uf, String cidade,
			String rua, String bairro, short numero, String cep, String complemento) {
		// TODO Auto-generated method stub
		
		Scanner logar = new Scanner(System.in);
		
		System.out.println("Informe seu CNPJ:");
		String cnpj = logar.nextLine();
		//PessoaFisica pessoaf = new PessoaFisica();
		
		this.setCnpj(cnpj);
		this.setNome(nome);
		this.setId(id);
		this.setEmail(email);
		this.setCelular(celular);
		this.setUf(uf);
		this.setCidade(cidade);
		this.setRua(rua);
		this.setBairro(bairro);
		this.setNumero(numero);
		this.setCep(cep);
		this.setComplemento(complemento);
	
		return cnpj;
		
	}
	
}

