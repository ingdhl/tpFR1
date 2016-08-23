package com.sdzee.tp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreationListeClients extends HttpServlet {
    public static final String VUE_LISTECLIENTS = "/WEB-INF/listerClients.jsp";

    @Override
    protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {

        req.getServletContext().getRequestDispatcher( VUE_LISTECLIENTS ).forward( req, resp );
    }

}
