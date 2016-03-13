package com.onlinelibrary.Model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/**
 * The persistent class for the book_category database table.
 * 
 */
@Entity
@Table(name="book_category")
@NamedQuery(name="BookCategory.findAll", query="SELECT b FROM BookCategory b")
@XmlRootElement(name = "book_category")
@XmlAccessorType(XmlAccessType.FIELD)
public class BookCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	//bi-directional many-to-one association to Book
	@ManyToOne
	@JoinColumn(name="isbn")
	private Book book;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="cat_id")
	private Category category;

	public BookCategory() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}