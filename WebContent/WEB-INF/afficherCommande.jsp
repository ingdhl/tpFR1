<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Affichage d'une commande</title>
<link type="text/css" rel="stylesheet" href="inc/style.css" />
</head>
<body>
	<div>
		<c:import url="menu.jsp"></c:import>
	</div>
	<div>
		<%-- Affichage de la chaîne "message" transmise par la servlet --%>
		<p class="info">${ form.resultat }</p>		
		<%-- Puis affichage des données enregistrées dans le bean "commande" transmis par la servlet --%>
		<p>Client</p>
		<%-- Les 5 expressions suivantes accèdent aux propriétés du client, qui est lui-même une propriété du bean commande --%>
		<p>Nom :<c:out value="${ commande.client.nom }"></c:out> </p>
		<p>Prénom : <c:out value="${ commande.client.prenom }"></c:out></p>
		<p>Adresse : <c:out value="${ commande.client.adresse }"></c:out></p>
		<p>Numéro de téléphone : <c:out value="${ commande.client.telephone }"></c:out></p>
		<p>Email : <c:out value="${ commande.client.email }"></c:out></p>
		<p>Commande</p>
		<p>Date : <c:out value="${ commande.date }"></c:out></p>
		<p>Montant : <c:if test="${ commande.montant > 0}"> <c:out value=" ${ commande.montant } "/></c:if></p>
		<p>Mode de paiement : <c:out value="${ commande.modePaiement }"></c:out></p>
		<p>Statut du paiement : <c:out value="${ commande.statutPaiement }"></c:out></p>
		<p>Mode de livraison : <c:out value="${ commande.modeLivraison }"></c:out></p>
		<p>Statut de la livraison : ${ commande.statutLivraison }</p>
	</div>
</body>
</html>