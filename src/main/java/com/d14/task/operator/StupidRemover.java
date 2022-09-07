package com.d14.task.operator;

import java.util.function.Function;

public class StupidRemover implements Function<String, String> {

	public String apply(String input) {

		if (input == null) {
			return "";
		}
		return input.replaceAll("stupid", "s*****");
	}
}
