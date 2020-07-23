import javax.swing.ImageIcon;

import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Numero;
import br.furb.furbot.suporte.LoadImage;

public class Lista4Ex02 extends Furbot {

	Numero personagemNumero = new Numero();
	int maiorNumero;
	int menorNumero = 300; // Integer.MAX_VALUE

	public void manipulaNum(Direcao direcao) {
		if (!ehVazio(direcao)) {
			personagemNumero = getObjeto(direcao);
			String valorDoPersonagem = personagemNumero.toString();
			int valor = Integer.parseInt(valorDoPersonagem);

			if (valor < menorNumero) {
				menorNumero = valor;
			}
			if (valor > maiorNumero) {
				maiorNumero = valor;
			}
		}
	}

	public void inteligencia() throws Exception {

		limparConsole();
		diga("mundo de furbot");

		while (!ehFim(ESQUERDA)) {
			andarEsquerda();
		}
		while (!ehFim(ACIMA)) {
			andarAcima();
		} // vai ate a origem

		if (!ehVazio(AQUIMESMO)) {
			manipulaNum(AQUIMESMO);
		}

		boolean repetir = true; // flag

		// comeca o zigue-zague
		while (repetir == true) {
			while (!ehFim(DIREITA)) {
				manipulaNum(DIREITA);
				andarDireita();
			} // while direita
			if (!ehFim(ABAIXO)) {
				manipulaNum(ABAIXO);
				andarAbaixo();
				while (!ehFim(ESQUERDA)) {
					manipulaNum(ESQUERDA);
					andarEsquerda();
				} // while esquerda
				if (!ehFim(ABAIXO)) {
					manipulaNum(ABAIXO);
					andarAbaixo();
				} else {
					repetir = false;
				}
			} else {
				repetir = false;
			}
		}
		diga("Fim do zigue-zague");

		diga("O menor numero eh: " + menorNumero);
		diga("O maior numero eh: " + maiorNumero);

		int sequencia = menorNumero;

		while (sequencia <= maiorNumero) {
			diga(sequencia);// mostra no mundo
			System.out.print(sequencia + ", "); // mostra no console
			sequencia++;
		}
	}

	public ImageIcon buildImage() {

		return LoadImage.getInstance().getIcon("furbot(50x70).jpg");
	}

	public static void main(String[] args) {
		MundoVisual.iniciar("Lista4Ex02.xml");

	}

}