<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Création d'un client</title>
        <link type="text/css" rel="stylesheet" href="inc/style.css" />
    </head>
    <body>
    	<div>
    		<c:import url="menu.jsp"/>
    	</div>
		<div>
            <form method="post" action="creationClient">
                <fieldset>
                    <legend>Informations client</legend>		
    				<c:import  url="clientToInclude.jsp"/>
                </fieldset>
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
            </form>    				
    	</div>
		<div>
    		<p class="erreur"><c:out value="${ form.resultat }" /></p>
    	</div>    	
    </body>
</html>