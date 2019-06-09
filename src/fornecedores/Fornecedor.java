package fornecedores;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

import caixa.ArquivoSerializadoUtil;
import caixa.Caixa;
import caixa.Operacoes;
import informacoes.ListaCategoria;
import informacoes.ListaProd;
import informacoes.Produto;

public class Fornecedor {

	public static void adcionarFornecedor() {

		System.out.println("Informe o nome do novo fornecedor: ");
		@SuppressWarnings("resource")

		Scanner leitor = new Scanner(System.in);
		String fornecedor = leitor.nextLine();

		File file = new File("FORNECEDORES\\" + fornecedor);
		if (!file.exists()) {
			if (file.mkdir()) {
				System.out.println("Fornecedor adcionado!");
			} else {
				System.out.println("Falha na adi��o do fornecedor!");
			}
		}
	}
	
	public static void alteraFornecedor(String fornecedor) {

		File dir = new File("FORNECEDORES/" + fornecedor + "/");
		@SuppressWarnings("resource")
		Scanner leitor = new Scanner(System.in);

		if (!dir.isDirectory()) {
			System.err.println("Esse fornecedor n�o existe.");
		} else {
			System.out.println("Informe o novo nome do fornecedor: ");
			String novoNome = leitor.nextLine();
			File newDir = new File(dir.getParent() + "/" + novoNome);
			dir.renameTo(newDir);
		}
	}
	
	public static void removeFornecedor(String fornecedor) {
        String folder = "CATEGORIA/"+ fornecedor + "/";
        //delete folder recursively
        recursiveDelete(new File(folder));
    }
    
    public static void recursiveDelete(File file) {
        //to end the recursive loop
        if (!file.exists())
            return;
        
        //if directory, go inside and call recursively
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                //call recursively
                recursiveDelete(f);
            }
        }
        //call delete to delete files and empty directory
        file.delete();
        System.out.println("Fornecedor apagado: "+file.getAbsolutePath());
    }
    
    public static void listaFornecedores() {
		
		File file = new File("FORNECEDORES/");
		String[] directories = file.list(new FilenameFilter() {
		  public boolean accept(File current, String name) {
		    return new File(current, name).isDirectory();
		  }
		});
		
		System.out.println(Arrays.toString(directories));
		
	}
    
    public static void compraFornecedor() {
    	
    	Caixa caixaLoja = (Caixa)ArquivoSerializadoUtil.lerCaixaSerializado();
		float disponivel = caixaLoja.getDinheirocaixa();
    	System.out.println("Valor dispon�vel para compra: " + caixaLoja.getDinheirocaixa());
		
    	System.out.println("Escolha um fornecedor e sua categoria: ");
    	listaFornecedores();
    	ListaCategoria.listaCategoria();
    	@SuppressWarnings("resource")
		Scanner leitor = new Scanner(System.in);
    	
    	System.out.println("Fornecedor: ");
    	String fornecedor = leitor.nextLine();
    	
    	System.out.println("Categoria: ");
    	String categoria = leitor.nextLine();
    	
    	File directory = new File("FORNECEDORES/" + fornecedor + "/CATEGORIA/" + categoria + "/");
    	int fileCount = (int)directory.list().length;
    	
    	System.out.println(fileCount);
		
		for(int i = 1; i <= fileCount; i++) {
			String id = Integer.toString(i);
			ListaProd.fornecer(fornecedor, id);
		}
    	
		String buscaID;
		
		float totalPreco = 0;
		
		System.out.println("Digite o ID do produto que deseja ou 0 para sair:");
		buscaID = leitor.nextLine();
	
		while(!buscaID.equals("0")) {
			
			File existe = new File("FORNECEDORES/" + fornecedor + "/" + buscaID + ".txt");
			boolean taOk = existe.exists();  
			
			if(taOk) {
			
				System.out.println("Digite a quantidade que deseja comprar: ");
				int buscaQuant = Integer.parseInt(leitor.nextLine());	
				
				Produto pegarItem = (Produto)ArquivoSerializadoUtilFornecedor.lerArquivoSerializado(fornecedor, buscaID);
				Produto pegarAlterado = pegarItem;
				
				totalPreco = pegarItem.getPrecovenda() * buscaQuant;
				
				
				pegarItem.setQtde_estoque(pegarItem.getQtde_estoque() + buscaQuant);
				
				boolean gravou = ArquivoSerializadoUtilFornecedor.gravaObjetoSerializado(fornecedor, pegarItem.getId(), pegarAlterado);
				
				if(gravou) {
					System.out.println("Tudo massa");
				}
				
				}else {
				System.out.println("Entre com um valor existente.");
			}
			System.out.println("Digite o ID do produto que deseja ou 0 para sair:");
			buscaID = leitor.nextLine();

		}
		disponivel = disponivel - totalPreco;
		Operacoes.comprarComCaixa(disponivel);
    }

}
