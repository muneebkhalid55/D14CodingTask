package com.d14.task;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.d14.task.operator.ConsecutiveDuplicateRemover;
import com.d14.task.operator.LowerCaseConverter;
import com.d14.task.operator.StupidRemover;
import com.d14.task.operator.UpperCaseConverter;
import com.d14.task.writer.FileWriter;
import com.d14.task.writer.StringWriter;
import com.d14.task.writer.Writer;

public class ExecutorTest {

	@Test
	public void testWhenContentWrittenToStringWriterWithUpperCaseConverter() {
		String content = "convert to upper case";
		String desired = "CONVERT TO UPPER CASE";
		Writer stringWriter = new StringWriter();
		Function<String, String> converter = new UpperCaseConverter();
		Executor.execute(stringWriter, content, converter);
		assertEquals(stringWriter.output(), desired);
	}

	@Test
	public void testWhenContentWrittenToStringWriterWithLowerCaseConverter() {
		String desired = "convert to upper case";
		String content = "CONVERT TO UPPER CASE";
		Writer stringWriter = new StringWriter();
		Function<String, String> converter = new LowerCaseConverter();
		Executor.execute(stringWriter, content, converter);
		assertEquals(stringWriter.output(), desired);
	}

	@Test
	public void testWhenContentWrittenToStringWriterWithDuplicateRemover() {
		String content = "convert convert to upper case";
		String desired = "convert to upper case";
		Writer stringWriter = new StringWriter();
		Function<String, String> remover = new ConsecutiveDuplicateRemover();
		Executor.execute(stringWriter, content, remover);
		assertEquals(stringWriter.output(), desired);
	}

	@Test
	public void testWhenContentWrittenToStringWriterWithStupidRemover() {
		String content = "Replace stupid from string";
		String desired = "Replace s***** from string";
		Writer stringWriter = new StringWriter();
		Function<String, String> remover = new StupidRemover();
		Executor.execute(stringWriter, content, remover);
		assertEquals(stringWriter.output(), desired);
	}

	@Test
	public void testWhenContentWrittenToStringWriterWithStupidAndDuplicateRemover() {
		String content = "Replace stupid from from string";
		String desired = "Replace s***** from string";
		Writer stringWriter = new StringWriter();
		Function<String, String> stupidMask = new StupidRemover();
		Function<String, String> duplicateRemover = new ConsecutiveDuplicateRemover();

		List<Function<String, String>> combinedOperation = new ArrayList<Function<String, String>>();
		combinedOperation.add(duplicateRemover);
		combinedOperation.add(stupidMask);
		Executor.execute(stringWriter, content, combinedOperation);
		assertEquals(stringWriter.output(), desired);
	}

	@Test
	public void testWhenContentWrittenToFileWriterWithUpperCaseConverter() throws IOException {
		String content = "convert to upper case";
		String desired = "CONVERT TO UPPER CASE";
		String filePath = "test.txt";
		Writer stringWriter = new FileWriter(filePath);
		Function<String, String> converter = new UpperCaseConverter();
		Executor.execute(stringWriter, content, converter);
		assertEquals(stringWriter.output(), desired);
		Files.delete(Paths.get(filePath));
	}

	@Test
	public void testWhenContentWrittenToFileWriterWithLowerCaseConverter() throws IOException {
		String desired = "convert to upper case";
		String content = "CONVERT TO UPPER CASE";
		String filePath = "test.txt";
		Writer stringWriter = new FileWriter(filePath);
		Function<String, String> converter = new LowerCaseConverter();
		Executor.execute(stringWriter, content, converter);
		assertEquals(stringWriter.output(), desired);
		Files.delete(Paths.get(filePath));
	}

	@Test
	public void testWhenContentWrittenToFileWriterWithDuplicateRemover() throws IOException {
		String content = "convert convert to upper case";
		String desired = "convert to upper case";
		String filePath = "test.txt";
		Writer stringWriter = new FileWriter(filePath);
		Function<String, String> remover = new ConsecutiveDuplicateRemover();
		Executor.execute(stringWriter, content, remover);
		assertEquals(stringWriter.output(), desired);
		Files.delete(Paths.get(filePath));
	}

	@Test
	public void testWhenContentWrittenToFileWriterWithStupidRemover() throws IOException {
		String content = "Replace stupid from string";
		String desired = "Replace s***** from string";
		String filePath = "test.txt";
		Writer stringWriter = new FileWriter(filePath);
		Function<String, String> remover = new StupidRemover();
		Executor.execute(stringWriter, content, remover);
		assertEquals(stringWriter.output(), desired);
		Files.delete(Paths.get(filePath));
	}

	@Test
	public void testWhenContentWrittenToFileWriterWithStupidAndDuplicateRemover() throws IOException {
		String content = "Replace stupid from from string";
		String desired = "Replace s***** from string";
		String filePath = "test.txt";
		Writer stringWriter = new FileWriter(filePath);
		Function<String, String> stupidMask = new StupidRemover();
		Function<String, String> duplicateRemover = new ConsecutiveDuplicateRemover();

		List<Function<String, String>> combinedOperation = new ArrayList<Function<String, String>>();
		combinedOperation.add(duplicateRemover);
		combinedOperation.add(stupidMask);
		Executor.execute(stringWriter, content, combinedOperation);
		assertEquals(stringWriter.output(), desired);
		Files.delete(Paths.get(filePath));
	}

}
