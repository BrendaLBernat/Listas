import java.util.Arrays;
import javax.swing.ImageIcon;
import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.ObjetoDoMundo;
import br.furb.furbot.suporte.LoadImage;

public class Lista5Ex06 extends Furbot {

	public static final int MaxInteiros = 30;
	public static final int ArrayOrdenado = 30;
	public static final int MaxObjetos = 30;

	int numero = 0;
	int armazenaOsNumerosInteiros = 0;
	int ordemNumerosInteiros = 0;
	String valorDoPersonagem;

	int[] inteiros = new int[MaxInteiros];
	int[] ordenado = new int[ArrayOrdenado];
	ObjetoDoMundo[] objetos = new ObjetoDoMundo[MaxObjetos];

	public void colocaNumerosInteirosEmOrdem(Direcao dir) {
		ObjetoDoMundo obj = this.getObjeto(dir);
		if ((ehObjetoDoMundoTipo("Numero", dir) == true)) {
			valorDoPersonagem = obj.toString();
			numero = Integer.parseInt(valorDoPersonagem);
			ordenado[ordemNumerosInteiros] = numero;
			ordemNumerosInteiros++;
		}
	}

	public void numerosArmazenadosPeloCaminho(Direcao dir) {
		ObjetoDoMundo obj = this.getObjeto(dir);
		if ((ehObjetoDoMundoTipo("Numero", dir) == true)) {
			valorDoPersonagem = obj.toString();
			numero = Integer.parseInt(valorDoPersonagem);
			diga("Número inteiro encontrado: " + numero);
			inteiros[armazenaOsNumerosInteiros] = numero;
			armazenaOsNumerosInteiros++;
		}
	}

	public String arrayInteiros() {
		String temp = "";
		for (int i = 0; i < MaxInteiros; i++) {
			temp = temp + inteiros[i] + ";";
		}
		return temp;
	}

	public String ordenaArray() {
		String temp = "";
		for (int i = 0; i < ArrayOrdenado; i++) {
			Arrays.sort(ordenado);
			temp = temp + ordenado[i] + ";";
		}
		return temp;
	}

	public void inteligencia() throws Exception {

		this.limparConsole();
		diga("Mundo de Furbot - Grupo 8");
		boolean controlaLoop;
		controlaLoop = true;
		while (controlaLoop == true) {

			while (!ehFim(DIREITA)) {
				colocaNumerosInteirosEmOrdem(DIREITA);
				numerosArmazenadosPeloCaminho(DIREITA);
				andarDireita();
			}
			if (!ehFim(ABAIXO)) {
				colocaNumerosInteirosEmOrdem(ABAIXO);
				numerosArmazenadosPeloCaminho(ABAIXO);
				andarAbaixo();
				while (!ehFim(ESQUERDA)) {
					colocaNumerosInteirosEmOrdem(ESQUERDA);
					numerosArmazenadosPeloCaminho(ESQUERDA);
					andarEsquerda();
				}
				if (!ehFim(ABAIXO)) {
					colocaNumerosInteirosEmOrdem(ABAIXO);
					numerosArmazenadosPeloCaminho(ABAIXO);
					andarAbaixo();
				} else {
					controlaLoop = false;
				}
			} else {
				controlaLoop = false;
			}
		}
		diga("fim do zigue-zague horizontal");

		System.out.println("Números ordenados do menor para o maior");
		String ordenaArray = this.ordenaArray();
		diga("Números ordenados do menor para maior" + ordenaArray);

		System.out.println(this.ordenaArray() + "\n");
		System.out.println("Posição dos números armazenados no tabuleiro:");
		diga("Posição dos números armazenados no tabuleiro" + arrayInteiros());

		System.out.println(this.arrayInteiros());

	}

	public ImageIcon buildImage() {
		return LoadImage.getInstance().getIcon("furbot(50x70).jpg");
	}

	public static void main(String[] args) {
		MundoVisual.iniciar("Lista5Ex06.xml");
	}
}