package com.supinfo.supcooking.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: CategRecipe
 *
 */
@Entity
@Table(name="recipe_category")
public class RecipeCategory implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	
	@ManyToMany
    @JoinTable(
        name="recipes",
        joinColumns=@JoinColumn(name="recipe_category_id", referencedColumnName="id"),
        inverseJoinColumns=@JoinColumn(name="recipe_id", referencedColumnName="id"))
	private List<Recipe> recipes;
	
	public RecipeCategory() {
		super();
	}

	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setNameCateg(String name) {
		this.name = name;
	}
	
	public List<Recipe> getRecipes() {
        return this.recipes;
    }
    public void setRecipe(List<Recipe> recipes) {
        this.recipes = recipes;
    }
}
