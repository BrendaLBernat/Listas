
import javax.swing.ImageIcon;

import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.suporte.LoadImage;

public class Lista2Ex11 extends Furbot {
	
	public void inteligencia() throws Exception {
		diga ("mundo de furbot");
		
		while (ehVazio(DIREITA)) {
			andarDireita();
		}
		
		andarAbaixo();
		andarDireita();
		andarDireita();
		andarAcima();
		
		andarDireita();
		


	}
	
    public ImageIcon buildImage() {
       
          return LoadImage.getInstance().getIcon("furbot(50x70).jpg");
    }

	public static void main(String[] args) {
		MundoVisual.iniciar("Lista2Ex11.xml");

	}

}
