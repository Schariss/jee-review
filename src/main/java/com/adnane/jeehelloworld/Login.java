package com.adnane.jeehelloworld;

import java.io.*;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "login", urlPatterns={"/login"})
public class Login extends HttpServlet {

    public void init() {
        System.out.println("I am right here");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Service method called");
        super.service(req, resp);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("get method called");
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("     <head>");
            out.println("         <title>Login Page</title>");
            out.println("     </head>");
            out.println("     <body>");
            out.print("         <h1>Login</h1>");
            out.println("         <h2>" + new Date() + "</h2>");
            out.println("         <form method='post' action='login'>");
            out.println("               <input type='text' size='20' name='username' placeholder='Username'>");
            out.println("               <input type='password' name='password' placeholder='Password'>");
            out.println("               <input type='submit' value='sign in'>");
            out.println("         </form>");
            out.println("     </body>");
            out.println("</html>");
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("post method called");
        String usernameP = request.getParameter("username");
        String passwordP = request.getParameter("username");
        if(usernameP.equals("Adnane") && passwordP.equals("Adnane")){
            response.setContentType("text/html");
            try(PrintWriter out = response.getWriter()){
                out.println("Successfully logged in");
            }
        } else {
            doGet(request, response);
        }
    }
}