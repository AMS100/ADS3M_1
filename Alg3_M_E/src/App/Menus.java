package App;

import M.Utilitarios.Auxiliar;

/**
 * Classe de implementação de menus de todo o sistema
 * @author Neimar, Aurélio
 */
public class Menus extends View {
	private static String sair = "=> SAIR\n";
	private static String menu = "";
	private static String opcMenu;
	private static String filtro;

	public static void setMenu(String menu) {
		Menus.menu = menu;
	}

	public static void setFiltro(String filtro) {
		Menus.filtro = filtro;
	}

	public static void setOpcMenu(String opcMenu) {
		Menus.opcMenu = opcMenu;
	}

	public static void menuSelecinaAtividade() {
		msgb("|QUAL ATIVIDADE?\n"
		 + "|\n"
		 + "|Obs.: Todas as atividade são independenstes, funcionam em separado.\n"
		 + "|Comandos, estes sim, compartilham métodos genéricos reaproveitáveis.\n"
		 + "|\n"
		 + "|----------------------------------------------------------------------\n"
		 + "|Comando      |Descrição               |Status atividade\n"
		 + "|-------------|------------------------|-------------------------------\n"
		 + "|=> T1        |Lista Encadeada         |" + Auxiliar.statusAcao(7,7,0) + "\n"
		 + "|=> T2        |Pesquisa Binária        |" + Auxiliar.statusAcao(7,7,0) + "\n"
		 + "|=> T4        |Algoritmos de Ordenação |" + Auxiliar.statusAcao(7,7,0) + "\n"
		 + "|=> T5        |Árvore Binária          |" + Auxiliar.statusAcao(8,7,80) + "\n"
		 + "|=> T6        |Árvores AVL e RED BLACK |" + Auxiliar.statusAcao(8,7,60) + "\n"
		 + "|=> G         |Imprime glossário       |" + Auxiliar.statusAcao(7,7,0) + "\n"
		 + "|" + sair);
	}

	/**
	 * Método responsável pela impressão dos comandos de execução das tarefas
	 */
	public static void mostarMenuApp() {
		menu = "|O QUE VOCÊ DESEJA FAZER?\n"
		     + "|--------------------------------------------------------------------\n"
			 + "|Comando      |Descrição\n"
			 + "|-------------|------------------------------------------------------\n";

		if (opcMenu.equals("LISTA") || Auxiliar.getOpcao().equals("ARVORE")) {
			menu += "|=> EXECUTAR  |Executa ações nas estruturas existentes\n" +
					"|=> ARQUIVO   |Propriedades de arquivo\n";
		}

		if (opcMenu.equals("ORDENADORES")) {
			menu += "|=> ORDENAR   |Executa ordenação de registro em arquivo(s)\n";
		} else {
			menu += "|=> CONSULTAR |Executa consulta em conteúdo salvo em arquivo(s)\n";
		}

		menu += "|=> IMPRIMIR  |Imprime arquivo selecionado\n"
			 +  "|" + sair;
		msgb(menu);

		menu = ""; // Limpa variável para exibição de próximo menu
	}


	/**
	 * Método responsável pele exibição dos menus de include
	 * @throws Exception
	 */
	public static void menuInclude(String include)throws Exception {
		menu =
			  "|OPÇÕES DE INCLUDE\n"
			+ "|--------------------------------------------------------------------\n"
			+ "|Comando     |Descrição\n"
			+ "|------------|-------------------------------------------------------\n"
			+ "|=> NOVO     |Habilita para gravar novo registro\n"
			+ "|=> REMOVER  |Remove arquivo existente\n";

		switch (include) {

		case "ARQUIVO":
			menu += "|=> BUSCAR   |Busca lista de arquivos existentes\n" +
					"|=> IMPRIMIR |Imprime dados\n";
			break;

		case "DADOS":
			menu += "|=> EDITAR   |Edita dados do arquivo\n";
			break;
		}

		menu += "|" + sair;
		msgb(menu);

		menu = "";  // Limpa variável para exibição do próximo menu
	}


	/**
	 * Método responsável pelo filtro do menu de consultas
	 * @throws Exception
	 */
	public static void menuAgrupaCosultas() throws Exception {
		if (Auxiliar.getAbilita() == false) {
			msgb(
			    "|SELEÇÃOO DE COMANDOS DE CONSULTAS?\n"
			  + "|--------------------------------------------------------------------\n"
			  + "|Comando        |Descrição\n"
			  + "|---------------|----------------------------------------------------\n"
			  + "|=> EDICAO      |Lista ítens de ediçãoo de estrutura\n"
			  + "|=> TRAVESSIAS  |Seleciona trevessias em árvores\n"
			  + "|=> ESTATISTICAS|Seleciona comendos de estatisticas\n"
			  + "|=> TODOS       |Imprmi a lista completa de comandos\n"
			 );
			filtro = Auxiliar.digita("Opções de comandos");
		}
	}


	/**
	 * Menu global para consultas
	 * @throws Exception
	 */
	public static void menuConsultas() throws Exception {
		String edicao = "";

		menuAgrupaCosultas();

		menu = "|OPÇÕES PARA CONSULTA(S) EM " + Auxiliar.getOpcao() + "(S)" + "\n"
			 + "|--------------------------------------------------------------------\n"
			 + "|Comando         |Descrição\n";

		if (filtro.equals("todos") || filtro.equals("edicao")) {
			Auxiliar.setAbilita(true);
			edicao += "|--------------------------------------------- < Edição >\n"
				   +  "|=> NOVO         |Insere um novo elemento\n"
				   +  "|=> REMOVER      |Remove um elemento\n"
				   +  "|=> IMPRIMIR     |Imprime estruturas elemento\n";
		}

		switch (opcMenu) {

		case "ARVORE":
			if (filtro.equals("todos") || filtro.equals("travessias")) {
				Auxiliar.setAbilita(true);
				menu += "|--------------------------------------------- < Travessias >\n"
					 +  "|=> POSFIXA      |Imprime ordem pós-fixa\n"
					 +  "|=> PREFIXA      |Imprime ordem pré-fixa\n"
					 +  "|=> INFIXA       |Imprime ordem infixa\n";
			}

			if (filtro.equals("todos") || filtro.equals("estatisticas")) {
				Auxiliar.setAbilita(true);
				menu += "|--------------------------------------------- < Estatísticas >\n"
					 +  "|=> CONTAR       |Conta nodos da lista\n";
			}

			if (filtro.equals("todos") || filtro.equals("buscas")) {
				Auxiliar.setAbilita(true);
				menu += "|--------------------------------------------- < Buscas >\n"
					 +  "|=> ALTURA       |Busca elementos em nível\n"
					 +  "|=> PROFUNDIDADE |Calcula profundidade da árvore\n"
					 +  "|=> NOME         |Encontra um nome ou elemento\n";
			}
				menu += edicao;
			break;

		case "BINARIA":
			menu +=
				    "|----------------|---------------------------------------------------\n"
				 +  "|=> ID           |Encontra um id através de uma busca binária\n";
			break;

		case "LISTA":
			menu += "|=> NAVEGAR      |Navega pelo arquivo com comando de teclado\n"
				 +  "|=> ARQUIVO      |Imprime arquivo inteiro\n"
				 +  "|=> NOME         |Encontra um nome ou elemento\n"
				 +  edicao;
			break;
		}


		if (Auxiliar.getAbilita() == true) {
			menu += "|" + sair;
			msgb(menu);
			menu = ""; // Limpa variável para exibição do próximo menu
		} else {
			menuConsultas();
			filtro = ""; // Limpa variável para exibição do próximo filtro
			menu = ""; // Limpa variável para exibição do próximo menu
		}
	}


	/**
	 * Método responsável pela execução das formas de ordenação
	 * @throws Exception
	 */
	public static void menuOrdenadores()throws Exception {
		msgb(
		    "|COMO ORDENAR DADOS?\n"
		  + "|--------------------------------------------------------------------\n"
		  + "|Comando      |Descrição\n"
		  + "|-------------|------------------------------------------------------\n"
		  + "|=> BUBLE     |Ordena dados do arquivo com BubleSort\n"
		  + "|=> QUICK     |Ordena dados do arquivo com QuickSort\n"
		  + "|=> COMPARAR  |Imprime dados estatísticos dos dois ordenadores\n"
		  + "|" + sair
		);
	}


	/**
	 * Menu de definição de modo de ordenação
	 * @throws Exception
	 */
	public static void menuModoOrdenacao(boolean ativaMenu) throws Exception {
		if (ativaMenu == true) {
			msgb(
				 "|COMO DESEJA ORDENAR?\n"
			   + "|--------------------------------------------------------------------\n"
			   + "|Comando   | Descrição\n"
			   + "|----------|---------------------------------------------------------\n"
			   + "|=> C      |Exibe arquivo em ordem crescente\n"
			   + "|=> D      |Exibe arquivo em ordem decrescente\n"
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
	public static void menuArvores(boolean tipoArvore, boolean ativaTodosTipo, boolean print)throws Exception {

		if (ativaTodosTipo == true) {
			menu = "|=> Binaria   |Árvore binária\n";
		} else {
			menu = "";
		}

		if (print == true) {
			msgb(
				"|QUAL TIPO DE ÁRVORE À SELECIONAR?\n"
			  + "|--------------------------------------------------------------------\n"
			  + "|Comando      |Descrição\n"
			  + "|-------------|------------------------------------------------------\n"
			  + menu
			  + "|=> avl       |Árvore avl\n"
		      + "|=> rb        |Árvore red black\n"
			);
		}

		if (tipoArvore == true) {
			Auxiliar.setDetalhes(Auxiliar.digita("Árvore do tipo"));
		}

		menu = ""; // Limpa variável para exibição do próximo menu
	}



	/**
	 * Exibe glossário do programa
	 * @throws Exception
	 */
	public static void glossario()throws Exception {
		msgb(
		    "|GLOSSÁRIO DO PROGRAMA:\n"
		  + "|--------------------------------------------------------------------\n"
		  + "|Vocábulo  |Significado\n"
		  + "|----------|---------------------------------------------------------\n"
		  + "|C         |Controller\n"
		  + "|M         |Model\n"
	      + "|V         |View\n"
		  + "|App       |Aplicação\n"
		  + "|Ficheiro  |Classe de manipulação de arquivo\n"
		  + "|l.txt     |Lista telefônica\n"
		  + "|avl       |Árvore avl\n"
		  + "|rb        |Árvore red black\n"
		  + "|ab        |ï¿½rvore binï¿½ria\n"
		  + "|#         |Marcador de exclusão de registro"
		);
	}
}