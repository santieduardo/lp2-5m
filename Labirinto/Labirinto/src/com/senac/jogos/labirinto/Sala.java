package com.senac.jogos.labirinto;

import java.util.ArrayList;
import java.util.List;

public class Sala {

	Conexao[] conexoes = new Conexao[6];
	private List<Item> itens = new ArrayList<Item>();

	/**
	 * captura um indice das direcoes
	 * @param direcao - inserido
	 * @return retorna o indice de uma direcao
	 * @throws Exception
	 */
	private static int getDirecaoIndex(String direcao) throws Exception {
		Direcao dir = Direcao.converte(direcao);
		return dir.getIndex();
	}

	/**
	 * define uma armadilha em um indice do labirinto
	 * @param direcao - inserido
	 * @throws Exception
	 */
	public void setArmadilha(String direcao) throws Exception {
		conexoes[getDirecaoIndex(direcao)].setArmadilha();
	}

	/**
	 * adiciona uma conexao
	 * @param direcao - inserido
	 * @param sala - inserido
	 * @throws Exception
	 */
	public void addConexao(String direcao, int sala) throws Exception {
		int ndx = getDirecaoIndex(direcao);
		if (conexoes[ndx] != null)
			throw new Exception("--- CONEXAO EXISTENTE---");

		conexoes[ndx] = new Conexao(sala);
	}

	/**
	 * captura a conexao feita
	 * @param direcao - inserido
	 * @return retorna o indice da direcao na conexao
	 */
	public Conexao getConexao(Direcao direcao) {
		return conexoes[direcao.getIndex()];
	}

	/**
	 * adiciona um item
	 * @param item - inserido
	 */
	public void addItem(Item item) {
		itens.add(item);
	}

	/**
	 * captura itens indicados
	 * @return retorna um item indicado
	 */
	public List<Item> getItens() {
		return itens;
	}

	/**
	 * busca a conexao
	 * @return retorna a conexao realizada
	 */
	public Conexao[] getConexoes() {
		return conexoes;
	}

	/**
	 * auxilia na formacao da string para informacao do jogador
	 */
	public String toString() {
		try {
			String res = "DIRECOES DA SALA:\n";
			for (int i = 0; i < 6; i++)
				if (conexoes[i] != null)
					res += "\t" + Direcao.converte(i) + " " + conexoes[i]
							+ "\n";
			return res;
		} catch (Exception e) {
			return "--- O estado da sala esta invalido ---";
		}

	}

}
