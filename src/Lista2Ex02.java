import javax.swing.ImageIcon;

import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.suporte.LoadImage;

public class Lista2Ex02 extends Furbot {
	
	public void inteligencia() throws Exception {
		diga ("mundo de furbot");
		
		while (!ehFim (ABAIXO)) {
			andarAbaixo();
			
		} //fim do while
		diga ("cheguei no fim da coluna!");
	}
	
    public ImageIcon buildImage() {
       
          return LoadImage.getInstance().getIcon("furbot(50x70).jpg");
    }

	public static void main(String[] args) {
		MundoVisual.iniciar("Lista2Ex02.xml");

	}

}
