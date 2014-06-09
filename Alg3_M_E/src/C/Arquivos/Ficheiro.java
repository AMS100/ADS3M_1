package  C.Arquivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import App.View;
import C.Registrador;
import M.Buffers;
import M.Dados;

/**
 * Classe responsável pela manipulação do arquivo
 * @author Neimar, Aurélio
 */
public class Ficheiro extends Dados {

	Memoria memoria =  new Memoria();

	
	/**
	 * Verificador de memória
	 * @param nomeAquivo
	 */
	public void criaNovo(final String nomeAquivo) {
		try {
			View.msg("\nVerificando disco...\n");
			if (memoria.verifica() >= 6000) { // Verifica memória ao inserir dados
				FileWriter fw = new FileWriter(new File(nomeAquivo), true);
				View.msgb("Novo arquivo criado: " + fw);
				fw.close();
			} else {
				View.espacoInsuficiente();
				memoria.imprime();
			}
		} catch (Exception e) {
			View.msgb("Não foi possível criar um novo arquivo.");
		}		
	}
	

	/** 
	 * Método de remoção de arquivo com verificação da existência do mesmo
	 * @param nomeArquivo
	 */
	public void remove(String nomeArquivo) { 
		File file = new File(nomeArquivo); 
		if (file.exists()) { 
			file.delete();
			View.msgr("O aquivo " + nomeArquivo + " foi removido com sucesso.");			
		} else {			
			View.msgb("Arquivo não encontrado!\nNão é possível remover.");
		}
	} 


	/**
	 * @param nomeAquivo
	 */
	public static void validadaArquivo(final String nomeAquivo) {
		Path p = Paths.get(nomeAquivo);				
		View.msg("Arquivo encontrado: " + p.toFile());
	}
	
	
	//=====================<< Leitor global de arquivos >>========================

	public static void leArquivo(String nomeArquivo, boolean criaVetor, String campo, boolean filtrar, boolean imprimir) throws Exception {
		
		try {
			setValidaArquivo(true); // Habilita execução de ordenador
			Buffers.setFile(new FileReader(nomeArquivo));		
			Buffers.setBuff(new BufferedReader(Buffers.getFile()));
			Buffers.setLinha(Buffers.getBuff().readLine());
			if(imprimir == true) { View.msgc(" Impressão do arquivo: " + nomeArquivo + "\n\n");}
			
			while(Buffers.getLinha() != null ) {
				Buffers.setLinha(Buffers.getBuff().readLine());
				index++;
				
				if (criaVetor == true) {
					insertVetor(index, criaVetor); // Método de transferência de dados de arquivo para vetor
				} else {
					Registrador.copiaArquivo(Buffers.getLinha()); // Método de inserção nas estruturas de dados
				}				
				imprimeDaDos(Buffers.getLinha(), campo, filtrar, imprimir); // Método de impressão de dados. Imprime quando habilitado 			
			}
			Buffers.getBuff().close();	
			
		} catch (NullPointerException e) {
			View.msgr("\nArquivo carregado com sucesso.");

		} catch (FileNotFoundException e) {
			View.msge("\nArquivo inexistente\n");
			setValidaArquivo(false); // Desabilita a execução de ordenador
				
		} catch (IOException e) {
			View.msge("\nO arquivo não pode ser fechado.\n");
		
		} catch (ArrayIndexOutOfBoundsException e) {
			View.msge("\nEspaço insufiente no array de armazenamento.\n");
		}		
	}
		
	
	/**
	 * Método de carregamento dos dados do arquivo para o vetor
	 * @param index
	 * @param criaVetor
	 */
	protected static void insertVetor(int index, boolean criaVetor) {
		if (criaVetor == true && Buffers.getLinha() != null) {
			vetor[index]= Buffers.getLinha();
		}

		if (criaVetor == true && Buffers.getLinha() == null) {
			for (int i = index; i < vetor.length; i++) { // Complementa o vetor após carregamento dos dados do arquivo
				vetor[i]= "";
			}
		}
		
	}
	
	/**
	 * Método global de impressão de dados 
	 * @param linha
	 * @param campo
	 * @param filtrar
	 */
	protected static void imprimeDaDos(String linha, String campo, boolean filtrar, boolean imprimir) {
		if (imprimir == true) { // Habilita impressão ou não.
			if (filtrar == true) { // Imprime dados coincidentes com o parâmetro	
				if (linha.equals(campo)) {		
					View.msg("\n> " + linha  + "\n");
				}
			} else {
				View.msg("> " + linha + "\n");
			}
		}
	}
		
}