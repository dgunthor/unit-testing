package uk.co.gslimited.example.hamcrest;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import uk.co.gslimited.example.Connection;
import uk.co.gslimited.example.EmailException;
import uk.co.gslimited.example.EmailServiceImpl;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@Slf4j
public class HamcrestEmailServiceImplTest {

	@Mock
	private Connection connection;

	@InjectMocks
	private EmailServiceImpl classUnderTest = new EmailServiceImpl();

	@Before
	public void setUp() {
		initMocks(this);
	}

	@Test
	public void shouldSendEmail_hamcrest() {

		//when
		String messageId = classUnderTest.sendEmail("subject", "message");

		//then
		assertThat("messageId", messageId, is(notNullValue()));
	}

	@Test
	public void shouldHave4Employees_hamcrest() {

		//given
		List<String> employees = Arrays.asList("Steve", "Anna", "Rebecca");

		//then
		assertThat("employees", employees, hasSize(4));
	}

	@Test
	public void shouldHaveEmployeeDave_hamcrest() {

		//given
		List<String> employees = Arrays.asList("Steve", "Anna", "Rebecca");

		//then
		assertThat("Dave is an employee", employees, hasItem("Dave"));
	}

	@Test
	public void shouldSendEmail_mockito() {

		//given
		when(connection.send(anyString(), anyString())).thenReturn("messageId123");

		//when
		String messageId = classUnderTest.sendEmail("subject", "message");

		//then
		assertThat(messageId, is("messageId123"));
		verify(connection, times(1)).connect();
		verify(connection, times(1)).send("subject", "message");
		verify(connection, times(1)).disconnect();
		verifyNoMoreInteractions(connection);
	}
}
