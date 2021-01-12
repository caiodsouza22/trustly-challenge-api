package com.caiodesouza.truslychallenge.services.exceptions;

public class ResourceEmptyExpection extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ResourceEmptyExpection(Object msg) {
		super("Repository doesn't have any commit.(" + msg + ")" );
	}
}
