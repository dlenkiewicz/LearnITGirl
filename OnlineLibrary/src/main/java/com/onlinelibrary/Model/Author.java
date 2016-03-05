package com.onlinelibrary.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the author database table.
 * 
 */
@Entity
@NamedQuery(name="Author.findAll", query="SELECT a FROM Author a")
public class Author implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String name;

	private String surname;

	//bi-directional many-to-one association to Authorship
	@OneToMany(mappedBy="author")
	private List<Authorship> authorships;

	public Author() {
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

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Authorship> getAuthorships() {
		return this.authorships;
	}

	public void setAuthorships(List<Authorship> authorships) {
		this.authorships = authorships;
	}

	public Authorship addAuthorship(Authorship authorship) {
		getAuthorships().add(authorship);
		authorship.setAuthor(this);

		return authorship;
	}

	public Authorship removeAuthorship(Authorship authorship) {
		getAuthorships().remove(authorship);
		authorship.setAuthor(null);

		return authorship;
	}

}