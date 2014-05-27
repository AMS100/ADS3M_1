package Controller;

import Model.MapaMod;
import Model.NaviosMod;
import View.Prints;

/**
 * Classe responsável pela distribuição das embarcações no mapaMod
 * @author Aurélio, Neimar
 */
public class Estrategia {
	
	MapaMod mapaMod = new MapaMod();
	PrintMapa printMapa = new PrintMapa();
	Inimigo inimigo = new Inimigo(); 
	PrintSoldados PrintSoldado = new PrintSoldados();

	private static int nivel;
	private int contUnidades;
	
	
	public static void setNivel(int nivel) {
		Estrategia.nivel = nivel;
	}

	/**
	 * Define posição do navio no mapaMod
	 */
	private void posiciona() {
		
		for (int i = 0; i <  MapaMod.getLinha(); i++) {
			for (int j = 0; j <  MapaMod.getColuna(); j++) {				
			
				if (i == 0 && j >= nivel && j < (NaviosMod.getUnidPortaAvioes() + nivel)) {
					MapaMod.mapa[i][j] = "-";					
				}
					
				if (i == 5 && j >= nivel-1 && j < (NaviosMod.getUnidDestroyers() + nivel -1)) {
					MapaMod.mapa[i][j] = "-";					
				}
				
				if (i == 2 && j >= nivel && j < (NaviosMod.getUnidDestroyers() + nivel)) {
					MapaMod.mapa[i][j] = "-";					
				}
				
				if (i == 3 && j >= (nivel+2) && j < (NaviosMod.getUnidFragatas() + nivel +2)) {
					MapaMod.mapa[i][j] = "-";					
				}
				
				if (i == 4 && j >= (nivel+1) && j < (NaviosMod.getUnidFragatas() + nivel +1)) {
					MapaMod.mapa[i][j] = "-";					
				}
		
				if (i == 1 && j >= nivel && j < (NaviosMod.getUnidTorpedeiros()+nivel)) {
					MapaMod.mapa[i][j] = "-";					
				}
				
				if (i == 6 && j >= (nivel+2) && j < (NaviosMod.getUnidTorpedeiros() + nivel +2)) {
					MapaMod.mapa[i][j] = "-";					
				}
				
				if (i == 7 && j >= (nivel+1) && j < (NaviosMod.getUnidTorpedeiros() + nivel +1)) {
					MapaMod.mapa[i][j] = "-";					
				}
		
				if (i == 8 && j >= nivel && j > (NaviosMod.getUnidTorpedeiros() + nivel)) {
					MapaMod.mapa[i][j] = "-";					
				}
				
				if (i == 8 && j >= nivel && j < (NaviosMod.getUnidTorpedeiros() + nivel)) {
					MapaMod.mapa[i][j] = "-";					
				}
				
				if (i == 9 && j >= (nivel) && j < (NaviosMod.getUnidTorpedeiros() + nivel)) {
					MapaMod.mapa[i][j] = "-";					
				}
				
				if (i == 9 && j >= (nivel) && j < (NaviosMod.getUnidTorpedeiros() + nivel)) {
					MapaMod.mapa[i][j] = "-";					
				}
				
				if (i == 9 && j >= (nivel) && j < (NaviosMod.getUnidTorpedeiros() + nivel)) {
					MapaMod.mapa[i][j] = "-";					
				}			
			}			
		}
	}

	
	/**
	 * Método de validação na matriz
	 * @throws Exception
	 */
	private void valida()throws Exception {		
		contUnidades = 0; 
		for (int i = 0; i <  MapaMod.getLinha(); i++) {
			for (int j = 0; j <  MapaMod.getColuna(); j++) {				
				if (MapaMod.getMapa()[i][j] != null) {
					contUnidades++;				
				}			
			}			
		}
	}
	
	
	/**
	 * Método de carregamento de dados
	 * @throws Exception
	 */
	private void carrega() throws Exception {
		
		if(MapaMod.getColuna()*MapaMod.getLinha() == contUnidades) {
			posiciona();
			PrintSoldado.imprime();
		} else {
			Prints.msgb("Mapa inesistente!");
			tatica();
		}
	}
	
	
	/** 
	 * Executa tática do inimigo antes de iniciar o jogo
	 * @throws Exception
	 */
	public void tatica()throws Exception {
		try {
			valida();
			carrega();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}