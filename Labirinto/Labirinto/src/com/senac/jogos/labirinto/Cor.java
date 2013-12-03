package com.senac.jogos.labirinto;

public enum Cor {
	VERMELHO("Vermelho"), VERDE("Verde"), AMARELO("Amarelo"), AZUL("Azul"), MARROM(
			"Marrom");

	private String descricao;

	/**
	 * 
	 * @param desc - insere a descricao
	 */
	private Cor(String desc) {
		this.descricao = desc;
	}

	/**
	 * 
	 * @param s - entrada da descricao
	 * @return retorna true se a descricao esta compativel
	 */
	public boolean equals(String s) {
		return descricao.equalsIgnoreCase(s);
	}

	/**
	 * gera a informacao para o jogador
	 */
	public String toString() {
		return descricao;
	}
}
