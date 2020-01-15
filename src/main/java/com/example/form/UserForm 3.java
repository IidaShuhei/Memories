package com.example.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * ユーザーフォーム.
 * 
 * @author iidashuhei
 *
 */
public class UserForm {

	@NotBlank(message="名前を入力してください")
	private String name;
	
	@Email(message="Eメールの形式が不正です")
	@NotBlank(message="メールアドレスを入力してください")
	private String email;
	
	@NotBlank(message="パスワードを入力してください")
	private String password;
	
	@NotBlank(message="確認用パスワードを入力してください")
	private String confirmationPassword;
	
	@NotBlank(message="郵便番号を入力してください")
	private String zipcode;
	
	@NotBlank(message="住所を入力してください")
	private String address;
	
	@NotBlank(message="電話番号を入力してください")
	private String telephone;

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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the confirmationPassword
	 */
	public String getConfirmationPassword() {
		return confirmationPassword;
	}

	/**
	 * @param confirmationPassword the confirmationPassword to set
	 */
	public void setConfirmationPassword(String confirmationPassword) {
		this.confirmationPassword = confirmationPassword;
	}

	/**
	 * @return the zipcode
	 */
	public String getZipcode() {
		return zipcode;
	}

	/**
	 * @param zipcode the zipcode to set
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "UserForm [name=" + name + ", email=" + email + ", password=" + password + ", confirmationPassword="
				+ confirmationPassword + ", zipcode=" + zipcode + ", address=" + address + ", telephone=" + telephone
				+ "]";
	}

}
