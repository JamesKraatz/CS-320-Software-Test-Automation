//Author Name: James Kraatz
//Date: 2021-SEP-19
//CourseID: CS320-H1873
/**
 * JUnit test for Contact object
 */
package test.contactservice.cs320;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contactservice.cs320.Contact;

class ContactTest {

	// verify contact can be initialized
	@Test
	void testContact() {
		Contact contact = new Contact("aZ90cDt", "Susanne", "Quesant", "9517538264", "12345 SomeStreet, Somewhere");
		assertTrue(contact.getId().equals("aZ90cDt"));
		assertTrue(contact.getFirstName().equals("Susanne"));
		assertTrue(contact.getLastName().equals("Quesant"));
		assertTrue(contact.getPhone().equals("9517538264"));
		assertTrue(contact.getAddress().equals("12345 SomeStreet, Somewhere"));
	}
	
	// verify exception if id equals null
	@Test
	void testContactIDNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Susanne", "Quesant", "9517538264", "12345 SomeStreet, Somewhere");
		});
	}
	
	// verify exception if id length is > 10
	@Test
	void testContactIDLength() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("01234567890", "Susanne", "Quesant", "9517538264", "12345 SomeStreet, Somewhere");
		});
	}
	
	// verify exception if first name equals null
	@Test
	void testContactFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("aZ90cDt", null, "Quesant", "9517538264", "12345 SomeStreet, Somewhere");
		});
	}
	
	// verify exception if first name length is > 10
	@Test
	void testContactFirstNameLength() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("aZ90cDt", "01234567890", "Quesant", "9517538264", "12345 SomeStreet, Somewhere");
		});
	}

	// verify exception if last name equals null
	@Test
	void testContactLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("aZ90cDt", "Susanne", null, "9517538264", "12345 SomeStreet, Somewhere");
		});
	}
	
	// verify exception if last name length is > 10
	@Test
	void testContactLastNameLength() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("aZ90cDt", "Susanne", "01234567890", "9517538264", "12345 SomeStreet, Somewhere");
		});
	}

	// verify exception if phone equals null
	@Test
	void testContactPhoneNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("aZ90cDt", "Susanne", "Quesant", null, "12345 SomeStreet, Somewhere");
		});
	}
	
	// verify exception if phone length is > 10
	@Test
	void testContactPhoneLengthLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("aZ90cDt", "Susanne", "Quesant", "95175382640", "12345 SomeStreet, Somewhere");
		});
	}
	
	// verify exception if phone length is < 10
	@Test
	void testContactPhoneLengthShort() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("aZ90cDt", "Susanne", "Quesant", "951753826", "12345 SomeStreet, Somewhere");
		});
	}

	// verify exception if phone length has non digit
	@Test
	void testContactPhoneOnlyDigits() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("aZ90cDt", "Susanne", "Quesant", "A951753826", "12345 SomeStreet, Somewhere");
		});
	}

	// verify exception if address equals null
	@Test
	void testContactAddressNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("aZ90cDt", "Susanne", "Quesant", "9517538264", null);
		});
	}
	
	// verify exception if address length is > 10
	@Test
	void testContactAddressLength() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("aZ90cDt", "Susanne", "Quesant", "9517538264", "1234 ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		});
	}
}
