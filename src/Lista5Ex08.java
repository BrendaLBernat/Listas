
import java.util.Arrays;

import javax.swing.ImageIcon;

import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.ObjetoDoMundo;
import br.furb.furbot.suporte.LoadImage;

public class Lista5Ex08 extends Furbot {

	int numero = 0;
	int contaInteiros = 0;
	int contaObjetos = 0;
	int ordemNumerosInteiros = 0;
	int maiorValor;
	int menorValor = 9999;
	double somaValores;

	String valorDoPersonagem;

	public static final int MaxInteiros = 30; // para valores dos tesouros
	public static final int MaxObjetos = 30;

	public static final int ArrayOrdenado = 30;
	int[] ordenado = new int[ArrayOrdenado];

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

	public void colocaNumerosInteirosEmOrdem(Direcao dir) {
		ObjetoDoMundo obj = this.getObjeto(dir);
		if ((ehObjetoDoMundoTipo("Numero", dir) == true)) {
			valorDoPersonagem = obj.toString();
			numero = Integer.parseInt(valorDoPersonagem);
			ordenado[ordemNumerosInteiros] = numero;
			ordemNumerosInteiros++;
		}
	}

	public String ordenaArray() {
		ordenado = valores;
		Arrays.sort(ordenado);
		String temp = "";
		for (int i = 0; i < ArrayOrdenado; i++) {

			temp = temp + ordenado[i] + ";";
		}
		temp = temp + "\n";
		return temp;
	}

	public String cincoMenores() {
		String temp = "";
		for (int i = 30 - contaObjetos; i < 35 - contaObjetos; i++) {

			temp = temp + ordenado[i] + " - ";

		} // for
		temp = temp + "\n";
		return temp;
	}

	public String cincoMaiores() {
		String temp = "";
		for (int i = 25; i < 30; i++) {

			temp = temp + ordenado[i] + " - ";

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

		for (int i = 0; i < 5; i++) {

		}

		System.out.println("A soma dos valores é: " + somaValores);
		System.out.println("A quantidade de valores é: " + contaObjetos);
		System.out.println("A média dos valores é: " + (somaValores / contaObjetos));

		System.out.println("Números ordenados do menor para o maior");
		System.out.println(this.ordenaArray());

		System.out.println("array de inteiros");
		System.out.println(this.mostraArrayInteiros());

		System.out.println("O tesouro de maior valor é: " + maiorValor);
		System.out.println("O tesouro de menor valor é: " + menorValor);

		System.out.println("Os 5 tesouros de maior valor são: ");
		System.out.println(this.cincoMaiores());
		System.out.println("Os 5 tesouros de menor valor são: ");
		System.out.println(this.cincoMenores());

	}

	public ImageIcon buildImage() {

		return LoadImage.getInstance().getIcon("furbot(50x70).jpg");
	}

	public static void main(String[] args) {
		MundoVisual.iniciar("Lista5Ex08.xml");
	}
}
