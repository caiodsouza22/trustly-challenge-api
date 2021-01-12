package com.caiodesouza.truslychallenge.dto;

import java.io.Serializable;


public class GithubFileDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String type;
	private Long lines;
	private String size;
	private String path;
	
	

	public GithubFileDTO(String type, Long lines, String size,String path) {
		super();
		this.type = type;
		this.lines = lines;
		this.size = size;
		this.path =path;
	}
	
	public GithubFileDTO() {
		
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	

	public Long getLines() {
		return lines;
	}

	public void setLines(Long lines) {
		this.lines = lines;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	
	
}
