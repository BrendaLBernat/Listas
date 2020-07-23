import javax.swing.ImageIcon;

import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.ObjetoDoMundo;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.suporte.LoadImage;

public class Lista5Ex03 extends Furbot {
	boolean repetir = true;

	boolean bol = false;
	int contaObjetos = 0;
	int contaBooleanos = 0;
	int multiplicaPeso = 128;
	int somaDosInteiros;
	int total;
	String valorDoPersonagem;

	public static final int MaxObjetos = 8;
	public static final int MaxBits = 8;

	int[] bits = new int[MaxBits];

	ObjetoDoMundo[] objetos = new ObjetoDoMundo[MaxObjetos];

	public void verificaBoolean(Direcao dir) {
		ObjetoDoMundo obj = this.getObjeto(dir);
		if (obj != null) {
			if (contaObjetos < MaxObjetos) {
				objetos[contaObjetos] = obj;
			}
			contaObjetos++;
		}

		if (ehObjetoDoMundoTipo("Booleano", dir) == true) {
			valorDoPersonagem = obj.toString();
			bol = Boolean.parseBoolean(valorDoPersonagem);
			diga("Boolean convertido: " + bol);
			if (this.contaBooleanos < 8) {
				if (bol == true) {
					bits[contaBooleanos] = 1;
				} else {
					bits[contaBooleanos] = 0;
				}
			}
			contaBooleanos++;
		}

	}

	public String mostraBits() {
		String temp = "";
		for (int i = 0; i < MaxBits; i++) {
			temp = temp + bits[i] + ",";
			somaDosInteiros = bits[i] * multiplicaPeso;
			total = total + somaDosInteiros;
			multiplicaPeso = multiplicaPeso / 2;
		} // for
		temp = temp + "\n";
		return temp;

	}

	public void inteligencia() throws Exception {

		while (repetir == true) {
			while (!ehFim(DIREITA)) {
				verificaBoolean(DIREITA);
				andarDireita();
			}
			if (!ehFim(ABAIXO)) {
				verificaBoolean(ABAIXO);
				andarAbaixo();

				while (!ehFim(ESQUERDA)) {
					verificaBoolean(ESQUERDA);
					andarEsquerda();
				}
				if (!ehFim(ABAIXO)) {
					verificaBoolean(ABAIXO);
					andarAbaixo();
				} else
					repetir = false;
			} else
				repetir = false;
		} // while

		System.out.println("Bits: " + mostraBits());
		System.out.println("Decimal: " + total);

	} // inteligencia

	public ImageIcon buildImage() {

		return LoadImage.getInstance().getIcon("furbot(50x70).jpg");
	}

	public static void main(String[] args) {
		MundoVisual.iniciar("Lista5Ex03.xml");

	}

}
