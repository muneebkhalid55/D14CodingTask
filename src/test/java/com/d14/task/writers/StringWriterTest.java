package com.d14.task.writers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.d14.task.writer.StringWriter;
import com.d14.task.writer.Writer;

public class StringWriterTest {
	
	@Test
	public void testWhenContentIsWritten() {
		
		String content = "This is data to test";
		Writer writer = new StringWriter();
		writer.write(content);
		assertEquals(content, writer.output());
		
	}
	
	@Test
	public void testWhenCloseIsCalled() {
		
		String content = "This is data to test";
		Writer writer = new StringWriter();
		writer.write(content);
		writer.close();
		writer.write("more content");
		assertEquals(content, writer.output());
		
	}
	

}
