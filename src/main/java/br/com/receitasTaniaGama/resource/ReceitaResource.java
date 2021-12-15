package br.com.receitasTaniaGama.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.receitasTaniaGama.model.dto.ReceitaDTO;
import br.com.receitasTaniaGama.service.ReceitaService;

@RestController
@RequestMapping(value = "/receita")
public class ReceitaResource {
	
	private static final String ID = "/{id}";
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private ReceitaService service;
	
	@GetMapping
	public ResponseEntity<List<ReceitaDTO>> findAll(){		
		return ResponseEntity.ok()
				.body(service.findAll().stream()
						.map(x -> mapper.map(x,  ReceitaDTO.class))
						.collect(Collectors.toList()));
	}
	
	@PostMapping
	public ResponseEntity<ReceitaDTO> create(@RequestBody ReceitaDTO obj) {
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest().path(ID).buildAndExpand(service.create(obj)).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping(value = ID)
	public ResponseEntity<ReceitaDTO> findById(@PathVariable Integer id) {
		return ResponseEntity.ok().body(mapper.map(service.findById(id), ReceitaDTO.class));
	}
	
	@DeleteMapping(value = ID)
	public ResponseEntity<ReceitaDTO> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = ID)
	public ResponseEntity<ReceitaDTO> update(@PathVariable Integer id, @RequestBody ReceitaDTO obj) {
		obj.setId(id);
		return ResponseEntity.ok().body(mapper.map(service.update(obj), ReceitaDTO.class));
	}
}
