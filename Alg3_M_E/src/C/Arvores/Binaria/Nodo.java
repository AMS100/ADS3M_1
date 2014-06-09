package C.Arvores.Binaria;
import App.View;
import C.Registrador;
import M.Utilitarios.Auxiliar;

/**
 * Classe de gravacão do nodo
 * @author Neimar, Aurélio *
 * @param <T>
 */
public class Nodo<T extends Comparable<T>> {
	protected Nodo<T> pai;
	private Nodo<T> esq;
	private Nodo<T> dir;
	private T valor;


	/**
	 * Construtor da classe nodo
	 * @param valor
	 */
	public Nodo(T valor) {
		pai = null;
		esq = null;
		dir = null;
		this.valor = valor;
	}


	private void setPai(Nodo<T> nodo) {
		this.pai = nodo;	
	}


	public T getValor() {
		return this.valor;
	}


	public void setValor(T valor) {
		this.valor = valor;
	}


	/**
	 * Método responsável pela insercão dos objetos na árvore
	 * @param novo
	 */
	public void insere(Nodo<T> novo) {
		if (novo.getValor().compareTo(valor) < 0 ) {
			if (esq == null) {
				esq = novo;
				novo.setPai(this);
			} else {
				esq.insere(novo);
			}
		}

		if (novo.getValor().compareTo(valor) > 0) {
			if (dir == null) {
				dir = novo;
				novo.setPai(novo);
			} else {
				dir.insere(novo);
			}
		}
		return;
	}	


	/**
	 * Método de impressão de toda a árvore	
	 */
	public void imprime() {

		View.msg("\n" + valor);

		if (esq != null) {			
			esq.imprime();	
		}

		if (dir != null) {
			dir.imprime();				
		}
	}

	
	/**
	 * Método responsável por armazenar temporariamente as alterações dos dados do arquivo
	 */
	public void guardaEdicao() {
		Registrador.setAcum("\n" + valor);
		if (esq != null) {
			esq.guardaEdicao();
		}
		
		if (dir != null) {
			dir.guardaEdicao();				
		}
	}


	/**
	 * Percorre a árvore forma pós-ordem
	 * @param no
	 */
	public void travessiaPosFixa(Nodo<T> no) {
		if (no == null)
			return;

			travessiaPosFixa(no.dir);
			travessiaPosFixa(no.esq);
			View.msg("\n:" + no.valor);
	}


	/**
	 * Percorre a árvore forma pré-ordem
	 * @param no
	 */
	public void travessiaPreFixa(Nodo<T> no) {
		if(no == null)
			return;

			View.msg("\n:" + no.valor);	
			travessiaPreFixa(no.dir);
			travessiaPreFixa(no.esq);		 
	}


	/**
	 * Percorre a árvore forma infixa
	 * @param no
	 */
	public void travessiaInfixa(Nodo<T> no) {
		if (no == null)
			return;

		 	travessiaInfixa(no.esq);
			View.msg("\n:" + no.valor);	
			travessiaInfixa(no.dir);		 
	}


	/**
	 * Conta nodos existentes na árvore
	 * @param no
	 * @return
	 */
	public int contaNodos(Nodo<T> no) {
	     if (no == null)
	         return 0;
	     else 
	         return 1 + contaNodos(no.esq) + contaNodos(no.dir);
	}


	/**
	 * Percore árvore contando os níveis de profundidade
	 * @param no
	 * @param nome
	 */
	public void buscEmAltura(Nodo<T> no, String nome) {
		if (no == null) {
			View.msg( " Nivel -1 ");

		} else if (no.valor.compareTo(no.valor) == nome.compareTo(nome)) {  
	    	View.msg("Nivel " + Auxiliar.getContador());

	    } else if (no.valor.compareTo(no.valor) > nome.compareTo(nome)) {  
	    	if (no != null ) {
	    		Auxiliar.setContador(true); // Contador  
	            buscEmAltura(no.dir, nome);  
	        }

	    } else if (no.valor.compareTo(no.valor) < nome.compareTo(nome)) {  
	    	if (no != null) {
	    		Auxiliar.setContador(true); // Contador    
	            buscEmAltura(no.dir, nome);  
	        } 
	    }
	}


	/**
	 * Percorre a árvore em busca do elemento solicitado
	 * @param no
	 * @param campo
	 * @param comparacoes
	 */
	public void buscaDado(Nodo<T> no, T campo) {
		if (no == null) {
			View.msg("\nDado não encontrado na árvore!" +
					 "\nComparacoes: " + Auxiliar.getContador());			
		} else {

			int comper = campo.compareTo(no.getValor());
			
			if (comper == 0) {
				Auxiliar.setContador(true); // Contador  
				View.msg(no + "\nComparacoes: " + Auxiliar.getContador());				

			} else if (comper < 0) {
				Auxiliar.setContador(true); // Contador  
				buscaDado(no.esq, campo);

			} else {
				Auxiliar.setContador(true); // Contador  
				buscaDado(no.dir,campo);
			}
		}	
	}


	/**
	 * Método de remoção - não implementado
	 * @param no
	 * @param campo
	 */
	public void remove(Nodo<T> no, T campo) {
		View.objetoNaoImplementado();
	}
}