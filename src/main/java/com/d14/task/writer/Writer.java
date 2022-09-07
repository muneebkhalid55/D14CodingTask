package com.d14.task.writer;

public interface Writer {

	void write(String data);

	String output();

	void close();
}