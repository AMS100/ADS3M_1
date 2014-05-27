package App;

import M.Utilitarios.Auxiliar;

/**
 * Classe de implemetação de menus do todo o sistema
 * @author Neimar, Aurélio
 */
public class Menus extends View {
	
		public static void menuSelecinaAtividade() {		
			msgb("	QUAL ATIVIDADE?\n\n"
			+ "=> T1 'Listas Encadeadas'       " + Auxiliar.statusAcao(7,7) + "\n"
			+ "=> T2 'Pesquisa Binária'        " + Auxiliar.statusAcao(7,7) + "\n"
			+ "=> T4 'Algoritmos de Ordenação' " + Auxiliar.statusAcao(7,7) + "\n"
			+ "=> T5 'Arvores'                 " + Auxiliar.statusAcao(2,0) + "\n"
			+ "=> SAIR\n");
		}
		
		/**
		 * Método responsável pela impressão dos comando de execução de taréfas
		 */
		public static void mostarMenuApp() {		
			String menu = "	O QUE VOCÊ DESEJA FAZER?\n\n";
				 
			if (Auxiliar.getOpcao().equals("LISTA") || Auxiliar.getOpcao().equals("ARVORE")) {
				menu += "=> EXECUTAR  'Executa ações nas estruturas existente'\n" +
						"=> ARQUIVO   'Propriedades de arquivo'\n";
			}
					
			if (Auxiliar.getOpcao().equals("ORDENADORES")) {
				menu += "=> ORDENAR  'Executa ordenação de registro em arquivo(s)'\n";
			}else{
				menu += "=> CONSULTAR 'Conteúdo do salvo em arquivo(s)'\n";
			}
							
			menu += "=> IMPRIMIR  'Imprime arquivo selecionado'\n" +					
					"=> SAIR\n";
			msgb(menu);		
		}

		
		/** 
		 * Métodos responsável pele exibição dos menus de include 
		 * @throws Exception
		 */
		public static void menuInclude(String include)throws Exception {	
			String menu =
					"	OPÇÕES DE INCLUDE\n\n"+
					"=> NOVO     'Habilita para gravar novo registro'\n"+	
					"=> REMOVER  'Remove arquivo existente'\n";					
			
			switch (include) {
			
			case "ARQUIVO":			
				menu += "=> BUSCAR   'Busca lista de arquivos existentes'\n"+
						"=> IMPRIMIR 'Imprime dados'\n";
				break;
				
			case "DADOS":	
				menu += "=> EDITAR   'Edita dados do arquivo'\n";
				break;				
			}
			
			menu += "=> SAIR\n";
			msgb(menu);		
		}
		
		
		/**
		 * Menu global para consultas
		 * @throws Exception
		 */
		public static void menuConsultas()throws Exception {	
			String menu ="";
			
			switch (Auxiliar.getOpcao()) {
			case "ARVORE":			
				menu += "	OPÇÕES PARA CONSULTA(S) EM " +Auxiliar.getOpcao() +"(S)" +"\n\n" 
					 +"=> NOME  'Encontra um nome dentro da árvore'\n";
				break;
				
			case "BINARIA":	
				menu += "	OPÇÕES PARA CONSULTA(S) " +Auxiliar.getOpcao() +"(S)" +"\n\n" 
					 +"=> ID 'Encontra um id através de uma busca binária'\n";
				break;
				
			case "LISTA":
				menu += "	OPÇÕES PARA CONSULTA(S) EM " +Auxiliar.getOpcao() +"\n\n"
						+"=> NOME	 'Encontra um nome dentro da lista'\n"
						+"=> NAVEGAR 'Navega pelo arquivo com comando de teclado'\n"
						+"=> ARQUIVO 'Imprime arquivo inteiro'\n";
				break;
			}
			
			menu += "=> SAIR\n";
			msgb(menu);		
		}

		
		/**
		 * Método responsável pela execução das formas de ordenação
		 * @throws Exception
		 */
		public static void menuOrdenadores()throws Exception {	
			msgb(
				"	COMO ORDENAR DADOS?\n\n"	
				+"=> BUBLE    'Ordena dados do arquivo com BubleSort'\n"
				+"=> QUICK    'Ordena dados do arquivo com QuickSort'\n"
				+"=> COMPARAR 'Imprime dados estatísticos dos dois ordenadores \n"
				+"=> SAIR\n"
			);		
		}

		
		/**
		 * Menu de definição de modo de ordenação
		 * @throws Exception
		 */
		public static void menuModoOrdenacao(boolean ativaMenu)throws Exception {	
			if (ativaMenu == true) {
				msgb(
					"	DESEJA ORDENAR PARA:\n\n"	
					+ "=> C 'Exibe arquivo na ordem crescente'\n"
					+ "=> D 'Exibe arquivo na ordem decrescente'\n"
				);
			}
		}
		
}