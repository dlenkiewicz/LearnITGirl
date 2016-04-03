package com.onlinelibrary.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
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

import com.onlinelibrary.DAO.CategoryDAOImpl;
import com.onlinelibrary.DAO.CopyDAOImpl;
import com.onlinelibrary.DAO.UserDAOImpl;
import com.onlinelibrary.Model.BooksOutOnLoan;
import com.onlinelibrary.Model.Category;
import com.onlinelibrary.Model.Copy;
import com.onlinelibrary.Model.User;

@Path("/CategoryService")
public class CategoryService {
	CategoryDAOImpl categoryDao = new CategoryDAOImpl();

	@GET
	@Path("/categories")
	@Produces(MediaType.APPLICATION_XML)
	public List<Category> getAll(){
		return categoryDao.getAll();
	   }	
	
	@GET
	@Path("/categories/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Category get(@PathParam("id") int id){
		return categoryDao.get(id);
	   }
	
	@DELETE
	@Path("/categories/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public void delete(@PathParam("id") int id){
		categoryDao.delete(id);
	   }
	
	@PUT
	@Path("/categories")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void create(@FormParam("name") String name,
			@Context HttpServletResponse servletResponse) throws IOException{
				Category category = new Category();
				category.setName(name);
				categoryDao.create(category);
			}
	
	@POST
	@Path("/categories/{id}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void update(@PathParam("id") int id,
			@FormParam("name") String name,
			@Context HttpServletResponse servletResponse) throws IOException{
				Category category = new CategoryDAOImpl().get(id);
				category.setName(name);
				categoryDao.update(category);
			}
}
