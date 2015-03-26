package org.gmjm.streams.model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class WeatherSnapshot {
	private String city;
	private String state;
	private Calendar dateTime;
	private BigDecimal temperatureFahrenheit;
	private BigDecimal dewPointFarenheit;
	private BigDecimal humidity;
	private BigDecimal SeaLevelPressureIn;
	private BigDecimal visibilityMPH;
	private String windDirection;
	private BigDecimal windSpeedMPH;
	private BigDecimal GustSpeedMPH;
	private BigDecimal precipitationIn;
	private String events;
	private String conditions;
	private BigDecimal windDirDegrees;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Calendar getDateTime() {
		return dateTime;
	}
	public void setDateTime(Calendar dateTime) {
		this.dateTime = dateTime;
	}
	public BigDecimal getTemperatureFahrenheit() {
		return temperatureFahrenheit;
	}
	public void setTemperatureFahrenheit(BigDecimal temperatureFahrenheit) {
		this.temperatureFahrenheit = temperatureFahrenheit;
	}
	public BigDecimal getDewPointFarenheit() {
		return dewPointFarenheit;
	}
	public void setDewPointFarenheit(BigDecimal dewPointFarenheit) {
		this.dewPointFarenheit = dewPointFarenheit;
	}
	public BigDecimal getHumidity() {
		return humidity;
	}
	public void setHumidity(BigDecimal humidity) {
		this.humidity = humidity;
	}
	public BigDecimal getSeaLevelPressureIn() {
		return SeaLevelPressureIn;
	}
	public void setSeaLevelPressureIn(BigDecimal seaLevelPressureIn) {
		SeaLevelPressureIn = seaLevelPressureIn;
	}
	public BigDecimal getVisibilityMPH() {
		return visibilityMPH;
	}
	public void setVisibilityMPH(BigDecimal visibilityMPH) {
		this.visibilityMPH = visibilityMPH;
	}
	public String getWindDirection() {
		return windDirection;
	}
	public void setWindDirection(String windDirection) {
		this.windDirection = windDirection;
	}
	public BigDecimal getWindSpeedMPH() {
		return windSpeedMPH;
	}
	public void setWindSpeedMPH(BigDecimal windSpeedMPH) {
		this.windSpeedMPH = windSpeedMPH;
	}
	public BigDecimal getGustSpeedMPH() {
		return GustSpeedMPH;
	}
	public void setGustSpeedMPH(BigDecimal gustSpeedMPH) {
		GustSpeedMPH = gustSpeedMPH;
	}
	public BigDecimal getPrecipitationIn() {
		return precipitationIn;
	}
	public void setPrecipitationIn(BigDecimal precipitationIn) {
		this.precipitationIn = precipitationIn;
	}
	public String getEvents() {
		return events;
	}
	public void setEvents(String events) {
		this.events = events;
	}
	public String getConditions() {
		return conditions;
	}
	public void setConditions(String conditions) {
		this.conditions = conditions;
	}
	public BigDecimal getWindDirDegrees() {
		return windDirDegrees;
	}
	public void setWindDirDegrees(BigDecimal windDirDegrees) {
		this.windDirDegrees = windDirDegrees;
	}
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
	
	@Override
	public String toString() {
		return "WeatherSnapshot [city=" + city + ", state=" + state
				+ ", dateTime=" + sdf.format(dateTime.getTime()) + " UTC" + ", temperatureFahrenheit="
				+ temperatureFahrenheit + ", dewPointFarenheit="
				+ dewPointFarenheit + ", humidity=" + humidity
				+ ", SeaLevelPressureIn=" + SeaLevelPressureIn
				+ ", visibilityMPH=" + visibilityMPH + ", windDirection="
				+ windDirection + ", windSpeedMPH=" + windSpeedMPH
				+ ", GustSpeedMPH=" + GustSpeedMPH + ", precipitationIn="
				+ precipitationIn + ", events=" + events + ", conditions="
				+ conditions + ", windDirDegrees=" + windDirDegrees + "]";
	}

	
	
	
}
