//Author Name: James Kraatz
//Date: 2021-SEP-19
//CourseID: CS320-H1873
/**
 * Contact service object:
 * 
 * Contains HashMap data structure of Contact objects
 * 		HashMap<String, Contact>
 * 
 * Public Methods:
 * 		void addContact(Contact contact);
 * 				Adds contact to service if it is not currently in conatct service.
 * 		void deleteContact(String id);
 * 				Deletes contact from contact service.
 * 		void updateContactFirstName(String id, String firstName);
 * 				Updates first name of contact in service by id.
 * 		void updateContactLastName(String id, String lastName);
 * 				Updates last name of contact in service by id.
 * 		void updateContactPhone(String id, String phone);
 * 				Updates phone of contact in service by id.
 * 		void updateContactAddress(String id, String address);
 * 				Updates address of contact in service by id.
 * 		String getContactFirstName(String id);
 * 				Returns first name of contact matching id from service.
 * 		String getContactLastName(String id);
 * 				Returns last name of contact matching id from service. 
 * 		String getContactPhone(String id);
 * 				Returns phone of contact matching id from service.
 * 		String getContactAddress(String id);
 * 				Returns address of contact matching id from service.
 * 
 * Private Methods:
 * 		Contact getContact(String id);
 * 				Returns contact matching id from service.
 */
package contactservice.cs320;
import java.util.HashMap;

public class ContactService {
	private HashMap<String, Contact> contacts = new HashMap<String, Contact>();
	
	// add contact with unique id
	public void addContact(Contact contact) {
		if(contacts.putIfAbsent(contact.getId(), contact) != null) {
			throw new IllegalArgumentException("ID is already exists");
		}
	}
	
	// delete contact per contact id
	public void deleteContact(String id) {
		contacts.remove(id);
	}
	
	// update contact first name per contact id
	public void updateContactFirstName(String id, String firstName) {
		Contact contact = getContact(id);
		contact.setFirstName(firstName);
	}
	
	// update contact last name per contact id
	public void updateContactLastName(String id, String lastName) {
		Contact contact = getContact(id);
		contact.setLastName(lastName);
	}
	
	// update contact phone number per contact id
	public void updateContactPhone(String id, String phone) {
		Contact contact = getContact(id);
		contact.setPhone(phone);
	}
	
	// update contact address per contact id
	public void updateContactAddress(String id, String address) {
		Contact contact = getContact(id);
		contact.setAddress(address);
	}
	
	
	// get contact data by id method
	// first name
	public String getContactFirstName(String id) {
		// verify contact is in contacts
		Contact contact = getContact(id);
		return contact.getFirstName();
	}
	// last name
	public String getContactLastName(String id) {
		// verify contact is in contacts
		Contact contact = getContact(id);
		return contact.getLastName();
	}
	// phone
	public String getContactPhone(String id) {
		// verify contact is in contacts
		Contact contact = getContact(id);
		return contact.getPhone();
	}
	// address
	public String getContactAddress(String id) {
		// verify contact is in contacts
		Contact contact = getContact(id);
		return contact.getAddress();
	}
	
	
	/*
	 * private method to verify contact is in service
	 * 
	 * INPUTS: String id; contact id to retrieve
	 * 
	 * OUPUTS: Contact object of provided id
	 * 
	 * EXCEPTIONS: Throws IllegalArgumentException if no Contact of id is in contact
	 * service
	 */
	private Contact getContact(String id) {
		Contact contact = this.contacts.get(id);
		if(contact == null) {
			throw new IllegalArgumentException("ID not found");
		}
		
		return contact;
	}
}

