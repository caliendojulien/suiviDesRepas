<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Ajout</title>
</head>
<body>
<div><%
    String ajout = (String) request.getAttribute("ajout");
    if (ajout != null) {
        out.print("<div>" + ajout + "</div>");
    }
%></div>
<form action="ajout" method="post">
    <label for="date">Date : </label><input type="date" name="date" id="date">
    <label for="heure">Heure : </label><input type="time" name="heure" id="heure">
    <label for="aliments">Aliments : </label><textarea name="aliments" id="aliments" cols="30" rows="10"></textarea>
    <input type="submit" value="Ajouter">
</form>
</body>
</html>
