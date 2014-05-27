package M.Arvore;

import M.Utilitarios.Auxiliar;


/**
 * 
 * @author Neimar, aurelio
 * @param <T>
 */
public class ArvoreBinaria<T extends Comparable<T>>{
	private Nodo<T> raiz;

	Nodo<T> nodo =  new Nodo<T>(null);
	
	/**
	 * Método de inserção na arvore
	 * @param novo
	 */
	public void insere(Nodo<T> novo){
		if(raiz == null){
			raiz = novo;
		}else{
			raiz.insere(novo);
		}
	}
	
	/**
	 * @param impressão da árvore
	 */
	public void imprime(){
		raiz.imprime();		
	}
	
	
	/**
	 * Metodo responsável por armazenar em terporariamente as alteração dos dados do arquivo
	 */
	public void guardaEdicao(){
		raiz.guardaEdicao();
	}
	
	/**
	 * Imprmir travessia pós fixa da árvore
	 */
	public void travessiaPosFixa(){
		raiz.travessiaPosFixa(raiz);
	}
	
	/**
	 * Imprimr Travassia pré fixa da árvore
	 */
	public void travessiaPreFixa(){
		raiz.travessiaPreFixa(raiz);
	}
	
	/**
	 * Imprimr Travassia infixa da árvore
	 */
	public void travessiaInfixa(){
		raiz.travessiaInfixa(raiz);
	}
	
	/**
	 * Conta toda de nodos da arvore
	 * @return
	 */
	public int contaNodos(){
		return raiz.contaNodos(raiz);
	}
	
	/**
	 * Busca elemento percorrendo a arvore em largura
	 * @param nome
	 */
	public void buscEmAltura(String nome){
		raiz.buscEmAltura(raiz, nome);
		Auxiliar.setContador(0); //Limpa contador
	}	
	
	/**
	 * Método e impressao de busca de dados
	 * @param campo
	 */
	public void buscaDado(T campo){
		raiz.buscaDado(null, campo);
		Auxiliar.setContador(0); //Limpa contador
	}
	
	/**
	 * Médo complementar de remoção
	 * @param campo
	 */
	public void remove(T campo){
		raiz.remove(raiz, campo);
	}
}