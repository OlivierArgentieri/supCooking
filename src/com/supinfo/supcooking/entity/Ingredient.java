package com.supinfo.supcooking.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="ingredient")
public class Ingredient implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private float price;
    
    private String image;
    
    @ManyToOne
	@JoinColumn
    private IngredientCategory category;
    
    @ManyToMany
    @JoinTable(
        name="recipes",
        joinColumns=@JoinColumn(name="ingredient_id", referencedColumnName="id"),
        inverseJoinColumns=@JoinColumn(name="recipe_id", referencedColumnName="id"))
	private List<Recipe> recipes;
    
    
    
    public Long getId() {
        return this.id;
    }
    
    public String getNameIngredient() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public float getPrice() {
        return this.price;
    }
    public void setPrice(Float prize) {
        this.price = prize;
    }
    
    public String getImage() {
        return this.image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    public IngredientCategory getCategory() {
        return this.category;
    }
    public void setCateg(IngredientCategory category) {
        this.category = category;
    }
    
    public List<Recipe> getRecipes() {
		return this.recipes;
	}
	public void setRecipe(List<Recipe> recipes) {
		this.recipes = recipes;
	}
    
}