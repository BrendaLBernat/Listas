import javax.swing.ImageIcon;

import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.suporte.LoadImage;

public class Lista2Ex13 extends Furbot {

	public void inteligencia() throws Exception {
		limparConsole();
		diga ("mundo de furbot");
		//vamos criar um CONTADOR (uma  variavel que recebera a contagem)
		int contaAliens = 0;  //inicializo esta variavel com valor inicial conhecido
		
		while (!ehFim (DIREITA)) {
			if ( ehObjetoDoMundoTipo("Alien", DIREITA)  == true ) {
	             
	             contaAliens = contaAliens + 1; //conta os Aliens encontrados
	             diga ("Encontrei um Alien. Tenho  "+ contaAliens + " Aliens");
			}
			else {
				//diga ("A célula está livre"); 
			}
			andarDireita();
		}// while

		if (contaAliens > 0) {
			if (contaAliens == 1) {
				diga("Encontrei 1 ALIEN");
			} else {
				diga("Encontrei " + contaAliens + " ALIENS");
			}
		} else {
			diga("Nao encontrei nenhum ALIEN");
		}

	}

	public ImageIcon buildImage() {

		return LoadImage.getInstance().getIcon("furbot(50x70).jpg");
	}

	public static void main(String[] args) {
		MundoVisual.iniciar("Lista2Ex13.xml");

	}

}
