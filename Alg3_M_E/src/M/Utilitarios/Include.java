package M.Utilitarios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import App.View;

/**
 * Classe para edição e arquivos
 * @author moises
 */
public class Include {
	static String acun = "";
	private static Boolean append = false;
	
	
	public static void setAppend(Boolean append) {
		Include.append = append;
	}
	
	
	public static Boolean getAppend() {
		return append;
	}

	
	/**
	 * Insere novo registro em arquivo .txt
	 * @param arquivo
	 * @param desc
	 * @throws IOException 
	 */
	public static void addNovo(String arquivo,String  desc) throws IOException {
		FileWriter f;
		BufferedWriter buff = null;
		
		try {
			f = new FileWriter(new File(arquivo),getAppend());
			buff = new BufferedWriter(f);			
			
			if (getAppend() == true) {	
				buff.newLine();				
			}			
			buff.write(desc);			
			buff.close();	
		
		} catch (IOException e) {
			View.msg("Não foi possivél inserir registro.");
		} finally {
			buff.close();
		}
	}
	
	
	/**
	 * Realiza ficheiro remoção lógica do registro 
	 * @param arquivo
	 * @param desc
	 * @throws IOException 
	 */
	public static void remove(String nomeArquivo, String  desc) throws IOException {                 
		BufferedReader br;
		FileReader r = new FileReader(nomeArquivo);
		br = new BufferedReader(r);
		String linha = br.readLine();		
		
		try {				
			while(linha != null ) {	
				
				if (linha.equals(desc)) {	
					acun += "#"+linha +"\n";
					View.msge("\nRegistro excluido com sucesso!\n");
					setAppend(false);					
				} else {
					acun += linha +"\n";
					setAppend(true);
				}
				linha = br.readLine();
			}			
			br.close();
			addNovo(nomeArquivo, acun);
		
		} catch (NullPointerException e) {
			e.getMessage();
		} catch (FileNotFoundException e1) {
			View.msgb("Arquivo inexistente.");
		}	  
	}    
        	
	
	/** 
	 * Realiza ficheiro salva edição do registro
	* 
	*/			
	public static void salva() {
		View.objetoNaoImplementado();
	} 
		
	
	/** 
	 * Realiza alteração do registro
	* 
	*/
	public static void altera() {
		View.objetoNaoImplementado();
	} 
}
