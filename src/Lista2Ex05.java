import javax.swing.ImageIcon;

import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.suporte.LoadImage;

public class Lista2Ex05 extends Furbot {

	public void inteligencia() throws Exception {
		diga("mundo de furbot");

		boolean repetir = true; // flag

		while (repetir == true) {
			while (!ehFim(DIREITA)) {
				andarDireita();
			} // while direita

			if (!ehFim(ABAIXO)) {
				andarAbaixo();
				while (!ehFim(ESQUERDA)) {
					andarEsquerda();
				} // while esquerda

				if (!ehFim(ABAIXO)) {
					andarAbaixo();
				} else
					repetir = false;
			} else
				repetir = false;
		}

		diga("acabou o zigue zague");

	}

	public ImageIcon buildImage() {

		return LoadImage.getInstance().getIcon("furbot(50x70).jpg");
	}

	public static void main(String[] args) {
		MundoVisual.iniciar("Lista2Ex05.xml");

	}

}