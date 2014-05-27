package C;

import M.MapaMod;
import V.View;

public class Consultas {
	
	MapaMod mapaMod = new MapaMod();
	PrintMapa printMapa = new PrintMapa();
	MapaCont mapaCont = new MapaCont();
	PrintNiveis PrintNiveis  = new PrintNiveis();
	PrintNavios printNavios = new PrintNavios();
	PrintSoldados printSoldado = new PrintSoldados();
	Batalha batalha = new Batalha();

	/**
	 * Método que lista todas as consultas do jogo
	 * @throws Exception
	 */
	public void listaConsultas() throws Exception {
		batalha.iniciaMapa();
		View.msgl();
		printNavios.imprime(false,true);
		View.msgl();
		PrintNiveis.imprime(false ,true);
		View.msgl();
		printSoldado.imprime();
	}
	
	/**
	 * Método de consulta a navios
	 * @param filtrar
	 * @throws Exception
	 */
	public void consultaNavios(Boolean filtrar,Boolean mostraCabecalho) throws Exception {
		printNavios.imprime(filtrar,mostraCabecalho);
		View.msgl();
	}
	
	
	/**
	 * Método de consulta aos níveis do jogo
	 * @param filtrar
	 * @throws Exception
	 */
	public void consultaNiveis(Boolean filtrar) throws Exception {
		View.msgl();
		PrintNiveis.imprime(filtrar,true);
	}
	
	/**
	 * Método de consulta a dados do soldado
	 * @throws Exception
	 */
	public void consultaSoldado() throws Exception {
		View.msgl();
		printSoldado.imprime();
	}
}