package C.Lista;

import App.View;
import C.Registrador;

/**
 * Classe responsável pela manipulação a lista
 * @author neimar , Aurelio
 * * @param <T>
 */
public class ListaEncadeada<T extends Comparable<T>> {


	private Nodo<T> head; // will be ficheiro Nodo
	private Nodo<T> tail; // will be ficheiro Nodo


	public Nodo<T> getHead() {
		return head;
	}


	public void insert(Nodo<T> novo) {
		novo.setNext(head);
		head = novo;

		if (tail == null)
			tail = head;
	}

	/**
	 * Método de insereção de nodos na lista
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
			Registrador.setAcum(Registrador.getAcum() +"\n" +nodo.getData()); // Acumalador de ordenação
			nodo = nodo.getNext();
		} while (nodo != null);	
	}

	/**
	 * Imprime quando habilitado na tela e edita registrador após a ordenação
	*/
	public void imprime(boolean impressaoPrevia) {
		try {
			Nodo<?> nodo = head;
			do {
				if (impressaoPrevia){View.msg("\n" + nodo.getData());} // Imprime a lista para consulta prévia em tempo de execução
				nodo = nodo.getNext();				
			} while (nodo != null);			

		} catch (NullPointerException e) {
			View.msg("\nNão existem dados no arquivo para serem impressos.\n");
		}
	}

}