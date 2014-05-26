package Model.Utilitarios;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import View.Prints;

/**
 * Classe controladora de saudações
 * @author Neimar, Aurélio
 */
public class Dia {
	Pressagios pressagios = new Pressagios(); 	
	
	Calendar diaHora = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	

	public void ImprimeHora() {		
		diaHora.set(Calendar.DST_OFFSET,0);		
		Prints.msg("São " +sdf.format(diaHora.getTime()) +"hs");
	}
	
	/**
	 * Método de impressão de cabeçalho de saudação
	 * @param hora
	 */
	public void defineCabecalho(Object hora) {		
		Prints.msg("\nOlá!" +
			  "\n" + defineNomenclatura() + hora + "\n");
	}
	
	/**
	 *  Método de verificação de hora, plural ou singular
	 * @return
	 */
	public String defineNomenclatura() {
		diaHora.set(Calendar.DST_OFFSET,0);
		
		int hora =  diaHora.get(Calendar.HOUR_OF_DAY);
		
		if (hora == 1) {
			return "É ";
		} return "São ";
	}
		
	/**
	 *  Método definidor de saudação
	 */
	public void defineSaudacao() {
		diaHora.set(Calendar.DST_OFFSET,0);
		
		int hora =  diaHora.get(Calendar.HOUR_OF_DAY);
		
		if (hora >= 0 && hora < 12) {
			defineCabecalho(sdf.format(diaHora.getTime()) +" da manhã." +"");
			pressagios.desejaBomDia();
		}

		if (hora >= 12  && hora < 18) {
			defineCabecalho(sdf.format(diaHora.getTime()) +" da tarde." +"");
			pressagios.desejaBoaTarde();
		}	
		
		if (hora >= 18  && hora <= 24) {
			defineCabecalho(sdf.format(diaHora.getTime()) +" da noite." +"");
			pressagios.desejaBoaNoite();
		}	
	}
}