package com.onlinelibrary.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categories database table.
 * 
 */
@Entity
@Table(name="categories")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String name;

	//bi-directional many-to-one association to BookCategory
	@OneToMany(mappedBy="category")
	private List<BookCategory> bookCategories;

	public Category() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<BookCategory> getBookCategories() {
		return this.bookCategories;
	}

	public void setBookCategories(List<BookCategory> bookCategories) {
		this.bookCategories = bookCategories;
	}

	public BookCategory addBookCategory(BookCategory bookCategory) {
		getBookCategories().add(bookCategory);
		bookCategory.setCategory(this);

		return bookCategory;
	}

	public BookCategory removeBookCategory(BookCategory bookCategory) {
		getBookCategories().remove(bookCategory);
		bookCategory.setCategory(null);

		return bookCategory;
	}

}