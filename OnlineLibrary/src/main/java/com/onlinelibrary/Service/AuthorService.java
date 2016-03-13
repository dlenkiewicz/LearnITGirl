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

import com.onlinelibrary.DAO.AuthorDAOImpl;
import com.onlinelibrary.Model.Author;

@Path("/AuthorService")
public class AuthorService {
	AuthorDAOImpl authorDao = new AuthorDAOImpl();

	@GET
	@Path("/authors")
	@Produces(MediaType.APPLICATION_XML)
	public List<Author> getAll(){
		return authorDao.getAll();
	   }	
	
	@GET
	@Path("/authors/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Author get(@PathParam("id") int id){
		Author author = authorDao.get(id);
		return author;
	   }
	
	@DELETE
	@Path("/authors/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public void delete(@PathParam("id") int id){
		authorDao.delete(id);
	   }
	
	@PUT
	@Path("/authors")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void create(@FormParam("name") String name,
			@FormParam("surname") String surname,
			@Context HttpServletResponse servletResponse) throws IOException{
				Author Author = new Author();
				Author.setName(name);
				Author.setSurname(surname);
				authorDao.create(Author);
			}
	
	@POST
	@Path("/authors")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void update(@FormParam("name") String name,
			@FormParam("surname") String surname,
			@Context HttpServletResponse servletResponse) throws IOException{
				Author Author = new Author();
				Author.setName(name);
				Author.setSurname(surname);
				authorDao.update(Author);
			}
}
