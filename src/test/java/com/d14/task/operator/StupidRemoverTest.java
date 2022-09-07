package com.d14.task.operator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.function.Function;

import org.junit.Test;

public class StupidRemoverTest {

	
	@Test
	public void testSuccess() {

		String content = "Replace stupid from string";
		String desired = "Replace s***** from string";
		Function<String, String> remover = new StupidRemover();
		
		String output = remover.apply(content);
		
		assertEquals(desired, output);
		
	}
	
	
	@Test
	public void testFail() {

		String content = "Replace stupid from string";
		Function<String, String> remover = new StupidRemover();
		
		String output = remover.apply(content);
		assertTrue(!content.equals(output));
		
	}

}
