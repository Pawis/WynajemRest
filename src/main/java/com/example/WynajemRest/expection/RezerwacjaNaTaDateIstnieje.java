package com.example.WynajemRest.expection;

@SuppressWarnings("serial")
public class RezerwacjaNaTaDateIstnieje extends RuntimeException  {

	public RezerwacjaNaTaDateIstnieje(String errorMessage) {
        super(errorMessage);
    }
}
