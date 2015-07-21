package uk.co.gslimited.example;

public interface Connection {

	void connect();
	String send(String subject, String message);
	void disconnect();
}

