package com.crud.model;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestScoped
public class UsuarioRepository implements Repository<Usuario> {

	private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioRepository.class);

	@Inject
	private EntityManager manager;

	@PostConstruct
	@Override
	public void iniciarTransacao() {
		if (!this.manager.getTransaction().isActive())
			this.manager.getTransaction().begin();
		}


	@Override
	public Usuario busca(Integer id) {
		Usuario u = null;
		try {
			u = this.manager.find(Usuario.class, id);			
		} catch (Exception e) {
			LOGGER.error("Ocorreu erro na busca do usuário!", e);
		}
		return u;
	}


	@Override
	public void adiciona(Usuario usuario) {
		try {
			this.manager.persist(usuario);
			this.manager.getTransaction().commit();

		} catch (Exception e) {
			this.manager.getTransaction().rollback();
			LOGGER.error("Ocorreu erro na inserção do usuário!", e);
		}

	}


	@Override
	public void remove(Integer id) {
		try {
			Usuario usuario = this.manager.find(Usuario.class, id);
			this.manager.remove(usuario);
			this.manager.getTransaction().commit();
		} catch (Exception e) {
			this.manager.getTransaction().rollback();
			LOGGER.error("Ocorreu erro na remoção do usuário!", e);
		}

	}


	@Override
	public void altera(Usuario usuario) {
		try {
			this.manager.merge(usuario);
			this.manager.getTransaction().commit();
		} catch (Exception e) {
			this.manager.getTransaction().rollback();
			LOGGER.error("Ocorreu erro na alteração do usuário!", e);
		}
	}


	@Override
	public List<Usuario> lista() {
		List<Usuario> result = null;
		try {
			TypedQuery<Usuario> query = this.manager.createQuery("select u from Usuario u", Usuario.class);
			result = query.getResultList();
		} catch (Exception e) {
			LOGGER.error("Ocorreu erro na busca dos usuários!", e);
		}
		return result;
	}


	@Override
	public boolean existeUsernameEPassword(String userName, String password) {
		boolean result = false;
		try {
			Query query = this.manager.createQuery("select u from Usuario u where u.userName=:userName and u.password=:password");
			query.setParameter("userName", userName);
			query.setParameter("password", password);
			result = !query.getResultList().isEmpty();
		} catch (Exception e) {
			LOGGER.error("Ocorreu erro na verificação de login e senha do usuário!", e);
		}
		return result;
	}


	@Override
	public boolean existeUsername(String userName) {
		boolean result = false;
		try {
			Query query = this.manager.createQuery("select u from Usuario u where u.userName=:userName");
			query.setParameter("userName", userName);
			result = !query.getResultList().isEmpty();
		} catch (Exception e) {
			LOGGER.error("Ocorreu erro na verificação de login do usuário!", e);
		}
		return result;
	}

}
