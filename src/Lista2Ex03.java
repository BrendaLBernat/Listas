import javax.swing.ImageIcon;

import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.suporte.LoadImage;

public class Lista2Ex03 extends Furbot {
	
	public void inteligencia() throws Exception {
		diga ("nasci em: " + getX() + "," + getY());
		
		if (!ehFim (DIREITA)) {
			andarDireita();
			
		} //fim do if
		
		if (!ehFim(ABAIXO)) {
			andarAbaixo();
		} // fim segundo if
		
		diga ("cheguei em:" +getX() + "," +getY());
		
		
	}//fim void
	
		
	
    public ImageIcon buildImage() {
       
          return LoadImage.getInstance().getIcon("furbot(50x70).jpg");
    }

	public static void main(String[] args) {
		MundoVisual.iniciar("Lista2Ex03.xml");

	}

}  //fim do public class