package C;

import M.SoldadoMod;
import V.View;

/**
 * Classe de impressão de dados do soldado
 * @author Neimar, Aurélio
 */
public class PrintSoldados extends SoldadoMod {
	
	/**
	 * Método de avaliação de nome 
	 */
	public void avaliaNome() {
		if (SoldadoMod.getNomeSoldado().equals(" ")) {
			View.msg("\nO soldado ainda não possui nome!\n");
		} else {
			View.msg("\nNome do jogador: " 
			+ SoldadoMod.getNomeSoldado() + "\n");
		}
	}
	
	/**
	 * Método de avaliação da pontuação do soldado 
	 */
	public void avaliaPontos() {
		if (SoldadoMod.getPontuacaoInicial() > 0) {
			View.msg("Pontuação inicial: " 
			+ Inimigo.getChances() + "\n"); // Imprime chances em tempo real do jogo
		} else {
			View.msgr("O soldado " + SoldadoMod.getNomeSoldado()
				+ " não possui pontos para iniciar o jogo!\n");
		}
	}
	
	/**
	 * Método que imprime dados do soldado
	 */
	public void imprime() {
		avaliaNome();
		avaliaPontos();
	}
}