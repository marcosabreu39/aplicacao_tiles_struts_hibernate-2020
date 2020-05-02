package com.crud.util;

import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.crud.model.Usuario;

public class Util extends TimerTask {

	private static Timer timer;

	public static void apagarMensagem(int segundos) throws Exception {
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

	public static boolean ExisteNaSessao(String nomeObj) throws Exception {
		boolean existe = true;
		HttpSession session = ServletActionContext.getRequest().getSession();		
		return existe = session.getAttribute(nomeObj) == null ? false : existe;
	}
	
	public static void colocarNaSessao(String nomeObj, String obj) throws Exception {		
		HttpSession session = ServletActionContext.getRequest().getSession();		
		session.setAttribute(nomeObj, obj);
	}
	
	public static void colocarUsuarioNaSessao(String nomeObj, Usuario usuario) throws Exception {		
		HttpSession session = ServletActionContext.getRequest().getSession();		
		session.setAttribute(nomeObj, usuario);
	}
	
	public static Object pegarDaSessao(String nomeObj) {
		HttpSession session = ServletActionContext.getRequest().getSession();		
		return session.getAttribute(nomeObj);
	}
	
	public static void removerDaSessao(String nomeObj) throws Exception {		
		HttpSession session = ServletActionContext.getRequest().getSession();		
		session.removeAttribute(nomeObj);
	}
	
	public static boolean usuarioValido(Usuario usuario) {
		return usuario != null && nomeValido(usuario) && loginValido(usuario) && senhaValida(usuario);
	}
	
	public static boolean nomeValido(Usuario usuario) {
		return usuario.getNome() != null && !usuario.getNome().equals("");
	}
	
	public static boolean loginValido(Usuario usuario) {
		return usuario.getUserName() != null && !usuario.getUserName().equals("");
	}
	
	public static boolean senhaValida(Usuario usuario) {
		return usuario.getPassword() != null && !usuario.getPassword().equals("");
	}
	
	public static boolean logonValido(Usuario usuario) {
		return loginValido(usuario) && senhaValida(usuario);
	}
}
