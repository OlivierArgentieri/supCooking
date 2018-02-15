package com.supinfo.supcooking.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity 
@IdClass(RateId.class)
@Table(name="rate")
public class Rate implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Id
	private String ip;
	private int rating;
	
	@OneToMany(mappedBy="rate")
	private List<Recipe> recipes;
	
	public Long getId() {
		return id;
	}
	
	public String getIp() {
		return this.ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
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
