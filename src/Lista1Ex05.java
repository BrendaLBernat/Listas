import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;

public class Lista1Ex05 extends Furbot {
	
	public void inteligencia () throws Exception {
		andarDireita();
		andarAbaixo();
		
	}
	
	public static void main (String args[]) {
		MundoVisual.iniciar("Lista1Ex05.xml");
		
	}

}
