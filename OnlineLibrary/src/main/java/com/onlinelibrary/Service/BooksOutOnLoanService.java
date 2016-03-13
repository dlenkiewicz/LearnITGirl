package com.onlinelibrary.Service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.onlinelibrary.DAO.BooksOutOnLoanDAOImpl;
import com.onlinelibrary.Model.BooksOutOnLoan;

@Path("/BooksOutOnLoanService")
public class BooksOutOnLoanService {
	BooksOutOnLoanDAOImpl booksOutOnLoanDao = new BooksOutOnLoanDAOImpl();

	@GET
	@Path("/booksoutonloan")
	@Produces(MediaType.APPLICATION_XML)
	public List<BooksOutOnLoan> getAll(){
		return booksOutOnLoanDao.getAll();
	   }	
	
	@GET
	@Path("/booksoutonloan/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public BooksOutOnLoan get(@PathParam("id") int id){
		return booksOutOnLoanDao.get(id);
	   }
	
	@DELETE
	@Path("/booksoutonloan/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public void delete(@PathParam("id") int id){
		booksOutOnLoanDao.delete(id);
	   }
}
