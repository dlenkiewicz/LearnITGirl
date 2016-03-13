package com.onlinelibrary.Service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.onlinelibrary.DAO.CopyDAOImpl;
import com.onlinelibrary.Model.Book;
import com.onlinelibrary.Model.Copy;
import com.onlinelibrary.Model.User;

@Path("/CopyService")
public class CopyService {
	CopyDAOImpl copyDao = new CopyDAOImpl();

	@GET
	@Path("/copies")
	@Produces(MediaType.APPLICATION_XML)
	public List<Copy> getAll(){
		return copyDao.getAll();
	   }	
	
	@GET
	@Path("/copies/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Copy get(@PathParam("id") int id){
		return copyDao.get(id);
	   }
	
	@DELETE
	@Path("/copies/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public void delete(@PathParam("id") int id){
		copyDao.delete(id);
	   }
	
}
