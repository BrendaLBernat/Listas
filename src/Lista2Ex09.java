import javax.swing.ImageIcon;

import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.suporte.LoadImage;

public class Lista2Ex09 extends Furbot {
	
	public void inteligencia() throws Exception {
		diga ("mundo de furbot");
		boolean controlaLoop;
		//aqui o sinal de igual representa uma atribuição
		controlaLoop = true; // "flag" ou bandeira

		//aqui o sinal de == representa uma comparação
		while (controlaLoop == true) {
			while (!ehFim(DIREITA)) {
				andarDireita();
			} // while
			if (!ehFim(ABAIXO)) {// se nao eh fim abaixo, executa o bloco
				andarAbaixo();
				while (!ehFim(ESQUERDA)) {
					andarEsquerda();
				} // while
				if (!ehFim(ABAIXO)) {
					andarAbaixo();
				} else {
					controlaLoop = false;// encerra o laco de repeticao
				}
			} else {
				controlaLoop = false; // encerra o laco de repeticao
			}
		} // while
		diga("fim do zigue-zague horizontal");

	}
	
    public ImageIcon buildImage() {
       
          return LoadImage.getInstance().getIcon("furbot(50x70).jpg");
    }

	public static void main(String[] args) {
		MundoVisual.iniciar("Lista2Ex09.xml");

	}

}
