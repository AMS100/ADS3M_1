package C.Arvores.RedBlack;

import App.View;
import M.Utilitarios.Auxiliar;

public class Nodorb<T extends Comparable<T>> {
	private Nodorb<T> par;
	private Nodorb<T> dir;
	private Nodorb<T> esq;
	private boolean corNodo;
	private T valor;


	public void setPar(Nodorb<T> parente) {
		this.par = parente;
	}

	public Nodorb<T> getDir() {
		return dir;
	}

	public void setDir(Nodorb<T> direita) {
		this.dir = direita;
	}

	public Nodorb<T> getEsq() {
		return esq;
	}

	public void setEsq(Nodorb<T> esquerda) {
		this.esq = esquerda;
	}

	public boolean isCorNodo() {
		return corNodo;
	}

	public void setCorNodo(boolean cor) {
		this.corNodo = cor;
	}

	public T getValor() {
		return valor;
	}

	public void setValor(T valor) {
		this.valor = valor;
	}

	public Nodorb<T> avo() {
		return par.par;
	}

	public Nodorb<T> irmao() {
		if (this == par.esq) {
			return par.dir;
		} else {
			return par.esq;
		}
	}

	public Nodorb<T> tio() {
		return par.irmao();
	}


	public Nodorb<T> getParente() {
		return par;
	}


	public Nodorb(Nodorb<T> dir, Nodorb<T> esq, T valor, boolean cor) {
		this.dir = dir;
		this.esq = esq;
		this.corNodo = cor;
		this.valor = valor;
		if (dir != null) {
			dir.par = this;
		}
		if (esq != null) {
			esq.par = this;
		}
		this.par = null;
	}


	/**
	 * Imprime ordem da árvore
	 */
	public void ordemInfixa() {
		String cor = "";

		if (isCorNodo() == true) {
			cor = "red  ";

		} else {
			cor = "black";
		}

		View.msg("Cor " + cor + " = " + valor + "\n");

		if (esq != null) {
			esq.ordemInfixa();

		} else {
			View.msg("");
		}

		if (dir != null) {
			dir.ordemInfixa();

		} else {
			View.msg("");
		}
	}


	/**
	 * Imprime ordem pós-fixa
	 */
	public void ordenPosFixa() {
		String cor = "";

		if (isCorNodo() == true) {
			cor = "red  ";

		} else {
			cor = "black";
		}


		if (esq != null) {
			esq.ordenPosFixa();

		} else {
			View.msg("");
		}

		View.msg("Cor " + cor +" = " + valor + "\n");

		if (dir != null) {
			dir.ordenPosFixa();

		} else {
			View.msg("");
		}
	}


	/**
	 * Imprime ordem pré-fixa
	 */
	public void ordenPreFixa() {
		String cor = "";

		if (isCorNodo() == true) {
			cor = "red  ";

		} else {
			cor = "black";
		}


		if (esq != null) {
			esq.ordenPreFixa();

		} else {
			View.msg("");
		}


		if (dir != null) {
			dir.ordenPreFixa();

		} else {
			View.msg("");
		}

		View.msg("Cor " + cor +" = " + valor + "\n");
	}

	/**
	 * Imprime ordem pré-fixa
	 */
	public void contaNodos() {

		if (esq != null) {
			Auxiliar.setContador(true);
			esq.contaNodos();
		} else {
			View.msg("");
		}


		if (dir != null) {
			Auxiliar.setContador(true);
			dir.contaNodos();
		} else {
			View.msg("");
		}
	}
}