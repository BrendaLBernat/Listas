import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;

public class Lista1Ex01 extends Furbot {
	
	public void inteligencia () throws Exception {
		andarDireita();
		andarDireita();
		andarDireita();
		
	}
	
	public static void main (String args[]) {
		MundoVisual.iniciar("Lista1Ex01.xml");
		
	}

}
