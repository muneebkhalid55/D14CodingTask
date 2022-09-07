package com.d14.task.operator;

import java.util.function.Function;

public class ConsecutiveDuplicateRemover implements Function<String, String> {

	public String apply(String data) {

		if (data == null) {
			return "";
		}

		if (data.contains(" ")) {
			StringBuilder output = new StringBuilder();
			String[] splittedInput = data.split(" ");
			String current = "";

			for (int index = 0; index < splittedInput.length ; index++) {
				if (!splittedInput[index].equals(current)) {
					output = output.append(splittedInput[index] + " ");
					current = splittedInput[index];
				}
			}
			data = output.toString().trim();
		}
		return data;
	}
}
