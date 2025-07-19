# Projet de gestion de facture

Pour installer le projet, vous devez avoir Docker sur votre ordinateur et lancer le Docker Desktop.
Les syntaxes ci-dessous sont écrites pour un OS Windows.

## Installation du projet
1. Build et lancer la base : ```docker compose up -d --build```
2. Se placer dans le dossier /src puis taper dans le terminal : ```javac -d ..\classes Main.java```
3. Se placer à la racine du projet "gestion-facture".
4. Lancer le programme : ```java -cp "lib/mysql-connector-j-9.3.0.jar;classes" Main```

## Connexion 
1. La fenêtre de connexion s'ouvre : il faut saisir les identifiants créés pour ce projet : 
- Nom d'utilisateur : vmonthe
- Mot de passe : java

2. Cliquer sur le bouton "Se connecter". Une fenêtre de confirmation s'affiche.
3. Vous arrivez ensuite sur l'application de gestion de facture.

## Utiliser l'application
Deux menus sont disponibles : le menu de prestation et celui du bilan.

Depuis le menu de prestations, vous pouvez créer une nouvelle prestation.
