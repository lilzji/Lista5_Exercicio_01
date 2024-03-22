package view;

import java.util.concurrent.Semaphore;

import controller.ThreadMovimentacao;

public class Main {

	public static void main(String[] args) {
		int permissao = 1;
		Semaphore mutex = new Semaphore(permissao);
		for(int id = 0; id < 10; id++) {
			Thread threadMovimentacao = new ThreadMovimentacao(id, mutex);
			threadMovimentacao.start();
		}
	}

}
