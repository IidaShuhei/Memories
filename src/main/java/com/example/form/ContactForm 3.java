package com.example.form;

public class ContactForm {

	private String name;
	private String contactEmail;
	private String contactMessage;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the contactEmail
	 */
	public String getContactEmail() {
		return contactEmail;
	}

	/**
	 * @param contactEmail the contactEmail to set
	 */
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	/**
	 * @return the contactMessage
	 */
	public String getContactMessage() {
		return contactMessage;
	}

	/**
	 * @param contactMessage the contactMessage to set
	 */
	public void setContactMessage(String contactMessage) {
		this.contactMessage = contactMessage;
	}

	@Override
	public String toString() {
		return "ContactForm [name=" + name + ", contactEmail=" + contactEmail + ", contactMessage=" + contactMessage
				+ "]";
	}

}
