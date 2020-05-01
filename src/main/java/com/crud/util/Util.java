package com.crud.util;

import java.util.Timer;
import java.util.TimerTask;

public class Util extends TimerTask {

	private static Timer timer;

	public static void apagarMsg(int segundos) {
		timer = new Timer();
		timer.schedule(new Util(), segundos * 1000);		
	}

	private static String mensagem;

	public static String getMensagem() {
		return mensagem;
	}

	public static void setMensagem(String mensagem) {
		Util.mensagem = mensagem;			
	}

	@Override
	public void run() {
		mensagem = null;
		timer.cancel();

	}

}
