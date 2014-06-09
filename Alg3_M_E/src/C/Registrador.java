package C;

import java.io.IOException;

import App.Menus;
import App.View;
import C.Arquivos.Ficheiro;
import C.Arvores.Avl.ArvoreAVL;
import C.Arvores.Avl.NodoAVL;
import C.Arvores.Binaria.ArvoreBinaria;
import C.Arvores.RedBlack.ArvoreRBlack;
import C.Lista.ListaOrdenada;
import C.Lista.Nodo;
import M.Buffers;
import M.Contatos;
import M.Dados;
import M.Utilitarios.Auxiliar;
import M.Utilitarios.Include;

/**
 * Classe responsável pela manipulação de dados em arquivo: edição, exclusão e inserção
 * @author Neimar, Aurélio
 * @param <T>
 */
public class Registrador {

	private static String acum =""; // Acumulador de dados para edição de arquivo
	private static ListaOrdenada<String> lista = new ListaOrdenada<String>();
	private static ArvoreBinaria<String> arvoreBinaria = new ArvoreBinaria<String>();
	private static ArvoreAVL avl = new ArvoreAVL();
	private static ArvoreRBlack<String> arvoreRedBlack = new ArvoreRBlack<String>();


	public static void setArvoreRedBlack(ArvoreRBlack<String> arvoreRedBlack) {
		Registrador.arvoreRedBlack = arvoreRedBlack;
	}

	/**
	 * Método de recuperação do estado do objeto
	 * @return
	 */
	public static ArvoreRBlack<String> getArvoreRedBlack() {
		return arvoreRedBlack;
	}


	/**
	 * Método de recuperação do estado do objeto
	 * @return
	 */
	public static ListaOrdenada<String> getLista() {
		return lista;
	}


	/**
	 * Método de recuperação do estado do objeto
	 * @return
	 */
	public static ArvoreBinaria<String> getArvoreBinaria() {
		return arvoreBinaria;
	}

	public static void setAvl(ArvoreAVL avl) {
		Registrador.avl = avl;
	}


	/**
	 * Método de recuperação do estado do objeto
	 * @return
	 */
	public static ArvoreAVL getAvl() {
		return avl;
	}


	public static void setAcum(String acum) {
		Registrador.acum += acum;
	}


	public static String getAcum() {
		return acum;
	}


	/**
	 * Informa quando a estrura de operação é inválida
	 * @param ativaTipo
	 * @throws Exception
	 */
	public static void informaEstrutura(boolean ativaTipo) throws Exception {
		View.msge("\nÁrvore inválida\n");
		Menus.menuArvores(true, ativaTipo, true);
	}

	NodoAVL nodoAvl  = new NodoAVL();


	/**
	 * Método responsável por receber os dados da leitura do arquivo, bem como inserir nas estruturas
	 * @param linha
	 * @throws Exception
	 */
	public static void copiaArquivo(String linha) throws Exception {

		switch (Auxiliar.getOpcao()) {

		case "LISTA":
			lista.insert(new Nodo<String>(linha), lista.getHead());
			break;

		case "ARVORE":

			if (Auxiliar.getDetalhes().equals("ab")) {
				arvoreBinaria.insere(new C.Arvores.Binaria.Nodo<String>(linha));// Insere o conteúdo da linha

			} else if (Auxiliar.getDetalhes().equals("avl")) {
				getAvl().insere(avl, Dados.getIndex()); // Insere na árvore o index da linha do arquivo

			} else if (Auxiliar.getDetalhes().equals("rb")) {
				getArvoreRedBlack().insere(linha); // Insere o conteúdo da linha

			} else {
				informaEstrutura(false);
				copiaArquivo(linha);
			}

			break;

		default:
			break; // Condição de saída quando atividade for inválida
		}
	}


	/**
	 * Método que lê dados do teclado
	 * @throws Exception
	 */
	private void gravaDados(String nomeArquivo) throws Exception {
		Contatos.setNome(Auxiliar.digita("Contato"));
		Contatos.setFone(Auxiliar.digita("Telefone"));
		Include.setAppend(true);
		Include.addNovo(nomeArquivo, Contatos.getNome() + "," + Contatos.getFone() + "\n"); // Insere dado na última linha do arquivo
	}


	/**
	 * Método responsável por salvar alterações
	 * @param nomeArquivo
	 * @throws IOException
	 */
	private void editaArquivo(String nomeArquivo) throws IOException {
		Include.setAppend(false);
		Include.addNovo(nomeArquivo, getAcum());
		setAcum(""); // Parâmetro de limpeza de "cache" do acumulador
	}


	/**
	 * Método responsável pela inserção de novo registro
	 * @param nomeArquivo
	 * @throws Exception
	 */
	public void insereRegistro(String nomeArquivo) throws Exception {

		switch (Auxiliar.getOpcao()) {

		case "LISTA":
			gravaDados(nomeArquivo);
			Ficheiro.leArquivo(nomeArquivo, false, null, false, false); // Carregador de arquivo para estrururas
			lista.guardaEdicao();
			editaArquivo(nomeArquivo);
			break;

		case "ARVORE":
			
			switch (Auxiliar.getDetalhes()) {
				
			case "ab":
				gravaDados(nomeArquivo);
				Ficheiro.leArquivo(nomeArquivo, false, null, false, false); // Carregador de arquivo para estrururas
				arvoreBinaria.guardaEdicao();
				editaArquivo(nomeArquivo);
				break;
				
			case "avl":
				gravaDados(nomeArquivo);
				Ficheiro.leArquivo(nomeArquivo, false, null, false, false); // Carregador de arquivo para estrururas
				break;
				
			case "rb":
				gravaDados(nomeArquivo);
				Ficheiro.leArquivo(nomeArquivo, false, null, false, false); // Carregador de arquivo para estrururas
				break;	
				
			default:
				informaEstrutura(false);
				insereRegistro(nomeArquivo);
				break;
			}
			break;
			
		default:
			View.msge("\nAtividade inválida!\n");
			break;
		}
	}


	/**
	 * Método de manipulação de dados de arquivos
	 * @throws Exception
	 */
	public void executaComando(String nomeArquivo) throws Exception {
		Menus.menuInclude("DADOS");

		switch (Auxiliar.digita("")) {

		case "novo":
			insereRegistro(nomeArquivo);
			executaComando(nomeArquivo); // Loop para novas ações do menu
			break;

		case "editar":
			View.objetoNaoImplementado();
			executaComando(nomeArquivo);
			break;

		case "remover":
			Buffers.setBuff(null); // Limpeza de "buffer"
			Buffers.setFile(null); // Limpeza de arquivo
			setAcum(""); // Limpeza de acumulador
			Include.setAppend(false); // Desabilita "append" para sobscrever dados no arquivo
			Include.remove(nomeArquivo, Auxiliar.digita("\nDigite um contato para excluir"));
		case "sair":
			View.sair();
			break;

		default:
			View.opcaoInvalida();
			executaComando(nomeArquivo); // "Loop" para novas ações do menu
			break;
		}
	}
}