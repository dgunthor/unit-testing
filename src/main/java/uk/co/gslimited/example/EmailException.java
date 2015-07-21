package uk.co.gslimited.example;

public class EmailException extends RuntimeException {

	static final long serialVersionUID = 42L;

	public EmailException(String message) {
		super(message);
	}
}
