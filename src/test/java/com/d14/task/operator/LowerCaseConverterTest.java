package com.d14.task.operator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.function.Function;

import org.junit.Test;

public class LowerCaseConverterTest {

	@Test
	public void testSuccess() {
		String content = "CONVERT";
		String desired = "convert";
		Function<String, String> lowerCaseConverter = new LowerCaseConverter();

		String loweredCase = lowerCaseConverter.apply(content);

		assertEquals(desired, loweredCase);

	}
	
	@Test
	public void testFailure() {
		String content = "CONVERT";
		Function<String, String> lowerCaseConverter = new LowerCaseConverter();
		String loweredCase = lowerCaseConverter.apply(content);
		assertTrue(!content.equals(loweredCase));
	}
}
