package br.com.receitasTaniaGama.service.exceptions;

public class IllegalArgumentException extends RuntimeException{
	private static final long serialVersionUID = 9196946629588715773L;

	public IllegalArgumentException(String message) {
		super(message);
	}
}
