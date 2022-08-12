package com.adnane.jeehelloworld.ihm;

import com.adnane.jeehelloworld.dao.DAOContext;
import com.adnane.jeehelloworld.dao.UserDAO;
import com.adnane.jeehelloworld.model.CatalogBrowser;
import com.adnane.jeehelloworld.model.User;

import java.io.*;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

// loadOnStartup = 1 execute init method immediately after servlet creation
@WebServlet(urlPatterns={"/login"}, loadOnStartup = 1)
public class Login extends HttpServlet {

    // A servlet is created only once
    public Login(){
        super();
        System.out.println("Login servlet created");
    }

    public void init() {
        // If we try doing this into the constructor we d get a 500 error
        // because we are not sure the servlet is created yet
        DAOContext.init(this.getServletContext());
    }

//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("Service method called");
//        super.service(req, resp);
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setAttribute( "username", "" );
        request.setAttribute( "password", "" );
        request.setAttribute( "errorMessage", "" );
        request.getRequestDispatcher( "/login.jsp" ).forward( request, response );
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String login = request.getParameter( "username" );
        String password = request.getParameter( "password" );

        request.setAttribute( "username", login );

        User connectedUser = UserDAO.isValidLogin( login, password );
        if ( connectedUser != null ) {
            HttpSession session = request.getSession( true );
            session.setAttribute( "connectedUser", connectedUser );
            session.setAttribute( "catalogBrowser", new CatalogBrowser() );
            request.getRequestDispatcher( "/viewArticle.jsp" ).forward( request, response );

        } else {
            request.setAttribute( "password", password );
            request.setAttribute( "errorMessage", "Bad identity" );
            request.getRequestDispatcher( "/login.jsp" ).forward( request, response );

        }
    }
}