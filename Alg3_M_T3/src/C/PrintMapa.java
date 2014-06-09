package C;

import M.MapaMod;
import V.View;

/**
 * Classe de impressão dos dados do mapaMod
 * @author Neimar, Aurélio
 */
public class PrintMapa {
	int j, i;
	char letra = 'A';
	MapaMod mapaMod = new MapaMod();
	
	public void setLetra(char letra) {
		this.letra = letra;
	}
	
	/**
	 * Método definidor do cabeçalho das colunas
	 */
	private void nomeiaConluna() {
		View.msg("+ ");
		for (j = 0; j <  MapaMod.getColuna(); j++) {
			View.msg(" " + letra++ );
		}
	}
	
	
	/**
	 * Mostra mensagem cabeçalho quando necessário 
	 * @param mostraMsgCabecalho
	 */
	private void abilitaMsg(boolean mostraMsgCabecalho,Object texto) {
		if (mostraMsgCabecalho == true) {
			// p.msgl();
			View.msg(texto + "\n");		
		}
	}
	
	
	/**
	 * Método que desenha mapaMod de batalha
	 * @param mostraMsgCabelho
	 * @throws Exception
	 */
	public void imprime(boolean mostraMsgCabecalho,Object texto)throws Exception {
		try {
			abilitaMsg(mostraMsgCabecalho, texto);
			nomeiaConluna();
			for (i = 0; i <  MapaMod.getLinha(); i++) {
				View.msg("\n" + i + " ");
				for (j = 0; j <  MapaMod.getColuna(); j++) {				
					View.msg(" " + MapaMod.getMapa()[i][j]);				
				}			
			}
			View.msg("\n");
		
		} catch (ArrayIndexOutOfBoundsException e) {
			View.msgb("Não foi possível imprimir o mapaMod!");
			View.msg("" +MapaMod.getLinha() + "x" + MapaMod.getColuna() + "\n\n");
		}
		setLetra('A');
	}
	
	/**
	 * Imprime regras do jogo
	 */
	public void imprimeRegras() {
		View.msgb("	REGRAS DO JOGO:\n\n"
				+ "=> Digitar o comando 'iniciar' onde será impresso o\n"
				+ "   mapa inicial do jogo.\n\n"		
				+ "=> Digitar o comando 'jogar' para confirmar que o \n"
				+ "   jogador vai iniciar o jogo.\n\n"
				+ "=> Digitar o comando 'atirar' para informar as \n"
				+ "   coordenadas de tiro.\n\n"   
				+ "=> O jogador inicia o jogo com 15 chances.\n\n"
				+ "=> Com 0 ponto o jogador inicia o nível 1.\n\n"
				+ "=> Com 6 pontos o jogador passa para o nível 2.\n\n"
				+ "=> Com 12 pontos o jogador passa para o nível 3.\n\n"
				+ "=> Com 21 pontos o jogador passa para o nível 4.\n\n"
				+ "=> Com 30 pontos o jogador passa para o nível 5,\n"
				+ "   nível máximo.\n\n"
				+ "=> Para atingir a pontuação máxima de 42 pontos,\n"
				+ "   o jogador não poderá errar nenhum tiro\n\n"
				+ "=> O jogador ainda pode jogar em um nível personalizado\n"
				+ "   com definições próprias de mapa e número de chances.\n");

	}
}