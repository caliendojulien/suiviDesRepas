<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Accueil</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/semantic.min.css">
    <script src="<%=request.getContextPath()%>/static/js/semantic.min.js"></script>
</head>
<body>
<div class="ui container">
    <h1 class="ui center aligned header">Suivi des repas</h1>
    <h2 class="ui dividing header">Accueil</h2>
    <br>
    <div class="ui centered two column grid">
        <div class="ui large buttons">
            <a href="<%=request.getContextPath()%>/ajout">
                <button class="ui primary button">Ajouter un repas</button>
            </a>
            <div class="or" data-text="OU"></div>
            <a href="<%=request.getContextPath()%>/historique">
                <button class="ui primary button">Visualiser les
                    repas
                </button>
            </a>
        </div>
    </div>
</div>
</body>
</html>
