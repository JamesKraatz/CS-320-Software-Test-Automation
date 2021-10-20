//Author Name: James Kraatz
//Date: 2021-SEP-19
//CourseID: CS320-H1873
/**
 * JUInit test for Contact Service object
 */
package test.contactservice.cs320;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import contactservice.cs320.Contact;
import contactservice.cs320.ContactService;

class ContactServiceTest {
	// declare a contact object
	Contact contact;
	// declare a contact service
	ContactService contactService;
	// Setup: Create working variables
	String id = "aZ90cDt";
	String firstName = "Susanne";
	String lastName = "Quesant";
	String phone = "9517538264";
	String address = "12345 SomeStreet, Somewhere";
	
	// initialize objects instances used in each test
	@BeforeEach
	void setUp() {
		//        Create a contact to add to the service
		contact = new Contact(id, firstName, lastName, phone, address);
		//        Start contact service
		contactService = new ContactService();
		//        Add contact to contact service
		contactService.addContact(contact);
	}

	// verify a contact with a unique id can be added to contact service
	@Test
	void testContactServiceAddUniqueContact() {
		assertTrue(contactService.getContactFirstName(id).equals(firstName));
		assertTrue(contactService.getContactLastName(id).equals(lastName));
		assertTrue(contactService.getContactPhone(id).equals(phone));
		assertTrue(contactService.getContactAddress(id).equals(address));
	}

	// verify only a unique contact can be added to the contact service
	@Test
	void testContactServiceAddDuplicateContact() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.addContact(contact);
		});
	}
	
	// verify contact can be deleted from contact service
	@Test
	void testContactServiceDeleteContact() {
		// delete contact
		contactService.deleteContact(id);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.getContactFirstName(id);
		});
	}
	
	// verify ability to fail contact update if invalid id given
	@Test
	void testContactServiceUpdateContactWithInValidID() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContactFirstName("none", "enon");
		});
	}

	// verify ability to update contact first name by id
	@Test
	void testContactServiceUpdateFirstName() {
		// update contact first name
		contactService.updateContactFirstName(id, id);
		assertTrue(contactService.getContactFirstName(id).equals(id));
	}
	
	// verify ability to update contact last name by id
	@Test
	void testContactServiceUpdatLastName() {
		// update contact last name
		contactService.updateContactLastName(id, id);
		assertTrue(contactService.getContactLastName(id).equals(id));
	}
	
	// verify ability to update contact phone by id
	@Test
	void testContactServiceUpdatPhone() {
		// update contact phone
		contactService.updateContactPhone(id, "9876543210");
		assertTrue(contactService.getContactPhone(id).equals("9876543210"));
	}
	
	// verify ability to update contact address by id
	@Test
	void testContactServiceUpdatAddress() {
		// update contact address
		contactService.updateContactAddress(id, id);
		assertTrue(contactService.getContactAddress(id).equals(id));
	}
}
