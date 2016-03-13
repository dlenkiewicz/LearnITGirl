package com.onlinelibrary.Service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.onlinelibrary.DAO.BookDAOImpl;
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
}
