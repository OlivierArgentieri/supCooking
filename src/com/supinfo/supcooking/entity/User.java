package com.supinfo.supcooking.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
@Entity
@Table(name="user")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long idUser;
	
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String mail;
	private String phoneNumber;
	
	@OneToMany(mappedBy="recipe")
	private List<Recipe> recipes;
	
	
	public Long getId() {
		return this.idUser;
	}
	
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirstName() {
		return this.firstname;
	}
	public void setFirstName(String firstName) {
		this.firstname = firstName;
	}
	
	public String getLastName() {
		return this.lastname;
	}
	public void setLstName(String lastName) {
		this.lastname = lastName;
	}
	
	public String getMail() {
		return this.mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Recipe> getRecipes() {
		return this.recipes;
	}
	public void setRecipe(List<Recipe> recipes) {
		this.recipes = recipes;
	}
	
}
