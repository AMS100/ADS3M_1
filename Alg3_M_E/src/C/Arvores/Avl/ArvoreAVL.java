package C.Arvores.Avl;

import App.View;

public class ArvoreAVL extends DadosAvl {
	
	private ArvoreAVL dir, esq;

	public ArvoreAVL inserir(ArvoreAVL aux, int num) {

		ArvoreAVL novo;
		
		if (aux == null) {
			novo = new ArvoreAVL();
			novo.setNum(num);
			novo.setAltDir(0);
			novo.setAltEsq(0);
			novo.esq = null;
			novo.dir = null;
			aux = novo;
		
		} else if (num < aux.getNum()) {
			
			aux.esq = inserir(aux.esq, num);
			
			
			if (aux.esq.getAltDir() > aux.esq.getAltEsq()) {
				aux.setAltEsq(aux.esq.getAltDir() + 1);
			
			} else {
				aux.setAltEsq(aux.esq.getAltEsq() + 1);
			}
			aux = balancia(aux);
			
		} else {
			aux.dir = inserir(aux.dir, num);
			
			
			if (aux.dir.getAltDir() > aux.dir.getAltEsq()) {
				aux.setAltDir(aux.dir.getAltDir() + 1);
			
			} else {
				aux.setAltDir(aux.dir.getAltEsq() + 1);
			}
			aux = balancia(aux);
		}
		return aux;
	}

	public ArvoreAVL balancia(ArvoreAVL aux) {
		int dado, df;
		
		dado = aux.getAltDir() - aux.getAltEsq();
		
		if (dado == 2) {
			df = aux.dir.getAltDir() - aux.dir.getAltEsq();
			
			
			if (df >= 0) {
				aux = rotacionaEsquerda(aux);
			
			} else {
				aux.dir = rotacionaDireita(aux.dir);
				aux = rotacionaEsquerda(aux);
			}
		
		} else if (dado == -2) {
			df = aux.esq.getAltDir() - aux.esq.getAltEsq();
			
			
			if (df <= 0) {
				aux = rotacionaDireita(aux);
			
			} else {
				aux.esq = rotacionaEsquerda(aux.esq);
				aux = rotacionaDireita(aux);
			}
		}
		return aux;
	}

	public ArvoreAVL rotacionaEsquerda(ArvoreAVL aux) {
		ArvoreAVL aux1, aux2;
		aux1 = aux.dir;
		aux2 = aux1.esq;
		aux.dir = aux2;
		aux1.esq = aux;
		
		if (aux.dir == null) {
			aux.setAltDir(0);
		
		} else if (aux.dir.getAltEsq() > aux.dir.getAltDir()) {
			aux.setAltDir(aux.dir.getAltEsq() + 1);
		
		} else {
			aux.setAltDir(aux.dir.getAltDir() + 1);
		}

		
		if (aux1.esq.getAltEsq() > aux1.esq.getAltDir()) {
			aux1.setAltEsq(aux1.esq.getAltEsq() + 1);
		
		} else {
			aux1.setAltEsq(aux1.esq.getAltDir() + 1);
		}
		return aux1;
	}

	public ArvoreAVL rotacionaDireita(ArvoreAVL aux) {
		ArvoreAVL aux1, aux2;
		aux1 = aux.esq;
		aux2 = aux1.dir;
		aux.esq = aux2;
		aux1.dir = aux;
		
		if (aux.esq == null) {
			aux.setAltEsq(0);
		
		} else if (aux.esq.getAltEsq() > aux.esq.getAltDir()) {
			aux.setAltEsq(aux.esq.getAltEsq() + 1);
		
		} else {
			aux.setAltEsq(aux.esq.getAltDir() + 1);
		}

		
		if (aux1.dir.getAltEsq() > aux1.dir.getAltDir()) {
			aux1.setAltDir(aux1.dir.getAltEsq() + 1);
		
		} else {
			aux1.setAltDir(aux1.dir.getAltDir() + 1);
		}
		return aux1;
	}

	
	public void imprimeOrdemInfixa(ArvoreAVL aux) {
		if (aux != null) {
			View.msg(aux.getNum() + "\n");
			
			imprimeOrdemInfixa(aux.esq);
			imprimeOrdemInfixa(aux.dir);
		}
	}

	
	public void imprmeOrdenPreFixa(ArvoreAVL aux) {
		if (aux != null) {			
			
			imprmeOrdenPreFixa(aux.esq);			
			View.msg(aux.getNum() + "\n");			
			imprmeOrdenPreFixa(aux.dir);
		}
	}

	
	public void imprimeOrdenPosFixa(ArvoreAVL aux) {
		if (aux != null) {
			
			imprimeOrdenPosFixa(aux.esq);
			imprimeOrdenPosFixa(aux.dir);
			View.msg(aux.getNum() + "\n");
		}
	}
}