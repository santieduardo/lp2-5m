import java.util.Scanner;
/**
 * 
 * @author Eduardo Santi - eduardo.senacrs@gmail.com
 *
 */

public class Jogo {

	private static int tamanho = 10;
	private static int posicao = 0;
	private static int combustivel = 6;
	private static int[] mapa = new int[tamanho];
	private static String comando;
	
	/**
	 * 
	 * @param args
	 */
	public static void main (String[] args){
		Jogo j = new Jogo();
		Scanner t = new Scanner(System.in);
		System.out.println("--- Travessia do Deserto ---\n");
		
		do{
		System.out.print("\nMapa do Deserto:                          ");		
		
		for (int i = 0; i < 10; i++){
			System.out.print("[" + i + "]");
		}
		
		System.out.println("");
		System.out.print("Caminhao:");
		for (int i = 0; i < 10; i++){
			if(posicao == i){
			System.out.print("                                 [C]");
			}else {
				System.out.print("   ");
			}
		}

		System.out.println();
		System.out.print("Combustiveis disponiveis em casa posicao: ");
		for (int i = 0; i < 10; i++){
			System.out.print("[" + mapa[i] + "]");
		}
	
		
		System.out.println("\n\nVoce esta na posicao: " +  j.getPosicao());
		System.out.println("Restam: " + j.getCombustivel() + " combustiveis no seu caminhao.\n");
		
		if(posicao == 0){
		System.out.println("O que deseja fazer? (Opcao disponivel no momento: avancar)");
		}else{
			System.out.println("O que deseja fazer? (Opcoes disponiveis no momento: avancar, voltar, carregar ou descarregar)");
		}
		
		comando = t.next();
		
		switch (comando.toUpperCase()){
		case "AVANCAR":
			
			j.avancar();
			System.out.println("Voce avancou uma posicao.");
			break;
			
		case "VOLTAR":
			
			if(j.getPosicao() == 0){
				System.out.println("Impossivel voltar, voce esta na posicao 0.");
			}else{
				j.voltar();
				System.out.println("Voce voltou uma posicao.");
			}
			break;
			
		case "CARREGAR":
			
			if(j.getPosicao() == 0){
				System.out.println("Voce esta na posicao 0 e sempre aqui voce tera seu caminhao reabastecido.");
			}else{
				j.carregar();
			}
			break;
			
		case "DESCARREGAR":
			
			if(j.getPosicao() == 0){
				System.out.println("Voce esta na posicao 0 e nao e possivel descarregar galoes aqui.");
			}else{
				j.descarregar();
			}
			break;
			
		default:
			System.out.println("Ops! Opcao invalida.");
		}
		
		
		} while(!isFimJogo() == true);
		
		System.out.println("Para jogar novamente digite (Ctrl + F11)");
		
	}

/**
 * 
 * @return true quando o jogador vence, ou seja, quando ele atravessa o mapa por completo. 
 * Ou quando ele fica sem combust�vel no meio do caminho.
 * Se o jogador ficar sem combust�vel em alguma posi��o, e nessa posi��o tenham combust�veis para carregar,
 * o jogador pode carregar todos os combust�veis dispon�veis para continuar o jogo.
 */
	public static boolean isFimJogo(){
		if(posicao == 9){
			System.out.println("Parabens, voce chegou ao seu destino \\o/");
			return true;
		}else if (combustivel == 0 && posicao > 0){
			if(mapa[posicao] > 0){
				System.out.println("Voce ficou sem combustivel. Porem nessa casa existem galoes para carregar o caminhao.");
				return false;
			}else
			System.out.println("Desculpe, voce nao conseguiu atravessar o deserto. Tente novamente.");
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * 
	 * @return retorna a posi��o que o caminh�o encontra-se no mapa ap�s ter avan�ado uma posi��o.
	 */
	public int avancar(){
		posicao ++;
		combustivel --;
		isFimJogo();
		return getPosicao();
	}
	
	/**
	 * 
	 * @return retorna a posi��o que o caminh�o encontra-se no mapa ap�s ter voltado uma posi��o.
	 * Caso o jogador estiver no in�cio do mapa/posi��o 0, ele n�o pode voltar posi��es.
	 */
	public int voltar(){
		posicao --;
		combustivel --;
		
		if(posicao == 0){
			combustivel = 6;
			System.out.println("\nVoce voltou para a base e seu caminhao foi totalmente reabastecido.");
		}
		isFimJogo();
		return getPosicao();
	}
	
	/**
	 * 
	 * @return retorna a quantidade de combust�veis restantes no caminh�o ap�s carregar um �tem no caminh�o.
	 * Caso a posi��o que o caminh�o encontra-se n�o tenham combust�veis para carregar, n�o � poss�vel carregar.
	 * Caso o caminh�o tenha o seu tanque completo (6 combust�veis) n�o ser� poss�vel carregar.
	 */
	public int carregar(){
		
		if(posicao > 0 && mapa[posicao] > 0 && combustivel < 6){
			mapa[posicao] --;
			combustivel ++;
			System.out.println("Voce reabasteceu um galao.");
		}else if(combustivel == 6){
			System.out.println("Desculpe, o caminhao ja esta cheio e nao � possivel carregar.");
		}
		else{
			System.out.println("Desculpe, nessa posicao nao existem galoes para carregar.");
		}
		isFimJogo();
		return getCombustivel();
	}
	
	/**
	 * 
	 * @return retorna o combust�vel atual ap�s descarregar uma unidade caso ele tenha pelo menos dois.
	 * Se tiver apenas uma unidade de combust�vel, o jogador ser� impossibilitado de descarregar, pois assim, perder� o jogo.
	 */
	public int descarregar(){
		
		if(combustivel > 1){
			mapa[posicao] ++;
			combustivel --;
			System.out.println("Voce descarregou um galao nessa posicao.");
		}else{
			System.out.println("Voce tem apenas 1 combustivel e nao pode descarregar porque sera fim de jogo.");
		}
		isFimJogo();
		return getCombustivel();
	}
	
	/**
	 * 
	 * @return retorna a posi��o atual
	 */
	public int getPosicao(){
		return posicao;
	}
	
	/**
	 * 
	 * @return retorna o combust�vel atual
	 */
	public int getCombustivel(){
		return combustivel;
	}
		
}