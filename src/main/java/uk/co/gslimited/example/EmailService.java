package uk.co.gslimited.example;

public interface EmailService {

	String sendEmail(String subject, String message) throws EmailException;
}

