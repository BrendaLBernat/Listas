import javax.swing.ImageIcon;

import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Numero;
import br.furb.furbot.ObjetoDoMundo;
import br.furb.furbot.ObjetoDoMundoAdapter;
import br.furb.furbot.suporte.LoadImage;

public class Lista3Ex02 extends Furbot {

	Numero personagemNumero = new Numero();
	int acumulador = 0;
	ObjetoDoMundo objetoEncontrado = null;

	public void manipulaNum(Direcao direcao) {
		if (!ehVazio(direcao)) {
			personagemNumero = getObjeto(direcao);
			String valorDoPersonagem = personagemNumero.toString();
			int valor = Integer.parseInt(valorDoPersonagem);

			if (acumulador <= 0) {
				acumulador = acumulador + valor;
			} else {
				acumulador = acumulador - valor;
			}

			diga("acumulador= " + acumulador);
			valor = 0; // tem q testar pra ver se precisa zerar

			// não estou conseguindo passar pelo alien
			// o mundo explode
			// preciso dobrar o valor do acumulador quando encontra um alien mas não consigo
			// passar dele
			// só falta passar por cima/pelo alien

			if (!objetoEncontrado.ehFim(direcao)) {
				acumulador = acumulador * 2;

			}
		}

	}

	public void inteligencia() throws Exception {

		limparConsole();
		diga("mundo de furbot");

		// caso tenha um num na origem (0,0)
		if (!ehVazio(AQUIMESMO)) {
			manipulaNum(AQUIMESMO);

			// NAO DEU CERTO ISSO TBM AFF
			if (ehObjetoDoMundoTipo("Alien", AQUIMESMO)) {
				acumulador = acumulador * 2;
			}
		}

		boolean repetir = true; // flag

		while (repetir == true) {
			while (!ehFim(DIREITA)) {
				manipulaNum(DIREITA);
				if (ehObjetoDoMundoTipo("Alien", DIREITA) == true) {
					acumulador = acumulador * 2;
				}//NAO DEU CERTO
				andarDireita();
			} // while direita
			if (!ehFim(ABAIXO)) {
				if (ehObjetoDoMundoTipo("Alien", ABAIXO)) {
					acumulador = acumulador * 2;
				}
				manipulaNum(ABAIXO);
				andarAbaixo();
				if (!ehVazio(AQUIMESMO)) {
					if (ehObjetoDoMundoTipo("Alien", AQUIMESMO)) {
						acumulador = acumulador * 2;
					}
					manipulaNum(AQUIMESMO);
				}
				while (!ehFim(ESQUERDA)) {
					if (ehObjetoDoMundoTipo("Alien", ESQUERDA)) {
						acumulador = acumulador * 2;
					}
					manipulaNum(ESQUERDA);
					andarEsquerda();
				} // while esquerda
				if (!ehFim(ABAIXO)) {
					if (ehObjetoDoMundoTipo("Alien", ABAIXO)) {
						acumulador = acumulador * 2;
					}
					manipulaNum(ABAIXO);
					andarAbaixo();
					if (!ehVazio(AQUIMESMO)) {
						if (ehObjetoDoMundoTipo("Alien", AQUIMESMO)) {
							acumulador = acumulador * 2;
						}
						manipulaNum(AQUIMESMO);
					}

				} else {
					repetir = false;
				}
			} else {
				repetir = false;
			}
		}

		diga("Fim do zigue-zague");
		diga("O numero total acumulado eh: " + acumulador);

	}

	public ImageIcon buildImage() {

		return LoadImage.getInstance().getIcon("furbot(50x70).jpg");
	}

	public static void main(String[] args) {
		MundoVisual.iniciar("Lista3Ex02.xml");

	}

}