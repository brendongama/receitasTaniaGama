package br.com.receitasTaniaGama.model.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceitaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotNull(message = "O campo titulo é requerido")
	private String titulo;
	
	@NotNull(message = "O ingredientes Titulo é requerido")
	private String ingredientes;
	
	@NotNull(message = "O campo modo de preparo é requerido")
	private String modoPreparo; 
}
