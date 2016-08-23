<%@ page pageEncoding="UTF-8" %>

 <label for="nomClient">Nom <span class="requis">*</span></label>
 <input type="text" id="nomClient" name="nomClient" 
 	value='<c:out value="${ client.nom }"/>' size="20" maxlength="20" />
 <span class="erreur"> <c:out value="${ form.erreurs['nomClient'] }"></c:out> </span>
 <br />
 
 <label for="prenomClient">Prénom </label>
 <input type="text" id="prenomClient" name="prenomClient" 
 	value='<c:out value="${ client.prenom }"/>' size="20" maxlength="20" />
 <span class="erreur"> <c:out value="${ form.erreurs['prenomClient'] }"></c:out> </span>
 <br />

 <label for="adresseClient">Adresse de livraison <span class="requis">*</span></label>
 <input type="text" id="adresseClient" name="adresseClient" 
 	value='<c:out value="${ client.adresse }"/>' size="20" maxlength="20" />
  <span class="erreur"> <c:out value="${ form.erreurs['adresseClient'] }"></c:out> </span>	
 <br />

 <label for="telephoneClient">Numéro de téléphone <span class="requis">*</span></label>
 <input type="text" id="telephoneClient" name="telephoneClient" 
 value='<c:if test="${ client.telephone > 0 }">${ client.telephone }</c:if>' size="20" maxlength="20" />
 <span class="erreur">  <c:out value="${ form.erreurs['telephoneClient'] }"></c:out> </span>
 <br />
 
 <label for="emailClient">Adresse email</label>
 <input type="email" id="emailClient" name="emailClient" 
 value='<c:out value="${ client.email }"/>' size="20" maxlength="60" />
 <span class="erreur"> <c:out value="${ form.erreurs['emailClient'] }"></c:out> </span>
 <br />
