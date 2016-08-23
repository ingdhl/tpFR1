package com.sdzee.tp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdzee.tp.beans.Client;
import com.sdzee.tp.datas.CreationListeClients;
import com.sdzee.tp.forms.CreationClientForm;

public class CreationClient extends HttpServlet {
    public static final String VUE_AFFICHAGE = "/WEB-INF/afficherClient.jsp";
    public static final String VUE_FORM      = "/WEB-INF/creerClient.jsp";
    public static final String ATTR_FORM     = "form";
    public static final String ATTR_CLIENT   = "client";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
    }

    @Override
    protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        CreationClientForm form = new CreationClientForm();
        Client client = form.creerClient( req );
        CreationListeClients cListeCli = new CreationListeClients();

        req.setAttribute( ATTR_FORM, form );
        req.setAttribute( ATTR_CLIENT, client );
        if ( form.getErreurs().isEmpty() ) {
            cListeCli.addClient( req, client );
            this.getServletContext().getRequestDispatcher( VUE_AFFICHAGE ).forward( req, resp );
        } else
            this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( req, resp );
    }

}