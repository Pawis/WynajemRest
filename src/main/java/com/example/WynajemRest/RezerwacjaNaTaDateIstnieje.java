package com.example.WynajemRest;

@SuppressWarnings("serial")
public class RezerwacjaNaTaDateIstnieje extends Exception {

	public RezerwacjaNaTaDateIstnieje(String errorMessage) {
        super(errorMessage);
    }
}
