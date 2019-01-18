package com.ajs.seeonsite.seeonsite.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;
	private String userName;
	private String password;
	private String email;
	private String phoneNumber;
	private Boolean isAdmin = Boolean.FALSE;

	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
	private Set<Home> homePosted;

	public User() {

	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the homePosted
	 */
	public Set<Home> getHomePosted() {
		return homePosted;
	}
	/**
	 * @param homePosted
	 *            the homePosted to set
	 */
	public void setHomePosted(Set<Home> homePosted) {
		this.homePosted = homePosted;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", email="
				+ email + "]";
	}
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber
	 *            the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return the isAdmin
	 */
	public Boolean getIsAdmin() {
		return isAdmin;
	}
	/**
	 * @param isAdmin
	 *            the isAdmin to set
	 */
	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

}
