<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
	<meta charset="UTF-8">
	<title>Liste des Commandes</title>
	<link type="text/css" rel="stylesheet" href="inc/style.css" />
</head>
<body>
	<div>
		<c:import url="menu.jsp"></c:import>
	</div>
	<div>
		<table>
			<c:if test="${!empty sessionScope.listeCommandes}">
				<tr>
					<th>Client</th>
					<th>Date</th>
					<th>Montant</th>
					<th>Mode de paiement</th>
					<th>Statut de paiement</th>
					<th>Mode de livraison</th>
					<th>Statut de livraison</th>
					<th>Action</th>
				</tr>
				<c:forEach var="item" items="${sessionScope.listeCommandes}" varStatus="vs">
					<tr>
						<c:if test="${vs.index % 2 == 0}">
							<td class="cel cel_td1">${item.value.client.nom}</td>
							<td class="cel cel_td1">${item.value.date}</td>
							<td class="cel cel_td1">${item.value.montant}</td>
							<td class="cel cel_td1">${item.value.modePaiement}</td>
							<td class="cel cel_td1">${item.value.statutPaiement}</td>
							<td class="cel cel_td1">${item.value.modeLivraison}</td>
							<td class="cel cel_td1">${item.value.statutLivraison}</td>
																													
						</c:if>					
						<c:if test="${vs.index % 2 != 0}">
							<td class="cel cel_td">${item.value.client.nom}</td>
							<td class="cel cel_td1">${item.value.date}</td>
							<td class="cel cel_td">${item.value.montant}</td>
							<td class="cel cel_td">${item.value.modePaiement}</td>
							<td class="cel cel_td">${item.value.statutPaiement}</td>
							<td class="cel cel_td">${item.value.modeLivraison}</td>
							<td class="cel cel_td">${item.value.statutLivraison}</td>																	
						</c:if>
						<td class="cel cel_td action"><a href="supprimer"><img src="inc/images/bsupprimer.png"/></a></td>
					</tr>										
				</c:forEach>								
			</c:if>
		</table>
	</div>
</body>
</html>