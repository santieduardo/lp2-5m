package com.senac.jogos.labirinto;

public class Armadura extends Item {
	private int resistencia;

	/**
	 * 
	 * @param tipo da armadura
	 * @param resistencia da armadura
	 */
	public Armadura(String tipo, int resistencia) {
		super(tipo);
		if (resistencia > 0)
			this.resistencia = resistencia;
		else
			this.resistencia = 0;
	}

	/**
	 * 
	 * @return retorna a resistencia da armadura
	 */
	public int getResistencia() {
		return resistencia;
	}
}
