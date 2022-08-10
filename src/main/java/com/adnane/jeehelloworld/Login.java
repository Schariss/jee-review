package com.adnane.jeehelloworld;

import java.io.*;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

// loadOnStartup = 1 execute init method immediately after servlet creation
@WebServlet(urlPatterns={"/login"})
public class Login extends HttpServlet {

    private String db_url;

    // A servlet is created only once
    public Login(){
        super();
        System.out.println("Login servlet created");
    }

    public void init() {
        // If we try doing this into the constructor we d get a 500 error
        // because we are not sure the servlet is created yet
        db_url = this.getServletContext().getInitParameter("DATABASE_URL");
        System.out.println("init, db url : " + db_url);
    }

//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("Service method called");
//        super.service(req, resp);
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        System.out.println(Thread.currentThread().getName());
        System.out.println("get method called");
        String usernameP = request.getParameter("username");
        String passwordP = request.getParameter("password");
        if(usernameP == null) usernameP = "";
        if(passwordP == null) passwordP = "";
        // if there is no session by passing true, a new session will automatically be created
        HttpSession session = request.getSession(true);
        session.setAttribute("username", usernameP);
        session.setAttribute("password", passwordP);
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        System.out.println("post method called");
        String usernameP = request.getParameter("username");
        String passwordP = request.getParameter("password");
        HttpSession session = request.getSession(true);
        session.setAttribute("username", usernameP);
        session.setAttribute("password", passwordP);

        if(usernameP.equals("Adnane") && passwordP.equals("Adnane")){
            session.setAttribute("isConnected", true);
            request.getRequestDispatcher("/home.jsp").forward(request, response);
        } else {
            session.setAttribute("isConnected", false);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("Servlet destroyed");
    }
}