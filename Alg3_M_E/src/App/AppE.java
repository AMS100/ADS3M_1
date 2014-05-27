package App;

import java.util.InputMismatchException;

import C.interacao;
import M.Ordenadores;
import M.Utilitarios.Auxiliar;
import M.Utilitarios.Dia;

/**
 * Classe principal de execução do programa
 * @author Neimar, Aurélio
 */
public class AppE {
	Ordenadores ordenador = new Ordenadores();
	
	
	/**
	 * Descrição do cabeçalho principal
	 */
	private void escreveCabecalho() {
		View.msgb("\n" +"	EXERCÍCIO DE ESTRUTURAS JAVA\n");
	}
	
	
	/**
	 * Carrega opções de interação com o programa
	 * @throws Exception
	 */
	private void iniciaInteracao() throws Exception {
		Menus.mostarMenuApp();				
		interacao.iniciaTarefas();
	}
	
	
	/**
	 *	Método com definição das atividades solicitadas
	 * @throws Exception
	 */
	private void selecionaAtividade() throws Exception {
	
		try {		
			Menus.menuSelecinaAtividade();	
			switch (Auxiliar.digita("Atividade")) {
			
			case "t1":	
				Auxiliar.setOpcao("LISTA");
				iniciaInteracao();
				break;
				
			case "t2":				
				Auxiliar.setOpcao("BINARIA");
				iniciaInteracao();
				break;
				
			case "t4":	
				Auxiliar.setOpcao("ORDENADORES");
				iniciaInteracao();	
				break;
				
			case "t5":
				Auxiliar.setOpcao("ARVORE"); // Arvore deve ficar sem acentuação pois, se trata de atribução
				iniciaInteracao();				
				break;
			
			case "sair":
				View.sair();
				break;
				
			default: 
				View.opcaoInvalida();
				selecionaAtividade();
				break;
			}
			
		} catch (ClassNotFoundException e) {
			View.msge("Comando não suportado em JavaSE igual ou inferior 6.1 ");
		} catch (InputMismatchException e) {
			View.msge("\nValor(es) digitado(s) inválido(s)!");
		}
	}
	

	/**
	 * @throws Exception
	 */
	private void run() throws Exception {
		escreveCabecalho();
		Dia.defineSaudacao();		
		selecionaAtividade();
		
	}
	

	public static void main(String[] args)throws Exception {		
		new AppE().run(); 
	}
}