
import javax.swing.ImageIcon;

import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.Numero;
import br.furb.furbot.ObjetoDoMundo;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.suporte.LoadImage;

public class Lista5Ex09 extends Furbot {

	boolean repetir = true; 

	public static int MAX_NUM = 10; // numero encontrado aleatório = valor
	int[] numeros = new int[MAX_NUM];
	int i = 0;
	boolean bol = false;
	String valorDoPersonagem;
	int booleanoTrue;
	int booleanoFalse;
	int contaBooleano = -1;
	int impares = 0;
	Numero personagemNumero = new Numero();

	public void identificaNumero() { // identifica a quantidade de booleanos

		if (!ehVazio(AQUIMESMO)) {

			if (ehObjetoDoMundoTipo("Numero", AQUIMESMO) == true) {
				personagemNumero = getObjeto(AQUIMESMO);
				String valorDoPersonagem = personagemNumero.toString();
				int valor = Integer.parseInt(valorDoPersonagem);

				MAX_NUM = valor;

			}
		}
	} // identificaNumero

	// pega os booleanos e mostra eles
	public void pegaBooleano(Direcao dir) {
		ObjetoDoMundo obj = this.getObjeto(dir);

		if (contaBooleano < MAX_NUM) {
			if (ehObjetoDoMundoTipo("Booleano", dir) == true) {
				valorDoPersonagem = obj.toString();
				bol = Boolean.parseBoolean(valorDoPersonagem);
				contaBooleano++;
				System.out.print(bol + ", ");

				if (bol == true) {
					booleanoTrue++;
				} else if (bol == false) {
					booleanoFalse++;

					if (contaBooleano % 2 == 0) {
						// faz nada
					} else {
						impares = impares + 1;
					}
				}

			}
		} else {
			repetir = false;
		}
	} // metodo pegaBooleano

	public void inteligencia() throws Exception {

		andarDireita();
		identificaNumero();
		// ando para direita e verifico o numero e coloco ele como valor max do vetor

		while (repetir == true) {
			while (!ehFim(DIREITA)) {
				pegaBooleano(DIREITA);
				andarDireita();
			}
			if (!ehFim(ABAIXO)) {
				pegaBooleano(ABAIXO);
				andarAbaixo();

				while (!ehFim(ESQUERDA)) {
					pegaBooleano(ESQUERDA);
					andarEsquerda();
				}
				if (!ehFim(ABAIXO)) {
					pegaBooleano(ABAIXO);
					andarAbaixo();
				} else
					repetir = false;
			} else
				repetir = false;
		} // while zigue-zague

		System.out.println(" "); // apenas para separar os itens

		System.out.println("a) O valor máximo armazenado é: " + MAX_NUM + " booleanos");
		System.out.println("b) A quantidade de booleanos TRUE é: " + booleanoTrue);
		System.out.println("c) A quantidade de booleanos FALSE em posiçao ímpar é: " + impares);

	}

	public ImageIcon buildImage() {

		return LoadImage.getInstance().getIcon("furbot(50x70).jpg");
	}

	public static void main(String[] args) {
		MundoVisual.iniciar("Lista5Ex09.xml");

	}

}
