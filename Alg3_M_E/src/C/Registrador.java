package C;

import java.io.IOException;

import App.Menus;
import App.View;
import C.Arquivos.Ficheiro;
import C.Arvores.Avl.ArvoreAVL;
import C.Arvores.Binaria.ArvoreBinaria;
import C.Lista.ListaOrdenada;
import C.Lista.Nodo;
import M.Contatos;
import M.Dados;
import M.Utilitarios.Auxiliar;
import M.Utilitarios.Include;

/**
 * Classe responsável pela manipulação de dados em arquivo: edição, exclusão e inserção
 * @author Neimar, Aurélio
 * @param <T>
 */
public class Registrador{
	
	static String acum =""; //Acumulador de dados para edição de arquivo 
	static ListaOrdenada<String> lista = new ListaOrdenada<String>();
	static ArvoreBinaria<String> arvoreBinaria = new ArvoreBinaria<String>();
	static ArvoreAVL avl = new ArvoreAVL();
	/**
	 * Método de reperação de estado do objeto
	 * @return
	 */
	public static ArvoreBinaria<String> getArvoreBinaria() {
		return arvoreBinaria;
	}
	
	
	/**
	 * Método de reperação de estado do objeto
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
	 * Informa quando a estrura de operação não é valida
	 * @param ativaTipo
	 * @throws Exception
	 */
	public static void informaEstrutura(boolean ativaTipo) throws Exception {
		View.msge("\nArvore inválida\n");
		Menus.menuArvores(true, ativaTipo, true);
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
			
			if(Auxiliar.getDetalhes().equals("binaria") ) {				
				arvoreBinaria.insere(new C.Arvores.Binaria.Nodo<String>(linha));
			
			} else if (Auxiliar.getDetalhes().equals("avl") ) {
				avl = null;
				avl.inserir(avl,Dados.getIndex());

			} else if(Auxiliar.getDetalhes().equals("redBlack") ) {
				View.objetoNaoImplementado();
				
			} else{
				informaEstrutura(false);
				copiaArquivo(linha);
			}
			
			break;
			
		default:
			break; // Condição de saída quando atividade for inválida
		}
	}
	
	
	/**
	 * Método que le dados do teclado
	 * @throws Exception
	 */
	private void gravaDados(String nomeArquivo) throws Exception {
		Contatos.setNome(Auxiliar.digita("Contato")); 
		Contatos.setFone(Auxiliar.digita("Telefone"));
		Include.setAppend(true);
		Include.addNovo(nomeArquivo, Contatos.getNome()+"," +Contatos.getFone() +"\n"); //Insere dado na última linha do arquivo
	}
	
	
	/**
	 * Método responsável por salvar alterações 
	 * @param nomeArquivo
	 * @throws IOException
	 */
	private void editaArquivo(String nomeArquivo) throws IOException {
		Include.setAppend(false);
		Include.addNovo(nomeArquivo, getAcum());
		setAcum(""); // Parâmetro de limpeza de "cache do acumulador" 
	}
	
					
	/**
	 * Método responsável pela insersão de novos registrador 
	 * @param nomeArquivo
	 * @throws Exception
	 */
	public void insereNovoRegistro(String nomeArquivo) throws Exception {
						
		switch (Auxiliar.getOpcao()) {
		
		case "LISTA":
			gravaDados(nomeArquivo);
			Ficheiro.leArquivo(nomeArquivo, false, null, false, false); // Lê arquivo após a insersão e padroniza a edição
			lista.guardaEdicao();
			editaArquivo(nomeArquivo);
				
			break;

		case "ARVORE":			
			if(Auxiliar.getDetalhes().equals("binaria") ) {
				//gravaDados(nomeArquivo);
				Ficheiro.leArquivo(nomeArquivo,false, null, false, false);
				//arvoreBinaria.guardaEdicao();
				//editaArquivo(nomeArquivo);	
			
			} else if (Auxiliar.getDetalhes().equals("avl") ) {

	
			
			} else if(Auxiliar.getDetalhes().equals("redBlack") ) {
				
			
			} else{			
				informaEstrutura(false);
				insereNovoRegistro(nomeArquivo);
			}			
			break;
			
		default:
			View.msge("\nAtividade invalida para!\n");
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
			insereNovoRegistro(nomeArquivo);
			executaComando(nomeArquivo); // Loop para novas ações do menu
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
			executaComando(nomeArquivo); // Loop para novas ações do menu
			break;
		}	
	}
}