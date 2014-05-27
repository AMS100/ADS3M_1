package App;

import Controller.Comandos;
import Model.Utilitarios.*;
import View.Menus;
import View.Prints;

public class Appt3 {

	Comandos comando = new Comandos();	
	Dia dia = new Dia();

	
	private void escreveCabecalho() {
	    Prints.msgb("		JOGO BATALHA NAVAL \n\n		     BEM-VINDO");
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