package M.Arvore;

import App.View;
import C.Registrador;
import M.Utilitarios.Auxiliar;
	
/**
 * Classo de gravacao do nodo
 * @author Neimar, Aurelio *
 * @param <T>
 */
public class Nodo<T extends Comparable<T>>{
	protected Nodo<T> pai;
	private Nodo<T> esq;
	private Nodo<T> dir;
	private T valor;
	
	
	/**
	 * Contrutor da classe nodo
	 * @param valor
	 */
	public Nodo(T valor){
		pai = null;
		esq = null;
		dir = null;
		this.valor = valor;
	}
	
	
	private void setPai(Nodo<T> nodo) {
		this.pai = nodo;	
	}
	
	
	public T getValor(){
		return this.valor;
	}
	
	
	public void setValor(T valor){
		this.valor = valor;
	}

	
	/**
	 * Metodo responsavel pela insecao dos objetos na arvore
	 * @param novo
	 */
	public void insere(Nodo<T> novo){
		if(novo.getValor().compareTo(valor) < 0 ){
			if(esq ==null){
				esq = novo;
				novo.setPai(this);
			}else{
				esq.insere(novo);
			}
		}
		
		if(novo.getValor().compareTo(valor) > 0){
			if(dir ==null){
				dir = novo;
				novo.setPai(novo);
			}else {
				dir.insere(novo);
			}
		}
		return;
	}	
	
	
	/**
	 * Método de impressão de toda a árvore	
	 */
	public void imprime(){
		View.msg("\n" + valor);
		if(esq != null){			
			esq.imprime();	
		}
		
		if(dir != null){
			dir.imprime();				
		}		
	}
		
	
	/**
	 * Metodo responsável por armazenar em terporariamente as alteração dos dados do arquivo
	 */
	public void guardaEdicao(){
		Registrador.setAcum(Registrador.getAcum() +"\n" +valor);
		if(esq != null){			
			esq.guardaEdicao();	
		}
		
		if(dir != null){
			dir.guardaEdicao();				
		}		
	}
	
	
	/**
	 * Percorre a árvore pós ordem
	 * @param no
	 */
	public void travessiaPosFixa(Nodo<T> no){
		if( no == null )  
			return;
		
			travessiaPosFixa(no.dir);
			travessiaPosFixa(no.esq);
			View.msg("\nTravessia pós-fixa :" +no.valor);
	}
	
	
	/**
	 * Percorre a árvore pré ordem
	 * @param no
	 */
	public void travessiaPreFixa(Nodo<T> no){
		if( no == null )  
			return;  
			
			View.msg("\nTravessia pré-fixa :" +no.valor);	
			travessiaPreFixa(no.dir);
			travessiaPreFixa(no.esq);		 
	}
	
	
	/**
	 * Percorre a árvore forma infixa
	 * @param no
	 */
	public void travessiaInfixa(Nodo<T> no){
		if( no == null )  
			return;
		
		 	travessiaInfixa(no.esq);
			View.msg("\nTravessia infixa :" +no.valor);	
			travessiaInfixa(no.dir);		 
	}
	
	
	/**
	 * Conta novos existentes na árvore
	 * @param no
	 * @return
	 */
	public int contaNodos(Nodo<T> no){
	     if(no == null)
	         return 0;
	     else 
	         return 1+contaNodos(no.esq)+contaNodos(no.dir);
	}
	
	
	/**
	 * Percore arvore a contando o niveis de profundidade
	 * @param no
	 * @param nome
	 */
	public void buscEmAltura(Nodo<T> no , String nome) {
		if ( no == null ) {  
			View.msg( " Nivel -1 " );  
	    
		}else if ( no.valor.compareTo(no.valor) == nome.compareTo(nome)){  
	    	View.msg(" Nivel " +Auxiliar.getContador());
	    
	    }else if ( no.valor.compareTo(no.valor) > nome.compareTo(nome)){  
	    	if ( no != null ) {  
	    		Auxiliar.setContador(Auxiliar.getContador()+1); //Contador  
	            buscEmAltura(no.dir , nome );  
	        }
	    
	    }else if ( no.valor.compareTo(no.valor) < nome.compareTo(nome)){  
	    	if( no != null){  
	    		Auxiliar.setContador(Auxiliar.getContador()+1); //Contador    
	            buscEmAltura(no.dir , nome );  
	        } 
	    }
	}
	
	
	/**
	 * Percorre a árvore em busca do elemento solicitado.
	 * @param no
	 * @param campo
	 * @param comparacoes
	 */
	public void buscaDado(Nodo<T> no, T campo){		
		if (no == null){
			View.msg("\nDado não encontrado na árvore!" +
					"\nComparacoes: " +Auxiliar.getContador());			
		}else {		
			
			int comper = campo.compareTo(no.getValor());
			
			if ( comper == 0){
				Auxiliar.setContador(Auxiliar.getContador()+1); //Contador  
				View.msg(no + "\nComparacoes: " +Auxiliar.getContador());				
			
			}else if (comper < 0){
				Auxiliar.setContador(Auxiliar.getContador()+1); //Contador  
				buscaDado(no.esq, campo);
			
			}else {
				Auxiliar.setContador(Auxiliar.getContador()+1); //Contador  
				buscaDado(no.dir,campo);
			}
		}	
	}
	
	
	/**
	 * Método de remoção " não consegui implementar"
	 * @param no
	 * @param campo
	 */
	public void remove(Nodo<T> no, T campo){
		View.objetoNaoImplementado();
	}
}
