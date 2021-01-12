package com.caiodesouza.truslychallenge.services;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.caiodesouza.truslychallenge.dto.GithubFileDTO;
import com.caiodesouza.truslychallenge.utils.ZipScraperUtils;

@Service
public class GithubService {

	private static final String GIT_HUB_URL = "https://github.com/";

	public String getUrlFromRepository(String owner, String repo) {
		if(StringUtils.isBlank(repo) || StringUtils.isBlank(owner)) {
			throw new IllegalArgumentException("Owner and/or Repo must not be null");
		}
		return (GIT_HUB_URL.concat(owner).concat("/").concat(repo) + "/archive/master.zip");
	}

	@Async
	public Map<String, List<GithubFileDTO>> extractEveryFileFromRepository(String baseURL) throws IOException {
		List<GithubFileDTO> list = ZipScraperUtils.findRepositoryByOwnerAndRepoName(baseURL);

		return list.stream().collect(Collectors.groupingBy(w -> w.getType()));

		
	}

}
