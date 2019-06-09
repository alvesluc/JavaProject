package informacoes;

import java.io.File;
import java.util.Scanner;

public class SystemVenda {
	
	public static float vender(String categoria) {
		
		float totalConta = 0;
		
		Scanner buscar = new Scanner(System.in);
		File directory = new File("CATEGORIA/" + categoria + "/");
		Produto produto = new Produto();
		
		int fileCount = (int)directory.list().length;
		
		for(int i = 1; i <= fileCount; i++) {
			String id = Integer.toString(i);
			ListaProd.listar(categoria, id);
		}
		
		String buscaID;
		
		float totalPreco;
		
		System.out.println("Digite o ID do produto que deseja ou 0 para sair:");
		buscaID = buscar.nextLine();
	
		while(!buscaID.equals("0")) {
			
			File existe = new File("CATEGORIA/" + categoria + "/" + buscaID + ".txt");
			boolean taOk = existe.exists();  // Existence 
			
			if(taOk) {
			
				System.out.println("Digite a quantidade que deseja:");
				int buscaQuant = Integer.parseInt(buscar.nextLine());	
				
				Produto pegarItem = (Produto)ArquivoSerializadoUtilInformacoes.lerArquivoSerializado(categoria, buscaID);
				Produto pegarAlterado = pegarItem;
				
				totalPreco = pegarItem.getPrecovenda() *buscaQuant;
				pegarItem.setQtde_estoque(pegarItem.getQtde_estoque() - buscaQuant);
				
				boolean gravou = ArquivoSerializadoUtilInformacoes.gravaObjetoSerializado(categoria, pegarItem.getId(), pegarAlterado);
				
				if(gravou) {
					System.out.println("Tudo massa");
				}
				totalConta = totalConta + totalPreco;
				System.out.println("Total: "+ totalPreco);
				
				}else {
				System.out.println("Entre com um valor existente.");
			}
			System.out.println("Digite o ID do produto que deseja ou 0 para sair:");
			buscaID = buscar.nextLine();

		}
		
		
		//buscar.close();
		return totalConta;
	}
	
	public static void comprar(String categoria) {
		
	}
}
