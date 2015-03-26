package org.gmjm.streams;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import org.gmjm.streams.model.WeatherSnapshot;
import org.gmjm.streams.util.WeatherUndergroundExportParser;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class WeatherStreamTests {
	
	private static List<WeatherSnapshot> extractedSnapshots = new ArrayList<WeatherSnapshot>();
	
	@BeforeClass
	public static void setUpClass()
	{
		
		extractedSnapshots = Arrays.asList(new File("src/test/resources/weather/").listFiles()).stream()
			.flatMap(file -> WeatherUndergroundExportParser.parseExtract(file, "Fontana", "WI").stream())
			.collect(Collectors.toList());
			
		System.out.println("Weather Records: " + extractedSnapshots.size() + "\n");
	}
	
	@Before
	public void before()
	{
		System.out.println("-------------------------");
	}
	
	@After
	public void after()
	{
		System.out.println("-------------------------");
	}
	
	@Test
	public void findDistinctConditionTypes()
	{	
		System.out.println("Find Distinct ConditionTypes \n");
		
		List<String> conditions = extractedSnapshots.stream()
			.map(WeatherSnapshot::getConditions)
			.distinct()
			.collect(Collectors.toList());
		
		System.out.println("Types of Conditions: " + conditions.size());
		System.out.println(conditions.toString());
	}
	
	@Test
	public void mapByConditionTypeAndCountSortOnType()
	{
		System.out.println("Map WeatherSnapshot objects by condition. Sorted on Condition Type \n");
		
		extractedSnapshots.stream()
			.collect(Collectors.groupingBy(WeatherSnapshot::getConditions))
			.entrySet()
			.stream()	
			.sorted((e1,e2) -> e1.getKey().compareTo(e2.getKey()))
			.forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue().size()));
	}
	
	@Test
	public void mapByConditionTypeAndCountSortOnCount()
	{
		System.out.println("Map WeatherSnapshot objects by condition. Sorted on Condition Count \n");
		
		extractedSnapshots.stream()
			.collect(Collectors.groupingBy(WeatherSnapshot::getConditions))
			.entrySet()
			.stream()	
			.sorted((e1,e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
			.forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue().size()));
	}
	
	@Test
	public void findHottestRainyDay()
	{
		System.out.println("Find the hottest rainy day \n");
		
		
		extractedSnapshots.stream()
			.filter(snapshot -> snapshot.getConditions().equals("Rain"))
			.max((s1,s2) -> s1.getTemperatureFahrenheit().compareTo(s2.getTemperatureFahrenheit()))
			.ifPresent(System.out::println);
	}
	
	@Test
	public void findAverageTemperatureForDateRange()
	{
		System.out.println("Find the hottest rainy day \n");
		
		Calendar startDateTime = Calendar.getInstance();
		startDateTime.set(2012, 07, 01);
		
		Calendar endDateTime = Calendar.getInstance();
		endDateTime.set(2012, 07, 20);
		
		extractedSnapshots.stream()
			.filter(snapshot -> snapshot.getTemperatureFahrenheit().doubleValue() > 0 && snapshot.getDateTime().after(startDateTime) && snapshot.getDateTime().before(endDateTime))
			.mapToDouble(snapshot -> snapshot.getTemperatureFahrenheit().doubleValue())
			.average()
			.ifPresent(average -> System.out.println(String.format("The average temperature between (%s) and (%s) was %.2f degrees Fahrenheit.",startDateTime.getTime(),endDateTime.getTime(),average)));
	}
	
}
