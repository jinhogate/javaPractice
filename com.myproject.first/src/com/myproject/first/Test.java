package com.myproject.first;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class Test {
	public static void main(String[] args) throws IOException {
		String message = "";
		System.out.println("message = " + message.isEmpty());
		System.out.println("Git is fun!");
		String str = "JD\nJD\nJD";
		System.out.println(str.lines().collect(Collectors.toList()));
		Path path = Files.writeString(Files.createTempFile("test", ".txt"), "I'am writing in this file");
		System.out.println(path);
		String s = Files.readString(path);
		System.out.println(s); // This was posted on JD
	}
}
