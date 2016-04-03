package com.onlinelibrary.Model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import java.util.List;


/**
 * The persistent class for the books database table.
 * 
 */
@Entity
@Table(name="books")
@NamedQuery(name="Book.findAll", query="SELECT b FROM Book b")
@XmlRootElement(name = "books")
@XmlAccessorType(XmlAccessType.FIELD)
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String isbn;

	@Column(name="date_of_publication")
	private Integer dateOfPublication;

	private String publisher;

	private String title;

	//bi-directional many-to-one association to Authorship
	@OneToMany(mappedBy="book")
	@XmlTransient
	private List<Authorship> authorships;

	//bi-directional many-to-one association to BookCategory
	@OneToMany(mappedBy="book")
	@XmlTransient
	private List<BookCategory> bookCategories;

	//bi-directional many-to-one association to Copy
	@OneToMany(mappedBy="book")
	@XmlTransient
	private List<Copy> copies;

	public Book() {
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getDateOfPublication() {
		return this.dateOfPublication;
	}

	public void setDateOfPublication(Integer dateOfPublication) {
		this.dateOfPublication = dateOfPublication;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Authorship> getAuthorships() {
		return this.authorships;
	}

	public void setAuthorships(List<Authorship> authorships) {
		this.authorships = authorships;
	}

	public Authorship addAuthorship(Authorship authorship) {
		getAuthorships().add(authorship);
		authorship.setBook(this);

		return authorship;
	}

	public Authorship removeAuthorship(Authorship authorship) {
		getAuthorships().remove(authorship);
		authorship.setBook(null);

		return authorship;
	}

	public List<BookCategory> getBookCategories() {
		return this.bookCategories;
	}

	public void setBookCategories(List<BookCategory> bookCategories) {
		this.bookCategories = bookCategories;
	}

	public BookCategory addBookCategory(BookCategory bookCategory) {
		getBookCategories().add(bookCategory);
		bookCategory.setBook(this);

		return bookCategory;
	}

	public BookCategory removeBookCategory(BookCategory bookCategory) {
		getBookCategories().remove(bookCategory);
		bookCategory.setBook(null);

		return bookCategory;
	}

	public List<Copy> getCopies() {
		return this.copies;
	}

	public void setCopies(List<Copy> copies) {
		this.copies = copies;
	}

	public Copy addCopy(Copy copy) {
		getCopies().add(copy);
		copy.setBook(this);

		return copy;
	}

	public Copy removeCopy(Copy copy) {
		getCopies().remove(copy);
		copy.setBook(null);

		return copy;
	}

}