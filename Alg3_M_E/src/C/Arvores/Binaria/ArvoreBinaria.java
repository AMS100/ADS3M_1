package C.Arvores.Binaria;

import App.View;
import M.Utilitarios.Auxiliar;


/**
 * Classe de execução da árvore binária
 * @author Neimar, Aurélio
 * @param <T>
 */
public class ArvoreBinaria<T extends Comparable<T>> {
	private Nodo<T> raiz;

	Nodo<T> nodo =  new Nodo<T>(null);


	/**
	 * Método de inserção na árvore
	 * @param novo
	 */
	public void insere(Nodo<T> novo) {
		if (raiz == null) {
			raiz = novo;
		} else {
			raiz.insere(novo);
		}		
	}


	/**
	 * @param impressão da árvore
	 * @throws Exception 
	 */
	public void imprime(boolean cabecalho) throws Exception {
		View.imprimeArvores(true, "\nIMPESSÃO DA - ");
		raiz.imprime();			
	}	

	/**
	 * Método responsável por armazenar temporariamente as alterações dos dados do arquivo
	 */
	public void guardaEdicao() {
		raiz.guardaEdicao();
	}

	/**
	 * Imprime travessia pós-fixa da árvore
	 */
	public void travessiaPosFixa(boolean cabecalho) {
		View.imprimeArvores(true, "\nTRAVESSIA PÓS-FIXA - ");
		raiz.travessiaPosFixa(raiz);
	}

	/**
	 * Imprime travessia pré-fixa da árvore
	 */
	public void travessiaPreFixa(boolean cabecalho) {
		View.imprimeArvores(true, "\nTRAVESSIA PRÉ-FIXA - ");
		raiz.travessiaPreFixa(raiz);
	}

	/**
	 * Imprime travessia infixa da árvore
	 */
	public void travessiaInfixa(boolean cabecalho) {
		View.imprimeArvores(true, "\nTRAVESSIA INFIXA - ");
		raiz.travessiaInfixa(raiz);
	}

	/**
	 * Conta nodos da árvore
	 * @return
	 */
	public int contaNodos(boolean cabecalho) {
		View.imprimeArvores(true, "\nCONTAGEM DE NODOS - ");
		return raiz.contaNodos(raiz);
	}

	/**
	 * Busca elemento percorrendo a árvore em largura
	 * @param nome
	 */
	public void buscEmAltura(String nome, boolean cabecalho) {
		View.imprimeArvores(true, "\nBUSCA EM ALTURA - ");
		raiz.buscEmAltura(raiz, nome);
		Auxiliar.setContador(false); // Limpa contador
	}

	/**
	 * Método de impressão de busca de dados
	 * @param campo
	 */
	public void buscaDado(T campo,boolean cabecalho) {
		View.imprimeArvores(true, "\nBUSCA DADOS - ");
		raiz.buscaDado(null, campo);
		Auxiliar.setContador(false); // Limpa contador
	}

	/**
	 * Método complementar de remoção
	 * @param campo
	 */
	public void remove(T campo, boolean cabecalho) {
		View.imprimeArvores(true, "\nREMOCÃO DE NODO - ");
		raiz.remove(raiz, campo);
	}
}