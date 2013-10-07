package teste;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import app.TravessiaDeserto;

/*
 * Métodos testados:
 * initGame();
 * avancar();
 * voltar();
 * descarregar();
 * carregar();
 * isGameOver();
 * isWinner();
 * 
 * Cobertura de testes:
 * initGame() - inicializacao do jogo (posicao = 0,combustivel = 6 e tamanho do mapa = 10);
 * 
 * avancar() - avanca uma proxima posicao enquanto houver combustiveis no tanque;
 * 
 * voltar() - volta uma posicao enquanto houver combustiveis no tanque e nao estando no inicio do mapa;
 * 
 * descarregar() - descarrega combustiveis enquanto houver no tanque;
 * 
 * carregar() - carrega combustiveis que foram descarregados ao longo das posicoes;
 * 
 * isGameOver() - testa se terminou o jogo quando o jogador vence ou perde;
 * 
 * isWinner() - testa se o caminhao chegou na ultima posicao.
 * 
 */

public class testeTravessiaDeserto {
	
	private TravessiaDeserto j = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		j = new TravessiaDeserto();
	}

	@After
	public void tearDown() throws Exception {
		j = null;
	}

	@Test
	public void testInitGame() {
		j.initGame();
		
		assertTrue(j.getFuel() > 0);
		assertTrue(j.getPosicao() == 0);
		
		int posicao = j.getPosicao();
		int combustivel = j.getFuel();
		int tamMapa = j.getMapSize();
		
		assertTrue(posicao == 0);
		assertTrue(combustivel == 6);
		assertTrue(tamMapa == 10);
		
	}

	@Test
	public void testAvancar() {
		j.initGame(); // 6 - 0

		assertTrue(j.getFuel() > 0);
		assertTrue(j.getPosicao() == 0);

		int combustivel = j.getFuel();
		int posicao = j.getPosicao();
		
		
		j.avancar(); // 5 - 1
		assertEquals("Testando combustivel: ", combustivel - 1, j.getFuel());
		assertEquals("Testando posicao: ", posicao + 1, j.getPosicao());

		combustivel = j.getFuel();
		posicao = j.getPosicao();
		j.avancar(); // 4 - 2
		assertEquals("Testando combustivel: ", combustivel - 1, j.getFuel());
		assertEquals("Testando posicao: ", posicao + 1, j.getPosicao());

		combustivel = j.getFuel();
		posicao = j.getPosicao();
		j.avancar(); // 3 - 3
		assertEquals("Testando combustivel: ", combustivel - 1, j.getFuel());
		assertEquals("Testando posicao: ", posicao + 1, j.getPosicao());

		combustivel = j.getFuel();
		posicao = j.getPosicao();
		j.avancar(); // 2 - 4
		assertEquals("Testando combustivel: ", combustivel - 1, j.getFuel());
		assertEquals("Testando posicao: ", posicao + 1, j.getPosicao());

		combustivel = j.getFuel();
		posicao = j.getPosicao();
		j.avancar(); // 1 - 5
		assertEquals("Testando combustivel: ", combustivel - 1, j.getFuel());
		assertEquals("Testando posicao: ", posicao + 1, j.getPosicao());

		combustivel = j.getFuel();
		posicao = j.getPosicao();
		j.avancar(); // 0 - 6
		assertEquals("Testando combustivel: ", combustivel - 1, j.getFuel());
		assertEquals("Testando posicao: ", posicao + 1, j.getPosicao());		
		
	}
	
	@Test
	public void testVoltar() {
		j.initGame(); // 6 - 0
		
		assertTrue(j.getFuel() > 0);
		assertTrue(j.getPosicao() == 0);
		
		int combustivel = j.getFuel();
		int posicao = j.getPosicao();
		
		j.avancar(); // 5 - 1
		j.avancar(); // 4 - 2
		j.avancar(); // 3 - 3
		
		assertTrue(j.getFuel() > 0);
		assertTrue(j.getPosicao() > 0);
		
		combustivel = j.getFuel();
		posicao = j.getPosicao();
		j.voltar(); // 2 - 2
		assertEquals("Testando combustivel: ", combustivel - 1, j.getFuel());
		assertEquals("Testando posicao: ", posicao - 1, j.getPosicao());
		
		assertTrue(j.getFuel() == 2);
		assertTrue(j.getPosicao() == 2);
		
		combustivel = j.getFuel();
		posicao = j.getPosicao();
		j.voltar(); // 1 - 1
		assertEquals("Testando combustivel: ", combustivel - 1, j.getFuel());
		assertEquals("Testando posicao: ", posicao - 1, j.getPosicao());
		
		assertTrue(j.getFuel() == 1);
		assertTrue(j.getPosicao() == 1);
		
		combustivel = j.getFuel();
		posicao = j.getPosicao();
		j.voltar(); // 1 - 1
		assertTrue(j.getFuel() == 6);
		assertEquals("Testando posicao: ", posicao - 1, j.getPosicao());
		
	}
	
	@Test
	public void testDescarregar() {
		j.initGame();
		
		assertTrue(j.getFuel() > 0);
		assertTrue(j.getPosicao() == 0);

		int combustivel = j.getFuel();
		int posicao = j.getPosicao();
		int tamMapa = j.getMapSize();
		int[] mapa = new int [tamMapa];
		
		j.avancar(); //5 - 1
		
		assertTrue(tamMapa == 10);
		combustivel = j.getFuel();
		posicao = j.getPosicao();
		j.descarregar(); //4 - 1
		assertEquals("Testando descarregar: ", combustivel -= 1, j.getFuel());
		assertEquals(mapa[posicao] += 1, j.getMap()[j.getPosicao()]);
		assertTrue(j.getMap()[j.getPosicao()] == 1);
		assertTrue(combustivel == 4);
		
		combustivel = j.getFuel();
		posicao = j.getPosicao();
		j.descarregar(); //3 - 1
		assertEquals("Testando descarregar: ", combustivel -= 1, j.getFuel());
		assertEquals(mapa[posicao] += 1, j.getMap()[j.getPosicao()]);
		assertTrue(j.getMap()[j.getPosicao()] == 2);
		assertTrue(combustivel == 3);
		
		combustivel = j.getFuel();
		posicao = j.getPosicao();
		j.descarregar(); //2 - 1
		assertEquals("Testando descarregar: ", combustivel -= 1, j.getFuel());
		assertEquals(mapa[posicao] += 1, j.getMap()[j.getPosicao()]);
		assertTrue(j.getMap()[j.getPosicao()] == 3);
		assertTrue(combustivel == 2);
		
		combustivel = j.getFuel();
		posicao = j.getPosicao();
		j.descarregar(); //1 - 1
		assertEquals("Testando descarregar: ", combustivel -= 1, j.getFuel());
		assertEquals(mapa[posicao] += 1, j.getMap()[j.getPosicao()]);
		assertTrue(j.getMap()[j.getPosicao()] == 4);
		assertTrue(combustivel == 1);
		
		combustivel = j.getFuel();
		posicao = j.getPosicao();
		j.descarregar(); //0 - 1
		assertEquals("Testando descarregar: ", combustivel -= 1, j.getFuel());
		assertEquals(mapa[posicao] += 1, j.getMap()[j.getPosicao()]);
		assertTrue(j.getMap()[j.getPosicao()] == 5);
		assertTrue(combustivel == 0);
		
	}
	
	@Test
	public void testCarregar() {
		j.initGame();
		
		assertTrue(j.getFuel() > 0);
		assertTrue(j.getPosicao() == 0);

		int combustivel = j.getFuel();
		int posicao = j.getPosicao();
		int tamMapa = j.getMapSize();
		int[] mapa = new int [tamMapa];
		
		j.avancar(); //5 - 1
		j.descarregar(); //4 - 1
		j.descarregar(); //3 - 1
		
		
		combustivel = j.getFuel();
		posicao = j.getPosicao();
		mapa[posicao] = j.getMap()[j.getPosicao()];
		j.carregar(); //4 - 1
		assertEquals("Testando carregar: ", combustivel += 1, j.getFuel());
		assertEquals(mapa[posicao] -= 1, j.getMap()[j.getPosicao()]);
		assertTrue(mapa[posicao] == 1);
		assertTrue(combustivel == 4);
		
		combustivel = j.getFuel();
		posicao = j.getPosicao();
		mapa[posicao] = j.getMap()[j.getPosicao()];
		j.carregar(); //5 - 1
		assertEquals("Testando carregar: ", combustivel += 1, j.getFuel());
		assertEquals(mapa[posicao] -= 1, j.getMap()[j.getPosicao()]);
		assertTrue(mapa[posicao] == 0);
		assertTrue(combustivel == 5);		
		
	}
	
	@Test
	public void testIsGameOver(){
		j.initGame();
		
		while(j.getFuel() > 0) {
			j.avancar();			
		}
		
		assertTrue(j.isGameOver()); //perdeu
		
		j.initGame();
		vencerGame();
		assertTrue(j.isGameOver()); //venceu
		
	}
	
	@Test
	public void testIsWinner(){
		j.initGame();
		
		int posicao = j.getMapSize();
		
		vencerGame();
		assertTrue(j.isWinner());		
		
	}
	
	// -------- metodos auxiliares --------
	
	private void avancarDpl(){
		j.avancar();
		j.avancar();
	}
	
	private void voltarDpl(){
		j.voltar();
		j.voltar();
	}
	
	private void carregarDpl(){
		j.carregar();
		j.carregar();
	}
	
	private void descarregarDpl(){
		j.descarregar();
		j.descarregar();
	}
	
	private void avanDescVol(){
		avancarDpl();
		descarregarDpl();
		voltarDpl();
	}
	private void avanCarreg(){
		avancarDpl();
		carregarDpl();
	}
	
	private void vencerGame(){
		avanDescVol();
		avanDescVol();
		avanDescVol();
		avanDescVol();
		avanCarreg();
		avanDescVol();
		carregarDpl();
		carregarDpl();
		carregarDpl();
		avanCarreg();
		avancarDpl();
		avancarDpl();
		avancarDpl();
		
	}

}