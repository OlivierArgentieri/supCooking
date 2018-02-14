package com.supinfo.supcooking.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Rate implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Id
	private String ipUser;
	private int rating;
	
	@OneToMany(mappedBy="recipe")
	private List<Recipe> recipes;
	
	public Long getId() {
		return id;
	}
	
	public String getIpUser() {
		return this.ipUser;
	}
	public void setIpUser(String ipUser) {
		this.ipUser = ipUser;
	}
	
	public int getRating() {
		return this.rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public List<Recipe> getRecipes() {
		return this.recipes;
	}
	
	public void setRecipe(List<Recipe> recipes) {
		this.recipes = recipes;
	}
}
