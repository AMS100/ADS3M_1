package M;

import App.View;
import C.Arquivos.Ficheiro;
import M.Utilitarios.Auxiliar;

/**
 * Classe responsável pela ondenação de dados carregados de um arquivo 
 * @author Neimar, Aurélio
 */
public class Ordenadores {
	
	static int topo;
	static long tempoExecucao;
	static String aux;
	static String pivo;
	static String nomeOrdenador;
	
	
	public static void setNomeOrdenador(String nomeOrdenador) {
		Ordenadores.nomeOrdenador = nomeOrdenador;
	}
	
	public static String getNomeOrdenador() {
		return nomeOrdenador;
	}

	
//========================= << Ordenação BubleSort >> ==============================
	
	/**
	 * Método responsável pela manipulação do vetor durante ordenação bubleSort
	 * @param i
	 * @param j
	 */
	private static void trocasItensBubleSort(int i, int j) {
		aux = Dados.vetor[i];                	
		Dados.vetor[i] = Dados.vetor[j];
		Dados.vetor[j] = aux;	
	}
		
	/**
	 * Metodo responsável pela ordenação BubleSort
	 * @param ordem
	 * @param mostraEstatisca
	 * @throws Exception
	 */
	private static void ordenaBubleSort(boolean ordem) throws Exception {		
		try {
			for (int i = 1; i < Dados.vetor.length; i++) {
	         	for (int j = i+1; j < Dados.getVetor().length; j++) {	         		
	         		if (ordem == true) {	         			
		                if (Dados.vetor[i].compareTo(Dados.vetor[j]) > 0) { // Ordem crescente  
		                   	trocasItensBubleSort(i, j);
		                   	Auxiliar.setContador(true);
		                }
	         		} else {
		                if (Dados.vetor[i].compareTo(Dados.vetor[j]) < 0) { // Ordem decrescente  
		                	trocasItensBubleSort(i, j);
		                	Auxiliar.setContador(true);
		                }
	         		} 
	         	}	         	
	         	tempoExecucao  = System.currentTimeMillis();	         	
	         }			
	
		} catch (NullPointerException e) {
		 	View.msge("\nO vetor de armazanamento está definido como null!"); 			
		}	    
	}
	
	
	/**
	 * Método responsável pelo execução do ordenador bubleSort
	 * @throws Exception
	 */
	private static void executaBubleSort() throws Exception {
		Ficheiro.leArquivo(Auxiliar.digita("Nome do arquivo"), true, null, false, false);
		
		if (Dados.getValidaArquivo() == true) {
			ordenaBubleSort(Auxiliar.defineOrdem(true));
		}		 
	}
		
	
	/**
	 * Método respensável pelo carregamento do ordenador bubleSort
	 * @throws Exception
	 */
	public static void carregaBubleSort(boolean imprimir) throws Exception {
		limpaVetor(true); // Garante o vetor limpo antes do carregamento do ordenador
		executaBubleSort();
		
		if (imprimir == true) { // Abilita impressão do vetor quando solicitado
			imprime(true,true, true, true);
		}
	}
	
	
// ======================== << Ordenação QuickSort >> ====================================

	
	/**
	 * Método que partiona o vetor e ordena as partes individualmente
	 * @param vet
	 * @param ini
	 * @param fim
	 * @return topo
	 */
	private static int particionaVetorQuickSort(String vet[], int ini, int fim, boolean ordem) {
		int i;
	    pivo = vet[ini];
	    topo = ini;
	 
	    for (i = ini + 1; i <= fim; i++) {
	    	if(ordem == true){
		    	if (vet[i].compareTo(pivo) < 0) {
		    		vet[topo] = vet[i];
			    	vet[i] = vet[topo + 1];		            
			    	 topo++;
			    	 Auxiliar.setContador(true);
		    	}
		    } else {
		    	if (vet[i].compareTo(pivo) > 0) {
		    		vet[topo] = vet[i];
			    	vet[i] = vet[topo + 1];		            
			    	topo++;
			    	Auxiliar.setContador(true);
		    	}	
		    }
	    	tempoExecucao  = System.currentTimeMillis();
	     }
	    vet[topo] = pivo;
	    return topo;
	 }
	 
	
	/**
	 * Método que executa as etapas à ordenação do vetor
	 * @param vet
	 * @param ini
	 * @param fim
	 */
	private static void ordenaQuickSort(String vet[], int ini, int fim, boolean ordem) {
		int meio;		
		if (ini < fim) {
			meio = particionaVetorQuickSort(vet, ini, fim, ordem);
		    ordenaQuickSort(vet, ini, meio, ordem);
		    ordenaQuickSort(vet, meio + 1, fim, ordem);
		}		
	}
	
	
	/**
	 * Método de carregamento e validação do ordenador 
	 * @throws Exception
	 */
	public static void carregaQuickSort(boolean imprimir) throws Exception {
		limpaVetor(true); // Garante vetor limpo antes do carregamento do ordenador
		Ficheiro.leArquivo(Auxiliar.digita("Nome do arquivo"),true, null, false, false);
		
		if (Dados.getValidaArquivo() == true) { 
			boolean ordem = Auxiliar.defineOrdem(true);
			ordenaQuickSort(Dados.vetor, 1, (Dados.vetor.length-2),ordem );
			
			if (imprimir == true){ // Habilita impressão do vetor quando solicitado
				imprime(ordem, true, true, true);
			}
		}	    
	}

	
//=============== << Comparação estatística de ordenadores >> ===============================
	
	/**
	 * Método estatístico que compara performance dos ordenadores
	 * @throws Exception
	 */
	public static void comparaOrdenadores() throws Exception {
		limpaVetor(true);
		nomeOrdenador = "BUBLE SORT COMPARADA";
		carregaBubleSort(false);
		informaStatistica(true);
		limpaVetor(true);
		nomeOrdenador = "QUICK SORT COMPARADA";
		carregaBubleSort(false);
		informaStatistica(true);
	}
	
	
//=============== << Menu de acesso aos ordenadores >> ===============================
	
	/**
	 * Método que exibe o cabeçalho com a ordem de execução, crescente ou decrescente
	 * @param ordem
	 * @param exibirCabecalho
	 */
	private static  void informaCabecalhoOrdem(boolean ordem,boolean exibirCabecalho) {	
		 if (exibirCabecalho == true) {
			if (ordem == true) {
	        	View.msgc("	ORDEM CRESCENTE " + nomeOrdenador.toUpperCase() + "\n\n");
			} else {
				View.msgc("	ORDEM DECRESCENTE " + nomeOrdenador.toUpperCase() +"\n\n");
			}
		 }
	}
	
	
	/**
	 * Médodo responsável pela limpeza do vetor após ordenação,
	 * de modo que possa ter suas posições livres,
	 * quando uma próxima ordenação for solicitada em tempo de execução
	 */
	private static  void limpaVetor(boolean limparVetor) {
		if (limparVetor == true) {
			for (int i = 0; i < Dados.vetor.length; i++) {
				Dados.vetor[i]= "";				
			}
		}
		Dados.setIndex(0); // Limpa "index" do vetor executado anteriormente
	}

	
	/**
	 * Informa dados estatísticos específicos da ordenação
	 * @param mostraEstatica
	 */
	private static void informaStatistica(boolean mostraEstatisca) {	
		if (mostraEstatisca == true) { 
			View.msg(
				"\nDADOS ESTATÍSTICOS DA ORDENAÇÃO " + nomeOrdenador.toUpperCase()
				+ "\nTamanho do vetor: " + Dados.getVetor().length
				+ "\nTotal de comparacoes: " + Auxiliar.getContador()
				+ "\nTempo total: " + tempoExecucao + "mls\n");
		}
		Auxiliar.setContador(false);
	}
	
	
	/**
	 * Médodo geral de impressão da lista de dados dos ordenadores
	 * @param ordem
	 * @param mostraEstatisca
	 * @param limpaVetor
	 * @param exibecabecalho
	 */
	private static  void imprime(boolean ordem, boolean mostraEstatisca, boolean limpaVetor, boolean exibecabecalho) {	
		informaCabecalhoOrdem(ordem,exibecabecalho);
		for (String dados : Dados.vetor) { 
        	if (dados != null && dados != "") {
            	View.msg(dados + " \n");  
        	}        	
		}
		View.msgl();
		informaStatistica(mostraEstatisca);
		limpaVetor(limpaVetor);
	}
}