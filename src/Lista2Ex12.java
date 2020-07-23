import javax.swing.ImageIcon;

import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.suporte.LoadImage;

public class Lista2Ex12 extends Furbot {

	public void inteligencia() throws Exception {
		diga("mundo de furbot");

		boolean encontreiErro = false;
		while (ehVazio(DIREITA) && !ehFim(DIREITA)) {
			andarDireita();
		}
		if (!ehFim(DIREITA)) {
			// estou na situacao onde encontrei um alien a direita
			// preciso TENTAR passar por baixo
			if (ehVazio(ABAIXO)) {
				andarAbaixo();
				if (ehVazio(DIREITA) && !ehFim(DIREITA)) {
					andarDireita();
					if (ehVazio(DIREITA) && !ehFim(DIREITA)) {
						andarDireita();
						if (ehVazio(ACIMA)) {
							andarAcima();
							while (ehVazio(DIREITA) && !ehFim(DIREITA)) {
								andarDireita();
							}
							if (!ehFim(DIREITA)) {
								diga("nao posso andar a direita!!!");
								encontreiErro = true;
							}

						} else {
							diga("nao posso andar acima");
							encontreiErro = true;
						}
					} else {
						diga("nao posso dar o segundo passo p/direita");
						encontreiErro = true;
					}
				} else {
					diga("nao posso dar o primeiro passo p/direita");
					encontreiErro = true;
				}
			} else {
				diga("nao posso andar abaixo!");
				encontreiErro = true;
			}
		} else {
			diga("encontrei fim a direita");
		}

		if (encontreiErro) {
			diga("foram encontrados erros no percurso");
		} else
			diga("cheguei na coluna final");

	}

	public ImageIcon buildImage() {

		return LoadImage.getInstance().getIcon("furbot(50x70).jpg");
	}

	public static void main(String[] args) {
		MundoVisual.iniciar("Lista2Ex12.xml");

	}

}
