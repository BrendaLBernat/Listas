import javax.swing.ImageIcon;

import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.suporte.LoadImage;

public class Lista2Ex08 extends Furbot {
	
	public void inteligencia() throws Exception {
		diga ("mundo de furbot");
		/*
		 * 
		 * enquanto (!ehFim(ESQUERDA) {
		 *      andarEsquerda(); }
		 * enquanto (!ehFim(ABAIXO) {
		 *       andarAbaixo(); }
		 * enquanto (!ehVazio(DIREITA) {
		 *       andarDireita(); }
		 * andarAcima();
		 * andarDIreita();
		 * enquanto (ehVazio(ACIMA) {
		 *    andarAcima() }
		 */

		while (!ehFim(ESQUERDA)) {
			andarEsquerda();
		}
		while (!ehFim(ABAIXO)) {
			andarAbaixo();
		}
		while (ehVazio(DIREITA)) {
			andarDireita();
		}
		andarAcima();
		andarDireita();
		while (ehVazio(ACIMA)) {
			andarAcima();
		}
		diga ("encontrei o tesouro!!!!");

	}
	
    public ImageIcon buildImage() {
       
          return LoadImage.getInstance().getIcon("furbot(50x70).jpg");
    }

	public static void main(String[] args) {
		MundoVisual.iniciar("Lista2Ex08.xml");

	}

}
