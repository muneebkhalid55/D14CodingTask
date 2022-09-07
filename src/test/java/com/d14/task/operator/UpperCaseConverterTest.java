package com.d14.task.operator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.function.Function;

import org.junit.Test;

public class UpperCaseConverterTest {
	
	@Test
	public void testSuccess() {
		String content = "convert";
		String desired = "CONVERT";
		Function<String, String> upperCaseConverter = new UpperCaseConverter();

		String upperCase = upperCaseConverter.apply(content);

		assertEquals(desired, upperCase);

	}
	
	@Test
	public void testFailure() {
		String content = "convert";
		Function<String, String> upperCaseConverter = new UpperCaseConverter();
		String upperCase = upperCaseConverter.apply(content);
		assertTrue(!content.equals(upperCase));
	}
	
	
}

