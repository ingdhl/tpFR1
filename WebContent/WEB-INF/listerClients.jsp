<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
	<meta charset="UTF-8">
	<title>Liste des Clients</title>
	<link type="text/css" rel="stylesheet" href="inc/style.css" />
</head>
<body>
	<div>
		<c:import url="menu.jsp"></c:import>
	</div>
	<div>
		<table>
			<c:if test="${!empty sessionScope.listeClients}">
				<tr>
					<th class="cel cel_th">Nom</th>
					<th class="cel cel_th">Prenom</th>
					<th class="cel cel_th">Adresse</th>
					<th class="cel cel_th">Téléphone</th>
					<th class="cel cel_th">Email</th>
					<th class="cel cel_th">Action</th>								
				</tr>
				<c:forEach var="item" items="${sessionScope.listeClients}" varStatus="vs">
					<tr>
						<c:if test="${vs.index % 2 == 0}">
								<td class="cel cel_td1">${item.value.nom}</td>
								<td class="cel cel_td1">${item.value.prenom}</td>
								<td class="cel cel_td1">${item.value.adresse}</td>
								<td class="cel cel_td1">${item.value.telephone}</td>
								<td class="cel cel_td1">${item.value.email}</td>
								<td class="cel cel_td1 action"><a href="supprimer"><img src="inc/images/bsupprimer.png"/></a></td>																						
						</c:if>					
						<c:if test="${vs.index % 2 != 0}">
								<td class="cel cel_td">${item.value.nom}</td>
								<td class="cel cel_td">${item.value.prenom}</td>
								<td class="cel cel_td">${item.value.adresse}</td>
								<td class="cel cel_td">${item.value.telephone}</td>
								<td class="cel cel_td">${item.value.email}</td>
								<td class="cel cel_td action"><a href="supprimer"><img src="inc/images/bsupprimer.png"/></a></td>																	
						</c:if>
						
					</tr>										
				</c:forEach>								
			</c:if>
		</table>
	</div>
</body>
</html>