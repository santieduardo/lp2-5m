package com.senac.jogos.labirinto;

abstract public class Personagem {
	protected int ataque;
	protected int resistencia;
	protected int vida;

	/*
	 * garante que o valor esta valido se ele e igual ou maior que o minimo
	 */
	private int ensureValidValue(int value, int min) {
		if (value >= min)
			return value;
		return min;
	}

	/**
	 * inicializa um personagem de maneira valida
	 * @param ataque - inserido
	 * @param resistencia - inserido
	 * @param vida - inserido
	 */
	protected Personagem(int ataque, int resistencia, int vida) {
		this.ataque = ensureValidValue(ataque, 1);
		this.resistencia = ensureValidValue(resistencia, 0);
		this.vida = ensureValidValue(vida, 1);
	}

	/**
	 * verifica se o character esta vivo
	 * @return vida do character
	 */
	public boolean isAlive() {
		return vida > 0;
	}

	/**
	 * define um dano para um determina combate
	 * @param value - inserido
	 */
	public void setDano(int value) {
		int total = value - resistencia;
		if (total > 0)
			vida -= total;
	}

	/**
	 * captura o ataque em um combate
	 * @return retorna o ataque
	 */
	public int getAtaque() {
		return ataque;
	}
}
