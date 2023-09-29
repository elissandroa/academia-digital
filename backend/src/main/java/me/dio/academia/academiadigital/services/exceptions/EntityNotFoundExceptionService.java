package me.dio.academia.academiadigital.services.exceptions;

public class EntityNotFoundExceptionService extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public EntityNotFoundExceptionService(String msg) {
		super(msg);
	}

}
