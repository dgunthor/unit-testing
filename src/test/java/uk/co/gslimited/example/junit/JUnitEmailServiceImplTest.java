package uk.co.gslimited.example.junit;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import uk.co.gslimited.example.Connection;
import uk.co.gslimited.example.EmailException;
import uk.co.gslimited.example.EmailServiceImpl;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * No spring configuration has been added but using Mockito we can mock the Connection used by EmailServiceImpl.
 */
@Slf4j
public class JUnitEmailServiceImplTest {

	@Mock
	private Connection connection;

	@InjectMocks
	private EmailServiceImpl classUnderTest = new EmailServiceImpl();

	@Before
	public void setUp() {
		initMocks(this);
	}

	@Test
	public void shouldSendEmail_junit() {

		//when
		String messageId = classUnderTest.sendEmail("subject", "message");

		//then
		assertNotNull(messageId);
	}

	@Test
	public void shouldSendEmail_junit_better() {

		//when
		String messageId = classUnderTest.sendEmail("subject", "message");

		//then
		assertNotNull("messageId", messageId);
	}

	@Test
	public void shouldHave4Employees_junit() {

		//given
		List<String> employees = Arrays.asList("Steve", "Anna", "Rebecca");

		//then
		assertEquals(4, employees.size());
	}

	@Test
	public void shouldHave4Employees_junit_better() {

		//given
		List<String> employees = Arrays.asList("Steve", "Anna", "Rebecca");

		//then
		assertEquals("employees", 4, employees.size());
	}

	@Test
	public void shouldHaveEmployeeDave_junit() {

		//given
		List<String> employees = Arrays.asList("Steve", "Anna", "Rebecca");

		//then
		assertTrue(employees.contains("Dave"));
	}

	@Test
	public void shouldHaveEmployeeDave_junit_better() {

		//given
		List<String> employees = Arrays.asList("Steve", "Anna", "Rebecca");

		//then
		assertTrue("Dave is an employee", employees.contains("Dave"));
	}
}
