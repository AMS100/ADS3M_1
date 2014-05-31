package M.Utilitarios;
import java.util.Scanner;
import App.Menus;
import App.View;

/**
 * Classe com mï¿½todos globais de apoio ï¿½ execuï¿½ï¿½o do programa
 * @author Neimar, Aurï¿½lio
 */
public class Auxiliar {
	static Scanner var = new Scanner(System.in);
	static String opcao; // Variïável global de apoio para parâmetro "strings"
	static int contador = 0; // Variïável global contadora de aïções 
	static String detalhes; // Variável global de apoio para detalhar ações do programa "strings"
	
	
	public static void setOpcao(String opcao) {
		Auxiliar.opcao = opcao;
	}
	
	 
	public static String getOpcao() {
		return opcao;
	}
	
	
	public static void setDetalhes(String detalhes) {
		Auxiliar.detalhes = detalhes;
	}
	
	public static String getDetalhes() {
		return detalhes;
	}
	
	/**
	 * Método global de contagem sequecial
	 * @param contar
	 */
	public static void setContador(boolean contar) {
		if (contar == true){
			Auxiliar.contador++; // Conta ações em tempo de execução
		}else{
			Auxiliar.contador = 0; //Limpa variavel contadorea
		}
	}
	
	
	public static int getContador() {
		return contador;
	}
	
	
	/**
	 * Mï¿½todo de definï¿½ï¿½o de status das atividades do programa
	 * @param status
	 * @return
	 */
	public static String statusAcao(int status, int sucesso) {
		String r, s;	
		
		if (sucesso == 7) { // Avaliaï¿½ï¿½o de sucesso da atividade
			s = "com sucesso!";
		} else if(sucesso == -1) {
			s = "sem sucesso"; 
		} else {
			s = "...";
		}
		
		switch (status) { // Definidor de "status" da atividade
		
		case -1:r = "Pendente " + s; 
			break;
		case 0:	r = "Nï¿½o definido " + s; 
			break;
		case 1:	r = "Em planejamento " + s; 
			break;
		case 2:	r = "Em desenvolvimento " + s; 
			break;
		case 3:	r = "Em teste " + s; 
			break;
		case 4:	r = "Em revisï¿½o " + s; 
			break;
		case 5:	r = "Concluï¿½do(a) parcialmente " + s; 
			break;
		case 6:	r = "Concluï¿½do(a) " + s; 
			break;
		case 7:	r = "Finalizado(a) " + s; 
			break;		
		default:
			r = "invï¿½lido "; break;
		}
		
		return r;
	}
	
	
//============================================================================	
	
	/**
	 * Mï¿½todo de Label dos comandos do sistema
	 * @param label
	 */
	public static void paleta(String label) {
		View.msg("\n");
		if (label.equals("")) {
			View.msg("COMANDO: ");
		} else {
			View.msg(label +": ");
		}
	}
	
	/**
	 * Valores boleanos
	 * @param label
	 * @return
	 */
	public static int digitaNumero(String label) {
		paleta(label);
		return var.nextInt();
	}
	
	/**
	 * Método de retorno que recebe ficheiro "label" com parï¿½metro,
	 * e retorna uma "string" para filtros
	 * @param label
	 * @return
	 */
	public static String digita(String label) {
		paleta(label);
		return var.next().toLowerCase();
	}
	
//============================================================================

	/**
	 * Mï¿½todo que define a ordem de ordenaï¿½ï¿½o para todos os ordenadores
	 * @return
	 * @throws Exception
	 */
	public static boolean defineOrdem(Boolean ativaMenu) throws Exception {	
		Menus.menuModoOrdenacao(ativaMenu);
		String modo  = Auxiliar.digita("Ordem");
		
		if (modo.equals("c")) { // Define ordem crescente
			return true;
			
		} else if (modo.equals("d")) { // Define ordem decrescente
			return false;
			
		} else { // Comando de validaï¿½ï¿½o de modo de ordenaï¿½ï¿½o
			View.opcaoInvalida();			
			return defineOrdem(ativaMenu);
		}		
	}
}
