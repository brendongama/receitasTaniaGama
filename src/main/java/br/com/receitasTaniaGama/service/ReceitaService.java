package br.com.receitasTaniaGama.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.receitasTaniaGama.model.Receita;
import br.com.receitasTaniaGama.model.dto.ReceitaDTO;
import br.com.receitasTaniaGama.repository.ReceitasRepository;
import br.com.receitasTaniaGama.service.exceptions.ObjectNotFoundException;

@Service
public class ReceitaService {

	@Autowired
	private ReceitasRepository repository;
	
	@Autowired
	private ModelMapper mapper;
	
	public Receita create(ReceitaDTO obj) {
		return repository.save(mapper.map(obj, Receita.class));
	}
	
	public Receita update(ReceitaDTO obj) {
		findById(obj.getId());
		return repository.save(mapper.map(obj, Receita.class));
	}
	
	public Receita findById(Integer id) {
		Optional<Receita> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Receita> findAll() {
		return repository.findAll();
	}
	
	public void delete(Integer id) {
		findById(id);
		repository.deleteById(id);			
	}
}
