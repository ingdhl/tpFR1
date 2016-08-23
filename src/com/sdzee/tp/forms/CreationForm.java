package com.sdzee.tp.forms;

import java.util.HashMap;
import java.util.Map;

public class CreationForm {
    public static final String EMAIL_PATTERN = "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)";

    public String              resultat;

    public String getResultat() {
        return resultat;
    }

    public CreationForm() {
        resultat = null;
        erreurs = new HashMap<String, String>();
    }

    public Map<String, String> erreurs;

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public void validationChampStringRequis( String nom, String cleDuChamp, int minCaracteres ) throws Exception {
        if ( nom == null || nom.trim().isEmpty() ) {
            throw new Exception( "Le champ " + cleDuChamp
                    + " est obligatoire" );

        } else if ( !nom.trim().isEmpty() && nom.length() < minCaracteres )
            throw new Exception( "Le champ " + cleDuChamp
                    + " doit contenir au moins " + minCaracteres + " caractères" );
    }

    public void validationChampStringNRequis( String nom, String cleDuChamp, int minCaracteres ) throws Exception {
        if ( ( nom != null && !nom.trim().isEmpty() && nom.length() < minCaracteres ) )
            throw new Exception( "Le champ " + cleDuChamp
                    + " doit contenir au moins " + minCaracteres + " caractères" );
    }

    public int validationChampInt( String valeur, String cleDuChamp, int minCaracteres ) throws Exception {
        int val = -1;
        if ( valeur == null )
            throw new Exception( "Le champ " + cleDuChamp
                    + " est obligatoire" );
        else {
            try {
                val = Integer.parseInt( valeur );
                if ( valeur.length() < minCaracteres )
                    throw new Exception( "Le champ " + cleDuChamp
                            + " doit contenir au moins " + minCaracteres + " caractères" );
            } catch ( Exception e ) {
                throw new Exception( "Une valeur numérique est requise pour le champ " + cleDuChamp );
            }
        }
        return val;
    }

    public Double validationChampDouble( String valeur, String cleDuChamp, int minCaracteres ) throws Exception {
        Double val = -1.0;
        if ( valeur == null )
            throw new Exception( "Le champ " + cleDuChamp
                    + " est obligatoire" );
        else {
            try {
                val = Double.parseDouble( valeur );
                if ( valeur.length() < minCaracteres )
                    throw new Exception( "Le champ " + cleDuChamp
                            + " doit contenir au moins " + minCaracteres + " caractères" );
            } catch ( Exception e ) {
                throw new Exception( "Une valeur numérique est requise pour le champ " + cleDuChamp );
            }
        }
        return val;
    }

    public void validationChampEmail( String email ) throws Exception {
        if ( email != null ) {
            if ( !email.matches( EMAIL_PATTERN ) ) {
                throw new Exception( "Merci de saisir une adresse mail valide." );
            }
        } else {
            throw new Exception( "Merci de saisir une adresse mail." );
        }
    }

    public void setErreur( String cle, String erreur ) {
        erreurs.put( cle, erreur );
    }

    public String initResultGlobalValidation( Map<String, String> erreurs ) {
        String resultat = null;

        if ( erreurs.isEmpty() ) {
            resultat = "Succès de la création";
        } else {
            resultat = "Échec de la création";
        }

        return resultat;
    }
}
