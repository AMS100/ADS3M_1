package V;

import java.util.Scanner;

/**
 * Classe responsável pela impressão do programa 
 * @author Neimar, Aurélio
 */
public class View {	
	static Scanner var = new Scanner(System.in);
	
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
			  "\n==========================================================================\n"
			+ desc
			+ "\n==========================================================================\n");
	}
	
	
	public static void msgc(Object desc) {
		System .out.print(
			"\n==========================================================================\n"
			+ desc);
	}


	public static void msgr(Object desc) {
		System .out.print(
			desc
			+ "\n==========================================================================\n");
	}	
	

	public static void msgl() {
		System .out.print(
			"\n==========================================================================\n");
	}
	
	
	public static void espacoInsuficiente() {
		System .err.print("\nEspaço insuficiente em disco para inserir dados.\n");
	}
	
	
	public static void opcaoInvalida() {
		System .err.println("\nComando inválido. Tente novamente.");
	}
	
	
	public static void objetoNaoImplementado() {
		System .err.print("\nNão implementado.\n");
	}
	

	/**
	 * Método de label dos comandos do sistema
	 * @param label
	 */
	public static void paleta(String label) {
		System .out.println();
		if (label.equals("")) {
			System .out.print("COMANDO: ");
		} else {
			System .out.print(label + ": ");
		}
	}

	
	/**
	 * Valores "booleans"
	 * @param label
	 * @return
	 */
	public static int digitaNumero(String label) {
		paleta(label);
		return var.nextInt();		
	}
	
	
	/**
	 * Método de retorno que recebe a label com parâmento, e retorna
	 * uma string para filtros
	 * @param label
	 * @return
	 */
	public static String digita(String label) {
		paleta(label);
		return var.next().toLowerCase();
	}
	
	
	public static void sair() {
		System.err.print("\nVocê optou por sair do jogo. Obrigado.");
	}
	
	
	/**
	 * Método de definção de status das atividades do programa
	 * @param status
	 * @return
	 */
	public static String statusAcao(int status, int sucesso) {
		String r, s;	
		
		if (sucesso == 7) { // Avaliação de sucesso da atividade
			s = "com sucesso!";
		} else if(sucesso == -1) {
			s = "sem sucesso"; 
		} else {
			s = "...";
		}
		
		switch (status) { // Definidor de status da atividade
		
		case -1:r = "Pendente " + s; 
			break;
		case 0:	r = "Não definido " + s; 
			break;
		case 1:	r = "Em planejamento " + s; 
			break;
		case 2:	r = "Em desenvolvimento " + s; 
			break;
		case 3:	r = "Em teste " + s; 
			break;
		case 4:	r = "Em revisão " + s; 
			break;
		case 5:	r = "Concluído(a) parcialmente " + s; 
			break;
		case 6:	r = "Concluído(a) " + s; 
			break;
		case 7:	r = "Finalizado(a) " + s; 
			break;		
		default:
			r = "inválido "; break;
		}
		
		return r;
	}
}