package br.com.receitasTaniaGama.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.receitasTaniaGama.model.Usuario;
import br.com.receitasTaniaGama.model.dto.UsuarioDTO;
import br.com.receitasTaniaGama.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	UsuarioRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public Usuario create(UsuarioDTO objDTO) {
		objDTO.setId(null);
		objDTO.setSenha(encoder.encode(objDTO.getSenha()));		
		return repository.save(mapper.map(objDTO, Usuario.class));
	}

}
