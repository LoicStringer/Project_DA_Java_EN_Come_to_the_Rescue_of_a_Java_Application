package com.hemebiotech.analytics.models;

public class Symptom implements Comparable<Symptom> {

	String name;
	int occurrence;

	public Symptom(String name, int occurrence) {
		super();
		this.name = name;
		this.occurrence = occurrence;
	}

	@Override
	public String toString() {
		return "Symptom [nom=" + name + ", occurrence=" + occurrence + "]";
	}

	@Override
	public int compareTo(Symptom sympt) {
		return (this.name.compareTo(sympt.getName()));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOccurrence() {
		return occurrence;
	}

	public void setOccurrence(int occurrence) {
		this.occurrence = occurrence;
	}

}
