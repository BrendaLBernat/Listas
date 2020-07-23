import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;

public class Lista1Ex02 extends Furbot {
	
	public void inteligencia () throws Exception {
		andarAbaixo();
		andarAbaixo();
		
	}
	
	public static void main (String args[]) {
		MundoVisual.iniciar("Lista1Ex02.xml");
		
	}

}
