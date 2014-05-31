package App;

import M.Utilitarios.Auxiliar;

/**
 * Classe de implemetação de menus de todo o sistema
 * @author Neimar, Aurélio
 */
public class Menus extends View {
	private static String sair = "=> SAIR\n";
	private static String menu ="";	
	private static String opcMenu;
	
	public static void setOpcMenu(String opcMenu) {
		Menus.opcMenu = opcMenu;
	}
	
	public static void menuSelecinaAtividade() {	
		msgb("|	QUAL ATIVIDADE?\n"
		 +"|---------------------------------------------------------------------\n"
		 +"|  Comando   |Descrição               |Status atividade\n"
		 +"|------------|------------------------|-------------------------------\n"
		+ "|=> T1       |Lista Encadeada         |" + Auxiliar.statusAcao(7,7) +"\n"
		+ "|=> T2       |Pesquisa Binária        |" + Auxiliar.statusAcao(7,7) +"\n"
		+ "|=> T4       |Algoritmos de Ordenação |" + Auxiliar.statusAcao(7,7) +"\n"
		+ "|=> T5       |Árvore binária          |" + Auxiliar.statusAcao(2,0) +"\n"
		+ "|=> T6       |Árvores AVL E RED BLACK |" + Auxiliar.statusAcao(2,0) +"\n"
		+ "|=> Glossario|Imprime glossário       |" + Auxiliar.statusAcao(2,7) +"\n"
		+ "|" +sair);		
	}
	
	/**
	 * Método responsável pela impressão dos comandos de execução das tarefas
	 */
	public static void mostarMenuApp() {		
		menu = "|	O QUE VOCÊ DESEJA FAZER?\n"
				+"|--------------------------------------------------------------------\n"
				+"|  Comando    |Descrição\n"
				+"|-------------|------------------------------------------------------\n";
		 
		if (opcMenu.equals("LISTA") || Auxiliar.getOpcao().equals("ARVORE")) {
			menu += "|=> EXECUTAR  |'Executa ações nas estruturas existentes'\n" +
					"|=> ARQUIVO   |'Propriedades de arquivo'\n";
		}
					
		if (opcMenu.equals("ORDENADORES")) {
			menu += "|=> ORDENAR   |'Executa ordenação de registro em arquivo(s)'\n";
		}else{
			menu += "|=> CONSULTAR |'Mostra conteúdo salvo em arquivo(s)'\n";
		}
							
		menu += "|=> IMPRIMIR  |'Imprime arquivo selecionado'\n"					
				+"|" +sair;
		msgb(menu);
		
		menu = ""; // Limpa variável para exibição do próximo menu
	}

		
	/** 
	 * Método responsável pela exibição dos menus de include 
	 * @throws Exception
	 */
	public static void menuInclude(String include)throws Exception {	
		menu =
			"|	OPÇÕES DE INCLUDE\n"
			+"|--------------------------------------------------------------------\n"
			+"|  Comando   |Descrição\n"
			+"|------------|-------------------------------------------------------\n"
			+"|=> NOVO     |'Habilita para gravar novo registro'\n"	
			+"|=> REMOVER  |'Remove arquivo existente'\n";					
		
		switch (include) {
			
		case "ARQUIVO":			
			menu += "|=> BUSCAR   |'Busca lista de arquivos existentes'\n"+
					"|=> IMPRIMIR |'Imprime dados'\n";
			break;
				
		case "DADOS":	
			menu += "|=> EDITAR   |'Edita dados do arquivo'\n";
			break;				
		}
			
		menu +="|" +sair;
		msgb(menu);
		
		menu = ""; // Limpa variável para exibição do próximo menu
	}
		
		
	/**
	 * Menu global para consultas
	 * @throws Exception
	 */
	public static void menuConsultas()throws Exception {	
		String edicao;
		
		menu ="|	OPÇÕES PARA CONSULTA(S) EM " + Auxiliar.getOpcao() + "(S)" + "\n"
			+ "|--------------------------------------------------------------------\n"
			+ "|  Comando       |Descrição\n";
		
		edicao = "|--------------------------------------------- < Edição > \n"
			+ "|=> NOVO         |'Insere um novo elemento'\n"
			+ "|=> REMOVER      |'Remove um elemento'\n";
					
		switch (opcMenu) {
		
		case "ARVORE":			
			menu +="|--------------------------------------------- < Travessias >\n"
				+ "|=> POSFIXA      |'Imprime ordem pós-fixa'\n"
				+ "|=> PREFIXA      |'Imprime ordem pré-fixa'\n"
				+ "|=> INFIXA       |'Imprime ordem infixa'\n"
				+ "|--------------------------------------------- < Estatísticas >\n"
				+ "|=> CONTAR       |'Conta nodos da lista'\n"
				+ "|--------------------------------------------- < Buscas > \n"
				+ "|=> ALTURA       |'? '\n"
				+ "|=> PROFUNDIDADE |'Calcula profundidade da árvore'\n"
				+ "|=> NOME         |'Encontra um nome ou elemento'\n"
				+ edicao;
			break;
				
		case "BINARIA":
			menu +=
				 "|----------------|---------------------------------------------------\n"
				+"|=> ID           |'Encontra um id através de uma busca binária'\n";
			break;
				
		case "LISTA":
			menu += "|=> NAVEGAR      |'Navega pelo arquivo com comando de teclado'\n"
				 +  "|=> ARQUIVO      |'Imprime arquivo inteiro'\n"
				 +  "|=> NOME         |'Encontra um nome ou elemento'\n"
				 +  edicao;
			break;							
		}
			
		menu +="|" +sair;
		msgb(menu);	
		
		menu = ""; // Limpa variável para exibição do próximo menu
	}

		
	/**
	 * Método responsável pela execução das formas de ordenação
	 * @throws Exception
	 */
	public static void menuOrdenadores()throws Exception {	
		msgb(
			"|	COMO ORDENAR DADOS?\n"
			+ "|--------------------------------------------------------------------\n"
			+ "|  Comando    |Descrição\n"
			+ "|-------------|------------------------------------------------------\n"
			+ "|=> BUBLE     |'Ordena dados do arquivo com BubleSort'\n"
			+ "|=> QUICK     |'Ordena dados do arquivo com QuickSort'\n"
			+ "|=> COMPARAR  |'Imprime dados estatísticos dos dois ordenadores \n"
			+ "|" + sair
		);		
	}

		
	/**
	 * Menu de definição de modo de ordenação
	 * @throws Exception
	 */
	public static void menuModoOrdenacao(boolean ativaMenu)throws Exception {	
		if (ativaMenu == true) {
			msgb(
				"|	DESEJA ORDENAR PARA:\n"
				 + "|--------------------------------------------------------------------\n"
				 + "|  Comando |Descrição\n"
				 + "|----------|---------------------------------------------------------\n"
				 + "|=> C      |'Exibe arquivo na ordem crescente'\n"
				 + "|=> D      |'Exibe arquivo na ordem decrescente'\n"
			);
		}
	}
	
	
	/**
	 * Método impressão de menus para selecionar as árvores
	 * @param tipoArvore
	 * @param ativaTodosTipo
	 * @param print
	 * @throws Exception
	 */
	public static void menuArvores(boolean tipoArvore, boolean ativaTodosTipo, boolean print) throws Exception {	
		
		if (ativaTodosTipo == true) {
			menu = "|=> Binaria   |Árvore binária\n";
		} else {
			menu = "";
		}
		
		if (print == true) {
			msgb(
				"|	SELECIONE QUAL TIPO DE ÁRVORE:\n"
				 + "|--------------------------------------------------------------------\n"
				 + "|  Comando    |Descrição\n"
				 + "|-----------  |------------------------------------------------------\n"
				 + menu 
				 + "|=> Avl       |Árvore avl\n"
				 + "|=> RedBlack  |Árvore rubro negra\n"
			);
		}
		
		if (tipoArvore == true) {
			Auxiliar.setDetalhes(Auxiliar.digita("Árvore do tipo"));
		}
		
		menu = ""; // Limpa variável para exibição do próximo menu
	}
	
	
	
	/**
	 * Exibe o glossário de programa
	 * @throws Exception
	 */
	public static void glossario()throws Exception {	
		msgb(
			"|	GLOSSÁRIO DO PROGRAMA:\n"
			 +"|--------------------------------------------------------------------\n"
			 +"| Vocábulo |Significado\n"
			 +"|----------|---------------------------------------------------------\n"
			+ "|C         |Controller\n"
			+ "|M         |Model\n"
			+ "|V         |View\n"
			+ "|App       |Aplicação\n"
			+ "|Ficheiro  |Classe de manipulação de arquivo\n"
		);
	}
}