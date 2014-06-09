package App;

import M.Utilitarios.Auxiliar;

public class View {	

	public static void msg(Object desc) {   
		System .out.print(desc);
	}

	public static void msge(Object desc) {   
		System .err.print(desc);
	}

	/**
	 * @param desc
	 */
	public static void msgb(Object desc) {
		System .out.print(
			  "\n=======================================================================\n"
			+ desc
			+ "\n=======================================================================\n");
	}

	public static void msgc(Object desc) {
		System .out.print(
			  "\n======================================================================\n"
			  + desc);
	}

	public static void msgr(Object desc) {
		System .out.print(
			  desc
			  + "\n=====================================================================\n");
	}	

	public static void msgl() {
		System .out.print(
			    "\n=====================================================================\n");
	}

	public static void espacoInsuficiente() {
		System .err.print("\nEspaço insuficiente em disco para inserir dados.\n");
	}

	public static void opcaoInvalida() {
		System .err.println("\nComando inválido!");
	}

	public static void objetoNaoImplementado() {
		System .err.print("\nNão implementado.\n");
	}

	public static void sair() {
		System.err.print("\nVocê optou por sair do programa.");
		System.exit(0);
	}

	public static void imprimeArvores(Boolean cabecalho, String txt) {	
		if (cabecalho == true) {
			View.msgc(txt
					+ Auxiliar.getOpcao().toUpperCase() + " " 
					+ Auxiliar.getDetalhes().toUpperCase() + "\n\n");
		}
	}
}