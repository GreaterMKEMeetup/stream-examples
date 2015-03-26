package org.gmjm.streams.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.gmjm.streams.model.WeatherSnapshot;


public class WeatherUndergroundExportParser {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static List<WeatherSnapshot> parseExtract(File file, String city, String state)
	{
		List<WeatherSnapshot> extractedSnapshots = new ArrayList<WeatherSnapshot>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			br.readLine();//skip header row
			String line = br.readLine();
			
			while(line != null)
			{
				
				String[] values = line.split(",");
				String timeCDT = values[0];
				String temperatureF = values[1];
				String dewPointF = values[2];
				String humidity = values[3];
				String seaLevelPressureIn = values[4];
				String visibilityMPH = values[5];
				String windDirection = values[6];
				String windSpeedMPH = values[7];
				String gustSpeedMPH = values[8];
				String precipitationIn = values[9];
				String events = values[10];
				String conditions = values[11];
				String windDirDegrees = values[12];
				String dateUTC = values[13];
				
				WeatherSnapshot ws = new WeatherSnapshot();
				
				Calendar c = Calendar.getInstance();
				c.setTime(sdf.parse(dateUTC));
				c.setTimeZone(TimeZone.getTimeZone("UTC"));
				
				ws.setState(state);
				ws.setCity(city);
				ws.setDateTime(c);
				ws.setTemperatureFahrenheit(getBigDecimal(temperatureF));
				ws.setDewPointFarenheit(getBigDecimal(dewPointF));
				ws.setHumidity(getBigDecimal(humidity));
				ws.setSeaLevelPressureIn(getBigDecimal(seaLevelPressureIn));
				ws.setVisibilityMPH(getBigDecimal(visibilityMPH));
				ws.setWindDirection(windDirection);
				ws.setWindSpeedMPH(getBigDecimal(windSpeedMPH));
				ws.setGustSpeedMPH(getBigDecimal(gustSpeedMPH));
				ws.setPrecipitationIn(getBigDecimal(precipitationIn));
				ws.setEvents(events);
				ws.setConditions(conditions);
				ws.setWindDirDegrees(getBigDecimal(windDirDegrees));
				
				extractedSnapshots.add(ws);
				
				line = br.readLine();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return extractedSnapshots;
	}
	
	public static BigDecimal getBigDecimal(String input)
	{
		if(input == null || input.length() < 1)
			return BigDecimal.ZERO;
		else
		{
			try{
				return new BigDecimal(input);
			} catch(NumberFormatException e)
			{
				return BigDecimal.ZERO;
			}
		}
	}
}
