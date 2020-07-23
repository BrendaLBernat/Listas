import javax.swing.ImageIcon;

import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.suporte.LoadImage;

public class Lista2Ex10 extends Furbot {
	
	public void inteligencia() throws Exception {
		diga ("mundo de furbot");
		boolean repetir = true;
		
		while (repetir == true) {
			while (!ehFim(ABAIXO)) {
				andarAbaixo();
			} // while
			if (!ehFim(DIREITA)) {// se nao eh fim abaixo, executa o bloco
				andarDireita();
				while (!ehFim(ACIMA)) {
					andarAcima();
				} // while
				if (!ehFim(DIREITA)) {
					andarDireita();
				} else {
					repetir = false;// encerra o laco de repeticao
				}
			} else {
				repetir = false; // encerra o laco de repeticao
			}
		} // while
		diga("fim do zigue-zague vertical");


	}
	
    public ImageIcon buildImage() {
       
          return LoadImage.getInstance().getIcon("furbot(50x70).jpg");
    }

	public static void main(String[] args) {
		MundoVisual.iniciar("Lista2Ex10.xml");

	}

}
