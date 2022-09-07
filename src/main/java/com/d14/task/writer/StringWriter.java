package com.d14.task.writer;

public class StringWriter implements Writer {

	private StringBuilder data = new StringBuilder();
	private boolean openToWrite = true;

	public void write(String input) {

		if (openToWrite && input != null) {
			data = data.append(input);
		}
	}

	public String output() {
		return data.toString();
	}

	public void close() {
		openToWrite = false;
	}
}
