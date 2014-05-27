package C.Utilitarios;

import V.View;

/**
 * Classe de impressao de pressagios 
 * @author Neimar, Aurélio
 *
 */
public class Pressagios {
	String sauda;	
	
	public void desejaBomDia() {
		View.msg("Bom Dia.\n");
	}
	
	public void desejaBoaTarde() {
		View.msg("Boa tarde.\n");
	}
	
	public void desejaBoaNoite() {
		View.msg("Boa noite.\n");	
	}
}