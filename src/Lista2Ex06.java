import javax.swing.ImageIcon;

import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.suporte.LoadImage;

public class Lista2Ex06 extends Furbot {

	public void inteligencia() throws Exception {
		diga("mundo de furbot");

		while (!ehFim(ABAIXO) || !ehFim(DIREITA)) {
			andarAbaixo();
			andarDireita();
		}

		diga("Acabei o labirinto! Cheguei a " + getX() + ", " + getY());
	}

	public ImageIcon buildImage() {

		return LoadImage.getInstance().getIcon("furbot(50x70).jpg");
	}

	public static void main(String[] args) {
		MundoVisual.iniciar("Lista2Ex06.xml");

	}

}