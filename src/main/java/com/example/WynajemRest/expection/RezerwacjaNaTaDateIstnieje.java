package com.example.WynajemRest.expection;

@SuppressWarnings("serial")
public class RezerwacjaNaTaDateIstnieje extends Exception {

	public RezerwacjaNaTaDateIstnieje(String errorMessage) {
        super(errorMessage);
    }
}
