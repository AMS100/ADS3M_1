package V;


public class Menus extends View {
	public static void menuJogar() {		
		msgb("	COMANDOS DE JOGO:\n\n"
		+ "=> JOGAR        'Abilita o jogador à jogar'\n"
		+ "=> PERSONALIZAR 'Personaliza nivel inicial de jogo'\n"
		+ "=> SAIR         'Sai do programa'\n");
	}

	
	public static void menuMain() {		
		msgb("	O QUE VOCÊ DESEJA FAZER?\n\n"
		+ "=> INICIAR  'Iniciar mapa de jogo'            " + View.statusAcao(7,7) + "\n"
		+ "=> IMPRIMIR 'Imprimi opções de jogo'          " + View.statusAcao(7,7) + "\n"
		+ "=> REGRAS   'Imprimi todas as regras do jogo' " + View.statusAcao(7,7) + "\n"
		+ "=> SAIR\n");
	}

	
	public static void menuBatalha() {		
		msgb("	COMANDOS DE JOGO:\n\n"
		+ "=> ATIRAR   'Abilita o jogador à inserir coordenadas'\n"
		+ "=> SAIR\n");
	}

	
	public static void menuImprimir() {		
		msgb("	COMANDOS DE IMPRESSÃO:\n\n"
		+ "=> MAPA    'Imprime mapa atual'\n"
		+ "=> NAVIOS  'Imprime navios existentes'\n"		
		+ "=> NIVEIS  'Imprime níveis de jogo'\n"
		+ "=> SOLDADO 'Imprime dados do jogador'\n"
		+ "=> FILTRAR 'Filtra dados'\n"
		+ "=> TODOS   'Imprime todos os dados do jogo'\n"
		+ "=> SAIR\n");
	}
	
	
	public static void menuFiltrar() {		
		msgb("	COMANDOS DE IMPRESSÃO:\n\n"
		+ "=> NAVIOS   'Opçao de filtro'\n"		
		+ "=> NIVEIS   'Opçao de filtro'\n"
		+ "=> RETORNAR 'Retorna ao menu imprimir'\n"
		+ "=> SAIR\n");
	}
}