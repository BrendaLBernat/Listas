import javax.swing.ImageIcon;

import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Numero;
import br.furb.furbot.suporte.LoadImage;

public class Lista4Ex03 extends Furbot {

	Numero personagemNumero = new Numero();
	int multiplica = 1;

	public void manipulaNum(Direcao direcao) {
		if (!ehVazio(direcao)) {
			personagemNumero = getObjeto(direcao);
			String valorDoPersonagem = personagemNumero.toString();
			int valor = Integer.parseInt(valorDoPersonagem);

			diga("Tabuada do numero " + valor);
			
			while (multiplica <= 10) {
				diga(valor + " * " + multiplica + " = " + valor * multiplica);
				multiplica++;
			}

			valor = 0;
			multiplica = 1;
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
		} // foi ate a origem

		if (!ehVazio(AQUIMESMO)) {
			manipulaNum(AQUIMESMO);
		}

		boolean repetir = true; // flag

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

	}

	public ImageIcon buildImage() {

		return LoadImage.getInstance().getIcon("furbot(50x70).jpg");
	}

	public static void main(String[] args) {
		MundoVisual.iniciar("Lista4Ex03.xml");

	}

}