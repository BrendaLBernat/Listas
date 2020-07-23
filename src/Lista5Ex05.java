import javax.swing.ImageIcon;

import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Numero;
import br.furb.furbot.suporte.LoadImage;

public class Lista5Ex05 extends Furbot {

	public static final int MAX_NUM = 30;
	int[] matriz_numerica = new int[MAX_NUM];

	Numero personagemNumero = new Numero();
	boolean repetir = true;
	int quantidadeDeNumerosNoTabuleiro = 0;
	int somaDosNumerosDoTabuleiro = 0;

	void armazenaNumeros() {
		if (ehObjetoDoMundoTipo("Numero", AQUIMESMO) == true) {
			personagemNumero = getObjeto(AQUIMESMO);
			String valorDoPersonagem0 = personagemNumero.toString();
			int valor = Integer.parseInt(valorDoPersonagem0);
			matriz_numerica[quantidadeDeNumerosNoTabuleiro] = valor;
			quantidadeDeNumerosNoTabuleiro++;
			somaDosNumerosDoTabuleiro = somaDosNumerosDoTabuleiro + valor;
		}
	}

	public void inteligencia() throws Exception {
		diga("Mundo de Furbot - Grupo 8");
		while (repetir == true) {
			while (!ehFim(DIREITA)) {
				armazenaNumeros();
				andarDireita();
			}
			if (!ehFim(ABAIXO)) {
				armazenaNumeros();
				andarAbaixo();
				while (!ehFim(ESQUERDA)) {
					armazenaNumeros();
					andarEsquerda();
				}
				if (!ehFim(ABAIXO)) {
					armazenaNumeros();
					andarAbaixo();
				} else {
					repetir = false;
				}
			} else {
				repetir = false;
			}
		}

		float media = somaDosNumerosDoTabuleiro / quantidadeDeNumerosNoTabuleiro;
		diga("Encontrados: " + quantidadeDeNumerosNoTabuleiro + " Numeros");
		diga("Média correspondente: " + media);
		for (int i = 0; i < MAX_NUM; i++) {
			if (matriz_numerica[i] > media) {
				diga("Número: " + matriz_numerica[i] + " é maior do que a média final de todos os respectivos números");
			}
		}
	}

	public ImageIcon buildImage() {
		return LoadImage.getInstance().getIcon("furbot(50x70).jpg");
	}

	public static void main(String[] args) {
		MundoVisual.iniciar("Lista5Ex05.xml");
	}
}