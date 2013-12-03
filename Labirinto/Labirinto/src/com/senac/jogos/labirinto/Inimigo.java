package com.senac.jogos.labirinto;

public class Inimigo extends Personagem {

	String tipo;

	/**
	 * 
	 * @param tipo do inimigo inserido
	 */
	protected Inimigo(TipoInimigo tipo) {
		super(tipo.getAtaque(), tipo.getResistencia(), tipo.getVida());
		this.tipo = tipo.getTipo();
	}

	/**
	 * 
	 * @param tipo do inimigo inserido
	 * @param ataque do inimido inserido
	 * @param resistencia do inimido inserido
	 * @param vida do inimido inserido
	 */
	protected Inimigo(String tipo, int ataque, int resistencia, int vida) {
		super(ataque, resistencia, vida);
		this.tipo = tipo;
	}

	/**
	 * auxilia na formacao da string para o jogador
	 */
	public String toString() {
		return tipo;
	}
}
