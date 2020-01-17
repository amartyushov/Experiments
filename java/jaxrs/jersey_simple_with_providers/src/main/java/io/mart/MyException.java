package io.mart;

public class MyException extends RuntimeException {
	
	public MyException(String message) {
		super(message + " my additional message");
	}
}
