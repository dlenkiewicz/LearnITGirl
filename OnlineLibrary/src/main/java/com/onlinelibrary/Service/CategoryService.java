package com.onlinelibrary.Service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.onlinelibrary.DAO.CategoryDAOImpl;
import com.onlinelibrary.Model.Category;

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
}
