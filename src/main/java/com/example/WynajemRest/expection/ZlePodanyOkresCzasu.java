package com.example.WynajemRest.expection;


@SuppressWarnings("serial")
public class ZlePodanyOkresCzasu extends Exception {

	public ZlePodanyOkresCzasu(String errorMessage) {
        super(errorMessage);
    }
}
