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
	private String icon;
	
	private int difficulty;
	private Time time;
	private Time cookingTime;

	private Date date;
	
	@ManyToOne
	@JoinColumn
	private RecipeCategory category;
	
	@ManyToOne
	@JoinColumn
	private User author;

	@ManyToMany(mappedBy="recipes")
	private List<Ingredient> ingredients;
	
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
	
	
	public String getIcon() {
		return this.icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
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
	
	public Time geCookingtIime () {
		return this.cookingTime;
	}
	public void setCookingTime(Time cookingTime) {
		this.cookingTime = cookingTime;
	}
	
	public RecipeCategory getCategory () {
		return this.category;
	}
	public void setCategory(RecipeCategory category) {
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
	public void setRIngredient(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
}
