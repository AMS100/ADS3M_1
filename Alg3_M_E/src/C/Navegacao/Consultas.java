package C.Navegacao;

import App.Menus;
import App.View;
import C.Registrador;
import C.Arquivos.Ficheiro;
import C.Lista.ListaEncadeada;
import M.Dados;
import M.Utilitarios.Auxiliar;


/**
 * Classe reponsável pelas consultas em todas as estruras.
 * @author Neimar, Aurelio
 */
public class Consultas {
	
	ListaEncadeada<String> lista = new ListaEncadeada<String>();
	
	
	/**
	 * Método que realiza ficheiro navegação entre os registrador 
	 * @param nomeArquivo
	 */
	public void	navega(String nomeArquivo) {
		View.objetoNaoImplementado();
	}	

		
//====================<< Busca binária de registrador >> =======================================	
	
	int vet[] = new int [Ficheiro.getVetor().length];
	int i, inicio = 0, meio, fim = Ficheiro.getVetor().length;
    boolean localizador = false;
    
    
    /**
	 * Imprime resultado da busca binária
	 * @param campo
	 */
	private void imprimeBuscaBinaria(int campo) {		
		if (localizador == true) {
			View.msgb("	RESULTADO DE BUSCA BINÁRIA\n"
				+ "\nRegistro encontrado\n"
				+ "\n\nPosição [" + meio + "] " + Dados.vetor[meio]
				+"\n\nTotal de comparações:" +Auxiliar.getContador()+"\n");
				Auxiliar.setContador(false); //Limpa variável contadora
				
		} else {
		   	View.msge("\nNúmero não encontrado");
		}
	}
		
    
	/**
	 * Realiza busca binária dentro do vetor carregado do arquivo
	 * @param campo
	 */
	private void executaBuscaBinaria(int campo) {
	    i = 0;
	    meio = (inicio + fim) / 2;

	    while (inicio <= fim && localizador == false) {
	    	if (vet[meio] == campo) {
	    		localizador = true;
	    		Auxiliar.setContador(true);
	    	} else {
	    		Auxiliar.setContador(true);
	        	if (campo < vet[meio]) {
	        		fim = meio - 1;	  
	        		Auxiliar.setContador(true);
	            }else {
	            	inicio = meio + 1;
	            	Auxiliar.setContador(true);
	            }
	        	meio = (inicio + fim) / 2;
	       }
	   }
	}
	

	/**
	 * Método responsável pelo carregamento do arquivo.
	 * @param nomeArquivo
	 * @param campo
	 * @throws Exception
	 */
	public void carregaBuscaBinaria(String nomeArquivo,int campo) throws Exception {
		Ficheiro.leArquivo(nomeArquivo,true, "", false, false);			
		
		if (campo <= Dados.getVetor().length){
		
			for (i = 0; i < Dados.getVetor().length; i++) {		    	
				vet[i] = i;
				View.msg("\nId: " +i +" " +Dados.vetor[i]);
			}
			
			executaBuscaBinaria(campo);
			imprimeBuscaBinaria(campo);

		} else {
			View.msge("\nId inexistente!");
		}
		
		Dados.setIndex(0); // Limpa vetor para próxima consulta
	}


//====================<< Busca em estruturas java >> ========================================		
	

	
	
	
	
	
	
	
	
//====================<< Menu busca >> ========================================================		
		
	/**
	 * Seleciona comando de consulta
	 */
	private void selecionaComando(String nomeArquivo) {
		try {
			Menus.menuConsultas();					
			switch (Auxiliar.digita("")) {
			
			case "novo":				
				View.objetoNaoImplementado();
				selecionaComando(nomeArquivo);
				break;
			
			case "remover":				
				View.objetoNaoImplementado();
				selecionaComando(nomeArquivo);
				break;
				
			case "posfixa":				
				Registrador.getArvoreBinaria().travessiaPosFixa();
				selecionaComando(nomeArquivo);
				break;
			
			case "prefixa":				
				Registrador.getArvoreBinaria().travessiaPreFixa();
				selecionaComando(nomeArquivo);
				break;
			
			case "infixa":				
				Registrador.getArvoreBinaria().travessiaInfixa();
				selecionaComando(nomeArquivo);
				break;
			
			case "contar":				
				Registrador.getArvoreBinaria().contaNodos();
				selecionaComando(nomeArquivo);
				break;
			
			case "altura":				
				Registrador.getArvoreBinaria().buscEmAltura(nomeArquivo);
				selecionaComando(nomeArquivo);
				break;
			
			case "profundidade":				
				View.objetoNaoImplementado();
				selecionaComando(nomeArquivo);
				break;
			
			case "id":				
				carregaBuscaBinaria(nomeArquivo, Auxiliar.digitaNumero("Id a ser localizado"));
				selecionaComando(nomeArquivo);
				break;
				
			case "navegar":
				View.objetoNaoImplementado();				
				selecionaComando(nomeArquivo);
				break;
			
			case "arquivo":
				Ficheiro.leArquivo(nomeArquivo, false, "", false, true);
				selecionaComando(nomeArquivo);
				break;
				
			case "nome":				
				View.objetoNaoImplementado();
				selecionaComando(nomeArquivo);
				break;
			
			case "sair":
				View.sair();
				break;
			
			default:
				View.opcaoInvalida();
				selecionaComando(nomeArquivo);
				break;
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 
	 * @throws Exception 
	 */
	public void selecinaExtrutura() throws Exception{
		String nomeArquivo = Auxiliar.digita("Nome do arquivo");
		
		switch (Auxiliar.getOpcao()) {
		
		case "LISTA":			
			Ficheiro.leArquivo(nomeArquivo,false, null, false, false);
			selecionaComando(nomeArquivo);
			break;

		case "ARVORE":			
			Ficheiro.leArquivo(nomeArquivo,false, null, false, false);
			selecionaComando(nomeArquivo);			
			break;
		
		case "BINARIA":			
			selecionaComando(nomeArquivo);
			break;
		
		default:
			View.opcaoInvalida();
			break;
		}
	}
	
	
}