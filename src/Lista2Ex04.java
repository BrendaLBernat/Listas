import javax.swing.ImageIcon;

import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.suporte.LoadImage;

public class Lista2Ex04 extends Furbot {
	
	public void inteligencia() throws Exception {
		diga ("mundo de furbot");
		
		while (!ehFim (DIREITA)) {
			andarDireita();
		} //fim do while
		diga ("cheguei no canto superior direito");
		
		while (!ehFim(ABAIXO)) {
			andarAbaixo();
		} //fim do segundo while
		diga ("cheguei no canto inferior direito");
		
		while (!ehFim (ESQUERDA)) {
			andarEsquerda();
		}//fim terceiro while
		diga ("cheguei no canto inferior esquerdo");
		
		while (!ehFim(ACIMA)) {
			andarAcima();
		} //fim do quarto while
		diga("cheguei no canto superior esquerdo");
		
	}
	
    public ImageIcon buildImage() {
       
          return LoadImage.getInstance().getIcon("furbot(50x70).jpg");
    }

	public static void main(String[] args) {
		MundoVisual.iniciar("Lista2Ex04.xml");

	}

}