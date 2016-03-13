package com.onlinelibrary.Model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the books_out_on_loan database table.
 * 
 */
@Entity
@Table(name="books_out_on_loan")
@NamedQuery(name="BooksOutOnLoan.findAll", query="SELECT b FROM BooksOutOnLoan b")
@XmlRootElement(name = "books_out_on_loan")
@XmlAccessorType(XmlAccessType.FIELD)
public class BooksOutOnLoan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="amount_of_fine")
	private BigDecimal amountOfFine;

	@Temporal(TemporalType.DATE)
	@Column(name="date_due_for_return")
	private Date dateDueForReturn;

	@Temporal(TemporalType.DATE)
	@Column(name="date_issued")
	private Date dateIssued;

	@Temporal(TemporalType.DATE)
	@Column(name="date_returned")
	private Date dateReturned;

	//bi-directional many-to-one association to Copy
	@ManyToOne
	@XmlTransient
	private Copy copy;
	
	@ManyToOne
	@XmlTransient
	@JoinColumn(name="u_id")
	private User user;
	
	public BooksOutOnLoan() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getAmountOfFine() {
		return this.amountOfFine;
	}

	public void setAmountOfFine(BigDecimal amountOfFine) {
		this.amountOfFine = amountOfFine;
	}

	public Date getDateDueForReturn() {
		return this.dateDueForReturn;
	}

	public void setDateDueForReturn(Date dateDueForReturn) {
		this.dateDueForReturn = dateDueForReturn;
	}

	public Date getDateIssued() {
		return this.dateIssued;
	}

	public void setDateIssued(Date dateIssued) {
		this.dateIssued = dateIssued;
	}

	public Date getDateReturned() {
		return this.dateReturned;
	}

	public void setDateReturned(Date dateReturned) {
		this.dateReturned = dateReturned;
	}

	public Copy getCopy() {
		return this.copy;
	}

	public void setCopy(Copy copy) {
		this.copy = copy;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}