package C.Lista;

import App.View;
import C.Registrador;
import M.Utilitarios.Auxiliar;

/**
 * Classe responsável pela manipulação da lista
 * @author Neimar, Aurélio
 * * @param <T>
 */
public class ListaEncadeada<T extends Comparable<T>> {


	private Nodo<T> head; // will be ficheiro Nodo
	private Nodo<T> tail; // will be ficheiro Nodo


	public Nodo<T> getHead() {
		return head;
	}


	public void insere(Nodo<T> novo) {
		novo.setNext(head);
		head = novo;

		if (tail == null)
			tail = head;
	}

	/**
	 * Método de inserção de nodos na lista
	 * @param novo
	 * @param anterior
	 */
	public void insert(Nodo<T> novo, Nodo<T> anterior) {
		if (anterior == tail) {
			tail.setNext((Nodo<T>)novo);
			tail = novo;
		} else {
			novo.setNext(anterior.getNext());
			anterior.setNext(novo);
		}
	}


	public void append(Nodo<T> novo) {
		tail.setNext(novo);
		tail = novo;
	}

	/**
	 * Método responsável por guardar as edições do dados em tempo de execução  
	 */
	public void guardaEdicao() {
		Nodo<?> nodo = head;
		do {	
			Registrador.setAcum("\n" + nodo.getData()); // Acumalador de ordenação
			nodo = nodo.getNext();
		} while (nodo != null);	
	}

	/**
	 * Imprime na tela quando habilitado e edita registrador após a ordenação
	*/
	public void imprime(boolean cabecalho) {
		if (cabecalho == true) {
			View.msgc("\nIMPESSÃO DA - " + Auxiliar.getOpcao().toUpperCase() + "\n\n");
		}
		try {
			Nodo<?> nodo = head;
			do {
				View.msg("\n" + nodo.getData()); // Imprime a lista para consulta prévia em tempo de execução
				nodo = nodo.getNext();				
			} while (nodo != null);			

		} catch (NullPointerException e) {
			View.msg("\nNão existem dados no arquivo para serem impressos.\n");
		}
	}

}