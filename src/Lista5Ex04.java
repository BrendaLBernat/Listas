import javax.swing.ImageIcon;

import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Numero;
import br.furb.furbot.suporte.LoadImage;

public class Lista5Ex04 extends Furbot {

	Numero personagemNumero = new Numero();
	String textoDoPersonagem;
	int valorDoPersonagem;
	int quantidade = 0;
	int soma = 0;
	int media = 0;
	int valorIgualMedia;
	boolean variavelBooleana = true;

	int[] valores = new int[20];

	public void manipulanumeros(Direcao direcao) {
		if (!ehVazio(direcao)) {
			personagemNumero = getObjeto(direcao);
			textoDoPersonagem = personagemNumero.toString();
			valores[quantidade] = Integer.parseInt(textoDoPersonagem);
			quantidade++;
		}
	}

	public void inteligencia() throws Exception {
		limparConsole();
		diga("mundo de furbot");

		boolean controlaLoop;

		controlaLoop = true; // "flag" ou bandeira

		while (controlaLoop == true) {
			while (!ehFim(DIREITA)) {
				manipulanumeros(DIREITA);
				andarDireita();
			}

			if (!ehFim(ABAIXO)) {
				manipulanumeros(ABAIXO);
				andarAbaixo();

				while (!ehFim(ESQUERDA)) {
					manipulanumeros(ESQUERDA);
					andarEsquerda();
				}

				if (!ehFim(ABAIXO)) {
					manipulanumeros(ABAIXO);
					andarAbaixo();
				} else {
					controlaLoop = false;
				}
			} else {
				controlaLoop = false;
			}
		}
		for (int i = 0; i < quantidade; i++) {

			diga("Mostre : " + valores[i]);
			soma = soma + valores[i];
			media = soma / quantidade;
		}

		for (int i = 0; i < quantidade; i++) {
			if (valores[i] == media) {
				variavelBooleana = true;
				valorIgualMedia = media;
			}
		}
		if (valorIgualMedia == media) {
			diga("Há possíveis números iguais a média");
		} else {
			diga("Não há números iguais a média");
		}

		diga("Soma total: " + soma);
		diga("Média: " + media);
	}

	public ImageIcon buildImage() {

		return LoadImage.getInstance().getIcon("furbot(50x70).jpg");
	}

	public static void main(String[] args) {
		MundoVisual.iniciar("Lista5Ex04.xml");

	}
}
