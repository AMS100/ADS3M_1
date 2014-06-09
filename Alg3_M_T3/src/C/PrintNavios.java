package C;
import M.NaviosMod;
import V.View;

/**
 *Classe de impressão e consulta a navios
 * @author Neimar, Aurélio
 */
public class PrintNavios {
	String acum =" ";
	
	/**
	 * Método que encontra um navio específico ou lista todos, 
	 * dependendo do parêmetro filtrar
	 * @param filtrar
	 * @param parametro
	 */
	private void pesquisa(boolean filtrar, String parametro) {
		
		if (parametro.equals("portaAvioes") && filtrar == true || filtrar == false) {
			acum += "\nPortaAvioes " 
					+ NaviosMod.getPortaAvioes()
					+ " de " + NaviosMod.getUnidPortaAvioes() + " unidades\n";
		} 
			
		if (parametro.equals("destroyers") && filtrar == true || filtrar == false) {
			acum += "\nDestroyers " 
					+ NaviosMod.getDestroyers()
				    + " de " +NaviosMod.getUnidTorpedeiros() + " unidades\n";
		}
			
		if (parametro.equals("fragatas") && filtrar == true || filtrar == false) {
			acum += "\nFragatas " 
					+ NaviosMod.getFragatas()
					+ " de " +NaviosMod.getUnidFragatas() + " unidades\n";
		}
				
		if (parametro.equals("torpedeiros") && filtrar == true || filtrar == false) {
			acum += "\nTorpedeiros " 
				 + NaviosMod.getTorpedeiros()
				 + " de " + NaviosMod.getUnidTorpedeiros() + " unidades\n";;
		} 
		
		if (parametro.equals("submarinos") && filtrar == true || filtrar == false) {
			acum += "\nSubmarinos " 
					+ NaviosMod.getSubmarinos()
					+ " de " + NaviosMod.getUnidSubmarinos() + " unidades\n";
		}
	}
	
	
	/**
	 * Método de avaliação de retorno de parâmetro
	 * @param filtrar
	 * @param parametro
	 */
	public void executa(boolean filtrar, String parametro) {
		pesquisa(filtrar, parametro);
		View.msg(acum);
		
		if (filtrar == true && acum.equals(" ")) {
			View.msgb("Não foi encontrado nenhum navio com nome de " + parametro);
		} else {
			pesquisa(filtrar, parametro);			
		}
		acum =""; // Limpa variável de impressão 
	}
	
	/**
	 * Habilita cabeçalho de impressão
	 * @param filtrar
	 * @param mostraCabecalho
	 */
	private void abilitaCabecalho(boolean filtrar, Boolean mostraCabecalho) {
		if (mostraCabecalho == true) {
			if (filtrar == true) {
				View.msgc("	CONSULTA DE NAVIOS\n");
			} else {
				View.msgc("	LISTA DE NAVIOS DO JOGO\n");
			}
		}
	}
	
	/**
	 * Método de impressão de navios inimigos
	 * @param filtrar
	 */
	public void imprime(boolean filtrar,Boolean mostraCabecalho) {
		if (filtrar == true) {
			executa(filtrar,View.digita("Nome do navio "));
		} else {
			abilitaCabecalho(filtrar, mostraCabecalho);
			executa(filtrar, " ");
		}
	}
}