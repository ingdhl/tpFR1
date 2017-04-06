<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>tp1FR Index</title>
</head>
<body>
	<h1>tp1FR</h1>
	<p>Cette application est le résultat de séances de travaux pratiques, le tp1.</p>
	<ul>
		<li><a href="<%= request.getContextPath()%>/listeClients">liste clients</a></li>
		<li><a href="<%= request.getContextPath()%>/listeCommandes">liste commandes</a></li>
		<li><a href="<%= request.getContextPath()%>/creationClient">creation client</a></li>
		<li><a href="<%= request.getContextPath()%>/creationCommande">creation commande</a></li>
	</ul>
</body>
</html>