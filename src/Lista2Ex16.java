import javax.swing.ImageIcon;

import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Numero;
import br.furb.furbot.suporte.LoadImage;

public class Lista2Ex16 extends Furbot {

	public void inteligencia() throws Exception {

		Numero personagemNumero = new Numero();
		int somaDosNumerosLinha = 0;
		int maiorValor = 0;
		int numLinhaMaiorValor = 0;

		limparConsole();
		diga("mundo de furbot");

		boolean repetir = true; // "flag" ou bandeira

		while (repetir == true) {
			// faz a soma dos numeros encontrados na 1a linha
			while (!ehFim(DIREITA)) {
				if (ehObjetoDoMundoTipo("Numero", DIREITA)) {
					// "pego" o objeto do tabuleiro e armazeno em "personagemNumero"
					personagemNumero = getObjeto(DIREITA);

					// converto o "personagemNumero" em seu valor numerico do tipo inteiro
					String valorDoPersonagem = personagemNumero.toString();
					int valor = Integer.parseInt(valorDoPersonagem);

					somaDosNumerosLinha = somaDosNumerosLinha + valor;
					// diga(personagemNumero.toString() + " - "+ valor);
					diga("soma da linha " + getY() + " = " + somaDosNumerosLinha);
				}
				andarDireita();
			} // while

			if (somaDosNumerosLinha > maiorValor) {
				maiorValor = somaDosNumerosLinha;
				numLinhaMaiorValor = getY();
			}
			somaDosNumerosLinha = 0; // zerei pra começar a contar

			if (!ehFim(ABAIXO)) {// se nao eh fim abaixo, executa o bloco
				andarAbaixo();
				if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
					personagemNumero = getObjeto(AQUIMESMO);
					String valorDoPersonagem = personagemNumero.toString();
					int valor = Integer.parseInt(valorDoPersonagem);

					somaDosNumerosLinha = somaDosNumerosLinha + valor;
				}
				diga("soma da linha" + getY() + " = " + somaDosNumerosLinha);
			} else {
				repetir = false;
			}

			while (!ehFim(ESQUERDA)) {
				if (ehObjetoDoMundoTipo("Numero", ESQUERDA)) {
					// "pego" o objeto do tabuleiro e armazeno em "personagemNumero"
					personagemNumero = getObjeto(ESQUERDA);

					// converto o "personagemNumero" em seu valor numerico do tipo inteiro
					String valorDoPersonagem = personagemNumero.toString();
					int valor = Integer.parseInt(valorDoPersonagem);

					somaDosNumerosLinha = somaDosNumerosLinha + valor;
					// diga(personagemNumero.toString() + " - "+ valor);
					diga("soma da linha" + getY() + " = " + somaDosNumerosLinha);
				}
				andarEsquerda();
			} // while

			if (somaDosNumerosLinha > maiorValor) {
				maiorValor = somaDosNumerosLinha;
				numLinhaMaiorValor = getY();
			}
			somaDosNumerosLinha = 0; // zerei pra começr a contar

			if (!ehFim(ABAIXO)) {// se nao eh fim abaixo, executa o bloco
				andarAbaixo();
				if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
					personagemNumero = getObjeto(AQUIMESMO);
					String valorDoPersonagem = personagemNumero.toString();
					int valor = Integer.parseInt(valorDoPersonagem);

					somaDosNumerosLinha = somaDosNumerosLinha + valor;
				}
				diga("soma da linha" + getY() + " = " + somaDosNumerosLinha);

			} else {
				repetir = false;
			}

		}
		repetir = false;

		diga("a linha de maior soma é: " + numLinhaMaiorValor);
		diga("a soma é: " + maiorValor);
	}

	public ImageIcon buildImage() {

		return LoadImage.getInstance().getIcon("furbot(50x70).jpg");
	}

	public static void main(String[] args) {
		MundoVisual.iniciar("Lista2Ex16.xml");

	}

}