package com.senac.jogos.labirinto;

public class Conexao {
	private int sala;
	private Inimigo inimigo;
	private Cor cor;

	/**
	 * 
	 * @param sala que sera conectada
	 */
	public Conexao(int sala) {
		this.sala = sala;
		this.cor = Cor.MARROM;
	}

	/**
	 * 
	 * @return retorna a sala
	 */
	public int getSala() {
		return sala;
	}

	/**
	 * 
	 * @param sala - envia para uma sala
	 */
	public void setSala(int sala) {
		this.sala = sala;
	}

	/**
	 * 
	 * @return retorna a cor da porta
	 */
	public Cor getCor() {
		return cor;
	}

	/**
	 * 
	 * @return retorna o inimigo identificado
	 */
	public Inimigo getInimigo() {
		return inimigo;
	}

	/**
	 * 
	 * @param inimigo - envia um inimigo
	 */
	public void setInimigo(Inimigo inimigo) {
		this.inimigo = inimigo;
	}

	/**
	 * criada uma nova armadilha
	 */
	public void setArmadilha() {
		this.inimigo = new Armadilha();
	}

	/**
	 * 
	 * @param cor a ser enviada
	 */
	public void setCor(Cor cor) {
		if (cor != null)
			this.cor = cor;
	}

	/**
	 * 
	 * @param jogador inserido
	 * @return retorna se pode atravar uma porta
	 */
	public boolean podeAtravessar(Jogador jogador) {
		if (cor != Cor.MARROM) {
			Chave c = jogador.getChave();
			if (c != null)
				return c.getCor() == cor;
			else
				return false;
		}

		if (inimigo != null) {
			if (!(inimigo instanceof Armadilha))
				return !inimigo.isAlive();
		}

		return true;
	}

	/**
	 * constroi informacao para uma string
	 */
	public String toString() {
		String res = "Porta " + cor;
		if (inimigo != null && !(inimigo instanceof Armadilha))
			res += " guardada por um " + inimigo;
		return res;
	}

	/**
	 * 
	 * @return retorna a cor da porta e caso haja um inimigo, informa tambem qual inimigo
	 */
	public String getInf() {
		String r = "Porta " + cor;

		if (inimigo != null) {
			r += " tem um " + inimigo;
		}

		return r;
	}

	/**
	 * gera de forma aleatoria as cores das portas no labirinto
	 * @return retorna a cor
	 */
	private Cor setRndCor() {
		if (Range.getPercentual() >= 60) {
			switch (new Range(1, 4).getRandom()) {
			case 1:
				return Cor.AMARELO;

			case 2:
				return Cor.AZUL;

			case 3:
				return Cor.VERDE;

			case 4:
				return Cor.VERMELHO;
			}
		}

		return Cor.MARROM;
	}
}