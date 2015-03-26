package org.gmjm.streams;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

public class BasicExamples {
	public List<Integer> integers = IntStream.range(0, 101).boxed().collect(Collectors.toList());
	
	public Consumer println = System.out::println;
	public DoubleConsumer printDouble = System.out::println;
	public IntConsumer printInt = System.out::println;
	
	@Test
	public void testPrint()
	{
		integers.stream()
		.forEach(println);
	}
	
	@Test
	public void testFilter()
	{
		integers.stream()
			.filter(i -> i % 5 == 0)
			.forEach(println);
	}
	
	@Test
	public void testMap()
	{
		integers.stream()
			.map(i -> i +1)
			.forEach(println);
	}
	
	@Test
	public void testReduce()
	{
		integers.stream()
			.reduce((a,b) -> a + b)
			.ifPresent(println);
	}
	
	@Test
	public void testMapToDouble()
	{
		integers.stream()
			.mapToDouble(i -> i + 0.1d)
			.forEach(printDouble);
	}
	
	@Test
	public void testFilterAndLimit()
	{
		integers.stream()
			.filter(i -> i % 5 == 0)
			.limit(10)
			.forEach(println);
	}
	
	@Test
	public void testFilterSkipAndLimit()
	{
		integers.stream()
			.filter(i -> i % 5 == 0)
			.skip(10)
			.limit(10)
			.forEach(println);
	}
	
	@Test
	public void testFilterSkipAndLimitThenReverse()
	{
		integers.stream()
			.filter(i -> i % 5 == 0)
			.skip(10)
			.limit(10)
			.sorted(Collections.reverseOrder())
			.forEach(println);
	}
	
	@Test
	public void testFilterSkipAndLimitThenAggregateMax()
	{
		integers.stream()
			.filter(i -> i % 5 == 0)
			.skip(10)
			.limit(10)
			.max(Integer::compare)
			.ifPresent(println);
	}
	
	@Test
	public void testFilterSkipAndLimitThenAggregateMin()
	{
		integers.stream()
			.filter(i -> i % 5 == 0)
			.skip(10)
			.limit(10)
			.min(Integer::compare)
			.ifPresent(println);
	}
	
	@Test
	public void sumOfAllOdd()
	{
		integers.stream()
			.filter(i -> i % 2 == 1)
			.reduce((a,b) -> a + b)
			.ifPresent(println);
	}
}
