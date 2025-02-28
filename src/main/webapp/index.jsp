<%@ page import="java.util.List, models.personne, dao.peersonnemetier" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestion des personnes</title>
    <style>
        /* Styles généraux */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            text-align: center;
            padding: 20px;
        }

        h1 {
            color: #333;
            margin-bottom: 20px;
        }

        /* Conteneur du formulaire */
        .form-container {
           background: #fff;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0px 4px 15px rgba(0, 0, 0, 0.1);
            display: inline-block;
            text-align: left;
            width: 800px; 
        }

        label {
            font-weight: bold;
            display: block;
            margin-top: 10px;
        }

        input[type="text"], input[type="number"] {
            width: calc(100% - 16px);
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 14px;
        }

        /* Style des boutons */
        .button-container {
            display: flex;
            justify-content: space-between;
            margin-top: 15px;
        }

        .btn {
            border: none;
            padding: 10px 15px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            width: 28%;
            color: white;
            text-align: center;
        }

        .btn-ajouter {
            background-color: #28a745;
        }

        .btn-ajouter:hover {
            background-color: #218838;
        }

        .btn-annuler {
            background-color: #dc3545;
        }

        .btn-annuler:hover {
            background-color: #c82333;
        }
    </style>
</head>
<body>

    <h1>Gestion des personnes</h1>

    <div class="form-container">
        <form method="post" action="myServelet">
            <label for="nom">Nom:</label>
            <input id="nom" type="text" name="nom" required>

            <label for="age">Âge:</label>
            <input id="age" type="number" name="age" required>

            <div class="button-container">
                <input type="submit" value="Ajouter" class="btn btn-ajouter">
                <button type="button" class="btn btn-annuler" onclick="window.location.href='list.jsp'">Annuler</button>
            </div>
        </form>
    </div>

</body>
</html>
