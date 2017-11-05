package com.koller.service;

import java.io.Serializable;

public class NegocioException extends Exception implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NegocioException(String msg) {
		super(msg);
	}

}
