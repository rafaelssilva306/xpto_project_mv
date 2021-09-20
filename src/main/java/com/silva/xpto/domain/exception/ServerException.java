package com.silva.xpto.domain.exception;

public class ServerException extends RuntimeException {
	  private static final long serialVersionUID = 1L;

	  public ServerException(){
	    super("Ocorreu um problema no servidor. Tente novamente mais tarde.");
	  }
	  
	}