<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Accueil</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/knacss.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/styles.css">
</head>
<body>
<div id="titre" class="text-36 text-center">Suivi des repas</div>
<hr />
<div class="grid grid-cols-2 gap-10 align-center">
    <div class="text-right"><a href="<%=request.getContextPath()%>/ajout">Ajouter un repas</a></div>
    <div class="text-left"><a href="<%=request.getContextPath()%>/historique">Visualiser les repas</a></div>
</div>
</body>
</html>
