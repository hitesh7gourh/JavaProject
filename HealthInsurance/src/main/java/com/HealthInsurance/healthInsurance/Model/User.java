package com.HealthInsurance.healthInsurance.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String password;
	private String contact;
	private String firstname;
	private String middlename;
	private String lastname;
	private String residentialAddress;
	private String officeAddress;
	private String qualification;
	

	public Long getId() {
		return id;
	}
	/**
	 * @param name
	 * @param email
	 * @param password
	 * @param contact
	
	 */
	public User(String name, String email, String password, String contact,String firstname,String middlename,String lastname,String residentialAddress,String officeAddress,String qualification) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.contact = contact;
	    this.firstname=firstname;
	    this.middlename=middlename;
	    this.lastname=lastname;
	    this.residentialAddress=residentialAddress;
	    this.officeAddress=officeAddress;
	    this.qualification=qualification;
	}
	/**
	 * 
	 */
	public User() {
	}
	/**
	 * @return the name
	 */
	
	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * @return the middlename
	 */
	public String getMiddlename() {
		return middlename;
	}
	/**
	 * @param middlename the middlename to set
	 */
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	/**
	 * @return the residentialAddress
	 */
	public String getResidentialAddress() {
		return residentialAddress;
	}
	/**
	 * @param residentialAddress the residentialAddress to set
	 */
	public void setResidentialAddress(String residentialAddress) {
		this.residentialAddress = residentialAddress;
	}
	/**
	 * @return the officeAddress
	 */
	public String getOfficeAddress() {
		return officeAddress;
	}
	/**
	 * @param officeAddress the officeAddress to set
	 */
	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}
	/**
	 * @return the qualification
	 */
	public String getQualification() {
		return qualification;
	}
	/**
	 * @param qualification the qualification to set
	 */
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}



	

}
