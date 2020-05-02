package com.crud.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crud.model.Usuario;
import com.crud.repository.Repository;
import com.crud.util.Util;
import com.opensymphony.xwork2.ActionSupport;

@RequestScoped
@SuppressWarnings("serial")
public class UsuarioAction extends ActionSupport {

	private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioAction.class);
	private String mensagem = Util.getMensagem();
	private String pagina;
	@Inject
	private Usuario usuario;
	private List<Usuario> usuarios;
	@Inject
	private Repository<Usuario> repository;
	private HttpSession session;

	@PostConstruct
	private void init() {
		usuarios = new ArrayList<>();
	}

	public String adiciona() {
		String retorno = "";
		try {
			if (usuario.getNome() == null || usuario.getNome().equals("") 
					|| usuario.getUserName() == null || usuario.getUserName().equals("") 
					|| usuario.getPassword() == null || usuario.getPassword().equals("")) {
				retorno = UsuarioAction.INPUT;
			} else {
				if (!repository.existeUsernameEPassword(this.usuario.getUserName(), this.usuario.getPassword())) {
					repository.adiciona(this.usuario.clone());
					mensagem = "Cadastro realizado com sucesso!";
					HttpSession session = ServletActionContext.getRequest().getSession();
					session.setAttribute("usuarioNovo", this.usuario.clone());
					Util.setMensagem(mensagem);
					Util.apagarMsg(1);
					retorno = UsuarioAction.SUCCESS;
					LOGGER.info(mensagem);
				} else {
					mensagem = "Usuário já cadastrado!";
					Util.setMensagem(mensagem);
					Util.apagarMsg(1);
					retorno = UsuarioAction.INPUT;
					LOGGER.info(mensagem);
				}
			}
		} catch (Exception e) {
			LOGGER.error("Ocorreu erro na inserção do usuário!", e);
		}
		return retorno;
	}

	public String altera() {
		String retorno = "";
		try {
			session = ServletActionContext.getRequest().getSession();
			if (session.getAttribute("usuario") == null) {
				pagina = "login";
				retorno = UsuarioAction.LOGIN;
			} else {
				if (this.usuario.getId() == null) {
					retorno = UsuarioAction.LOGIN;
				} else {
					session = ServletActionContext.getRequest().getSession();
					if (session.getAttribute("loginUsuarioParaAlterar").equals(this.usuario.getUserName())
							|| !repository.existeUsername(this.usuario.getUserName())) {
						repository.altera(this.usuario.clone());
						mensagem = "Usuário alterado com sucesso!";
						pagina = "usuario";
						Util.setMensagem(mensagem);
						Util.apagarMsg(1);
						retorno = UsuarioAction.SUCCESS;
						LOGGER.info(mensagem);
						session.removeAttribute("loginUsuarioParaAlterar");
					} else {
						mensagem = "Este login já está sendo utilizado!";
						Util.setMensagem(mensagem);
						Util.apagarMsg(1);
						retorno = UsuarioAction.INPUT;
						LOGGER.info(mensagem);
					}
				}
			}
		} catch (Exception e) {
			LOGGER.error("Ocorreu erro na alteração do usuário!", e);
		}
		return retorno;
	}

	public String remove() {
		String retorno = "";
		try {
			session = ServletActionContext.getRequest().getSession();
			if (session.getAttribute("usuario") == null) {
				retorno = UsuarioAction.ERROR;
			} else {			
			repository.remove(this.usuario.getId());
			mensagem = "Usuário removido com sucesso!";
			Util.setMensagem(mensagem);
			Util.apagarMsg(1);
			LOGGER.info(mensagem);
			retorno = UsuarioAction.SUCCESS;
			}
		} catch (Exception e) {
			LOGGER.error("Ocorreu erro na remoção do usuário!", e);
		}
		return retorno;
	}

	public String preparaAlteracao() {
		String retorno = "";
		try {
			session = ServletActionContext.getRequest().getSession();
			if (session.getAttribute("usuario") == null) {
				pagina = "login";
				retorno = UsuarioAction.ERROR;
			} else {
			this.usuario = repository.busca(this.usuario.getId());
			String loginUsuarioParaAlterar = this.usuario.getUserName();
			session = ServletActionContext.getRequest().getSession();
			session.setAttribute("loginUsuarioParaAlterar", loginUsuarioParaAlterar);
			 retorno = UsuarioAction.SUCCESS;
		}
		} catch (Exception e) {
			LOGGER.error("Ocorreu erro na busca do usuário!", e);
		}
		return retorno;
		
	}

	public String lista() {
		String retorno = "";
		try {
			session = ServletActionContext.getRequest().getSession();
			if (session.getAttribute("usuario") != null) {
				this.usuarios = repository.lista();
				pagina = "usuario";
				retorno = UsuarioAction.SUCCESS;
			} else if (session.getAttribute("usuarioNovo") != null) {
				this.usuarios.add((Usuario) session.getAttribute("usuarioNovo"));
				session.removeAttribute("usuarioNovo");
				return UsuarioAction.SUCCESS;
			} else {
				retorno = UsuarioAction.ERROR;
			}
		} catch (Exception e) {
			LOGGER.error("Ocorreu erro para listar o(s) usuário(s)!", e);
		}
		return retorno;

	}

	public String cadastro() {
		pagina = "cadastro";
		return UsuarioAction.SUCCESS;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public String getMensagem() {
		return mensagem;
	}

	public String getPagina() {
		return pagina;
	}

	public void setPagina(String pagina) {
		this.pagina = pagina;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
