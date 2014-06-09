package M.Utilitarios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import App.View;
import C.Registrador;
import M.Buffers;

/**
 * Classe para edição e arquivos
 * @author moises
 */
public class Include {

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
			f = new FileWriter(new File(arquivo), getAppend());
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
		Buffers.setFile(new FileReader(nomeArquivo));
		Buffers.setBuff(new BufferedReader(Buffers.getFile()));
		Buffers.setLinha(Buffers.getBuff().readLine());

		try {
			while(Buffers.getLinha()!= null ) {
				if (Buffers.getLinha().equals(desc)) {
					Registrador.setAcum("#" + Buffers.getLinha() + "\n");
					View.msge("\nRegistro excluído com sucesso!\n");
					setAppend(false);
				} else {
					Registrador.setAcum(Buffers.getLinha() + "\n");
					setAppend(true);
				}
				Buffers.setLinha(Buffers.getBuff().readLine());
			}
			Buffers.getBuff().close();
			 setAppend(false);
			 addNovo(nomeArquivo, Registrador.getAcum());

		} catch (NullPointerException e) {
			e.getMessage();
		} catch (FileNotFoundException e1) {
			View.msgb("Arquivo inexistente.");
		}
	}


	/**
	 * Realiza ficheiro e salva edição do registro
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