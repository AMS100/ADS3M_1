package App;

import C.Comandos;
import C.Utilitarios.*;
import V.Menus;
import V.View;

public class Appt3 {

	Comandos comando = new Comandos();	
	Dia dia = new Dia();

	
	private void escreveCabecalho() {
	    View.msgb("		          JOGO BATALHA NAVAL \n\n	     	               BEM-VINDO");
	}
	
	/**
	 * @throws Exception
	 */
	public void run() throws Exception {
		escreveCabecalho();
		dia.defineSaudacao();
		Menus.menuMain();
		comando.inicia();
	}
	

	public static void main(String[] args)throws Exception {
		new Appt3().run();    
	}
	
}