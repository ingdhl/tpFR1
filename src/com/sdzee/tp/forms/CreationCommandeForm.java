package com.sdzee.tp.forms;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.sdzee.tp.beans.Client;
import com.sdzee.tp.beans.Commande;
import com.sdzee.tp.datas.CreationListeClients;

public class CreationCommandeForm extends CreationForm {
    public static final String DATE_PATTERN             = "dd/MM/yyyy HH:mm:ss";
    public static final String CHAMP_MONTANT            = "montantCommande";
    public static final String CHAMP_MODE_PAIMENT       = "modePaiementCommande";
    public static final String CHAMP_STATUT_PAIEMENT    = "statutPaiementCommande";
    public static final String CHAMP_MODE_LIVRAISON     = "modeLivraisonCommande";
    public static final String CHAMP_STATUT_LIVRAISON   = "statutLivraisonCommande";
    public static final String CHAMP_CHOIX_SAISI_CLIENT = "choixSaisiClient";
    public static final String CHAMP_ANCIEN_CLIENT      = "ancienClient";
    public static final String CHAMP_LISTE_CHOIXCLIENT  = "listeChoixClients";

    public static final int    MIN_CAR                  = 2;

    public CreationCommandeForm() {
        super();
    }

    public Commande creerCommande( HttpServletRequest req ) {
        CreationClientForm formCli = new CreationClientForm();
        // Client client = formCli.creerClient( req );
        Client client = this.getClient( req, formCli );

        InfosCommande infoCde = new InfosCommande(
                req.getParameter( FormaterDateCourante( DATE_PATTERN ) ),
                req.getParameter( CHAMP_MONTANT ),
                req.getParameter( CHAMP_MODE_PAIMENT ),
                req.getParameter( CHAMP_STATUT_PAIEMENT ),
                req.getParameter( CHAMP_MODE_LIVRAISON ),
                req.getParameter( CHAMP_STATUT_LIVRAISON ) );

        Double montantCde = validationInfoCommande( infoCde.montant, CHAMP_MONTANT );
        validationInfoCommande( infoCde.modePaiement, CHAMP_MODE_PAIMENT );
        validationInfoCommande( infoCde.modeLivraison, CHAMP_MODE_LIVRAISON );
        validationInfoCommande( infoCde.statutLivraison, CHAMP_STATUT_LIVRAISON );

        Commande commande = new Commande(
                client,
                infoCde.date,
                montantCde,
                infoCde.modePaiement,
                infoCde.statutPaiement,
                infoCde.modeLivraison,
                infoCde.statutLivraison );
        initResultGlobalValidation( this.erreurs );
        fusionnerErreursClient( formCli );
        return commande;
    }

    private Double validationInfoCommande( String info, String champ ) {
        Double val = -1.0;
        try {
            switch ( champ ) {

            case CHAMP_MONTANT:
                val = validationChampDouble( info, CHAMP_MONTANT, 0 );
                break;
            case CHAMP_MODE_PAIMENT:
                validationChampStringRequis( info, CHAMP_MODE_PAIMENT, MIN_CAR );
                break;
            case CHAMP_MODE_LIVRAISON:
                validationChampStringRequis( info, CHAMP_MODE_LIVRAISON, MIN_CAR );
                break;
            case CHAMP_STATUT_LIVRAISON:
                validationChampStringNRequis( info, CHAMP_STATUT_LIVRAISON, MIN_CAR );
                break;
            default:
                break;
            }
        } catch ( Exception e ) {
            setErreur( champ, e.getMessage() );
        }
        return val;
    }

    private String FormaterDateCourante( String datePattern ) {
        /* Récupération de la date courante */
        DateTime dt = new DateTime();
        /* Conversion de la date en String selon le format défini */
        DateTimeFormatter formatter = DateTimeFormat.forPattern( datePattern );

        return dt.toString( formatter );
    }

    private void fusionnerErreursClient( CreationClientForm formcli ) {
        this.erreurs.putAll( formcli.erreurs );
    }

    private Client getClient( HttpServletRequest req, CreationClientForm formCli ) {
        HttpSession session = req.getSession();
        Client client = null;
        String choixClient = req.getParameter( CHAMP_CHOIX_SAISI_CLIENT );
        if ( choixClient != null && choixClient != CHAMP_ANCIEN_CLIENT ) {
            String nomClient = req.getParameter( CHAMP_LISTE_CHOIXCLIENT );
            Map<String, Client> liste;
            if ( nomClient != null ) {
                liste = (Map<String, Client>) session.getAttribute( CreationListeClients.NOM_LISTE_CLIENTS );
                client = liste.get( nomClient );
            } else
                client = formCli.creerClient( req );
        }

        return client;
    }

}

class InfosCommande {
    public String date;
    public String modePaiement;
    public String statutPaiement;
    public String modeLivraison;
    public String statutLivraison;
    public String montant;

    public InfosCommande( String date, String montant, String modePaiement, String statutPaiement, String modeLivraison,
            String statutLivraison ) {
        this.date = date;
        this.montant = montant;
        this.modePaiement = modePaiement;
        this.statutPaiement = statutPaiement;
        this.modeLivraison = modeLivraison;
        this.statutLivraison = statutLivraison;
    }

}