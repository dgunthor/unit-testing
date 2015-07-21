package uk.co.gslimited.example;

import org.springframework.stereotype.Service;

@Service
public class ConnectionImpl implements Connection {

	@Override
	public void connect() {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public String send(String subject, String message) {
		return null;
	}

	@Override
	public void disconnect() {
		//To change body of implemented methods use File | Settings | File Templates.
	}
}

