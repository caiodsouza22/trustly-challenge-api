package com.caiodesouza.truslychallenge.dto;

import java.util.List;
import java.util.Map;

public class GithubRepoDTO {
	
	private String user;
	private String repository;
	private Map<String, List<GithubFileDTO>> repositoryFiles;
	
	public GithubRepoDTO(String user, String repository, Map<String, List<GithubFileDTO>> repositoryFiles) {
		super();
		this.user = user;
		this.repository = repository;
		this.repositoryFiles = repositoryFiles;
	}
	
	public GithubRepoDTO() {
		super();
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getRepository() {
		return repository;
	}

	public void setRepository(String repository) {
		this.repository = repository;
	}

	public Map<String, List<GithubFileDTO>> getRepositoryFiles() {
		return repositoryFiles;
	}

	public void setRepositoryFiles(Map<String, List<GithubFileDTO>> repositoryFiles) {
		this.repositoryFiles = repositoryFiles;
	}
	
	

}
