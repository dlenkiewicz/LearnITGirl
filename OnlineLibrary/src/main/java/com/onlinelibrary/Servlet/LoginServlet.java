package com.onlinelibrary.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlinelibrary.DAO.UserDAOImpl;
import com.onlinelibrary.Model.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
    
    UserDAOImpl userDao = new UserDAOImpl();
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
 
        // get request parameters for userID and password
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");
        
        String userCompare = userDao.getByEmail(user).getEmail();
        String passwordCompare = userDao.getByEmail(user).getPassword();
         
        if(userCompare.equals(user) && passwordCompare.equals(pwd)){
            HttpSession session = request.getSession();
            session.setAttribute("user", userDao.getByEmail(user).getName());
            //setting session to expiry in 30 mins
            session.setMaxInactiveInterval(30*60);
            Cookie userName = new Cookie("user", user);
            userName.setMaxAge(30*60);
            response.addCookie(userName);
            response.sendRedirect("profile.html");
        }else{
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
            PrintWriter out= response.getWriter();
            out.println("<font color=red>Either user name or password is wrong.</font>");
            rd.include(request, response);
 
        }
    }
}
