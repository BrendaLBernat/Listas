import javax.swing.ImageIcon;

import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.ObjetoDoMundo;
import br.furb.furbot.suporte.LoadImage;
import br.furb.furbot.Direcao;

public class Lista3Ex05 extends Furbot {

	ObjetoDoMundo tesouro1 = null;
	ObjetoDoMundo tesouro2 = null;
	ObjetoDoMundo tesouro3 = null;
	
	/*
	 * Este metodo tem por objetivo posicionar o Furbot sempre no canto superior esquerdo do mapa
	 * de paredes
	 */
	void posicionaFurbotNoCantoSuperiorEsquerdo(Direcao dirMovimento, Direcao dirParede) {
		switch (dirMovimento) {
		case DIREITA: {// posiciona o furbot no canto superior esquerdo
			switch (dirParede) {
			case DIREITA: { // andava p/direita e encontrou parede a direita
				// precisa subir para o canto superior esquerdo
				while (!ehVazio(DIREITA)) {
					andarAcima();
				}
				break;
			}
			case ABAIXO: { // andava p/direita e encontrou parede a abaixo
				// precisa ir para o canto superior esquerdo
				while (!ehVazio(ESQUERDA) && (!ehFim(ESQUERDA))) {
					andarEsquerda();
				}
				// verifica se esta no extremo superior esquerdo
				if (ehVazio(ESQUERDA) && (!ehFim(ESQUERDA))) {
					andarEsquerda();
					if (ehVazio(ABAIXO)) {
						andarDireita(); // volta para o canto superior esquerdo
					}
				}
				break;
			}

			case ACIMA: { // andava p/direita e encontrou parede acima
				// precisa ir para a esquerda e subir p/canto superior esquerdo
				while (!ehVazio(ESQUERDA) && (!ehFim(ESQUERDA))) {
					andarEsquerda();
				}
				andarAcima();
				while (!ehVazio(DIREITA) && (!ehFim(DIREITA))) {
					andarAcima();
				}
				break;
			}
			}// switch

			break;
		}
		case ESQUERDA: { // posiciona o furbot no canto superior direito
			switch (dirParede) {
			case ESQUERDA: { // andava p/esquerda e encontrou parede a esquerda
				// precisa subir para o canto superior direito e ir p/canto sup.esq
				while (!ehVazio(ESQUERDA)) {
					andarAcima();
				}
				while (!ehVazio(ABAIXO)) {
					if (!ehFim(ESQUERDA)) {
						andarEsquerda();
					}
				}
				if (ehVazio(ESQUERDA)) {
					andarEsquerda();
					if (ehVazio(ABAIXO)) {
						if (!ehFim(DIREITA)) {
							andarDireita(); // volta para o canto superior esquerdo
						}
					}
				}
				break;
			}
			case ABAIXO: { // andava p/esquerda e encontrou parede abaixo
				// precisa ir para o canto superior esquerdo
				while (!ehVazio(ABAIXO)) {
					if (!ehFim(ESQUERDA)) {
						andarEsquerda();
					}
				}
				// chega aqui qdo furbot esta sobre um vazio
				if (ehVazio(ABAIXO)) {
					if (!ehFim(ESQUERDA) && (ehVazio(ESQUERDA))) {
						andarEsquerda(); // tenta dar mais um passo p/esquerda
						while (ehVazio(ABAIXO)) {// posicionamos no canto corretamente
							andarDireita();// volta para posicionar no canto superior esquerdo
						}
					}
				} else {
					// ja estamos posicionados corretamente
				}

				break;
			}

			case ACIMA: { // andava p/esquerda e encontrou parede acima
				// precisa ir para a esquerda e subir p/canto superior esquerdo
				while (!ehVazio(ESQUERDA) && (!ehFim(ESQUERDA))) {
					andarEsquerda();
				}
				andarAcima();
				while (!ehVazio(DIREITA) && (!ehFim(DIREITA))) {
					andarAcima();
				}
				break;
			}
			}// switch

			break;
		}
		}// case
	}

	/*
	 * Este metodo é chamado quando o furbot, durante o zigue-zague, localizou uma parede.
	 * É chamado o metodo posicionaFurbotNoCantoSuperiorEsquerdo para, a partir dai, iniciar
	 * a busca pela entrada do mapa.
	 */
	ObjetoDoMundo andarPeloPerimetro( Direcao dirMovimento, Direcao dirParede) {
		ObjetoDoMundo tesouroProcurado = null;
		
		posicionaFurbotNoCantoSuperiorEsquerdo(dirMovimento, dirParede);
		
		// a partir daqui o furbot esta posicionado no canto superior esquerdo
		
		andarDireita(); //tenta encontrar a entrada por cima

		if (!ehVazio(ABAIXO)) {
			//diga("U de cabeca para baixo");// o U esta de cabeca para baixo

			while (!ehVazio(ABAIXO)) {
				andarEsquerda();
			}
			andarAbaixo();
			while (!ehVazio(DIREITA)) {
				andarAbaixo();
			}
			andarDireita();
			andarDireita();
			if (!ehVazio(ACIMA)) { 
				diga("estou perdido, achei que a entrada era aqui!");
				return null; // como estamos retornando um objeto e não o encontramos, devemos retornar NULL
			} else {
				andarAcima();
				tesouroProcurado = getObjeto(ACIMA);
				diga("Encontrei um tesouro  com valor: " + tesouroProcurado.toString());
				andarAbaixo();
			}
		} else {
			//diga("U correto");// o U está correto, encontrei a entrada
			andarAbaixo();
			tesouroProcurado = getObjeto(ABAIXO);
			diga("Encontrei um tesouro  com valor: " + tesouroProcurado.toString());
			andarAcima();
		}
		return tesouroProcurado;
	}

	/*
	 * Este metodo tem por objetivo realizar o zigue-zague em cada quadrante do mundo
	 * tentando localizar o primeiro objeto PAREDE que indica a presença de uma  estrutura
	 * que guarda um tesouro.
	 * Observe que o metodo recebe como parametros a coordenada X de início do quadrante e a
	 * coordenada X do final do quadrante.
	 * Isto permite que o zigue-zague esteja restrito a uma delimitação de QUADRANTES conforme
	 * proposto no enunciado.
	 */
	ObjetoDoMundo buscaTesouros(int coordInicio, int coordFim) {
		ObjetoDoMundo tesouroProcurado = null;
		boolean controlaLoop = true; // "flag" ou bandeira
		//boolean procurarTesouro = true;
		boolean repeteBusca = true;

		while (controlaLoop == true) {
			// faz o passeio da ESQUERDA para a DIREITA
			// ----------------------------------------------------
			repeteBusca = true;
			while (repeteBusca) {
				// anda para direita até o meio do tabuleiro
				if (getX() < coordFim) {
					if (!ehVazio(DIREITA)) { //diga("encontrei parede a direita");
						tesouroProcurado = andarPeloPerimetro(DIREITA, DIREITA);
						
					} else { // ehVazio(DIREITA)
						if (!ehVazio(ABAIXO)) {	//diga("encontrei parede abaixo");
							tesouroProcurado = andarPeloPerimetro(DIREITA, ABAIXO);
						} else {
							if (!ehVazio(ACIMA)) { //diga("encontrei parede acima");
								tesouroProcurado = andarPeloPerimetro(DIREITA, ACIMA);
							} else
								andarDireita();
						}
					}
				} else {
					repeteBusca = false;
				}
				//se encontrou o tesouro
				if (tesouroProcurado != null) {
					repeteBusca = false;
					controlaLoop = false;
				}
			} // while repeteBusca

			if (!ehFim(ABAIXO) && controlaLoop == true) { // desce a linha
				andarAbaixo();

				// faz o passeio da DIREITA para a ESQUERDA
				// ----------------------------------------------------
				repeteBusca = true;
				while (repeteBusca) {
					if (getX() > coordInicio) { // anda para a esquerda ate a metade do tabuleiro
						if (!ehVazio(ESQUERDA)) { //diga("encontrei parede a esquerda");
							tesouroProcurado = andarPeloPerimetro(ESQUERDA, ESQUERDA);
						} else { // ehVazio(ESQUERDA)
							if (!ehVazio(ABAIXO)) { //diga("encontrei parede abaixo");
								tesouroProcurado = andarPeloPerimetro( ESQUERDA, ABAIXO);
							} else {
								if (!ehVazio(ACIMA)) {	//diga("encontrei parede acima");
									tesouroProcurado = andarPeloPerimetro(ESQUERDA, ACIMA);
								} else
									andarEsquerda();
							}
						}
					} else { // cheguei na metade do tabuleiro
						repeteBusca = false;
					}
					//se encontrou o tesouro
					if (tesouroProcurado != null) {
						repeteBusca = false;
						controlaLoop = false;
					}
				} // while repeteBusca

				if (!ehFim(ABAIXO) && controlaLoop == true)
					andarAbaixo();
			}
		} // while
			
		// Fim da busca neste quadrante
		return tesouroProcurado;
	}
	
	/*
	 * Método que recebe como parametro o valor simbolico de dois tesouros,
	 * converte os valores para o tipo INT e verifica qual o maior valor entre eles
	 * Retorna um STRING com o maior valor identificado
	 */
	String maiorValorDosTesouros(String valor1,String valor2) {
		int iValor1 = Integer.parseInt(valor1);
		int iValor2 = Integer.parseInt(valor2);
		if (iValor1 > iValor2) {
			return ""+iValor1;
		} else {
			return ""+iValor2;
		}
	}

	/*
	 * METODO INTELIGENCIA: este metodo divide o mundo em 3 quadrantes e
	 * realiza tres buscas por tesouros, uma em cada quadrante.
	 */
	public void inteligencia() throws Exception {
		int contaColunas = 0;
		
		this.limparConsole();
		
		while (!ehFim(DIREITA)) {
			contaColunas++;
			andarDireita();
		}
	
		int metade = contaColunas / 2 + 1;
		diga("O tabuleiro possui " + contaColunas + " colunas.A metade e na coluna: " + metade);

		//volta para a origem no canto superior esquerdo
		while (!ehFim(ESQUERDA)) {
			andarEsquerda();
		}
		// INICIA A BUSCA PELO PRIMEIRO TESOURO
		tesouro1 = buscaTesouros( 0, metade - 1);
		diga("Encontrei o tesouro 1 com valor: " + tesouro1.toString());

		//agora vai buscar o tesouro2"
		//posiciona o Furbot no canto superior esquerdo do quadrante2
		while (!ehFim(ESQUERDA)) {
			andarEsquerda();
		}
		while (!ehFim(ACIMA)) {
			andarAcima();
		}
		while (getX() < metade) {
			andarDireita();
		}
		// INICIA A BUSCA PELO SEGUNDO TESOURO
		tesouro2 = buscaTesouros( metade - 1, contaColunas);
		diga("Encontrei o tesouro 2 com valor: " + tesouro2.toString());

		//agora vai buscar o tesouro3"
		while (!ehFim(DIREITA)) {
			andarDireita();
		}
		while (getY() < metade - 1) {
			andarAbaixo();
		}
		
		// INICIA A BUSCA PELO TERCEIRO TESOURO
		tesouro3 = buscaTesouros( 0, contaColunas);

		diga("Encontrei o tesouro 3 com valor: " + tesouro3.toString());
		
		//agora vai para o canto inferior esquerda
		while (!ehFim(ESQUERDA)) {
			andarEsquerda();
		}
		while (!ehFim(ABAIXO)) {
			andarAbaixo();
		}
		
		//agora identifica qual o maior valor entre os tesouros encontrados
		String maiorValor = maiorValorDosTesouros(tesouro1.toString(),tesouro2.toString());
		maiorValor= maiorValorDosTesouros(maiorValor,tesouro3.toString());

		diga ("O maior valor dos tesouros encontrados e: "+ maiorValor);
		diga("FIM");

	}

	public ImageIcon buildImage() {

		return LoadImage.getInstance().getIcon("furbot(50x70).jpg");
	}

	public static void main(String[] args) {
		MundoVisual.iniciar("Lista3Ex05.xml");

	}

}
