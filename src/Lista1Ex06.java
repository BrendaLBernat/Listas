import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;

public class Lista1Ex06 extends Furbot {
	
	public void inteligencia () throws Exception {
		andarAbaixo();
		andarDireita();
		andarAbaixo();
		andarDireita();
		andarAbaixo();
		andarDireita();
		
		
	}
	
	public static void main (String args[]) {
		MundoVisual.iniciar("Lista1Ex06.xml");
		
	}

}
