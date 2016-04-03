package com.onlinelibrary.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.onlinelibrary.DAO.BooksOutOnLoanDAOImpl;
import com.onlinelibrary.DAO.CopyDAOImpl;
import com.onlinelibrary.DAO.UserDAOImpl;
import com.onlinelibrary.Model.Book;
import com.onlinelibrary.Model.BooksOutOnLoan;
import com.onlinelibrary.Model.Copy;
import com.onlinelibrary.Model.User;

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
	
	@PUT
	@Path("/booksoutonloan")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void create(@FormParam("amount_of_fine") BigDecimal amountOfFine,
			@FormParam("date_due_for_return") String dateDueForReturn,
			@FormParam("date_issued") String dateIssued,
			@FormParam("date_returned") String dateReturned,
			@FormParam("userId") int userId,
			@FormParam("copyId") int copyId,
			@Context HttpServletResponse servletResponse) throws IOException{
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");		
				BooksOutOnLoan bookoutonloan = new BooksOutOnLoan();
				User user = new UserDAOImpl().get(userId);
				Copy copy = new CopyDAOImpl().get(copyId);
				bookoutonloan.setAmountOfFine(amountOfFine);
				try {
					bookoutonloan.setDateDueForReturn(dateFormat.parse(dateDueForReturn));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				try {
					bookoutonloan.setDateIssued(dateFormat.parse(dateIssued));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				try {
					bookoutonloan.setDateReturned(dateFormat.parse(dateReturned));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				bookoutonloan.setCopy(copy);
				bookoutonloan.setUser(user);
				booksOutOnLoanDao.create(bookoutonloan);
			}
	
	@POST
	@Path("/booksoutonloan/{id}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void update(@PathParam("id") int id,
			@FormParam("amount_of_fine") BigDecimal amountOfFine,
			@FormParam("date_due_for_return") String dateDueForReturn,
			@FormParam("date_issued") String dateIssued,
			@FormParam("date_returned") String dateReturned,
			@FormParam("userId") int userId,
			@FormParam("copyId") int copyId,
			@Context HttpServletResponse servletResponse) throws IOException{
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");		
				BooksOutOnLoan bookoutonloan = new BooksOutOnLoanDAOImpl().get(id);
				User user = new UserDAOImpl().get(userId);
				Copy copy = new CopyDAOImpl().get(copyId);
				bookoutonloan.setAmountOfFine(amountOfFine);
				try {
					bookoutonloan.setDateDueForReturn(dateFormat.parse(dateDueForReturn));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				try {
					bookoutonloan.setDateIssued(dateFormat.parse(dateIssued));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				try {
					bookoutonloan.setDateReturned(dateFormat.parse(dateReturned));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				bookoutonloan.setCopy(copy);
				bookoutonloan.setUser(user);
				booksOutOnLoanDao.update(bookoutonloan);
			}
}
