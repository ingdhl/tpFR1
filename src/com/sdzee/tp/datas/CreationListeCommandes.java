package com.sdzee.tp.datas;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.sdzee.tp.beans.Commande;

public class CreationListeCommandes {
    public static final String    NOM_LISTE_COMMANDES = "listeCommandes";
    private Map<String, Commande> listeCommandes;

    public CreationListeCommandes() {
        this.listeCommandes = new HashMap<String, Commande>();
    }

    public Map<String, Commande> getListeClients() {
        return listeCommandes;
    }

    private void setListeCommandes( Map<String, Commande> listeCommandes ) {
        this.listeCommandes = listeCommandes;
    }

    public void addCommande( HttpServletRequest req, Commande commande ) {

        if ( req.getSession().getAttribute( NOM_LISTE_COMMANDES ) != null ) {
            this.setListeCommandes( (Map<String, Commande>) req.getSession().getAttribute( NOM_LISTE_COMMANDES ) );
        }
        this.listeCommandes.put( commande.getDate(), commande );
        req.getSession().setAttribute( NOM_LISTE_COMMANDES, this.listeCommandes );
    }

}
