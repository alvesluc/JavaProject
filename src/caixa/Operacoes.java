package caixa;

import java.io.File;

import caixa.ArquivoSerializadoUtil;
import caixa.Caixa;



public class Operacoes {

	
	public static void totalCaixa(float noCaixa) { 
		
		Caixa caixaAntigo = (Caixa)ArquivoSerializadoUtil.lerCaixaSerializado();
		Caixa caixaTotal = caixaAntigo;
	
		float caixaAtual = caixaTotal.getDinheirocaixa();
		caixaAtual = caixaAtual + noCaixa;
		
		caixaTotal.setDinheirocaixa(caixaAtual);
		
		boolean gravou = ArquivoSerializadoUtil.alteraCaixaSerializado(caixaTotal);

		if (gravou) {
			System.out.println("Compra realizada com sucesso.");
		} 
	}
	
	public static void valorCaixa(){
		
		File directory = new File("CAIXA/Caixa.txt");
		
		boolean verif = directory.exists();
	
		if(verif) {
		
			Caixa caixaLeitura = (Caixa) ArquivoSerializadoUtil.lerCaixaSerializado();
			
			System.out.println("Total no caixa: " + caixaLeitura.getDinheirocaixa());

		}
	}
	
	public static void comprarComCaixa(float valorCompra) {
		
		Caixa caixaAntigo = (Caixa)ArquivoSerializadoUtil.lerCaixaSerializado();
		Caixa caixaTotal = caixaAntigo;
	
		float caixaAtual = caixaTotal.getDinheirocaixa();
		caixaAtual = caixaAntigo.getDinheirocaixa() - valorCompra;
		
		caixaTotal.setDinheirocaixa(caixaAtual);
		
		boolean gravou = ArquivoSerializadoUtil.alteraCaixaSerializado(caixaTotal);

		if (gravou) {
			System.out.println("Compra realizada com sucesso.");
		} 
	}
}	