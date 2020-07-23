
import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.ObjetoDoMundo;

public class Lista5Ex07 extends Furbot {
	// atributos
	int i = 0;
	int numero = 0;
	boolean bol = false;
	int contaInteiros = 0;
	int contaBooleanos = 0;
	int contaObjetos = 0;
	String valorDoPersonagem;

	public static final int MaxInteiros = 40;
	public static final int MaxBits = 8;
	public static final int MaxObjetos = 40;

	boolean[] vetorBoolean = new boolean[8];
	int[] inteiros = new int[MaxInteiros];
	int[] bits = new int[MaxBits];
	ObjetoDoMundo[] objetos = new ObjetoDoMundo[MaxObjetos];

	public void converte(Direcao dir) {
		ObjetoDoMundo obj = this.getObjeto(dir);
		if (obj != null) {
			if (contaObjetos < MaxObjetos) {
				objetos[contaObjetos] = obj;
			}
			contaObjetos++;
		}
		
		

		if (ehObjetoDoMundoTipo("Alien", AQUIMESMO) == true) {
			i = getX();
			vetorBoolean[i] = true;

			diga("o ET bilu ali na coluna: " + i);

		} else {
			diga("sem ET bilu por aqui");
			i = getX();
			if (vetorBoolean[i] == true){
				// para não mudar um valor true
				
			}else
			vetorBoolean[i] = false;
		}

	}
	
	public String aquiTemEt() {
		String temp = "";
		for (int i = 0; i < 8; i++) {
			
			temp = temp + vetorBoolean[i] + " - ";
			System.out.println (vetorBoolean[i]);
			
			
		} // for
		temp = temp + "\n";
		return temp;
	}

	

	// definicao de comportamento do Furbot
	public void inteligencia() throws Exception {
		diga("Lista5Ex01");

		boolean controlaLoop;
		// aqui o sinal de igual representa uma atribuição
		controlaLoop = true; // "flag" ou bandeira

		// aqui o sinal de == representa uma comparação
		while (controlaLoop == true) {
			// ======================================
			while (!ehFim(DIREITA)) {
				converte(DIREITA);
				andarDireita();
			} // while
				// ======================================
			if (!ehFim(ABAIXO)) {// se nao eh fim abaixo, executa o bloco

				converte(ABAIXO);
				andarAbaixo();
				while (!ehFim(ESQUERDA)) {
					converte(ESQUERDA);
					andarEsquerda();
				} // while
				if (!ehFim(ABAIXO)) {
					converte(ABAIXO);
					andarAbaixo();
				} else {
					controlaLoop = false;// encerra o laco de repeticao
				}
			} else {
				controlaLoop = false; // encerra o laco de repeticao
			}
		} // while
		
		System.out.println("territorio dos aliens");
		System.out.println (this.aquiTemEt());

	}

	public static void main(String[] args) {
		MundoVisual.iniciar("Lista5Ex07.xml"); // inicia o mundo do furbot
	}
}
