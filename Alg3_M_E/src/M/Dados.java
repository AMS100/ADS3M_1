package M;

import C.Arquivos.Ficheiro;

/**
 * Classe responsável pelo armazenamento do vetor de dados coletado do arquivo
 * @author Neimar, Aurélio
 */
public class Dados {

	static boolean validaArquivo; 
	protected static int index = 0;
	static int tamanho = 70;
 	public static String vetor[] = new String[tamanho];


	public static void setIndex(int index) {
		Ficheiro.index = index;
	}

	public static int getIndex() {
		return index;
	}

	public static void setValidaArquivo(boolean validaArquivo) {
		Dados.validaArquivo = validaArquivo;
	}

	public static boolean getValidaArquivo() {
		return validaArquivo;
	}

	public static String[] getVetor() {
		return vetor;
	}
}