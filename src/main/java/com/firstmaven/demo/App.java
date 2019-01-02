package com.firstmaven.demo;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
	static Logger logger = Logger.getLogger(App.class);
	private static final String MESSAGE = "Hello World!";
	App() {}
	
    public static void main(String[] args) {
    	BasicConfigurator.configure();
        logger.debug(new App().getMessage());
    }

    private final String getMessage() {
        return MESSAGE;
    }
}
