package M.Utilitarios;
import java.util.Scanner;
import App.Menus;
import App.View;

/**
 * Classe com métodos globais de apoio à execuçãoo do programa
 * @author Neimar, Aurélio
 */
public class Auxiliar {
	static Scanner var = new Scanner(System.in);
	static String opcao; // Variável global de apoio para parâmetro "strings"
	static int contador = 0; // Variável global contadora de ações
	static String detalhes; // Variável global de apoio para detalhar ações do programa "strings"
	static boolean abilita = false; // Variável global 

	
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
	
	
	public static void setAbilita(boolean abilita) {
		Auxiliar.abilita = abilita;
	}
	
	
	public static boolean getAbilita() {
		return abilita;
	}
	
	
	
	/**
	 * Método global de contagem sequecial
	 * @param contar
	 */
	public static void setContador(boolean contar) {
		if (contar == true) {
			Auxiliar.contador++; // Conta ações em tempo de execução
		} else {
			Auxiliar.contador = 0; // Limpa variável contadora
		}
	}


	public static int getContador() {
		return contador;
	}


	/**
	 * Método de definição de "status" das atividades do programa
	 * @param status
	 * @return
	 */
	public static String statusAcao(int status, int sucesso, int percentual) {
		String r, s;

		if (sucesso == 7) { // Avaliação de sucesso da atividade
			s = "com sucesso!";
		} else if (sucesso == -1) {
			s = "sem sucesso";
		} else {
			s = "...";
		}

		switch (status) { // Definidor de "status" da atividade

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
		case 5:	r = "Concluído parcialmente " + s;
			break;
		case 6:	r = "Concluído " + s;
			break;
		case 7:	r = "Finalizado " + s;
			break;		
		case 8:	r = percentual +"% concluído " + s;
			break;
		default:
			r = "inválido "; break;
		}
		return r;
	}


//============================================================================	

	/**
	 * Método de "Label" dos comandos do sistema
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
	 * Método de retorno que recebe ficheiro "label" com parâmetro,
	 * retorna uma "string" para filtros
	 * @param label
	 * @return
	 */
	public static String digita(String label) {
		paleta(label);
		return var.next().toLowerCase();
	}

//============================================================================

	/**
	 * Método que define a ordem de ordenaçãoo para todos os ordenadores
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

		} else { // Comando de validação de modo de ordenação
			View.opcaoInvalida();
			return defineOrdem(ativaMenu);
		}
	}
}