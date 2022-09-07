package com.d14.task.writer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWriter implements Writer {

	private Path filePath;
	private boolean openToWrite = true;

	public FileWriter(String path) {
		this.filePath = Paths.get(path);
	}

	public void write(String input) {

		if (openToWrite) {
			try {
				
				createFileIfNotExists();
				Files.write(filePath, input.getBytes());
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}
	}

	public String output() {
		if (!Files.exists(filePath)) {
			return "";
		}
		try {
			return new String(Files.readAllBytes(filePath));
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}

	public void close() {
		openToWrite = false;
	}

	public void createFileIfNotExists() throws IOException {

		if (!Files.exists(filePath)) {
			Files.createFile(filePath);
		}
	}

}
