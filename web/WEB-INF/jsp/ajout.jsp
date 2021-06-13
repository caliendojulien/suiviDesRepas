<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Ajout</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/semantic.min.css">
    <script src="<%=request.getContextPath()%>/static/js/semantic.min.js"></script>
</head>
<body>
<div><%
    String ajout = (String) request.getAttribute("ajout");
    if (ajout != null) {
        out.print("<div>" + ajout + "</div>");
    }
%></div>
<div class="ui container">
    <h1 class="ui center aligned header">Suivi des repas</h1>
    <h2 class="ui dividing header">Ajout</h2>
    <br>
    <div class="ui centered one column grid">
        <form class="ui form" action="ajout" method="post">
            <div class="field"><label for="date">Date : </label><input type="date" name="date" id="date"></div>
            <div class="field"><label for="heure">Heure : </label><input type="time" name="heure" id="heure"></div>
            <div class="field"><label for="aliments">Aliments : </label><textarea name="aliments" id="aliments"
                                                                                  cols="30"
                                                                                  rows="10"></textarea></div>
            <br/>
            <input class="ui button" type="submit" value="Ajouter">
        </form>
    </div>
    <br />
    <a href="<%=request.getContextPath()%>"><i class="home icon"></i>Retour a l'accueil</a>
</div>
</body>
</html>
