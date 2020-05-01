package com.crud.action;

import com.crud.util.Util;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class HomeAction extends ActionSupport {

	private String mensagem = Util.getMensagem();
	private String pagina;

	public String home() {
		pagina = "home";
		return HomeAction.SUCCESS;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getPagina() {
		return pagina;
	}

}
