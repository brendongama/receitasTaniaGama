package br.com.receitasTaniaGama.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.receitasTaniaGama.model.Usuario;
import br.com.receitasTaniaGama.repository.UsuarioRepository;
import br.com.receitasTaniaGama.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Optional<Usuario> user = repository.findBylogin(login);
		if(user.isPresent()) {
			return new UserSS(user.get().getId(), user.get().getLogin(), user.get().getSenha());
		}
		throw new UsernameNotFoundException(login);
	}

}
