# Programme de gestion d'un restaurant de bagels

## Cadre :
Etudes

## Développeurs
<br/>
Etudiants en 3ème année à l'ESIEA

## Lien des consignes :
https://github.com/ledoyen/tp-java/tree/master/projet/3A_2018

## Temps de développement:
Octobre-Novembre 2018

## Langages utilisés:
- Java
- Bash
- Markdown

## IDE utilisé :
IntelliJ IDEA

## Compilation et exécution
- Le fichier compile.sh permet de lancer la compilation de tous les fichiers .java des différents projets
- Le fichier test.sh permet de lancer les tests du projet restaurant
- Le fichier launch.sh permet de lancer l'application restaurant

## Fonctionnalités:
- afficher la liste des opérations disponibles
- ajouter un produit à la vente (nom, prix, stock)
- afficher la liste des produits à la vente (ainsi que le nombre restant)
- ouvrir la note d'un client (il peut y avoir plusieurs clients dans le restaurant au même moment)
- enregistrer la vente d'un produit sur la note d'un client
- clôturer la note d'un client en affichant :
	- le prix de chaque produit HT (hors-taxe)
	- le prix total HT
	- la TVA (10%)
	- le prix TTC
- afficher les données comptables:
	- total des rentrées d'argent (TVA + bénéfices)
	- total de la TVA facturée
	- total des bénéfices
- quitter
- retrait automatique de la liste des produits en vente d'un produit en rupture de stock
- possibilité d'offrir une remise de 10% au moment de la clôture d'une note

## Subtilités du programme:
- La liste de produits en vente correspond à une liste d'objets "Aliment", tout comme la note d'un client
- La liste des clients présents dans le restaurant correspond à une liste d'objets "Note".

- La classe Affichage contient une méthode "choix_chaine" utilisée chaque fois que l'on demande à l'utilisateur d'entrer une donnée<br/>
Ainsi un seul scanner est utilisé pour tout le programme. Cette méthode prend en paramètre des chaînes de caractères qui
correspondent aux messages s'affichant lors de la demande d'une entrée (en effet, on doit changer le message selon que l'on
demande d'entrer le nom d'un client ou un prix par exemple)<br/>
Ces chaînes de caractères sont stockées dans la classe Affichage.

- La méthode "verification_aliment_existant" permet de verifier si un aliment (dont on a entré le nom en paramètre) existe
dans une liste d'aliments entrée en paramètre. Elle renvoie l'aliment s'il existe, et null s'il n'existe pas.<br/>
Son retour contient alors une double information:
    - l'aliment existe ou non (renvoie null ou non)
    - on récupère directement l'aliment s'il existe<br/>
La méthode "verification_client_existant" fonctionne de la même manière pour vérifier que la note d'un client existe.

- Les méthodes getIndexAliment et getIndexNote renvoient l'index dans sa liste de l'aliment ou de la note passé en paramètre.
Ces méthodes nous sont très utiles pour obtenir les informations d'un objet dans une liste ou le manipuler,
 car les objets Aliment et Note sont souvent identifiés par leurs noms.

## Difficultés rencontrées:
### __Gestion de multiples cas:__
- Vérifier qu'on entre un entier positif lors de la demande d'une quantité
- Vérifier qu'on entre un décimal positif lors de la demande d'un prix
- Vérifier qu'un client existe bien lors de l'entrée du nom d'un client
- Vérifier qu'un produit soit en vente lors de l'entrée du nom d'un produit
- Vérifier qu'il y ait assez d'un produit par rapport à la quantité demandée par un client
- Lorsqu'un client commande un produit : vérifier qu'il n'avait pas déjà commandé de ce produit, auquel cas il faut
incrémenter la quantité du produit déjà présent sur sa note

**Résolution :** création de plusieurs méthodes de vérification pour traiter ces différents cas

### __Difficultés à respecter le nombre maximal de lignes autorisées pour les méthodes et les classes__
**Résolution :** cela nous a contraint à penser "orienté objet" et à créer plus de méthodes afin de diviser le code en
plusieurs actions élémentaires

### __Transmission des avancées de chacun__<br/>
**Résolution :** Utilisation de GitHub qui nous a fait économiser beaucoup de temps, notamment pour fusionner nos versions
du projet
