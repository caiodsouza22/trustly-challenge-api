package com.caiodesouza.truslychallenge.resourcers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.caiodesouza.truslychallenge.dto.GithubRepoDTO;
import com.caiodesouza.truslychallenge.services.GithubService;

@RestController
@RequestMapping(value = "/github")
public class GithubResource {

	@Autowired
	GithubService service;
	

	@GetMapping(value = "/repository")
	public ResponseEntity<GithubRepoDTO> findRepoByOwnerAndRepoName(
			@RequestParam(name = "owner", required = true) final String owner,
			@RequestParam(name = "repo", required = true) final String repo) throws IOException {
		final GithubRepoDTO list = service.extractEveryFileFromRepository(owner, repo);
		return  ResponseEntity.ok().body(list);
			
				
		
			
	}
}
