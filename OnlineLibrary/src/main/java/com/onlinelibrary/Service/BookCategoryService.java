package com.onlinelibrary.Service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.onlinelibrary.DAO.BookCategoryDAOImpl;
import com.onlinelibrary.Model.BookCategory;

@Path("/BookCategoryService")
public class BookCategoryService {
	BookCategoryDAOImpl bookCategoryDao = new BookCategoryDAOImpl();

	@GET
	@Path("/bookcategories")
	@Produces(MediaType.APPLICATION_XML)
	public List<BookCategory> getAll(){
		return bookCategoryDao.getAll();
	   }	
	
	@GET
	@Path("/bookcategories/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public BookCategory get(@PathParam("id") int id){
		return bookCategoryDao.get(id);
	   }
}
