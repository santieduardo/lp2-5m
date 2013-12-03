package com.senac.jogos.labirinto;

import java.util.Date;
import java.util.Random;

public class Range {

	private int min;
	private int max;
	private Random randomGenerator = null;

	/**
	 * inicializa um range de maneira correta
	 * @param min - inserido
	 * @param max - inserido
	 */
	public Range(int min, int max) {
		this.min = min;
		this.max = max;
		this.randomGenerator = new Random();
		this.randomGenerator.setSeed((new Date()).getTime());
	}

	/**
	 * captura o minimo
	 * @return retorna o minimo
	 */
	public int getMin() {
		return min;
	}

	/**
	 * captura o maximo
	 * @return retorna o minimo
	 */
	public int getMax() {
		return max;
	}

	/**
	 * captura um range de forma aleatoria
	 * @return retorna um valor range aleatorio
	 */
	public int getRandom() {
		int range = max - min;
		return randomGenerator.nextInt(range + 1) + min;
	}

	/**
	 * captura um percentual entre 0 e 100
	 * @return retorna o percentural do range
	 */
	public static int getPercentual() {
		return (new Range(0, 100)).getRandom();
	}
}
