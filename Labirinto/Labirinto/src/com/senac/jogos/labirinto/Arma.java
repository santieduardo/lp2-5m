package com.senac.jogos.labirinto;

public class Arma extends Item {
	private int dano;

	/**
	 * 
	 * @param tipo da arma
	 * @param dano da arma
	 */
	public Arma(String tipo, int dano) {
		super(tipo);
		if (dano > 0)
			this.dano = dano;
		else
			this.dano = 1;
	}

	/**
	 * 
	 * @return retorna o dano da arma
	 */
	public int getDano() {
		return dano;
	}
}
