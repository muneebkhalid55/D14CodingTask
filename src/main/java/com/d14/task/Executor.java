package com.d14.task;

import java.util.List;
import java.util.function.Function;

import com.d14.task.writer.Writer;

public class Executor {

	public static void execute(Writer writer, String content, Function<String, String> operation) {
		if (operation != null && writer != null) {
			content = operation.apply(content);
		}
		writer.write(content);
	}

	public static void execute(Writer writer, String content, List<Function<String, String>> operation) {

		if (operation != null && writer != null) {
			for (Function<String, String> op : operation) {
				content = op.apply(content);
			}
		}
		writer.write(content);
	}

	public static void execute(Writer writer, String content) {

		if (writer != null) {
			writer.write(content);
		}
	}
}
