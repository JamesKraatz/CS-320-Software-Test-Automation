//Author Name: James Kraatz
//Date: 2021-SEP-19
//CourseID: CS320-H1873
/**
 * Contact object:
 * 		Contact information object..
 * 
 * Contains five properties:
 * 		String id: unique id for the appointment, it cannot be
 * 				   longer than 10 characters or null or modifiable.
 * 		String firstName: field containing first name of contact. Field
 * 				   cannot be longer than 10 characters or null. Field is
 * 				   modifiable.
 * 		String lastName:  field containing last name of contact.
 * 				   Modifiable field cannot be longer than 10 characters
 * 				   of null.
 * 		String phone: field containing phone number of contact. Modifiable
 * 				   field cannot be longer than 10 digits or null.
 * 		String address:   field containing address of contact. Modifiable
 * 				   field cannot be longer than 30 characters or null.
 * 
 * Public Methods:
 * 		Contact(String id, String firstName, String lastName, 
 * 				   String phone, String address);
 * 											construct for new contact.
 * 		String getID();						Returns contact id string.
 * 		String getFirstName();				Returns contact first name string.
 * 		String getLastName();				Returns contact last name string.
 * 		String getPhone();					Returns contact phone string.
 * 		String getAddress();				Returns contact address string.
 * 		void setFirstName(String firstName);Updates contact first name string.
 * 		void setLastName(String lastName);	Updates contact last name string.
 * 		void setPhone(String phone);		Updates contact phone string.
 * 		void setAddress(String address);	Updates contact address string.
 * 
 * Private Methods:		Methods to qualify field data with requirements
 * 		void checkID(String id);				Qualifies contact id.
 * 		void checkFirstName(String firstName);	Qualifies contact first name.
 * 		void checkLastName(String lastName);	Qualifies contact last name.
 * 		void checkPhone(String phone);			Qualifies contact phone.
 * 		void checkAddress(String address)		Qualifies contact address.
 */
package contactservice.cs320;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact {
	
	private String id;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	// Contact constructor
	public Contact(String id, String firstName, String lastName, String phone, String address) {
		
		// Check for valid input
		this.checkID(id);
		this.checkFirstName(firstName);
		this.checkLastName(lastName);
		this.checkPhone(phone);
		this.checkAddress(address);
		
		// Assign values
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	
	// get methods
	public String getId() {
		return id;
	};
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	
	// set methods, there is no set method for id since it cannot be modified
	public void setFirstName(String firstName) {

		// check input before assigning to class property
		checkFirstName(firstName);
		// assign to class property
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {

		// check input before assigning to class property
		checkLastName(lastName);
		// assign to class property
		this.lastName = lastName;
	}

	public void setPhone(String phone) {

		// check input before assigning to class property
		checkPhone(phone);
		// assign to class property
		this.phone = phone;
	}

	public void setAddress(String address) {
		
		// check input before assigning to class property
		checkAddress(address);
		// assign to class property
		this.address = address;
	}
	

	
	/*
	 * private method to verify id format
	 * 
	 * INPUTS: String id; contact id
	 * 
	 * OUPUTS: none
	 * 
	 * EXCEPTIONS: Throws IllegalArgumentException if id is invalid
	 */
	private void checkID(String id) {
		// check id to make sure it is not null or too long
		if(id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
	}
	
	/*
	 * private method to verify first name format
	 * 
	 * INPUTS: String first name; contact first name
	 * 
	 * OUPUTS: none
	 * 
	 * EXCEPTIONS: Throws IllegalArgumentException if first name is invalid
	 */
	private void checkFirstName(String firstName) {
		// check firstName for null and length > 10
		if(firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
	}

	/*
	 * private method to verify last name format
	 * 
	 * INPUTS: String last name; contact last name
	 * 
	 * OUPUTS: none
	 * 
	 * EXCEPTIONS: Throws IllegalArgumentException if last name is invalid
	 */
	private void checkLastName(String lastName) {
		// check lastName for null and length > 10
		if(lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
	}
	
	/*
	 * private method to verify phone format
	 * 
	 * INPUTS: String phone; contact phone
	 * 
	 * OUPUTS: none
	 * 
	 * EXCEPTIONS: Throws IllegalArgumentException if phone is invalid
	 */
	private void checkPhone(String phone) {
		// check phone number for null and length not equal to exactly 10 "digits"
		// 1. check phone for null and length
		boolean illegalArg = (phone == null) || (phone.length() != 10);
		// 2. check phone is numbers only
		if(!illegalArg) {
			Pattern p = Pattern.compile("[0-9]{10}");		// regex expression pattern to get digits
			Matcher m = p.matcher(phone);				// create object to match phone against pattern
			illegalArg = !m.matches();
		}
		if(illegalArg) {
			throw new IllegalArgumentException("Invalid Phone");
		}		
	}
	
	/*
	 * private method to verify address format
	 * 
	 * INPUTS: String address; contact address
	 * 
	 * OUPUTS: none
	 * 
	 * EXCEPTIONS: Throws IllegalArgumentException if address is invalid
	 */
	private void checkAddress(String address) {
		// check address for null or length > 30
		if(address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}		
	}
}
