package com.onlinelibrary.Service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.onlinelibrary.DAO.BookDAOImpl;
import com.onlinelibrary.Model.Author;
import com.onlinelibrary.Model.Book;

@Path("/BookService")
public class BookService {
	BookDAOImpl bookDao = new BookDAOImpl();

	@GET
	@Path("/books")
	@Produces(MediaType.APPLICATION_XML)
	public List<Book> getAll(){
		return bookDao.getAll();
	   }	
	
	@GET
	@Path("/books/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Book get(@PathParam("id") int id){
		return bookDao.get(id);
	   }
	
	@DELETE
	@Path("/books/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public void delete(@PathParam("id") int id){
		bookDao.delete(id);
	   }
	
	@PUT
	@Path("/books")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void create(@FormParam("isbn") String isbn,
			@FormParam("date_of_publication") int dateOfPublication,
			@FormParam("publisher") String publisher,
			@FormParam("title") String title,
			@Context HttpServletResponse servletResponse) throws IOException{
				Book book = new Book();
				book.setIsbn(isbn);
				book.setDateOfPublication(dateOfPublication);
				book.setPublisher(publisher);
				book.setTitle(title);
				bookDao.create(book);
			}
	
	@POST
	@Path("/books")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void update(@FormParam("isbn") String isbn,
			@FormParam("date_of_publication") int dateOfPublication,
			@FormParam("publisher") String publisher,
			@FormParam("title") String title,
			@Context HttpServletResponse servletResponse) throws IOException{
				Book book = new Book();
				book.setIsbn(isbn);
				book.setDateOfPublication(dateOfPublication);
				book.setPublisher(publisher);
				book.setTitle(title);
				bookDao.update(book);
			}
}
