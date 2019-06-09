package caixa;

import java.io.Serializable;

public class Caixa implements Serializable{

	float dinheirocaixa;

	private static final long serialVersionUID = 1L;
	
	public float getDinheirocaixa() {
		return dinheirocaixa;
	}

	public void setDinheirocaixa(float dinheirocaixa) {
		this.dinheirocaixa = dinheirocaixa;
	}
	
}
