import javax.swing.ImageIcon;

import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.ObjetoDoMundo;
import br.furb.furbot.suporte.LoadImage;

public class Lista3Ex03 extends Furbot {

	/* definicao de CONSTANTES */
	private static final int tipoFurbot = 0;
	private static final int tipoAlien = 1;
	private static final int tipoNumero = 2;
	private static final int tipoBooleano = 3;
	private static final int tipoNaoIdentificado = 99;

	 //Identifica o tipo do objeto passado como parametro

	int identificaTipoDoObjeto(ObjetoDoMundo objeto) {
		String tipoDoObjeto = objeto.getSouDoTipo();

		if (tipoDoObjeto.contentEquals("Alien")) {
			return tipoAlien;
		} else if (tipoDoObjeto.contentEquals("Numero")) {
			return tipoNumero;
		} else if (tipoDoObjeto.contentEquals("Booleano")) {
			return tipoBooleano;
			// ***************************************************************
		} else if (objeto instanceof Lista3Ex03) // se eh objeto do tipo FURBOT
			return tipoFurbot;

		return tipoNaoIdentificado;
	}

	Direcao defineDirecaoDoMovimento(ObjetoDoMundo objeto, String valor) {
		int tipoDoObjeto = identificaTipoDoObjeto(objeto);
		// caso o tipoDoObjeto seja:

		switch (tipoDoObjeto) {
		case tipoAlien: {
			diga("sou Alien, vou para a esquerda");
			return ESQUERDA;
			// break; //desvia o fluxo de execucao para depois da chave do Switch
		}
		case tipoNumero: {
			diga("sou Numero," + valor + " vou para a direita");
			return DIREITA;
			// break;
		}
		case tipoBooleano: {
			diga("sou booleano," + valor + " vou para cima");
			return ACIMA;
		}
		default: {// caso nao seja nenhuma das opcoes acima, executa o DEFAULT
			diga("sou Furbot!");
			return AQUIMESMO;
		}

		}// switch
	}

	void fazObjetoAndar(ObjetoDoMundo objeto, Direcao direcao) {
		if (direcao == DIREITA)
			objeto.andarDireita();
		else if (direcao == ESQUERDA)
			objeto.andarEsquerda();
		else if (direcao == ACIMA)
			objeto.andarAcima();
		else if (direcao == ABAIXO)
			objeto.andarAbaixo();
		else {
			// neste caso, o valor PROVAVELMENTE será "AQUIMESMO" cujo efeito
			// é fazer com que o objeto NAO SE MOVA!
		}
	}

	
	/*
	 * quando eu chego aqui, OBJETOATUAL contem a ponta da pipa do objeto sendo
	 * controlado pelo FURBOT. ENtao o OBJETO deve ser programado para movimentar-se
	 * na direcao passada como parametro
	 */
	public void fazObjetoEncontradoAndarParaADirecao(ObjetoDoMundo objetoAtual, Direcao direcao) {
		boolean repetir = true;
		ObjetoDoMundo novoObjetoEncontrado = null;
		//Direcao direcaoDoNovoObjetoEncontrado = AQUIMESMO;
		//aqui diz q nao tava sendo usado entao comentei

		int tipoDoObjetoAtual = identificaTipoDoObjeto(objetoAtual);
		while (repetir) {
			// caso o tipoDoObjeto seja:
			switch (tipoDoObjetoAtual) {
			case tipoAlien:
			case tipoBooleano:
			case tipoNumero: {
				if (objetoAtual.ehFim(direcao)) {
					repetir = false;
				} else {
					// se o objeto nao chegou ao fim entao
					if (objetoAtual.ehVazio(direcao)) {
						fazObjetoAndar(objetoAtual, direcao);
					} else { // nao ehVazio na proxima posicao na direcao que eu tenho que andar
						
						// pega o novo objeto encontrado
						novoObjetoEncontrado = objetoAtual.getObjeto(direcao);
						
						fazObjetoAndar(objetoAtual, direcao);
						
						Direcao novaDirecao = defineDirecaoDoMovimento(novoObjetoEncontrado, novoObjetoEncontrado.toString());
						fazObjetoEncontradoAndarParaADirecao(novoObjetoEncontrado, novaDirecao);	
					}
				} 
				break; // desvia o fluxo de execucao para depois da chave do Switch
			}

			default: {// caso nao seja nenhuma das opcoes acima, executa o DEFAULT
				diga("sou Furbot!");
				// pula por cima do objeto sendo controlado
				//fazObjetoAndar(objetoAtual, direcao);

				repetir = false;
				break;
			}

			}// switch

		} // while
		return;
	}

	public void inteligencia() throws Exception { // ESCOPO DE VARIAVEIS
		ObjetoDoMundo objetoEncontrado = null;
		Direcao novaDirecao = AQUIMESMO;
		limparConsole();
		diga("mundo de furbot");
		// implementa zigue-zague

		boolean controlaLoop;
		// aqui o sinal de igual representa uma atribuição
		controlaLoop = true; // "flag" ou bandeira

		while (controlaLoop == true) {
			// faz o passeio da direita para a esquerda

			while (!ehFim(DIREITA)) {
				if (!ehVazio(DIREITA)) {
					// o comando getObjeto() devolve o FIO DA PIPA
					// quem foi encontrado à DIREITA fará o papel da PIPA
					objetoEncontrado = getObjeto(DIREITA);
					novaDirecao = defineDirecaoDoMovimento(objetoEncontrado, objetoEncontrado.toString());
					fazObjetoEncontradoAndarParaADirecao(objetoEncontrado, novaDirecao);
				}
				// -------------------
				andarDireita();
			} // while

			if (!ehFim(ABAIXO)) {// se nao eh fim abaixo, executa o bloco
				if (!ehVazio(ABAIXO)) {
					objetoEncontrado = getObjeto(ABAIXO);
					novaDirecao = defineDirecaoDoMovimento(objetoEncontrado, objetoEncontrado.toString());
					fazObjetoEncontradoAndarParaADirecao(objetoEncontrado, novaDirecao);
				}
				// -------------------
				andarAbaixo();

				while (!ehFim(ESQUERDA)) {
					if (!ehVazio(ESQUERDA)) {
						objetoEncontrado = getObjeto(ESQUERDA);
						novaDirecao = defineDirecaoDoMovimento(objetoEncontrado, objetoEncontrado.toString());
						fazObjetoEncontradoAndarParaADirecao(objetoEncontrado, novaDirecao);
					}
					// -------------------
					andarEsquerda();
				} // while

				if (!ehFim(ABAIXO)) {
					if (!ehVazio(ABAIXO)) {
						objetoEncontrado = getObjeto(ABAIXO);
						novaDirecao = defineDirecaoDoMovimento(objetoEncontrado, objetoEncontrado.toString());
						fazObjetoEncontradoAndarParaADirecao(objetoEncontrado, novaDirecao);
					}
					// -------------------
					andarAbaixo();
				} else {
					controlaLoop = false;// encerra o laco de repeticao
				}
			} else {
				controlaLoop = false; // encerra o laco de repeticao
			}
		} // while
	}

	public ImageIcon buildImage() {

		return LoadImage.getInstance().getIcon("furbot(50x70).jpg");
	}

	public static void main(String[] args) {
		MundoVisual.iniciar("Lista3Ex03.xml");

	}

}