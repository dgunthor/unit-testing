package uk.co.gslimited.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private Connection connection;

	public String sendEmail(String subject, String message) throws EmailException {
		if (connection == null) {
			throw new EmailException("no connection");
		}

		String messageId = null;

		try {
			connection.connect();
			messageId = connection.send(subject, message);
		} finally {
			connection.disconnect();
		}

		return messageId;
	}
}

