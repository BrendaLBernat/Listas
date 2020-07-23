
import javax.swing.ImageIcon;

import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.ObjetoDoMundo;
import br.furb.furbot.suporte.LoadImage;

public class Lista5Ex02 extends Furbot {
	// atributos
	double numero = 0;
	boolean bol = false;
	int contaInteiros = 0;
	int contaBooleanos = 0;
	int contaObjetos = 0;
	String valorDoPersonagem;

	public static final int MaxInteiros = 40;
	public static final int MaxObjetos = 40;

	double[] inteiros = new double[MaxInteiros];
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
			diga("numero: " + numero);

			inteiros[contaInteiros] = numero;
			contaInteiros++;
		}

	}

	public String mostraArrayInteiros() {
		String temp = "";
		for (int i = 0; i < MaxInteiros; i++) {
			temp = temp + inteiros[i] + " - ";
		} // for
		temp = temp + "\n";
		return temp;
	}

	public String procuraElemento() { // // PEGA O ARRAY NUMERO POR NUMERO E VE SE O INDEX DELE É PAR OU IMPAR E
										// MULTIPLICAR POR 1.1 OU 0.9
		String elemento = "";
		for (int i = 0; i < MaxInteiros; i++) {
			if (i % 2 == 0) {
				elemento = elemento + inteiros[i] * 1.1 + " - ";
			} else {
				elemento = elemento + inteiros[i] * 0.9 + " - ";
			}
		} // for
		elemento = elemento + "\n";
		return elemento;
	}

	public void inteligencia() throws Exception {
		diga("Lista5Ex01");

		boolean controlaLoop;

		controlaLoop = true; // "flag" ou bandeira

		while (controlaLoop == true) {

			while (!ehFim(DIREITA)) {
				converte(DIREITA);
				andarDireita();
			} // while

			if (!ehFim(ABAIXO)) {// se nao eh fim abaixo, executa o bloco

				converte(ABAIXO);
				andarAbaixo();
				while (!ehFim(ESQUERDA)) {
					converte(ESQUERDA);
					andarEsquerda();
				} // while
				if (!ehFim(ABAIXO)) {
					converte(ABAIXO);
					andarAbaixo();
				} else {
					controlaLoop = false;// encerra o laco de repeticao
				}
			} else {
				controlaLoop = false; // encerra o laco de repeticao
			}
		} // while
		diga("fim do zigue-zague horizontal");

		System.out.println("array de inteiros");
		System.out.println(this.mostraArrayInteiros());
		System.out.println("array de inteiros alterados");
		System.out.println(this.procuraElemento());
	}

	public ImageIcon buildImage() {

		return LoadImage.getInstance().getIcon("groot.png");
	}

	public static void main(String[] args) {
		MundoVisual.iniciar("Lista5Ex02.xml"); // inicia o mundo do furbot
	}
}
