package com.supinfo.supcooking.entity;



import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="recipe")
public class Recipe implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	private String description;

	private String image;
	
	private int difficulty;
	private Time time;
	private Time cookingTime;

	private Date date;
	
	@ManyToMany(mappedBy="recipes")
	private List<RecipeCategory> category;
	
	@ManyToOne
	@JoinColumn()
	private User author;

	@ManyToMany(mappedBy="recipes")
	private List<Ingredient> ingredients;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn
    private Rate rate;
	
	
	public Long getId() {
		return this.id;
	}
	
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRecipeDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public String getImage() {
		return this.image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public int getDifficulty() {
		return this.difficulty;
	}
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	
	public Time getTime () {
		return this.time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	
	public Time getCookingTime () {
		return this.cookingTime;
	}
	public void setCookingTime(Time cookingTime) {
		this.cookingTime = cookingTime;
	}
	
	public List<RecipeCategory> getCategory () {
		return this.category;
	}
	public void setCategory(List<RecipeCategory> category) {
		this.category = category;
	}
	
	public User getAuthor () {
		return this.author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	
	public Date getDate () {
		return this.date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public List<Ingredient> getIngredients() {
		return this.ingredients;
	}
	public void setIngredient(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	
	public Rate getRateId() {
		return this.rate;
	}
	public void setRate(Rate rate) {
		this.rate = rate;
	}
}
