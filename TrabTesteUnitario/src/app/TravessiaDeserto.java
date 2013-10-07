package app;

/**
 * 
 * Jogo Travessia do Deserto.
 * Objetivo: Atravessar o mapa por completo.
 *
 */
public class TravessiaDeserto {

	public static final int MAP_SIZE = 10;
	public static final int MAX_FUEL = 6;

	public static final java.util.Scanner sc = new java.util.Scanner(System.in);
	
	public static final int AVANCAR = 0;
	public static final int VOLTAR = 1;
	public static final int CARREGAR = 2;
	public static final int DESCARREGAR = 3;
	public static final int AJUDA = 4;
	public static final int ERROR = -1;
	
	private int[] map;
	private int fuel;
	private int pos;

	/**
	 * Metodo principal que chama o jogo pelo metodo auxiliar run()
	 * 
	 */
	public static void main(String[] args) {
		(new TravessiaDeserto()).run();
	}

	/**
	 * Metodo auxiliar responsavel por iniciar o jogo, receber as entradas do usuário e verificar se
	 * o jogo chegou ao fim - caso chegue ao fim do jogo ele informa se o usuario venceu ou perdeu.
	 * 
	 */
	public void run() {
		initGame();
		do {
			printStatus();
			int cmd = translateCommand( sc.next() );
			processCommand( cmd );
		} while (!isGameOver());
		
		System.out.println(getEndMessage());
	}

	/**
	 * 
	 * @return retorna mensagem que o usuario venceu ou nao o jogo.
	 */
	public String getEndMessage() {
		if (isWinner())
			return "Voce GANHOU!";
		else
			return "Voce PERDEU.";
	}

	/**
	 * 
	 * @return retorna Game Over caso o usuario não atravesse o mapa por completo.
	 */
	public boolean isGameOver() {
		if (isWinner())
			return true;
		if (fuel == 0 && getMap()[pos] == 0)
			return true;
		return false;
	}

	/**
	 * 
	 * @return retorna a checagem se a posicao atual e igual a posicao final do mapa.
	 */
	public boolean isWinner() {
		return pos == MAP_SIZE;
	}

	/**
	 * Metodo responsavel por iniciar o jogo.
	 * Caracteristicas:
	 *  - Posicao = 0
	 *  - Combustivel = 6
	 *  - Tamanho do mapa = 10
	 */
	public void initGame() {
		pos = 0;
		fuel = MAX_FUEL;
		setMap(new int[MAP_SIZE]);
	}

	/**
	 * Metodo responsavel por informar a situacao atual do jogo.
	 * Caracteristicas:
	 * 	- Posicao atual;
	 * 	- Quantidade de combustivel* atual;
	 * 	
	 * 	*Caso o usuario descarregou combustiveis na posicao atual, ele sera alertado que pode carregar
	 * naquela posicao não estando com o seu tanque cheio.
	 */
	public void printStatus() {
		System.out.println(String.format("Voce esta na posicao %d.", pos));
		System.out.println(String.format("Voce possui %d unidades de combustivel.",fuel));
		if (pos > 0)
			System.out.println(String.format("Existem %d unidades de combustivel nessa posicao.", getMap()[pos]));
	}

	/**
	 * 
	 * @param command - entrada de comando (avancar, voltar, carregar, descarregar e ajuda)
	 * @return interpretacao dos comandos dado pelo usuario.
	 */
	public int translateCommand(String command) {
		String cmd = command.toLowerCase();
		if (cmd.equals("avancar"))
			return AVANCAR;
		if (cmd.equals("voltar"))
			return VOLTAR;
		if (cmd.equals("carregar"))
			return CARREGAR;
		if (cmd.equals("descarregar"))
			return DESCARREGAR;
		if (cmd.equals("ajuda"))
			return AJUDA;
		return ERROR;
	}

	/**
	 * 
	 * @param command - entrada de comando (avancar, voltar, carregar, descarregar e ajuda)
	 * Possiveis operações:
	 * 	- Avancar = avanca uma posicao;
	 * 	- Voltar = volta uma posicao;
	 * 	- Descarregar = descarrega um combustivel na posicao atual - caso haja combustivel para descarregar -;
	 * 	- Carregar = carregar um combustivel da posicao atual - caso haja - nao estando cheio o tanque
	 */
	public void processCommand(int command) {
		switch (command) {
			case AVANCAR:
				avancar();
				break;
			case VOLTAR:
				voltar();
				break;
			case CARREGAR:
				carregar();
				break;
			case DESCARREGAR:
				descarregar();
				break;
			case AJUDA:
				ajuda();
				break;
			default:
				System.err.println("Comando invalido.");
		}
	}

	/**
	 * Metodo acionado quando o usuario insere a palavra "ajuda" (sem aspas).
	 * Ele informa os comandos - avancar, voltar, carregar, descarregar e ajuda - para jogar.
	 * 
	 */
	public void ajuda() {
		System.out.println("Comandos: avancar voltar carregar descarregar ajuda");
	}

	/**
	 * Descarrega um combustivel na posicao atual - caso haja - cada vez que o comando for dado
	 */
	public void descarregar() {
		if (fuel > 0) {
			fuel--;
			getMap()[pos]++;
		}
	}

	/**
	 * Carrega um combustivel da posicao atual - caso haja - cada vez que o comando for dado
	 */
	public void carregar() {
		if (getMap()[pos] > 0) {
			getMap()[pos]--;
			fuel++;
		}
	}

	/**
	 * Volta sempre uma posicao nao estando na base e tendo pelo menos uma unidade de combustivel no tanque.
	 */
	public void voltar() {
		if (fuel > 0 && pos > 0) {
			fuel--;
			pos--;
		}
		if (pos == 0)
			fuel = MAX_FUEL;
	}

	/**
	 * Avanca sempre uma posicao que tenha pelo menos uma unidade de combustivel no tanque.
	 */
	public void avancar() {
		if (fuel > 0) {
			fuel--;
			pos++;
		}
	}
	
	/**
	 * 
	 * @return retorna a quantidade de combustiveis atuais no caminhao.
	 */
	public int getFuel(){
		return fuel;
	}
	
	/**
	 * 
	 * @return retorna a posicao atual no mapa.
	 */
	public int getPosicao(){
		return pos;
	}

	/**
	 * 
	 * @return retorna e armazena juntamente com a posicao o quantidade de combustiveis
	 * armazenados nas posicoes do mapa.
	 */
	public int[] getMap() {
		return map;
	}
	
	/**
	 * 
	 * @param map - insere o mapa do jogo.
	 */
	private void setMap(int[] map) {
		this.map = map;
	}
	
	/**
	 * 
	 * @return retorna o tamanho do mapa.
	 */
	public int getMapSize(){
		return MAP_SIZE;
	}

}
