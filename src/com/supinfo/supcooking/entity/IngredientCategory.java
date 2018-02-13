package com.supinfo.supcooking.entity;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: CategIngredient
 *
 */
@Entity
@Table(name="ingredient_category")
public class IngredientCategory implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	
	public IngredientCategory() {
		super();
	}

	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
