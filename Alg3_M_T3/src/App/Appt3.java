package App;

import Controller.PrintInterface;
import Model.Utilitarios.*;
import View.Menus;
import View.Prints;

public class Appt3 {

	PrintInterface Interface = new PrintInterface();	
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
		Interface.inicia();
	}
	

	public static void main(String[] args)throws Exception {
		new Appt3().run();    
	}
	
}