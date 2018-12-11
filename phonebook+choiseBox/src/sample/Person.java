package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {
	private int id;
	private final String to;
	private final String from;
	private final String time;
	private final String date;
	private final String duration;
	private final String type;

	public Person(int id, String to, String from, String time, String date, String duration, String type) {
		this.id = id;
		this.to = to;
		this.from = from;
		this.time = time;
		this.date = date;
		this.duration = duration;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTo() {
		return to;
	}

	public String getFrom() {
		return from;
	}

	public String getTime() {
		return time;
	}

	public String getDate() {
		return date;
	}

	public String getDuration() {
		return duration;
	}

	public String getType() {
		return type;
	}
}

