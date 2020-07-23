import javax.swing.ImageIcon;

import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.suporte.LoadImage;

public class Lista2Ex01 extends Furbot {
	
	public void inteligencia() throws Exception {
		diga ("mundo de furbot");
		
		while (!ehFim (DIREITA)) {
			andarDireita();
			
		} //fim do while
		diga ("cheguei no fim da linha!");
	}
	
    public ImageIcon buildImage() {
       
          return LoadImage.getInstance().getIcon("furbot(50x70).jpg");
    }

	public static void main(String[] args) {
		MundoVisual.iniciar("Lista2Ex01.xml");

	}

}