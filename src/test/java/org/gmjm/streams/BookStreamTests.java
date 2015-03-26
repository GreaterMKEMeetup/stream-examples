package org.gmjm.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.Test;

public class BookStreamTests {
	
	@BeforeClass
	public static void beforeClass()
	{
		
	}
	
	@Test
	public void ulyssesLineCount() throws IOException
	{
		long lineCount = Files.lines(Paths.get("src/test/resources/books/ulysses.txt")).count();
		System.out.println("Ulysses line count: " + lineCount);
	}
	
	@Test
	public void ulyssesWordCount() throws IOException
	{
		long wordCount = Files.lines(Paths.get("src/test/resources/books/ulysses.txt"))
			.flatMap(line -> Arrays.stream(line.split(".")))
			.count();
		
		System.out.println("Ulysses word count: " + wordCount);
	}
	
	@Test
	public void ulyssesUniqueWordCount() throws IOException
	{
		long uniqueWordCount = Files.lines(Paths.get("src/test/resources/books/ulysses.txt"))
			.flatMap(line -> Arrays.stream(line.split("[\\p{P} \\t\\n\\r]")))
			.map(string -> string.toLowerCase())
			.distinct()
			.count();
		
		System.out.println("Ulysses unique word count: " + uniqueWordCount);
	}
}
