package com.d14.task.writers;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

import com.d14.task.writer.FileWriter;
import com.d14.task.writer.Writer;

public class FileWriterTest {

	
	@Test
	public void testWhenContentIsWritten() throws IOException {
		String content = "This is data to test";
		String filePath = "test.txt";
		Writer writer = new FileWriter(filePath);
		writer.write(content);
		assertEquals(content, writer.output());
		Files.delete(Paths.get(filePath));
	}

	@Test
	public void testWhenCloseIsCalled() throws IOException {
		String content = "This is data to test";
		
		String filePath = "test.txt";
		Writer writer = new FileWriter(filePath);
		writer.write(content);
		writer.write(content);
		assertEquals(content, writer.output());
		Files.delete(Paths.get(filePath));
		
	}
	
}
