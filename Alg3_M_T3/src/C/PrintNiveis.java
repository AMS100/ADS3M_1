package C;

import M.NiveisMod;
import V.View;

/**
 * Classe de impressão de níveis de jogo
 * @author Neimar, Aurélio
 */
public class PrintNiveis {
	String acum =" ";
	
	/**
	 * Método que encontra um nível específico ou lista todos, 
	 * dependendo do parêmetro filtrar
	 * @param filtrar
	 * @param parametro
	 */
	private void pesquisa(boolean filtrar, int parametro) {
			
		if (parametro == NiveisMod.getNivel1()  && filtrar == true || filtrar == false) {
			acum += "\nNIVEL " 
				 +  NiveisMod.getNivel1()
				 +  " MAPA DE " + NiveisMod.getMapanivel1() + "x" + NiveisMod.getMapanivel1() + "\n";
		} 
			
		if (parametro == NiveisMod.getNivel2() && filtrar == true || filtrar == false) {
			acum += "\nNIVEL " 
				 +  NiveisMod.getNivel2()
				 +  " MAPA DE " + NiveisMod.getMapanivel2() + "x" +NiveisMod.getMapanivel2() +"\n";
		}
			
		if (parametro == NiveisMod.getNivel3() && filtrar == true || filtrar == false) {
			acum += "\nNIVEL " 
				 +  NiveisMod.getNivel3()
				 +  " MAPA DE " + NiveisMod.getMapanivel3() + "x" + NiveisMod.getMapanivel3() + "\n";
		}
				
		if (parametro == NiveisMod.getNivel4() && filtrar == true || filtrar == false) {
			acum += "\nNIVEL " 
				 +  NiveisMod.getNivel4()
				 +  " MAPA DE " + NiveisMod.getMapanivel4() + "x" + NiveisMod.getMapanivel4() + "\n";
		} 
		
		if (parametro == NiveisMod.getNivel5() && filtrar == true || filtrar == false) {
			acum += "\nNIVEL " 
				 +  NiveisMod.getNivel5()
				 +  " MAPA DE " + NiveisMod.getMapanivel5() + "x" + NiveisMod.getMapanivel5() + "\n";
		}		
	}
	
	/**
	 * Método de validação de busca
	 * @param filtrar
	 * @param parametro
	 */
	public void executa(boolean filtrar, int parametro) {
		pesquisa(filtrar, parametro);
		View.msg(acum);
		
		if (filtrar == true && acum.equals(" ")) {
			View.msgb("Nivel inesistente!");
		} else {
			pesquisa(filtrar, parametro);			
		}
		acum =""; // Limpa variável de impressão 
	}
	
	/**
	 * Habilita exibição do cabeçalho
	 * @param filtrar
	 * @param mostraCabecalho
	 */
	private void abilitaCabecalho(boolean filtrar,Boolean mostraCabecalho) {
		if (mostraCabecalho == true) {
			if (filtrar == true) {
				View.msgc("	CONSULTA DE NÍVEL\n");
			} else {
				View.msgc("	LISTA DE NÍVEIS DO JOGO\n");
			}
		}
	}
		
	/**
	 * Método de impressão de navios inimigos
	 * @param filtrar
	 */
	public void imprime(boolean filtrar, Boolean mostraCabecalho) {
		abilitaCabecalho(filtrar, mostraCabecalho);
		if (filtrar == true) {
			executa(filtrar, View.digitaNumero("Nro do nivel "));
		} else {
			executa(filtrar, 0);
		}
	}
}