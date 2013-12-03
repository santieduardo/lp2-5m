package com.senac.jogos.labirinto;

public class Jogador extends Personagem {

	private Arma arma;
	private Armadura armadura;
	private Chave chave;

	/**
	 * constroi um jogador valido para o inicio do jogo
	 */
	public Jogador() {
		super(1, 1, 20);
		this.arma = null;
		this.armadura = null;
		this.chave = null;
	}

	/**
	 * 
	 * @return retorna a arma
	 */
	public Arma getArma() {
		return arma;
	}

	/**
	 * 
	 * @param arma inserida
	 * @throws Exception
	 */
	public void setArma(Arma arma) throws Exception {
		if (this.arma == null)
			throw new Exception("Seu player tem uma arma");
		this.arma = arma;
	}

	/**
	 * 
	 * @return retorna a armadura
	 */
	public Armadura getArmadura() {
		return armadura;
	}

	/**
	 * 
	 * @param armadura inserida
	 * @throws Exception
	 */
	public void setArmadura(Armadura armadura) throws Exception {
		if (this.armadura == null)
			throw new Exception("Seu player tem uma armadura");
		this.armadura = armadura;
	}

	/**
	 * 
	 * @return retorna a chave
	 */
	public Chave getChave() {
		return chave;
	}

	/**
	 * 
	 * @param chave inserida
	 * @throws Exception
	 */
	public void setChave(Chave chave) throws Exception {
		if (this.arma == null)
			throw new Exception("Seu player tem uma chave");
		this.chave = chave;
	}

	/**
	 * retorna o ataque
	 */
	public int getAtaque() {
		int bonus = 0;
		if (arma != null)
			bonus += arma.getDano();
		return ataque + bonus;
	}
	
	/**
	 * verifica o dano e retira da vida atual 
	 */
	public void setDano(int value) {
		int total = value - resistencia;
		if (armadura != null)
			total -= armadura.getResistencia();
		vida -= total;
	}

	/**
	 * mata o jogador
	 */
	public void matarJogador() {
		this.vida = 0;
	}

	/**
	 * remove a armadura
	 */
	public void matarArmadura() {
		this.armadura = null;
	}

	/**
	 * remove a arma
	 */
	public void matarArma() {
		this.arma = null;
	}

	/**
	 * remove a chave
	 */
	public void matarChave() {
		this.chave = null;
	}

	/**
	 * auxilia da formacao da string para a o jogador
	 */
	public String toString() {
		int ataq = 0;
		ataq = ataque;

		int defesa = 0;
		defesa = resistencia;

		if (armadura != null) {
			defesa += armadura.getResistencia();
		}

		if (arma != null) {
			ataq += arma.getDano();
		}

		return "Jogador" + "\nVida: " + vida + "\nAtaque: " + ataq
				+ "\nDefesa: " + defesa;
	}
}
