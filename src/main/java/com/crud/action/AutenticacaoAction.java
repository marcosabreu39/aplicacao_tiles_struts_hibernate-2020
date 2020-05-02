package com.crud.action;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crud.model.Usuario;
import com.crud.repository.UsuarioRepository;
import com.crud.util.Util;
import com.opensymphony.xwork2.ActionSupport;

@RequestScoped
@SuppressWarnings("serial")
public class AutenticacaoAction extends ActionSupport {

	private static final Logger LOGGER = LoggerFactory.getLogger(AutenticacaoAction.class);

	@Inject
	private Usuario usuario;
	private String mensagem = Util.getMensagem();
	private String pagina;
	@Inject
	UsuarioRepository repository;
	
	public String login() {		
		this.pagina = "login";		
		return AutenticacaoAction.SUCCESS;
		
	}

	public String logon() {
		String retorno = "";
		try {
			if (this.usuario.getUserName() == null || this.usuario.getPassword() == null) {
				this.pagina = "login";
				retorno = AutenticacaoAction.INPUT;
			} else {
				if (repository.existeUsernameEPassword(this.usuario.getUserName(), this.usuario.getPassword())) {
					HttpSession session = ServletActionContext.getRequest().getSession(true);
					session.setAttribute("usuario", this.usuario.clone());
					this.mensagem = "Autenticação realizada com sucesso!";
					Util.setMensagem(mensagem);
					Util.apagarMsg(1);
					pagina = "home";
					retorno = AutenticacaoAction.SUCCESS;
					LOGGER.info(mensagem);
				} else {
					this.mensagem = "Usuário e/ou senha incorretos!";
					Util.setMensagem(mensagem);
					Util.apagarMsg(1);
					this.pagina = "login";
					retorno = AutenticacaoAction.INPUT;
					LOGGER.info(mensagem);
				}
			}
		} catch (Exception e) {
			LOGGER.error("Ocorreu erro no controle de acesso!", e);
		}
		return retorno;

	}

	public String logout() {
		try {
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.removeAttribute("usuario");
			this.mensagem = "Até logo!";
			Util.setMensagem(mensagem);
			Util.apagarMsg(1);
			this.pagina = "login";
			LOGGER.info("Logout realizado com sucesso!");
		} catch (Exception e) {
			LOGGER.error("Ocorreu erro para realizar o logout!", e);
		}
		return AutenticacaoAction.SUCCESS;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
