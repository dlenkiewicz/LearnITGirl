package com.onlinelibrary.Service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.onlinelibrary.DAO.AuthorshipDAOImpl;
import com.onlinelibrary.Model.Authorship;

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
}
