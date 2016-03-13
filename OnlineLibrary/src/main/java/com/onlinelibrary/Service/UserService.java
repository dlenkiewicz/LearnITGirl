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

import com.onlinelibrary.DAO.UserDAOImpl;
import com.onlinelibrary.Model.User;

@Path("/UserService")
public class UserService {
	UserDAOImpl userDao = new UserDAOImpl();

	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_XML)
	public List<User> getAll(){
		return userDao.getAll();
	   }	
	
	@GET
	@Path("/users/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public User get(@PathParam("id") int id){
		return userDao.get(id);
	   }
	
	@DELETE
	@Path("/users/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public void delete(@PathParam("id") int id){
		userDao.delete(id);
	   }
	
	@PUT
	@Path("/users")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void create(@FormParam("name") String name,
			@FormParam("surname") String surname,
			@FormParam("street_address") String streetAddress,
			@FormParam("city") String city,
			@FormParam("email") String email,
			@FormParam("password") String password,
			@FormParam("phone_number") String phoneNumber,
			@Context HttpServletResponse servletResponse) throws IOException{
				User user = new User();
				user.setName(name);
				user.setSurname(surname);
				user.setStreetAddress(streetAddress);
				user.setCity(city);
				user.setEmail(email);
				user.setPassword(password);
				user.setPhoneNumber(phoneNumber);
				userDao.create(user);
			}
	
	@POST
	@Path("/users")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void update(@FormParam("name") String name,
			@FormParam("surname") String surname,
			@FormParam("street_address") String streetAddress,
			@FormParam("city") String city,
			@FormParam("email") String email,
			@FormParam("password") String password,
			@FormParam("phone_number") String phoneNumber,
			@Context HttpServletResponse servletResponse) throws IOException{
				User user = new User();
				user.setName(name);
				user.setSurname(surname);
				user.setStreetAddress(streetAddress);
				user.setCity(city);
				user.setEmail(email);
				user.setPassword(password);
				user.setPhoneNumber(phoneNumber);
				userDao.update(user);
			}
}
