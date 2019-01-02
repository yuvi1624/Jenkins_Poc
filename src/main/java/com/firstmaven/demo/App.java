package com.firstmaven.demo;

import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
	private static final String MESSAGE = "Hello World!";
	App() {}
	
    public static void main(String[] args) {
    	
        Logger.getLogger(new App().getMessage());
    }

    private final String getMessage() {
        return MESSAGE;
    }
}