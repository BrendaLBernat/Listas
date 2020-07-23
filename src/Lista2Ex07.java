import javax.swing.ImageIcon;

import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.suporte.LoadImage;

public class Lista2Ex07 extends Furbot {

	public void inteligencia() throws Exception {
		diga("mundo de furbot");

		boolean repetir = true;
		boolean mudeiDeDirecao1 = false; // flag
		boolean mudeiDeDirecao2 = false; // flag

		while (repetir == true) {
			if (mudeiDeDirecao1 == true) {
				while (ehVazio(DIREITA)) {
					andarDireita();
				}
				while (ehVazio(ABAIXO)) {
					andarAbaixo();
				}
				mudeiDeDirecao1 = false; // reseta condição de mudança
				mudeiDeDirecao2 = true; // liga o flag para mudar novamente

			} // if
			else {
				while (ehVazio(ABAIXO)) {
					andarAbaixo();
				}
				while (ehVazio(DIREITA)) {
					andarDireita();
				}
			} // else

			if (mudeiDeDirecao2 == true) {
				while (ehVazio(ESQUERDA)) {
					andarEsquerda();
				}
					mudeiDeDirecao2 = false;
					repetir = false; 
					diga ("mudou de finalizar o laço externo");
					
				} else {
					while (ehVazio(ACIMA)) {
						andarAcima();
						mudeiDeDirecao1 = true; //sinaliza condição de mudança
						diga("mudeou de direção 1");					
				}
				while (ehVazio(ESQUERDA)) {
					andarEsquerda();
				}

			} // if
		} // while

	} // void

	public ImageIcon buildImage() {

		return LoadImage.getInstance().getIcon("furbot(50x70).jpg");
	}

	public static void main(String[] args) {
		MundoVisual.iniciar("Lista2Ex07.xml");

	}

}