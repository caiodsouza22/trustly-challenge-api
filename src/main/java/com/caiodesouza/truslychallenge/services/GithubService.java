package com.caiodesouza.truslychallenge.services;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.caiodesouza.truslychallenge.dto.GithubFileDTO;
import com.caiodesouza.truslychallenge.dto.GithubRepoDTO;
import com.caiodesouza.truslychallenge.utils.ZipScraperUtils;

@Service
public class GithubService {

	private static final String GIT_HUB_URL = "https://github.com/";

	public String getUrlFromRepository(String owner, String repo) {
		if (StringUtils.isBlank(repo) || StringUtils.isBlank(owner)) {
			throw new IllegalArgumentException("Owner or Repo must not be null");
		}
		return (GIT_HUB_URL.concat(owner).concat("/").concat(repo) + "/archive/master.zip");
	}

	@Async
	public GithubRepoDTO extractEveryFileFromRepository(String owner, String repo) throws IOException {
		final String baseURL = this.getUrlFromRepository(owner, repo);
		List<GithubFileDTO> list = ZipScraperUtils.findRepositoryByOwnerAndRepoName(baseURL);
		GithubRepoDTO dto = new GithubRepoDTO();
		dto.setRepositoryFiles(list.stream().collect(Collectors.groupingBy(w -> w.getType())));
		dto.setUser(owner);
		dto.setRepository(repo);
		return dto;

	}

}
