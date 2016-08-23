package com.sdzee.tp.forms;

import javax.servlet.http.HttpServletRequest;

import com.sdzee.tp.beans.Client;

public final class CreationClientForm extends CreationForm {
    public static final String CHAMP_NOM       = "nomClient";
    public static final String CHAMP_PRENOM    = "prenomClient";
    public static final String CHAMP_ADRESSE   = "adresseClient";
    public static final String CHAMP_TELEPHONE = "telephoneClient";
    public static final String CHAMP_EMAIL     = "emailClient";

    public static final int    MIN_NOMPRENOM   = 2;
    public static final int    MIN_ADRESSE     = 9;
    public static final int    MIN_TELEPHONE   = 4;

    public CreationClientForm() {
        super();
    }

    public String resultat;

    public String getResultat() {
        return resultat;
    }

    public Client creerClient( HttpServletRequest req ) {
        InfosClient infosClient = new InfosClient(
                req.getParameter( CHAMP_NOM ),
                req.getParameter( CHAMP_PRENOM ),
                req.getParameter( CHAMP_ADRESSE ),
                req.getParameter( CHAMP_TELEPHONE ),
                req.getParameter( CHAMP_EMAIL ) );

        validationInfoClient( infosClient.nom, CHAMP_NOM );
        validationInfoClient( infosClient.prenom, CHAMP_PRENOM );
        validationInfoClient( infosClient.adresse, CHAMP_ADRESSE );
        int infoteleph = validationInfoClient( infosClient.telephone, CHAMP_TELEPHONE );
        validationInfoClient( infosClient.email, CHAMP_EMAIL );

        Client client = new Client(
                infosClient.nom,
                infosClient.prenom,
                infosClient.adresse,
                infoteleph,
                infosClient.email );

        resultat = initResultGlobalValidation( erreurs );

        return client;
    }

    private int validationInfoClient( String info, String champ ) {
        int val = -1;
        try {
            switch ( champ ) {
            case CHAMP_NOM:
                validationChampStringRequis( info, CHAMP_NOM, MIN_NOMPRENOM );
                break;
            case CHAMP_PRENOM:
                validationChampStringNRequis( info, CHAMP_PRENOM, MIN_NOMPRENOM );
                break;
            case CHAMP_ADRESSE:
                validationChampStringRequis( info, CHAMP_ADRESSE, MIN_ADRESSE );
                break;
            case CHAMP_TELEPHONE:
                val = validationChampInt( info, CHAMP_TELEPHONE, MIN_TELEPHONE );
                break;
            case CHAMP_EMAIL:
                validationChampEmail( info );
                break;
            default:
                break;
            }
        } catch ( Exception e ) {
            setErreur( champ, e.getMessage() );
        }
        return val;
    }

}

class InfosClient {
    public String nom;
    public String prenom;
    public String adresse;
    public String telephone;
    public String email;

    public InfosClient( String nom, String prenom, String adresse, String telephone, String email ) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
    }

}
