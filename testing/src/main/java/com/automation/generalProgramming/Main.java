package com.automation.generalProgramming;

public class Main {

	public static void main(String[] args) {

		System.out.println(fixSpelling("hostleworld"));

	}

	public static String fixSpelling(String name) {

		String wordToCheck = new String(name);

		if (wordToCheck == "hostleworld") {

			name = "hostelworld";

		} else {
			// Exception in thread "main" java.lang.StackOverflowError
			fixSpelling(name); // this line will cause an infinite loop

		}

		return name;

	}

}
