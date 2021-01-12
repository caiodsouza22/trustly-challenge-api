package com.caiodesouza.truslychallenge.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.caiodesouza.truslychallenge.dto.GithubRepoDTO;
import com.caiodesouza.truslychallenge.services.exceptions.ResourceNotFoundException;


public class GithubServiceTest {
	

	@InjectMocks
	private GithubService service;
	
	@MockBean
	private GithubService serviceBean;
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	
	@Before
	public void init() throws IOException {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetUrlFromRepository() {
		
		final String url = service.getUrlFromRepository("caiodsouza22", "DrumKit");
		
		assertNotNull(url);
		assertTrue(url.contains("caiodsouza22"));
		assertTrue(url.contains("DrumKit"));
		
		
	}
	
	@Test
	public void testGetUrlFromRepositoryException() {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("Owner or Repo must not be null");
		
		this.service.getUrlFromRepository("", "DrumKit");		
		
		
	}
	
	@Test
	public void testExtractEveryFileFromRepository() throws IOException {
		final GithubRepoDTO dto = this.service.extractEveryFileFromRepository("caiodsouza22", "DrumKit");
		
	assertNotNull(dto);
	assertNotNull(dto.getRepositoryFiles());
	assertEquals("caiodsouza22", dto.getUser());
	assertEquals("DrumKit", dto.getRepository());
	}
	
	@Test
	public void testExtractEveryFileFromRepositoryException() throws IOException {
		expectedEx.expect(ResourceNotFoundException.class);
		expectedEx.expectMessage("Repository or Owner was not found.");
	  this.service.extractEveryFileFromRepository("caiodsouza22", "DrumKittt");
		
	 
	}
	
}