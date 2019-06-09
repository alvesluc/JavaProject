package pessoas;

import java.io.File;

public class RemovePessoa {
	
	public static void removePessoaF(String param) {
				
		File remover = new File("FONTES/CLIENTE/CPF/"+ param + ".txt");
		boolean removeu = remover.delete();
		if(removeu) {
			System.out.println("O cadastro do cliente com CPF: " + param + " foi apagado");
		}
	}
	
	public static void removePessoaJ(String param) {
		
		File remover = new File("FONTES/CLIENTE/CNPJ/"+ param + ".txt");
		boolean removeu = remover.delete();
		if(removeu) {
			System.out.println("O cadastro do cliente com CNPJ: " + param + " foi apagado");
		}
	}
	
}
