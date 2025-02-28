<%@ page import="java.util.List, models.personne, dao.peersonnemetier" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Personnes</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

    <!-- Table d'affichage des personnes -->
    <div>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nom</th>
                    <th>Âge</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <%
                List<personne> personnes = peersonnemetier.Listpersonnes();
                if (personnes != null) {
                    for (personne p : personnes) {
                %>
                <tr>    
                    <td><%= p.getId() %></td>
                    <td><%= p.getNom() %></td>
                    <td><%= p.getAge() %></td>
                    <td>
                        <a href="myServelet?id=<%= p.getId() %>">Supprimer</a>
                    </td>
                </tr>
                <%
                    }
                }
                %>
            </tbody>
        </table>
    </div>

</body>
</html>
