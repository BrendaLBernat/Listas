import javax.swing.ImageIcon;

import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Numero;
import br.furb.furbot.suporte.LoadImage;

public class Lista2Ex15 extends Furbot {

	public void inteligencia() throws Exception {

		limparConsole();
		diga("mundo de furbot");

		Numero personagemNumero = new Numero();

		int somaDosNumeros = 0;

		// o metodo getObjeto (direcao) retorna um manipulador
		// que permite ao programador "conversar" com aquele objeto
		// Entao, se encontramos um objeto do tipo "Numero" a nossa
		// direita, pegamos ele da seguinte forma:
		// personagemNumero = getObjeto(DIREITA).
		// --------------------------------------------
		// Uma vez que temos um "manipulador" para o personagemNumero,
		// podemos perguntar para o personagemNumero qual é o valor dele.
		// Fazemos isto da seguinte forma:
		// 1) declaramos uma variavel String que recebera o valor do personagemNumero em
		// formato String
		// Fazemos isto da seguinte maneira:
		// String valorDoPersonagem = personagemNumero.toString();
		// 2) convertemos o valor em formato String para um formato numerico
		// Fazemos isto da seguinte maneira:
		// int valorConvertido = Integer.parseInt(valorDoPersonagem);
		// 3) agora podemos utilizar este "valorConvertido" em operacoes aritmeticas
		// quaisquer.
		// ------------------------------------------------------------------------

		// Voltando ao problema, temos que andar pelo perimetro realizando a soma dos
		// numeros
		// encontrados no trajeto. Ao iniciar um novo trecho, zeramos a soma e
		// reiniciamos
		// a contagem
		// ---------------------------------------------------------------------------------

		// faz a soma dos numeros encontrados na 1a linha
		while (!ehFim(DIREITA)) {
			if (ehObjetoDoMundoTipo("Numero", DIREITA)) {
				// "pego" o objeto do tabuleiro e armazeno em "personagemNumero"
				personagemNumero = getObjeto(DIREITA);

				// converto o "personagemNumero" em seu valor numerico do tipo inteiro
				String valorDoPersonagem = personagemNumero.toString();
				int valor = Integer.parseInt(valorDoPersonagem);

				somaDosNumeros = somaDosNumeros + valor;
				diga("soma ate agora = " + somaDosNumeros);
				// soma da primeira linha ok
			}
			andarDireita();
		} // while

		diga("Encontrei a soma de: " + somaDosNumeros + "  na primeira linha");

		// reinicia o valor da soma
		somaDosNumeros = 0;
		// agora vai continuar o perimetro andando na ultima coluna

		while (!ehFim(ABAIXO)) {
			if (ehObjetoDoMundoTipo("Numero", ABAIXO)) {
				// pego o objeto e armazeno em "personagemNumero"
				personagemNumero = getObjeto(ABAIXO);
				// converto o "personagemNumero" em int de novo
				String valorDoPersonagem = personagemNumero.toString();
				int valor = Integer.parseInt(valorDoPersonagem);

				somaDosNumeros = somaDosNumeros + valor;
				diga("soma ate agora = " + somaDosNumeros);
				// soma da ultima coluna ok
			}

			andarAbaixo();

		} // while

		diga("Encontrei a soma de: " + somaDosNumeros + "  na ultima coluna");

		// reinicia o valor da soma
		somaDosNumeros = 0;
		// agora vai continuar o perimetro andando na ultima linha

		while (!ehFim(ESQUERDA)) {
			if (ehObjetoDoMundoTipo("Numero", ESQUERDA)) {

				personagemNumero = getObjeto(ESQUERDA);
				// converto o "personagemNumero" para int
				String valorDoPersonagem = personagemNumero.toString();
				int valor = Integer.parseInt(valorDoPersonagem);

				somaDosNumeros = somaDosNumeros + valor;
				diga("soma ate agora = " + somaDosNumeros);
				// soma da ultima linha ok
			}

			andarEsquerda();

		} // while

		diga("Encontrei a soma de: " + somaDosNumeros + "  na ultima linha");

		// reinicia o valor da soma
		somaDosNumeros = 0;
		// agora vai continuar o perimetro andando na primeira coluna

		while (!ehFim(ACIMA)) {
			if (ehObjetoDoMundoTipo("Numero", ACIMA)) {

				personagemNumero = getObjeto(ACIMA);
				// converto o "personagemNumero" para int
				String valorDoPersonagem = personagemNumero.toString();
				int valor = Integer.parseInt(valorDoPersonagem);

				somaDosNumeros = somaDosNumeros + valor;
				diga("soma ate agora = " + somaDosNumeros);
				// soma da primeira coluna ok
			}

			andarAcima();

		} // while

		diga("Encontrei a soma de: " + somaDosNumeros + "  na primeira coluna");
	}

	public ImageIcon buildImage() {

		return LoadImage.getInstance().getIcon("furbot(50x70).jpg");
	}

	public static void main(String[] args) {
		MundoVisual.iniciar("Lista2Ex15.xml");

	}

}