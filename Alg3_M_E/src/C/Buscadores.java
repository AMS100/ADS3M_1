package C;

import App.Menus;
import App.View;
import C.Arquivos.Ficheiro;
import C.Consultas.ArvoresLista;
import C.Consultas.Binarias;
import M.Utilitarios.Auxiliar;

public class Buscadores {

		static Binarias buscadorBinario = new Binarias();
		static ArvoresLista onsultorArvores = new ArvoresLista();


		public static Binarias getBuscadorBinario() {
			return buscadorBinario;
		}

		public static ArvoresLista getOnsultorArvores() {
			return onsultorArvores;
		}


		/**
		 * Método de validação de comando de menu
		 * @param nomeArquivo
		 * @throws Exception
		 */
		private static void validaMenu(String nomeArquivo) throws Exception {
			if (Auxiliar.getAbilita() == true ) {
				Auxiliar.setAbilita(true); // Garante a execução do menu armazenado no filtro anterior
				Menus.menuConsultas();
			} else {
				Auxiliar.setAbilita(false); // Garante a destruição do filtro anterior para receber um novo
				Menus.menuConsultas();
			}
		}


		/**
		 * Seleciona definições de estrutura à ser utilizada
		 */
		private static void selecionaComando(String nomeArquivo) {
			try {
				validaMenu(nomeArquivo);

				switch (Auxiliar.digita("")) {

				case "novo":
					getOnsultorArvores().manipulaEstrutura(true);
					selecionaComando(nomeArquivo);
					break;

				case "remover":
					getOnsultorArvores().removeElemento();
					break;

				case "posfixa":
					getOnsultorArvores().tPosFixa();
					selecionaComando(nomeArquivo);
					break;

				case "prefixa":
					getOnsultorArvores().tPrefixa();
					selecionaComando(nomeArquivo);
					break;

				case "infixa":
					getOnsultorArvores().tInfixa();
					selecionaComando(nomeArquivo);
					break;

				case "contar":
					getOnsultorArvores().contaDeElementos();
					selecionaComando(nomeArquivo);
					break;

				case "altura":
					getOnsultorArvores().buscaEmAltura();
					selecionaComando(nomeArquivo);
					break;
					
				case "profundidade":
					View.objetoNaoImplementado();
					selecionaComando(nomeArquivo);
					break;

				case "id":
					getBuscadorBinario().carregaBuscaBinaria(nomeArquivo, Auxiliar.digitaNumero("Id à ser localizado"));
					selecionaComando(nomeArquivo);
					break;

				case "navegar":
					View.objetoNaoImplementado();
					selecionaComando(nomeArquivo);
					break;

				case "arquivo":
					Ficheiro.leArquivo(nomeArquivo, false, null, false, true);
					selecionaComando(nomeArquivo);
					break;

				case "nome":
					View.objetoNaoImplementado();
					selecionaComando(nomeArquivo);
					break;

				case "imprimir":
					getOnsultorArvores().manipulaEstrutura(false);
					selecionaComando(nomeArquivo);
					break;

				case "sair":
					View.sair();
					break;

				default:
					View.opcaoInvalida();
					selecionaComando(nomeArquivo);
					break;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}


		//====================<< Menu definidor de atividade >> ====================

		/**
		 * Método de execução de atividade
		 * @throws Exception
		 */
		public static void selecinaExtrutura() throws Exception {

			String nomeArquivo = Auxiliar.digita("Nome do arquivo");

			switch (Auxiliar.getOpcao()) {

			case "LISTA":
				Ficheiro.leArquivo(nomeArquivo, false, null, false, false);
				selecionaComando(nomeArquivo);
				break;

			case "ARVORE":
				Ficheiro.leArquivo(nomeArquivo, false, null, false, false);
				selecionaComando(nomeArquivo);
				break;

			case "BINARIA":
				selecionaComando(nomeArquivo);
				break;
				
			default:
				View.opcaoInvalida();
				break;
			}
		}

}