package C;

import java.io.IOException;

import App.Menus;
import App.View;
import C.Arquivos.Ficheiro;
import M.Contatos;
import M.Arvore.ArvoreBinaria;
import M.Lista.ListaOrdenada;
import M.Lista.Nodo;
import M.Utilitarios.Auxiliar;
import M.Utilitarios.Include;

/**
 * Classe respons�vel pela manipula��o de dados em arquivo: edi��o, exclus�o e inser��o
 * @author Neimar, Aur�lio
 * @param <T>
 */
public class Registrador{
	
	static String acum =""; //Acumulador de dados para edi��o de arquivo 
	static ListaOrdenada<String> lista = new ListaOrdenada<String>();
	static ArvoreBinaria<String> arvoreBinaria = new ArvoreBinaria<String>();

	
	public static void setAcum(String acum) {
		Registrador.acum = acum;
	}
		
	public static String getAcum() {
		return acum;
	}
	
	
	/**
	 * Metodo responsavel por receber os dados da leitura do arquivo e insirir nas etruturas		
	 * @param linha
	 * @throws Exception
	 */
	public static void copiaArquivo(String linha) throws Exception {

		switch (Auxiliar.getOpcao()) {
	
		case "LISTA":
			lista.insert(new Nodo<String>(linha), lista.getHead());
			break;
		
		case "ARVORE":
			arvoreBinaria.insere(new M.Arvore.Nodo<String>(linha));
			break;
			
		default:
			break; // Condi��o de sa�da quando atividade for inv�lida
		}
	}
	
	
	/**
	 * M�todo que le dados do teclado
	 * @throws Exception
	 */
	private void gravaDados(String nomeArquivo) throws Exception {
		Contatos.setNome(Auxiliar.digita("Contato")); 
		Contatos.setFone(Auxiliar.digita("Telefone"));
		Include.setAppend(true);
		Include.addNovo(nomeArquivo, Contatos.getNome()+"," +Contatos.getFone() +"\n"); //Insere dado na �ltima linha do arquivo
	}
	
	
	/**
	 * M�todo respons�vel por salvar altera��es 
	 * @param nomeArquivo
	 * @throws IOException
	 */
	private void editaArquivo(String nomeArquivo) throws IOException {
		Include.setAppend(false);
		Include.addNovo(nomeArquivo, getAcum());
		setAcum(""); // Par�metro de limpeza de "cache do acumulador" 
	}
	
					
	/**
	 * M�todo respons�vel pela insers�o de novos registrador 
	 * @param nomeArquivo
	 * @throws Exception
	 */
	public void insereNovoRegistro(String nomeArquivo) throws Exception {
		
		switch (Auxiliar.getOpcao()) {
		
		case "LISTA":
			gravaDados(nomeArquivo);
			Ficheiro.leArquivo(nomeArquivo, false, null, false, false); // L� arquivo ap�s a insers�o e padroniza a edi��o
			lista.guardaEdicao();;
			editaArquivo(nomeArquivo);	
			break;

		case "ARVORE":
			gravaDados(nomeArquivo);
			Ficheiro.leArquivo(nomeArquivo,false, null, false, false);
			arvoreBinaria.guardaEdicao();
			editaArquivo(nomeArquivo);
			break;
			
		default:
			View.msge("\nAtividade invalida para!\n");
			break;
		}
	}


	/**
	 * M�todo de manipula��o de dados de arquivos
	 * @throws Exception
	 */
	public void executaComando(String nomeArquivo) throws Exception {
		Menus.menuInclude("DADOS");
		
		switch (Auxiliar.digita("")) {
		
		case "novo":
			insereNovoRegistro(nomeArquivo);
			executaComando(nomeArquivo); // Loop para novas a��es do menu
			break;
		
		case "editar":
			View.objetoNaoImplementado();
			executaComando(nomeArquivo);
			break;
			
		case  "remover" :			
			Include.setAppend(false); // Desabilita "append" para sobscrever dados no arquivo
			Include.remove(nomeArquivo,Auxiliar.digita("\nDigite um contato para excluir"));
		case "sair":
			View.sair();
			break;
		
		default:
			View.opcaoInvalida();
			executaComando(nomeArquivo); // Loop para novas a��es do menu
			break;
		}	
	}
}