package org.gmjm.streams.crypto;

import java.util.HashMap;
import java.util.Map;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class CrackingUtils {
	private static final IntUnaryOperator TO_LOWER_FUNCTION = c -> 
	{
		if(c >= 65 && c <= 90)
			return c + 32;
		return c;
	};
	
	public static void calculateAndPrintFrequencies(String input)
	{
		Map<Character,Integer> charCountMap = new HashMap<Character, Integer>();
	
		IntStream.range(97, 123)
		.forEach(c -> charCountMap.put((char)c, 0));
		
		 input.chars()
		 .map(TO_LOWER_FUNCTION)
		 .filter(i -> i >= 97 && i <= 122)
		 .forEach(c ->
		 	{
		 		charCountMap.put((char)c, charCountMap.get((char)c)+1);
			});
		 
		 System.out.println("Character Frequencies: ");
		 
		 System.out.println("\nSorted by value: ");
		 charCountMap.entrySet()
			.stream()	
			.sorted((e1,e2) -> e1.getKey().compareTo(e2.getKey()))
			.forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));
		 
		 System.out.println("\nSorted by count: ");
		 charCountMap.entrySet()
			.stream()	
			.sorted((e1,e2) -> e2.getValue().compareTo(e1.getValue()))
			.forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));
	}
}
