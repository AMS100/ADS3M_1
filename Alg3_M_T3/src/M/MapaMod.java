package M;

import V.View;

/**
 * Classe de criação do mapaMod
 * @author Neimar, Aurélio
 *
 */
public class MapaMod {
	
	private static int i = 0 ,j = 0;

	private static int linha = getLinha(); 
	private static int coluna = getLinha();
	public static String [][]mapa = new String[100][100];
	
	public static String[][] getMapa() {
		return mapa;
	}
	
	
	public static int getColuna() {
		return coluna;
	}
	
	
	public static void setColuna(int coluna) {
		MapaMod.coluna = coluna;
	}
	
	
	public static void setLinha(int linha) {
		MapaMod.linha = linha;
	}
	
	
	public static int getLinha() {
		return linha;
	}
	
	
	/**
	 * Cria tabluleiro do jogo
	 * @throws Exception
	 */
	public static void criaMapa() throws Exception {
		try {
			for (i = 0; i < linha; i++) {	
				for (j = 0; j < coluna; j++) {
					mapa[i][j] = ".";
				}				
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			View.msgb("Não foi possível criar o mapaMod!");
		}
	}
}