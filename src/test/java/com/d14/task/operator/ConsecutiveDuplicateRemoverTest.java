package com.d14.task.operator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ConsecutiveDuplicateRemoverTest {

	
	@Test
	public void testSuccess() {
		
		String content = "This is is it";
		String desired = "This is it";
		ConsecutiveDuplicateRemover remover = new ConsecutiveDuplicateRemover();
		
		String output = remover.apply(content);
		
		assertEquals(desired, output);
	}
	
	
	@Test
	public void testFail() {
		
		String content = "This is is it";
		ConsecutiveDuplicateRemover remover = new ConsecutiveDuplicateRemover();
		String output = remover.apply(content);
		assertTrue(!content.equals(output));
	}
	
}
