package C.Arvores.Avl;

import App.View;

public class ArvoreAVL extends NodoAVL {

	public void inisert(NodoAVL aux, int valor) {
		insere(aux, valor);
	}


	public void imprimeOrdemInfixa(NodoAVL valor) {
		View.imprimeArvores(true, "IMPRESSÃO DE ORDEM INFIXA - ");
		ordemInfixa(valor);
	}


	public void imprimeOrdemPreFixa(NodoAVL valor){
		View.imprimeArvores(true, "IMPRESSÃO DE ORDEM PRÉ-FIXA - ");
		ordemPosFixa(valor);
	}


	public void imprimeOrdemPosFixa(NodoAVL valor) {
		View.imprimeArvores(true, "IMPRESSÃO DE ORDEM PÓS-FIXA - ");
		ordemPosFixa(valor);
	}


	public void imprimeAvore() {
		View.imprimeArvores(true, "IMPRESSÃO DA - ");
		imprimeArvore();
	}
	
}