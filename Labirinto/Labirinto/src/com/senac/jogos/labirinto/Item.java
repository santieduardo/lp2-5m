package com.senac.jogos.labirinto;

abstract public class Item {
	private String descricao;

	/**
	 * 
	 * @param descricao inserida do item
	 */
	protected Item(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * 
	 * @return retorna a descricao do item
	 */
	public String getDescricao() {
		return this.descricao;
	}

	/**
	 * auxilia na formacao da string para informacao do jogador
	 */
	public String toString() {
		return descricao;
	}

	/**
	 * retorna true se a descricao inserida esta compativel com outra existente
	 */
	public boolean equals(Object o) {
		if (o == this)
			return true;

		String item = null;
		if (o instanceof Item)
			item = ((Item) o).getDescricao();
		else if (o instanceof String)
			item = (String) (o);
		else
			return false;

		return this.descricao.equalsIgnoreCase(item);
	}
}
