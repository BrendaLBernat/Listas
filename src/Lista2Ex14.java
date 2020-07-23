import javax.swing.ImageIcon;

import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.suporte.LoadImage;

public class Lista2Ex14 extends Furbot {

	public void inteligencia() throws Exception {
		limparConsole();
		diga("mundo de furbot");

		int contaAliens = 0;
	 
		int xDeNascimento = 0;
		int yDeNascimento = 0;

		//armazena temporariamente as coordenadas onde o
		//  Furbot nasceu
		xDeNascimento = getX();
		yDeNascimento = getY();
		
		diga ("Nasci em ("+ xDeNascimento+ "," + yDeNascimento+")");
		
		// como nao sabemos onde o robo nasceu,
		// vamos leva-lo a posicao 0,0
		while (!ehFim(ESQUERDA)) {
			andarEsquerda();
		}
		while (!ehFim(ACIMA)) {
			andarAcima();
		}
		// agora vou andar pelo perimetro contando os Aliens
		// que eu encontrar
		while (!ehFim(DIREITA)) {
			if (ehObjetoDoMundoTipo("Alien", DIREITA)) {
				contaAliens = contaAliens + 1;
			}
			andarDireita();
		}
		while (!ehFim(ABAIXO)) {
			if (ehObjetoDoMundoTipo("Alien", ABAIXO)) {
				contaAliens = contaAliens + 1;
			}
			andarAbaixo();
		}
		while (!ehFim(ESQUERDA)) {
			if (ehObjetoDoMundoTipo("Alien", ESQUERDA)) {
				contaAliens = contaAliens + 1;
			}
			andarEsquerda();
		}
		while (!ehFim(ACIMA)) {
			if (ehObjetoDoMundoTipo("Alien", ACIMA)) {
				contaAliens = contaAliens + 1;
			}
			andarAcima();
		}

		//agora preciso ir ate o local onde nasci
		
		while (getX() < xDeNascimento) {
			// enquanto a posicao x do robo for menor que 
			// a posicao de nascimento, faca o furbot ir
			// ate a posicao x de nascimento
			andarDireita();
		}
		diga ("cheguei na posicao x de nascimento na coluna "+getX());
		while (getY() < yDeNascimento) {
			// enquanto a posicao x do robo for menor que 
			// a posicao de nascimento, faca o furbot ir
			// ate a posicao x de nascimento
			andarAbaixo();
		}
		diga ("cheguei na posicao y de nascimento na linha "+getY());
		
		//agora apresento os resultados
		if (contaAliens > 0) {
			if (contaAliens == 1) {
				diga("Encontrei 1 ALIEN");
			} else {
				diga("Encontrei " + contaAliens + " ALIENS");
			}
		} else {
			diga("Nao encontrei nenhum ALIEN");
		}
				
	}

	public ImageIcon buildImage() {

		return LoadImage.getInstance().getIcon("furbot(50x70).jpg");
	}

	public static void main(String[] args) {
		MundoVisual.iniciar("Lista2Ex14.xml");

	}

}
