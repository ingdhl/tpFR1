<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Création d'une commande</title>
        <link type="text/css" rel="stylesheet" href="inc/style.css" />
    </head>
    <body>
    	<div>
    		<c:import  url="menu.jsp"/>
    	</div>
        <div>	      
            <form method="post" action="creationCommande">
                <fieldset>
                    <legend>Informations client</legend>                
                	<p>
	                	<label for="lblQstionClient">Nouveau client? </label>
	                	<INPUT type= "radio" name="choixSaisiClient" id="choixSaisiClient" value="nouveauClient" checked="checked"> oui 
	                	<INPUT type= "radio" name="choixSaisiClient" id="choixSaisiClient" value="ancienClient"> non
                	</p>
                	<div id="nouveauClient">
                		<c:import  url="clientToInclude.jsp"/>
                	</div>

                	<div id="ancienClient">
                		<select name="listeChoixClients" id="listeChoixClients" >
							<c:forEach var="client" items="${sessionScope.listeClients }">
								<option value='<c:out value="${ client.value.nom }" />'>
									<c:out value="${ client.value.nom }" />
								</option>
							</c:forEach>							
						</select>
                	</div>
                	
                </fieldset>		
                <fieldset>
                    <legend>Informations commande</legend>
                    
                    <label for="dateCommande">Date <span class="requis">*</span></label>
                    <input type="text" id="dateCommande" name="dateCommande" 
                    value="${ commande.date }" size="20" maxlength="20" disabled />
                    <br />
                    
                    <label for="montantCommande">Montant <span class="requis">*</span></label>
                    <input type="text" id="montantCommande" name="montantCommande" 
                    value='<c:if test="${ commande.montant > 0 }"> <c:out value="${ commande.montant }"/></c:if>' size="20" maxlength="20" />
                    <span class="erreur"><c:out value="${ form.erreurs['montantCommande'] }"/></span>
                    <br />
                    
                    <label for="modePaiementCommande">Mode de paiement <span class="requis">*</span></label>
                    <input type="text" id="modePaiementCommande" name="modePaiementCommande" 
                    value="<c:out value="${ commande.modePaiement }"/>" size="20" maxlength="20" />
                    <span class="erreur"><c:out value="${ form.erreurs['modePaiementCommande'] }"/></span>
                    <br />
                    
                    <label for="statutPaiementCommande">Statut du paiement</label>
                    <input type="text" id="statutPaiementCommande" name="statutPaiementCommande" 
                    value="<c:out value="${ commande.statutPaiement }"/>" size="20" maxlength="20" />
                    <span class="erreur"><c:out value="${ form.erreurs['statutPaiementCommande'] }"/></span>
                    <br />
                    
                    <label for="modeLivraisonCommande">Mode de livraison <span class="requis">*</span></label>
                    <input type="text" id="modeLivraisonCommande" name="modeLivraisonCommande" 
                    value="<c:out value="${ commande.modeLivraison }"/>" size="20" maxlength="20" />
                    <span class="erreur"><c:out value="${ form.erreurs['modeLivraisonCommande'] }"/></span>
                    <br />
                    
                    <label for="statutLivraisonCommande">Statut de la livraison</label>
                    <input type="text" id="statutLivraisonCommande" name="statutLivraisonCommande" 
                    value="${ commande.statutLivraison }" size="20" maxlength="20" />
                    <span class="erreur"><c:out value="${ form.erreurs['statutLivraisonCommande'] }"/></span>
                    <br />
                </fieldset>
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
            </form>
            <p class="erreur"><c:out value="${ form.resultat }" /></p>
        </div>
        
        <script src="<c:url value="/inc/jquery-1.12.0.js"/>"></script>
        
        <%-- Petite fonction jQuery permettant le remplacement de la première partie du formulaire par la liste déroulante, au clic sur le bouton radio. --%>
        <script>
        	jQuery(document).ready(function(){
        		/* 1 - Au lancement de la page, on cache le bloc d'éléments du formulaire correspondant aux clients existants */
        		$("div#ancienClient").hide();
        		/* 2 - Au clic sur un des deux boutons radio "choixNouveauClient", on affiche le bloc d'éléments correspondant (nouveau ou ancien client) */
                jQuery('input[name=choixSaisiClient]:radio').click(function(){
                	$("div#nouveauClient").hide();
                	$("div#ancienClient").hide();
                    var divId = jQuery(this).val();
                    $("div#"+divId).show();
                });
            });
        </script>    
    
    </body>
</html>