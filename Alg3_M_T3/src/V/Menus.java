package V;

public class Menus extends View {
	public static void menuJogar() {		
		msgb("|COMANDOS DE JOGO:\n"
		+ "|-------------------------------------------------------------------------\n"
		+ "| Comando        | Descrição\n"
		+ "|----------------|--------------------------------------------------------\n"
		+ "|=> JOGAR        |Habilita o jogador à jogar\n"
		+ "|=> PERSONALIZAR |Personaliza nível inicial de jogo'\n"
		+ "|=> SAIR         |Sai do programa\n");
	}

	
	public static void menuMain() {		
		msgb("|O QUE VOCÊ DESEJA FAZER?\n"
		+ "|-------------------------------------------------------------------------\n"
		+ "| Comando    |Descrição                 |Status atividade\n"
		+ "|------------|--------------------------|---------------------------------\n"
		+ "|=> INICIAR  |Inicia mapa de jogo       |" + View.statusAcao(7,7) + "\n"
		+ "|=> IMPRIMIR |Imprime opções de jogo    |" + View.statusAcao(7,7) + "\n"
		+ "|=> REGRAS   |Imprime as regras do jogo |" + View.statusAcao(7,7) + "\n"
		+ "|=> SAIR     |Sai do programa\n");
	}

	
	public static void menuBatalha() {		
		msgb("|COMANDOS DE JOGO:\n"
		+ "|-------------------------------------------------------------------------\n"
		+ "| Comando    |Descrição\n"
		+ "|------------|------------------------------------------------------------\n"
		+ "|=> ATIRAR   |Habilita o jogador à inserir coordenadas\n"
		+ "|=> SAIR     |Sai do programa\n");
	}

	
	public static void menuImprimir() {		
		msgb("|COMANDOS DE IMPRESSÃO:\n"
		+ "|-------------------------------------------------------------------------\n"
		+ "| Comando    |Descrição\n"
		+ "|------------|------------------------------------------------------------\n"
		+ "|=> MAPA     |Imprime mapa atual\n"
		+ "|=> NAVIOS   |Imprime navios existentes\n"		
		+ "|=> NIVEIS   |Imprime níveis de jogo\n"
		+ "|=> SOLDADO  |Imprime dados do jogador\n"
		+ "|=> FILTRAR  |Filtra dados\n"
		+ "|=> TODOS    |Imprime todos os dados do jogo\n"
		+ "|=> SAIR     |Sai do programa\n");
	}
	
	
	public static void menuFiltrar() {		
		msgb("|COMANDOS DE IMPRESSÃO:\n"
		+ "|-------------------------------------------------------------------------\n"
		+ "| Comando    |Descrição\n"
		+ "|------------|------------------------------------------------------------\n"
		+ "|=> NAVIOS   |Opçao de filtro\n"		
		+ "|=> NIVEIS   |Opçao de filtro\n"
		+ "|=> RETORNAR |Retorna ao menu imprimir\n"
		+ "|=> SAIR     |Sai do programa\n");
	}
}