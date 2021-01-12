package com.caiodesouza.truslychallenge.utils;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.MockitoAnnotations;

import com.caiodesouza.truslychallenge.dto.GithubFileDTO;
import com.caiodesouza.truslychallenge.services.exceptions.ResourceNotFoundException;

public class ZipScraperUtilsTest {

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Before
	public void init() throws IOException {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testConvertToStringRepresentationException() throws IOException {
		expectedEx.expect(ResourceNotFoundException.class);
		expectedEx.expectMessage("Repository or Owner was not found.");

		ZipScraperUtils
				.findRepositoryByOwnerAndRepoName("https://github.com/caiodsouza22222/DrumKit/archive/master.zip");
	}

	@Test
	public void testConvertToStringRepresentation() throws IOException {
		final List<GithubFileDTO> filesDTO = ZipScraperUtils
				.findRepositoryByOwnerAndRepoName("https://github.com/caiodsouza22/DrumKit/archive/master.zip");

		assertNotNull(filesDTO);

		assertEquals("DS_Store", filesDTO.get(0).getType());
		assertEquals(1, filesDTO.get(0).getLines());
	}
}
