package com.crud.facade;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.crud.model.Usuario;
import com.crud.repository.UsuarioRepository;

@RequestScoped
public class UsuarioFacadeImpl implements UsuarioFacade {
	
	@Inject
	UsuarioRepository usuarioRepository;

	@Override
	public Usuario busca(Integer id) throws Exception {
		
		return usuarioRepository.busca(id);
	}


	@Override
	public void adiciona(Usuario usuario) throws Exception {
		
		usuarioRepository.adiciona(usuario);
	}


	@Override
	public void remove(Integer id) throws Exception {
		
		usuarioRepository.remove(id);

	}


	@Override
	public void altera(Usuario usuario) throws Exception {
		
		usuarioRepository.altera(usuario);
	}


	@Override
	public List<Usuario> lista() throws Exception {
		
		return usuarioRepository.lista();
	}


	@Override
	public boolean existeUsernameEPassword(String userName, String password) throws Exception {
		
		return usuarioRepository.existeUsernameEPassword(userName, password);
	}


	@Override
	public boolean existeUsername(String userName) throws Exception {
		
		return usuarioRepository.existeUsername(userName);
	}

}
