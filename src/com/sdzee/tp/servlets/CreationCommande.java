package com.sdzee.tp.servlets;

import java.io.IOException;
//import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdzee.tp.beans.Commande;
import com.sdzee.tp.datas.CreationListeCommandes;
import com.sdzee.tp.forms.CreationCommandeForm;

public class CreationCommande extends HttpServlet {
    public static final String VUE_AFFICHAGE = "/WEB-INF/afficherCommande.jsp";
    public static final String VUE_FORM      = "/WEB-INF/creerCommande.jsp";
    public static final String ATTR_FORM     = "form";
    public static final String ATTR_COMMANDE = "commande";
    public static final String ATTR_CLIENT   = "client";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
    }

    @Override
    protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        CreationCommandeForm form = new CreationCommandeForm();
        CreationListeCommandes cListeCdes = new CreationListeCommandes();
        Commande commande = form.creerCommande( req );

        req.setAttribute( ATTR_FORM, form );
        req.setAttribute( ATTR_COMMANDE, commande );
        req.setAttribute( ATTR_CLIENT, commande.getClient() );

        if ( form.getErreurs().isEmpty() ) {
            cListeCdes.addCommande( req, commande );
            this.getServletContext().getRequestDispatcher( VUE_AFFICHAGE ).forward( req, resp );
        } else
            this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( req, resp );
    }

}