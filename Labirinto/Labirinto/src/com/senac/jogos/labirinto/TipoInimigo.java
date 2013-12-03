package com.senac.jogos.labirinto;

public enum TipoInimigo {
	GOBLIN("Goblin", new Range(1, 3), new Range(0, 1), new Range(2, 4)), ORC(
			"Orc", new Range(2, 4), new Range(1, 2), new Range(3, 6)), TROLL(
			"Troll", new Range(3, 6), new Range(2, 4), new Range(4, 10));

	private Range vida;
	private Range ataque;
	private Range resistencia;
	private String tipo;

	/**
	 * inicializa os inimigos de forma coreta
	 * @param tipo - inserido
	 * @param ataque - inserido
	 * @param resistencia - inserido
	 * @param vida - inserido
	 */
	private TipoInimigo(String tipo, Range ataque, Range resistencia, Range vida) {
		this.ataque = ataque;
		this.resistencia = resistencia;
		this.vida = vida;
		this.tipo = tipo;
	}

	/**
	 * 
	 * @return retorna o tipo do inimigo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * 
	 * @return retorna a vida do inimigo
	 */
	public int getVida() {
		return vida.getRandom();
	}

	/**
	 * 
	 * @return retorna o ataque do inimigo
	 */
	public int getAtaque() {
		return ataque.getRandom();
	}

	/**
	 * 
	 * @return retorna a resistencia do inimigo
	 */
	public int getResistencia() {
		return resistencia.getRandom();
	}
}
