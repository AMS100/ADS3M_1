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
import M.Dados;

/**
 * Classe responsavel pela manupulação do arquivo
 * @author Neimar,Aurelio
 */
public class Ficheiro extends Dados {
	
	Memoria memoria =  new Memoria();
	static String linha;
	static FileReader file;
	static BufferedReader buff;	

	/**
	 * Verificador de memória
	 * @param nomeAquivo
	 */
	public void criaNovo(final String nomeAquivo) {
		try {
			View.msg("\nVerificando disco...\n");
			if (memoria.verifica() >= 6000) { // Verifica memória ao inserir dados
				FileWriter fw = new FileWriter(new File(nomeAquivo),true);
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
	 * Método de remoção de arquivo com verificação da existência do arquivo
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
			file = new FileReader(nomeArquivo);		
			buff = new BufferedReader(file);
			linha = buff.readLine();
			if(imprimir== true){View.msgc(" Impressão do arquivo: " +nomeArquivo +"\n\n");}
			
			while(linha != null ) {
				linha = buff.readLine();
				index++;
				
				if (criaVetor == true){
					insertVetor(index, criaVetor); //Metodo transferência de dados para do arquivo para vetor
				}else{
					Registrador.copiaArquivo(linha); //Médoto de insersão nas estruturas de dados
				}				
				imprimeDaDos(linha,campo, filtrar, imprimir); //Método de impressão dados. Imprime quando abilitado 			
			}
			buff.close();	
			
		} catch (NullPointerException e) {
			View.msgr("\nArquivo carregado com sucesso!");
					
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
	 * Método de carregamento dos dados do arquivo para o vetor e strins
	 * @param index
	 * @param criaVetor
	 */
	protected static void insertVetor(int index, boolean criaVetor) {
		if (criaVetor == true && linha != null) {
			vetor[index]= linha;			
		}
		
		if (criaVetor == true && linha == null){
			for (int i = index; i < vetor.length; i++) { // Complementa o vetor após carregamento dos dados do arquivo
				vetor[i]= "";
			}
		}
		
	}	
	
	/**
	 * Método global de impressão dados 
	 * @param linha
	 * @param campo
	 * @param filtrar
	 */
	protected static void imprimeDaDos(String linha, String campo, boolean filtrar, boolean imprimir) {
		if (imprimir == true) {//Abilita impressão ou não.
			if (filtrar == true) { // Imprime dados coincidentes com o parâmetro	
				if (linha.equals(campo)) {				
					View.msg("\n> " +linha  + "\n");
				}				
			} else {
				View.msg("> " + linha + "\n");
			}
		}
	}
		
}