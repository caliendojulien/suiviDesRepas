<%@ page import="fr.eni.bo.Repas" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.format.FormatStyle" %>
<%@ page import="fr.eni.bo.Aliment" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Historique</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/semantic.min.css">
    <script src="<%=request.getContextPath()%>/static/js/semantic.min.js"></script>
</head>
<body>
<div class="ui container">
    <h1 class="ui center aligned header">Suivi des repas</h1>
    <h2 class="ui dividing header">Historique</h2>
    <br>
    <table class="ui celled red table sortable">
        <thead>
        <tr>
            <th>ID</th>
            <th>Date</th>
            <th>Heure</th>
            <th>Aliments</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Repas> listeRepas = (List<Repas>) request.getAttribute("listeDesRepas");
            for (Repas repas : listeRepas) {
                out.print("<tr>");
                out.print("<td data-label='ID'>" + repas.getId() + "</td>");
                out.print("<td data-label='Date'>" + repas.getDate().format(DateTimeFormatter.ofLocalizedDate((FormatStyle.SHORT))) + "</td>");
                out.print("<td data-label='Heure'>" + repas.getHeure() + "</td>");
                out.print("<td data-label='Aliments'><details>" +
                        "<summary>Détails</summary>");
                out.print("<div class='ui horizontal animated list'>");
                for (Aliment aliment : repas.getAliments()) {
                    out.print("<div class='item'>" + aliment.getNom() + "</div>");
                }
                out.print("</div>");
                out.print("</details></td>");
                out.print("</tr>");
            }
        %>
        </tbody>
    </table>
    <a href="<%=request.getContextPath()%>"><i class="home icon"></i>Retour a l'accueil</a>
</div>
</body>
</html>
