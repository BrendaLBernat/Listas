import javax.swing.ImageIcon;

import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Numero;
import br.furb.furbot.suporte.LoadImage;

public class Lista3Ex01 extends Furbot {

	// declaracao das variaveis GLOBAIS DA CLASSE que serao utilizadas no programa
	Numero personagemNumero = new Numero();
	String textoDoPersonagem;
	int valorDoPersonagem;
	int somaDeTodosOsNumeros = 0;
	int somaDaLinha = 0;
	int maiorSomaDaLinha = 0;
	int linhaComMaiorSoma = 0;

	// declaracao de um trecho de codigo que foi batizado com um nome:
	// respostaQuestao1
	// este trecho de codigo recebe o nome de METODO
	// particularmente este METODO recebe como PARAMETRO a direcao que deve ser
	// utilizada para nortear a solucao do problema
	public void manipulaNumeros(Direcao direcao) { // direcao neste caso chama-se PARAMETRO
		if (!ehVazio(direcao)) {
			personagemNumero = getObjeto(direcao);
			textoDoPersonagem = personagemNumero.toString();
			valorDoPersonagem = Integer.parseInt(textoDoPersonagem);
			// aqui acumula todos os valores encontrados
			somaDeTodosOsNumeros = somaDeTodosOsNumeros + valorDoPersonagem;

			// aqui acumula todos os valores da linha atual
			somaDaLinha = somaDaLinha + valorDoPersonagem;
		}

	}// fim do metodo respostaDaQuestao

	public void verificaMaiorSomaDaLinha() {
		diga("soma desta linha= " + somaDaLinha);
		// ao final tenho a soma de todos os numeros encontrados e a soma dos numeros desta linha
		if (somaDaLinha > maiorSomaDaLinha) {
			maiorSomaDaLinha = somaDaLinha;
			linhaComMaiorSoma = getY(); // armazena o numero da linha com maior soma ate aqui
		}
		somaDaLinha = 0;
	}

	public void inteligencia() throws Exception { // ESCOPO DE VARIAVEIS

		limparConsole();
		diga("mundo de furbot");
		// diga ("nasci em: " + getX() + "," + getY());
		// implementa zigue-zague

		boolean controlaLoop;
		// aqui o sinal de igual representa uma atribuição
		controlaLoop = true; // "flag" ou bandeira

		while (controlaLoop == true) {
			// faz o passeio da direita para a esquerda
			somaDaLinha = 0;
			while (!ehFim(DIREITA)) {
				// ----resposta da prova
				manipulaNumeros(DIREITA);
				// -------------------
				andarDireita();
			} // while

			verificaMaiorSomaDaLinha();

			if (!ehFim(ABAIXO)) {// se nao eh fim abaixo, executa o bloco

				somaDaLinha = 0;
				// ----resposta da prova
				manipulaNumeros(ABAIXO);
				// -------------------
				andarAbaixo();

				while (!ehFim(ESQUERDA)) {
					manipulaNumeros(ESQUERDA);
					// -------------------
					andarEsquerda();
				} // while

				verificaMaiorSomaDaLinha();

				if (!ehFim(ABAIXO)) {
					somaDaLinha = 0;
					// ----resposta da prova
					manipulaNumeros(ABAIXO);
					// -------------------

					andarAbaixo();
				} else {
					controlaLoop = false;// encerra o laco de repeticao
				}
			} else {
				controlaLoop = false; // encerra o laco de repeticao
			}
		} // while
		diga("fim do zigue-zague horizontal");
		diga("A soma de TODOS os numeros e: " + somaDeTodosOsNumeros);
		diga("A linha com maior soma é: " + linhaComMaiorSoma);
		diga("E o valor desta soma foi: " + maiorSomaDaLinha);

	}

	public ImageIcon buildImage() {

		return LoadImage.getInstance().getIcon("furbot(50x70).jpg");
	}

	public static void main(String[] args) {
		MundoVisual.iniciar("Lista3Ex01.xml");

	}

}
