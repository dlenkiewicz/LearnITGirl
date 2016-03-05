package com.onlinelibrary.Model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the authorship database table.
 * 
 */
@Entity
@NamedQuery(name="Authorship.findAll", query="SELECT a FROM Authorship a")
public class Authorship implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	//bi-directional many-to-one association to Author
	@ManyToOne
	@JoinColumn(name="auth_id")
	private Author author;

	//bi-directional many-to-one association to Book
	@ManyToOne
	@JoinColumn(name="isbn")
	private Book book;

	public Authorship() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Author getAuthor() {
		return this.author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}