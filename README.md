#Laby2022-COLLIN-TRIEU-MALAVASI

#un descriptif des difficultés rencontrées au cours du TP
On a eu des petits problèmes d'organisation pendant ce TP, nous avons donc travaillé pas mal sur l'ordinateur de Zhi-Sheng, par conséquent pas mal de commit ont été effectué sur l'ordinateur de Zhi-Sheng.
Il y a aussi des difficultés avec la gestion des exceptions, car elles étaient un peu difficiles à placées.


#une explication de vos choix de programmation
Nous avons choisi de charger le labyrinthe directement dans le constructeur car cela nous évite d'avoir plusieurs paramètres,
dans la méthode charger labyrinthe, nous utilisons le constructeur pour charger le labyrinthe.
Nous avons utilisé des try catch pour gérer les exceptions, en particulier celle du constructeur.
Pour les personnages et sorties nous avons choisis d'utiliser des compteurs pour gérer les exceptions, car nous n'avons pas trouvé d'autre solution correct.


#un descriptif expliquant comment lancer votre application
On lance le main, on donne le chemin du fichier labyrinthe à charger (on part de la racine), puis le labyrinthe est chargé, il se lance.
Il n'y a plus qu'a jouer !


#un résumé des résultats de vos tests (ce qui réussit / échoue éventuellement)
Tout les tests fournis sont passés, il n'y a pas d'erreur.
Les tests que nous avons créées sont bien fonctionnels, ils sont bien réalisés.

#une présentation de votre couverture de test et des explications associées
Nous avons testés tout ce qui est possible sauf si l'on donne des coordonnées incorrectes soit pour getChar() ou getSuivant().
Nous avons testé de charger le labyrinthe avec toutes les erreurs tels que le fichier n'existe pas, le labyrinthe contient 2 sorties, il ne contient pas de sorties, il y a 2 personnages, il y a 0 personnages et aussi si il y a un caractère inconnu.
Nous avons testé la méthode getChar() au lancement du labyrinthe puis après un déplacement.
Nous avons testé la méthode getSuivant() au lancement du labyrinthe.
Nous avons testé la méthode deplacerPerso() avec un déplacement vers le haut puis nous avons vérifier sa position dans le labyrinthe.
Nous avons aussi vérifier la méthode to_String pour vérifier que le labyrinthe est bien affiché.
Enfin, nous avons vérifier la méthode etreFini, un test ou le personnage est sur la sortie, donc le labyrinthe est fini, et une autre ou le personnage n'est pas sur la sortie et donc le labyrinthe n'est pas terminé.
Le dernier test que nous avons fait est le test de la méthode toString() avec un grand labyrinthe. Ce test s'appel toSgringGrandLaby, il permet de tester que le toString marche bien même avec un grand labyritnhe.
