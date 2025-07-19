# Projet de gestion de facture

Pour installer le projet, vous devez avoir Docker sur votre ordinateur et lancer le Docker Desktop.
Les syntaxes ci-dessous sont écrites pour un OS Windows.

## Installation du projet
1. Cloner le dépôt : https://github.com/Gwendoline-Pinault/gestion-facture
2. Build et lancer la base : ```docker compose up -d --build```
2. Se placer dans le dossier /src puis taper dans le terminal : ```javac -d ..\classes Main.java```
3. Se placer à la racine du projet "gestion-facture".
4. Lancer le programme : ```java -cp "lib/mysql-connector-j-9.3.0.jar;classes" Main```

## Connexion 
1. La fenêtre de connexion s'ouvre : il faut saisir les identifiants créés pour ce projet : 
- Nom d'utilisateur : vmonthe
- Mot de passe : java

2. Cliquer sur le bouton "Se connecter". Une fenêtre de confirmation s'affiche. Cliquer sur OK pour la fermer.
3. Vous arrivez ensuite sur l'application de gestion de facture.

## Utiliser l'application
L'onglet du menu "Prestations" vous permet d'accéder aux trois sous-menus :
- Ajouter une prestation
- Liste des consultations
- Liste des cours.

Les deux listes affichent dans un tableau les éléments correspondant en base rattachés à l'utilisateur connecté.

Pour ajouter une prestation, aller sur le sous menu en question : vous êtes amenés vers le formulaire de création.

Pour information : les dates et les heures sont des champs texte et non date.
Par convention, la date est au format JJ/MM/AAAA, les heures de cours sont notés HH:MM.

Le formulaire de création prend en compte le type de prestation à créer grâce au menu déroulant du champ type. Changer le type mettra à jour le formulaire pour afficher les bons champs à saisir.

Une fois le formulaire complété, cliquez sur "Valider". Une pop-up confirmera la création et vous ramenera vers la page d'accueil.
