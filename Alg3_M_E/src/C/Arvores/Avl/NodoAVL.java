package C.Arvores.Avl;

import App.View;

public class NodoAVL {

	    private int valor;
		private int altDir;
		private int altEsq;
	    private NodoAVL dir;
		private NodoAVL esq;


	    /**
	     * O objeto novo é um objeto auxiliar da árvore 
	     * @param aux
	     * @param val
	     * @return
	     */
	    public NodoAVL insere(NodoAVL aux, int val) {

	        NodoAVL novo;
	        if (aux == null) {
	            novo = new NodoAVL();
	            novo.valor = val;
	            novo.altDir = 0;
	            novo.altEsq = 0;
	            novo.esq = null;
	            novo.dir = null;
	            aux = novo;

	        } else if (val < aux.valor) {
	            aux.esq = insere(aux.esq, val);

	            if (aux.esq.altDir > aux.esq.altEsq) {
	                aux.altEsq = aux.esq.altDir + 1;
	            } else {
	                aux.altEsq = aux.esq.altEsq + 1;
	            }
	            aux = balancia(aux);

	        } else {
	            aux.dir = insere(aux.dir, val);

	            if (aux.dir.altDir > aux.dir.altEsq) {
	                aux.altDir = aux.dir.altDir + 1;

	            } else {
	                aux.altDir = aux.dir.altEsq + 1;
	            }
	            aux = balancia(aux);
	        }
	        return aux;
	    }

	    /**
	     * Método gerenciador de balanciamento
	     * @param aux
	     * @return
	     */
	    public NodoAVL balancia(NodoAVL aux) {
	        int d, df;
	        d = aux.altDir - aux.altEsq;
	        if (d == 2) {
	            df = aux.dir.altDir - aux.dir.altEsq;
	            if (df >= 0) {
	                aux = rotacionaEsq(aux);
	            } else {
	                aux.dir = rotacionaDir(aux.dir);
	                aux = rotacionaEsq(aux);
	            }
	        } else if (d == -2) {
	            df = aux.esq.altDir - aux.esq.altEsq;
	            if (df <= 0) {
	                aux = rotacionaDir(aux);
	            } else {
	                aux.esq = rotacionaEsq(aux.esq);
	                aux = rotacionaDir(aux);
	            }
	        }
	        return aux;
	    }

	    /**
	     * Método de rotação à esquerda
	     * @param aux
	     * @return
	     */
	    public NodoAVL rotacionaEsq(NodoAVL aux) {
	        NodoAVL aux1, aux2;
	        aux1 = aux.dir;
	        aux2 = aux1.esq;
	        aux.dir = aux2;
	        aux1.esq = aux;
	        if (aux.dir == null) {
	            aux.altDir = 0;
	        } else if (aux.dir.altEsq > aux.dir.altDir) {
	            aux.altDir = aux.dir.altEsq + 1;
	        } else {
	            aux.altDir = aux.dir.altDir + 1;
	        }

	        if (aux1.esq.altEsq > aux1.esq.altDir) {
	            aux1.altEsq = aux1.esq.altEsq + 1;
	        } else {
	            aux1.altEsq = aux1.esq.altDir + 1;
	        }
	        return aux1;
	    }


	    /**
	     * Método de rotação à direita
	     * @param aux
	     * @return
	     */
	    public NodoAVL rotacionaDir(NodoAVL aux) {
	        NodoAVL aux1, aux2;
	        aux1 = aux.esq;
	        aux2 = aux1.dir;
	        aux.esq = aux2;
	        aux1.dir = aux;
	        if (aux.esq == null) {
	            aux.altEsq = 0;
	        } else if (aux.esq.altEsq > aux.esq.altDir) {
	            aux.altEsq = aux.esq.altEsq + 1;
	        } else {
	            aux.altEsq = aux.esq.altDir + 1;
	        }

	        if (aux1.dir.altEsq > aux1.dir.altDir) {
	            aux1.altDir = aux1.dir.altEsq + 1;
	        } else {
	            aux1.altDir = aux1.dir.altDir + 1;
	        }
	        return aux1;
	    }

	    /**
	     * Impressão de todos os ítens da árvore
	     * @param aux
	     */
	    public void imprimeArvore() {
	    	View.msg(valor + "\n");

	    	if (dir != null) {
	        	dir.imprimeArvore();

	    	}

	    	if (esq != null) {
	    		esq.imprimeArvore();
	        }
	    }


	    /**
	     * Impressão ordenada
	     * @param aux
	     */
	    public void ordemInfixa(NodoAVL aux) {
	        if (aux != null) {
	        	View.msg(aux.valor + "\n");
	            ordemInfixa(aux.esq);
	            ordemInfixa(aux.dir);
	        }
	    }

	    /**
	     * Impressão pré-ordenada
	     * @param aux
	     */
	    public void odermPrefixa(NodoAVL aux) {
	        if (aux != null) {
	            odermPrefixa(aux.esq);

	            odermPrefixa(aux.dir);
	        }
	    }

	    /**
	     * Impressão pós-ordenada
	     * @param aux
	     */
	    public void ordemPosFixa(NodoAVL aux) {
	        if (aux != null) {
	            ordemPosFixa(aux.esq);
	            ordemPosFixa(aux.dir);
	            View.msg(aux.valor + "\n");
	        }
	    }
	}