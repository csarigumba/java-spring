package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {

	private String firstName;
	private String lastName;
	
	private String favoriteLanguage;
	private LinkedHashMap<String, String> favoriteLanguageOptions;
	
	// create no-arg constructor
	public Student() {
		
		// populate favorite language options
		favoriteLanguageOptions = new LinkedHashMap<>();

		// parameter order: value, display label
		//
		favoriteLanguageOptions.put("Java", "Java");
		favoriteLanguageOptions.put("C#", "C#");
		favoriteLanguageOptions.put("PHP", "PHP");
		favoriteLanguageOptions.put("Ruby", "Ruby");		
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public LinkedHashMap<String, String> getFavoriteLanguageOptions() {
		return favoriteLanguageOptions;
	}

	// define getter/setter methods	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
