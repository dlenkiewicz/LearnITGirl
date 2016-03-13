package com.onlinelibrary.Model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import java.util.List;


/**
 * The persistent class for the copies database table.
 * 
 */
@Entity
@Table(name="copies")
@NamedQuery(name="Copy.findAll", query="SELECT c FROM Copy c")
@XmlRootElement(name = "copies")
@XmlAccessorType(XmlAccessType.FIELD)
public class Copy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	//bi-directional many-to-one association to BooksOutOnLoan
	@OneToMany(mappedBy="copy")
	@XmlTransient
	private List<BooksOutOnLoan> booksOutOnLoans;

	//bi-directional many-to-one association to Book
	@ManyToOne
	@JoinColumn(name="isbn")
	private Book book;

	public Copy() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<BooksOutOnLoan> getBooksOutOnLoans() {
		return this.booksOutOnLoans;
	}

	public void setBooksOutOnLoans(List<BooksOutOnLoan> booksOutOnLoans) {
		this.booksOutOnLoans = booksOutOnLoans;
	}

	public BooksOutOnLoan addBooksOutOnLoan(BooksOutOnLoan booksOutOnLoan) {
		getBooksOutOnLoans().add(booksOutOnLoan);
		booksOutOnLoan.setCopy(this);

		return booksOutOnLoan;
	}

	public BooksOutOnLoan removeBooksOutOnLoan(BooksOutOnLoan booksOutOnLoan) {
		getBooksOutOnLoans().remove(booksOutOnLoan);
		booksOutOnLoan.setCopy(null);

		return booksOutOnLoan;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}