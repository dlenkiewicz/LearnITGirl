package com.onlinelibrary.Service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.onlinelibrary.DAO.AuthorDAOImpl;
import com.onlinelibrary.DAO.AuthorshipDAOImpl;
import com.onlinelibrary.DAO.BookDAOImpl;
import com.onlinelibrary.Model.Author;
import com.onlinelibrary.Model.Authorship;
import com.onlinelibrary.Model.Book;

@Path("/AuthorshipService")
public class AuthorshipService {
	AuthorshipDAOImpl authorshipDao = new AuthorshipDAOImpl();

	@GET
	@Path("/authorships")
	@Produces(MediaType.APPLICATION_XML)
	public List<Authorship> getAll(){
		return authorshipDao.getAll();
	   }	
	
	@GET
	@Path("/authorships/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Authorship get(@PathParam("id") int id){
		return authorshipDao.get(id);
	   }
	
	@DELETE
	@Path("/authorships/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public void delete(@PathParam("id") int id){
		authorshipDao.delete(id);
	   }
	
	@PUT
	@Path("/authorships")
	public void create(@FormParam("authorId") int authorId, @FormParam("isbn") String isbn){
		Author author = new AuthorDAOImpl().get(authorId);
		Book book = new BookDAOImpl().get(isbn);
		Authorship authorship = new Authorship();
		authorship.setAuthor(author);
		authorship.setBook(book);
		//author.getAuthorships().add(authorship);
		//book.getAuthorships().add(authorship);
		authorshipDao.create(authorship);
	}
	
	@POST
	@Path("/authorships/{id}")
	public void update(@PathParam("id") int id, @FormParam("authorId") int authorId, @FormParam("isbn") String isbn){
		Authorship authorship = new AuthorshipDAOImpl().get(id);
		Author author = new AuthorDAOImpl().get(authorId);
		Book book = new BookDAOImpl().get(isbn);
		authorship.setAuthor(author);
		authorship.setBook(book);
		authorshipDao.update(authorship);
	}
}
