
import javax.swing.ImageIcon;

import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.ObjetoDoMundo;
import br.furb.furbot.suporte.LoadImage;

public class Lista5Ex10 extends Furbot {

	int numero = 0;
	int contaInteiros = 0;
	int contaObjetos = 0;

	int maiorValor;
	int menorValor = 999;
	int somaValores;

	String valorDoPersonagem;

	public static final int MaxInteiros = 30; // para valores dos tesouros
	public static final int MaxObjetos = 30;

	int[] valores = new int[MaxInteiros]; // valores dos tesouros
	ObjetoDoMundo[] objetos = new ObjetoDoMundo[MaxObjetos];

	public void converte(Direcao dir) {
		ObjetoDoMundo obj = this.getObjeto(dir);
		if (obj != null) {
			if (contaObjetos < MaxObjetos) {
				objetos[contaObjetos] = obj;
			}
			contaObjetos++;
		}
		if ((ehObjetoDoMundoTipo("Tesouro", dir) == true)) {
			valorDoPersonagem = obj.toString();
			numero = Integer.parseInt(valorDoPersonagem);
			diga("Tesouro convertido: " + numero);

			valores[contaInteiros] = numero;
			contaInteiros++; // quantidade de tesouros

			somaValores = somaValores + numero;

			if (numero > maiorValor) {
				maiorValor = numero;
			}
			if (numero < menorValor) {
				menorValor = numero;
			}
		}
	}

	public String mostraArrayInteiros() {
		String temp = "";
		for (int i = 0; i < MaxInteiros; i++) {
			temp = temp + valores[i] + ";";
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

		System.out.println("O numero de tesouros é: " + contaObjetos);
		System.out.println("O tesouro de maior valor é: " + maiorValor);
		System.out.println("O tesouro de menor valor é: " + menorValor);
		System.out.println("A soma de todos os tesouros é: " + somaValores);

		System.out.println("array de inteiros");
		System.out.println(this.mostraArrayInteiros());

	}

	public ImageIcon buildImage() {

		return LoadImage.getInstance().getIcon("furbot(50x70).jpg");
	}

	public static void main(String[] args) {
		MundoVisual.iniciar("Lista5Ex10.xml");
	}
}
