import javax.swing.ImageIcon;

import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Numero;
import br.furb.furbot.suporte.LoadImage;

public class Lista4Ex01 extends Furbot {

	Numero personagemNumero = new Numero();
	int somaDosNum = 0;
	int qtdNum = 0;
	String seqNumero = " ";
	int len = 0;

	public void manipulaNum(Direcao direcao) {
		if (!ehVazio(direcao)) {
			personagemNumero = getObjeto(direcao);
			String valorDoPersonagem = personagemNumero.toString();
			int valor = Integer.parseInt(valorDoPersonagem);
			qtdNum++;
			somaDosNum = somaDosNum + valor;
			seqNumero = seqNumero + " - " + valorDoPersonagem;
			len = seqNumero.length();

		}
	}

	public void inteligencia() throws Exception {

		limparConsole();
		diga("mundo de furbot");

		boolean repetir = true; // flag

		while (repetir == true) {
			while (!ehFim(DIREITA)) {
				manipulaNum(DIREITA);
				andarDireita();
			} // while direita
			if (!ehFim(ABAIXO)) {
				manipulaNum(ABAIXO);
				andarAbaixo();
				while (!ehFim(ESQUERDA)) {
					manipulaNum(ESQUERDA);
					andarEsquerda();
				} //while esquerda
				if (!ehFim(ABAIXO)) {
					manipulaNum(ABAIXO);
					andarAbaixo();
				} else {
					repetir = false;
				}
			} else {
				repetir = false;
			}
		}
		
		diga("A quantidade de numeros encontrados foi:" + qtdNum);
		diga("A media dos numeros encontrados foi:" + (somaDosNum / qtdNum));
		
		if (somaDosNum>50){
			diga("A raiz quadrada do somatorio foi: " + (Math.sqrt(somaDosNum)));
		} else {
			diga("Só devo calcular a raiz se a soma dos números for maior do que 50");
		}	
		diga("A sequencia dos numeros foi:");
		diga(seqNumero.substring(3, len));

	}

	public ImageIcon buildImage() {

		return LoadImage.getInstance().getIcon("furbot(50x70).jpg");
	}

	public static void main(String[] args) {
		MundoVisual.iniciar("Lista4Ex01.xml");

	}

}