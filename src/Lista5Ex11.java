
import javax.swing.ImageIcon;

import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.ObjetoDoMundo;
import br.furb.furbot.suporte.LoadImage;

public class Lista5Ex11 extends Furbot {

	int numero = 0;
	boolean bol = false;
	int contaInteiros = 0;
	int contaBooleanos = 0;
	int contaObjetos = 0;
	String valorDoPersonagem;
	int y;

	public static final int MaxInteiros = 30;
	public static final int MaxObjetos = 40;
	public static final int MaxBol = 10;

	int[] numeros = new int[MaxInteiros];
	boolean[] boolanos = new boolean[MaxBol];

	ObjetoDoMundo[] objetos = new ObjetoDoMundo[MaxObjetos];

	public void converte(Direcao dir) {
		ObjetoDoMundo obj = this.getObjeto(dir);
		if (obj != null) {
			if (contaObjetos < MaxObjetos) {
				objetos[contaObjetos] = obj;
			}
			contaObjetos++;
		}
		if (ehObjetoDoMundoTipo("Numero", dir) == true) {
			valorDoPersonagem = obj.toString();
			numero = Integer.parseInt(valorDoPersonagem);
			diga("Numero: " + numero);

			numeros[contaInteiros] = numero;
			contaInteiros++;

		} else {
			if (ehObjetoDoMundoTipo("Booleano", dir) == true) {
				valorDoPersonagem = obj.toString();
				bol = Boolean.parseBoolean(valorDoPersonagem);
				diga("Boolean convertido: " + bol);

				boolanos[contaBooleanos] = bol;
				contaBooleanos++;
			}
		}
	}

	public String mostraArrayInteiros() {
		String temp = "";
		int y;

		for (int i = 0; i < MaxInteiros; i++) {
			temp = temp + numeros[i] + ";";
		} // for
		temp = temp + "\n";

		for (int i = 0; i < MaxInteiros; i++) {
			y = i + 1;
			if (y < MaxInteiros)
				numeros[i] = numeros[y];
		} // for
		temp = temp + "\n";

		for (int i = 0; i < MaxInteiros; i++) {
			temp = temp + numeros[i] + ";";
		} // for
		temp = temp + "\n";

		return temp;

	}

	public String mostraArrayBooleanos() {
		String temp = "";
		for (int i = 0; i < MaxObjetos; i++) {
			if (i < contaBooleanos)

				temp = temp + boolanos[i] + ";";
			else
				temp = temp + ".;";
		} // for
		temp = temp + "\n";

		int x = 0;
		int z = 0;

		for (int i = 0; i < MaxObjetos; i++) {
			if (i < contaBooleanos) {
				if (boolanos[i] == false && x == 0) {
					x = 1;
				}

				z = i + x;

				boolanos[i] = boolanos[z];
			}

		} // for

		contaBooleanos = contaBooleanos - x;

		for (int i = 0; i < MaxObjetos; i++) {
			if (i < contaBooleanos)

				temp = temp + boolanos[i] + ";";
			else
				temp = temp + ".;";
		} // for
		temp = temp + "\n";

		return temp;
	}

	public String mostraArrayObjetos() {
		String temp = "";
		for (int i = 0; i < MaxObjetos; i++) {
			if (objetos[i] != null)
				temp = temp + objetos[i].toString() + ";";
			else
				temp = temp + ".;";
		} // for
		temp = temp + "\n";
		return temp;
	}

	public void inteligencia() throws Exception {

		boolean repetir = true;

		while (repetir == true) {
			while (!ehFim(DIREITA)) {
				converte(DIREITA);
				andarDireita();
			}
			if (!ehFim(ABAIXO)) {
				converte(ABAIXO);
				andarAbaixo();

				while (!ehFim(ESQUERDA)) {
					converte(ESQUERDA);
					andarEsquerda();
				}
				if (!ehFim(ABAIXO)) {
					converte(ABAIXO);
					andarAbaixo();
				} else
					repetir = false;
			} else
				repetir = false;
		} // while zigue-zague

		diga("fim do zigue-zague horizontal");

		System.out.println("Quantidade de numeros: " + contaInteiros);
		System.out.println("Quantidade de booleanos: " + contaBooleanos);

		System.out.println("Vetor dos numeros");
		System.out.println(this.mostraArrayInteiros());

		System.out.println("array de booleans");
		System.out.println(this.mostraArrayBooleanos());

	}

	public ImageIcon buildImage() {
		return LoadImage.getInstance().getIcon("furbot(50x70).jpg");
	}

	public static void main(String[] args) {
		MundoVisual.iniciar("Lista5Ex11.xml"); // inicia o mundo do furbot
	}
}
