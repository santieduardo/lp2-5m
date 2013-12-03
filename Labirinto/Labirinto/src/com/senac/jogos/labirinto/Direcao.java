package com.senac.jogos.labirinto;

public enum Direcao {
	NORTE("North", 0), SUL("South", 1), LESTE("East", 2), OESTE("West", 3), ACIMA(
			"Up", 4), ABAIXO("Down", 5);

	private String name;
	private int index;

	/**
	 * 
	 * @param s - entrada do comando
	 * @return retona a direcao
	 * @throws Exception
	 */
	public static Direcao converte(String s) throws Exception {
		if (NORTE.name.equalsIgnoreCase(s))
			return NORTE;
		if (SUL.name.equalsIgnoreCase(s))
			return SUL;
		if (LESTE.name.equalsIgnoreCase(s))
			return LESTE;
		if (OESTE.name.equalsIgnoreCase(s))
			return OESTE;
		if (ACIMA.name.equalsIgnoreCase(s))
			return ACIMA;
		if (ABAIXO.name.equalsIgnoreCase(s))
			return ABAIXO;
		throw new Exception("Direcao invalida.");
	}

	/**
	 * atribui uma direcao
	 * @param s - entrada das direcoes
	 * @param i - indice para conversao
	 */
	private Direcao(String s, int i) {
		this.name = s;
		this.index = i;
	}

	/**
	 * 
	 * @return retorna o indice da conversao
	 */
	public int getIndex() {
		return this.index;
	}

	/**
	 * auxilia na formacao da string para ser exibida ao jogador
	 */
	public String toString() {
		return name;
	}

	/**
	 * 
	 * @param direcao - entrada da direcao
	 * @return retorna a direcao partindo do indice
	 * @throws Exception
	 */
	public static Direcao converte(int direcao) throws Exception {
		switch (direcao) {
		case 0:
			return NORTE;
		case 1:
			return SUL;
		case 2:
			return LESTE;
		case 3:
			return OESTE;
		case 4:
			return ACIMA;
		case 5:
			return ABAIXO;
		}
		throw new Exception("Direcao invalida.");
	}
}
