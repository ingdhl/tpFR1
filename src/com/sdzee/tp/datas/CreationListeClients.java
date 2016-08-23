package com.sdzee.tp.datas;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.sdzee.tp.beans.Client;

public class CreationListeClients {
    public static final String  NOM_LISTE_CLIENTS = "listeClients";
    private Map<String, Client> listeClients;

    public CreationListeClients() {
        this.listeClients = new HashMap<String, Client>();
    }

    public Map<String, Client> getListeClients() {
        return listeClients;
    }

    private void setListeClients( Map<String, Client> listeClients ) {
        this.listeClients = listeClients;
    }

    public void addClient( HttpServletRequest req, Client client ) {

        if ( req.getSession().getAttribute( NOM_LISTE_CLIENTS ) != null ) {
            this.setListeClients( (Map<String, Client>) req.getSession().getAttribute( NOM_LISTE_CLIENTS ) );
        }
        this.listeClients.put( client.getNom(), client );
        req.getSession().setAttribute( NOM_LISTE_CLIENTS, this.listeClients );
    }

}
