package com.d14.task.operator;

import java.util.function.Function;

public class UpperCaseConverter implements Function<String, String> {

	public String apply(String input) {

		if (input == null)
			return "";
		return input.toUpperCase();
	}
}
