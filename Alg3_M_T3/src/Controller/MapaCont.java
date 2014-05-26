package Controller;

import java.util.InputMismatchException;

import Model.MapaMod;
import View.Prints;

/**
 * Classe para edição e personalização dos navios (NÃO IMPLEMENTADA)
 * @author Neimar
 */
public class MapaCont extends MapaMod {
	
	PrintMapa mapaView = new PrintMapa();
	
	
	public static void setaColuna() throws Exception {
		try {	
			MapaMod.setColuna(Prints.digitaNumero("\nDigite nro. de coluna. "));
			if (getColuna()<= 30){
				Prints.msge("\nO Nro. de chances deve ser mair que 30.\n");
				setaColuna();
			}
		} catch (InputMismatchException e) {
			Prints.msge("\nEra esperado um número!\n");
		}
	}
	

	public static void setaLinha() throws Exception {
		try {
			MapaMod.setLinha(Prints.digitaNumero("Digite nro. de linha. "));	
			if (getLinha() <= 30) {
				Prints.msge("\nO Nro. de chances deve ser mair que 30.\n");
				setaLinha();
			}	
		} catch (InputMismatchException e) {
			Prints.msge("\nEra esperado um numero!\n");
		}					
	}
		
	
	/**
	 * Método controlador de personalização do mapaMod
	 * @throws Exception
	 */
	public static void iniciaMapa() throws Exception {
		Prints.msgc("	REDEFINIR DIMENSÕES DO MAPA");
		setaColuna();
		setaLinha();
		criaMapa();		
	}	
	
	/**
	 * Método de impressão de dados
	 * @param mostraMsgCabelho
	 * @param texto
	 * @throws Exception
	 */
	public void imprimeView(Boolean mostraMsgCabelho,String texto) throws Exception {
		mapaView.imprime(mostraMsgCabelho, texto);		
	}	
}