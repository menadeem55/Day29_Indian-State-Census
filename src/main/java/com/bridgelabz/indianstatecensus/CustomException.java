package com.bridgelabz.indianstatecensus;

public class CustomException extends Exception {
	public enum ExceptionType {
		FILE_NOT_FOUND;
	}

	final ExceptionType type;

	public CustomException(ExceptionType type, String message) {
		super(message);
		this.type = type;
	}
}
