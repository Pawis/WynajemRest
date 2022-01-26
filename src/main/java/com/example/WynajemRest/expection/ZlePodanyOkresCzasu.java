package com.example.WynajemRest.expection;


@SuppressWarnings("serial")
public class ZlePodanyOkresCzasu extends RuntimeException  {

	public ZlePodanyOkresCzasu(String errorMessage) {
        super(errorMessage);
    }
}
