package com.caiodesouza.truslychallenge.utils;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.MockitoAnnotations;

public class FormatUtilsTest {
	
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Before
	public void init() throws IOException {
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void testConvertToStringRepresentationException() {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("Invalid file size: 0" );
		FormatUtils.convertToStringRepresentation(0);
		
	}
	
	@Test
	public void testConvertToStringRepresentation() {
		final String result1 = FormatUtils.convertToStringRepresentation(1000l);
		
		assertNotNull(result1);
		assertEquals("1.000 Bytes", result1);
		
		final String result2 = FormatUtils.convertToStringRepresentation(430l);
		
		assertNotNull(result2);
		assertEquals("430 Bytes", result2);
		
		final String result3 = FormatUtils.convertToStringRepresentation(50000l);
		
		assertNotNull(result3);
		assertEquals("48,8 KB", result3);
		
		final String result4 = FormatUtils.convertToStringRepresentation(76000l);
		
		assertNotNull(result4);
		assertEquals("74,2 KB", result4);
		
		final String result5 = FormatUtils.convertToStringRepresentation(100000000l);
		
		assertNotNull(result5);
		assertEquals("95,4 MB", result5);
		
	}
}
