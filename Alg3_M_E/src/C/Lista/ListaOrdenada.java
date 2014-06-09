package C.Lista;

/**
 * Classe responsável pela ordenação do dados antes da insersão no arquivo
 * @author Neimar, Aurélio
 * @param <T>
 */
public class ListaOrdenada<T extends Comparable<T>> extends ListaEncadeada<T> {

	/**
	 * Método de ordenação de dados
	 * @param novo
	 * @return
	 */
	private Nodo<T> findBefore(Nodo<T> novo) {
		Nodo<T> atual = getHead();
		Nodo<T> anterior = null;

		while (atual != null) {
			int comp = atual.compareTo(novo);
			if (comp < 0) {
				anterior = atual;
				atual = atual.getNext();
			}
			if (comp == 0)
				return atual;
			if (comp > 0)
				return anterior;
		}
		return anterior;
	}


	@Override
	public void insere(Nodo<T> novo) {
		Nodo<T> anterior = findBefore(novo);
		if (anterior == null) {
			super.insere(novo);
		} else {
			super.insert(novo, anterior);
		}
	}


	@Override
	public void insert(Nodo<T> novo, Nodo<T> anterior) {
		insere(novo);
	}


	@Override
	public void append(Nodo<T> novo) {
		insere(novo);
	}

}