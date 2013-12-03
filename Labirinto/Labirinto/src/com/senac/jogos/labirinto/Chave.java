package com.senac.jogos.labirinto;

public class Chave extends Item {

	private Cor cor;

	/**
	 * 
	 * @param cor da chave
	 */
	public Chave(Cor cor) {
		super("Chave " + cor);
		this.cor = cor;
	}
	
	public boolean equals(Object o) {
		if (o == this)
			return true;

		Cor c = null;
		if (o instanceof Chave)
			c = ((Chave) o).cor;
		else if (o instanceof Cor)
			c = (Cor) o;

		return cor.equals(c);
	}

	/**
	 * 
	 * @return retorna a cor da chave
	 */
	public Cor getCor() {
		return cor;
	}

}
