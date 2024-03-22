package controller;

import java.util.concurrent.Semaphore;

public class ThreadMovimentacao extends Thread {

	Semaphore mutex;
	private int id;

	public ThreadMovimentacao(int id, Semaphore mutex) {
		this.id = id;
		this.mutex = mutex;

	}

	public void run() {
		movimentacao();
	}

	private void movimentacao() {
		int sentido = (int) ((Math.random() * 4) + 1);
		try {
			mutex.acquire();
			String sentidoString = sentido(sentido);
			System.out.println("Carro #" + (id + 1) + " cruzou " + sentidoString);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			mutex.release();
		}
	}

	private String sentido(int sentido) {
		String sentidoString = "";
		if (sentido == 1) {
			sentidoString = "Norte";
		} else if (sentido == 2) {
			sentidoString = "Sul";
		} else if (sentido == 3) {
			sentidoString = "Leste";
		} else {
			sentidoString = "Oeste";
		}
		return sentidoString;
	}

}
