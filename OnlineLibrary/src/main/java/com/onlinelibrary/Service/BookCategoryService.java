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
import com.onlinelibrary.DAO.BookCategoryDAOImpl;
import com.onlinelibrary.DAO.BookDAOImpl;
import com.onlinelibrary.DAO.CategoryDAOImpl;
import com.onlinelibrary.Model.Author;
import com.onlinelibrary.Model.Authorship;
import com.onlinelibrary.Model.Book;
import com.onlinelibrary.Model.BookCategory;
import com.onlinelibrary.Model.Category;

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
	
	@DELETE
	@Path("/bookcategories/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public void delete(@PathParam("id") int id){
		bookCategoryDao.delete(id);
	   }
	
	@PUT
	@Path("/bookcategories")
	public void create(@FormParam("isbn") String isbn, @FormParam("categoryId") int categoryId){
		Category category = new CategoryDAOImpl().get(categoryId);
		Book book = new BookDAOImpl().get(isbn);
		BookCategory bookCategory = new BookCategory();
		bookCategory.setCategory(category);
		bookCategory.setBook(book);
		//category.getBookCategories().add(bookCategory);
		//book.getBookCategories().add(bookCategory);
		bookCategoryDao.create(bookCategory);
		}
	
	@POST
	@Path("/bookcategories/{id}")
	public void update(@PathParam("id") int id, 
			@FormParam("isbn") String isbn, 
			@FormParam("categoryId") int categoryId){
				BookCategory bookCategory = new BookCategoryDAOImpl().get(id);
				Category category = new CategoryDAOImpl().get(categoryId);
				Book book = new BookDAOImpl().get(isbn);
				bookCategory.setCategory(category);
				bookCategory.setBook(book);
				bookCategoryDao.update(bookCategory);
		}
}
