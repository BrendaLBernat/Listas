
import javax.swing.ImageIcon;

import br.furb.furbot.Furbot;
import br.furb.furbot.Numero;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.suporte.LoadImage;

public class Lista5Ex01 extends Furbot {
	boolean repetir = true;
	public static final int MAX_NUM = 10;
	int[] numeros = new int[MAX_NUM];
	int i = 0;

	Numero personagemNumero = new Numero();

	void pegaNumero() {

		if (!ehVazio(AQUIMESMO)) {

			if (ehObjetoDoMundoTipo("Numero", AQUIMESMO) == true) {
				personagemNumero = getObjeto(AQUIMESMO);
				String valorDoPersonagem = personagemNumero.toString();
				int valor = Integer.parseInt(valorDoPersonagem);

				numeros[i] = valor;
				i++;
			}
		}
	}

	public void inteligencia() throws Exception {

		System.out.println("Equipe 8: Brenda L. Bernat, Douglas J. D. Greuel, Gustavo Gonçalves, Lucca Moraes e Victor Hugo Mette");
		
		while (repetir == true) {
			while (!ehFim(DIREITA)) {
				pegaNumero();
				andarDireita();
			}
			if (!ehFim(ABAIXO)) {
				pegaNumero();
				andarAbaixo();

				while (!ehFim(ESQUERDA)) {
					pegaNumero();
					andarEsquerda();
				}
				if (!ehFim(ABAIXO)) {
					pegaNumero();
					andarAbaixo();
				} else
					repetir = false;
			} else
				repetir = false;
		} // while

		for (int i = MAX_NUM - 1; i >= 0; i--) {
			System.out.print(numeros[i] + ",");

		} // for
	}

	public ImageIcon buildImage() {

		return LoadImage.getInstance().getIcon("furbot(50x70).jpg");
	}

	public static void main(String[] args) {
		MundoVisual.iniciar("Lista5Ex01.xml");

	}

}
