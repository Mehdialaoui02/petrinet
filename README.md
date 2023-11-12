# Petrinet Project

## Overview

Le projet Petrinet est une implémentation d'un réseau de Petri, un modèle mathématique utilisé pour la modélisation des systèmes distribués et concurrents. Ce projet comprend des classes Java pour représenter des places, des transitions et des arcs, ainsi que des fonctionnalités pour exécuter des transitions et déterminer leur tirabilités.

## Contenu 
Le projet Petrinet est constitué d'un ensemble de classes Java visant à modéliser un réseau de Petri. 
1. Petrinet : Cette classe gère l'ensemble du réseau de Petri. Elle maintient des listes de transitions, de places et d'arcs, permettant ainsi la construction et la manipulation du réseau.
2. Place : Représente une place dans le réseau de Petri, avec un nombre de jetons associé et une liste d'arcs.
3. Transition : Modélise une transition, capable d'être déclenchée si toutes ses conditions d'entrée sont satisfaites. Elle maintient une liste d'arcs entrants et sortants.
4. Arc : Classe abstraite décrivant le comportement général d'un arc dans le réseau de Petri. Les sous-classes incluent EnteringArc, ExitingArc, ZeroArc, et EmptyingArc.
5. EnteringArc : Représente un arc entrant, contribuant à la tirabilité d'une transition.
6. ExitingArc : Modélise un arc sortant, indiquant comment les jetons sont distribués après le déclenchement d'une transition.
7. ZeroArc : Un arc spécial qui s'active que quand la place source est vide.
8. EmptyingArc : Un autre arc spécial qui vide une place lorsque la transition est déclenchée.

Le projet intègre également des classes de test JUnit pour chaque classe principale, assurant la robustesse et la fiabilité des fonctionnalités implémentées. Ces tests couvrent différents scénarios d'utilisation, de la modification du nombre de jetons à l'exécution de transitions variées. En adoptant ces classes, le projet offre une base solide pour comprendre et manipuler les réseaux de Petri dans des applications Java.

## Lancement du Code

Pour utiliser le code, vous pouvez suivre ces étapes :

1. **Importer le projet** : Clonez le dépôt Git et importez-le dans votre environnement de développement Java préféré.

2. **Exécuter le code** : Vous pouvez exécuter le code principal depuis votre IDE en lançant la classe principale correspondante.

## Exécution des Tests

Le projet est livré avec un ensemble de tests JUnit pour vérifier le bon fonctionnement des différentes fonctionnalités. Pour exécuter les tests, suivez ces étapes :

1. **Assurez-vous que JUnit est configuré** : Assurez-vous que JUnit est correctement configuré dans votre projet.

2. **Exécutez les tests** : Exécutez les classes de test situées dans `src/test/java/mehdi/` depuis votre IDE.

## Lien entre les modèles de Conception et l'implémentation 

La différence principale entre la conception initiale et l'implémentation du projet Petrinet réside dans la nature abstraite de la classe `Arc`. Initialement, dans la conception, la classe `Arc` n'était pas déclarée comme abstraite. Cependant, au cours de l'implémentation, nous avons reconnu la nécessité de la rendre abstraite pour encapsuler le comportement général des arcs tout en permettant des spécialisations spécifiques pour différents types d'arcs.

Cette modification a facilité l'extension du projet et la manipulation des sous-classes :  `EnteringArc`, `ExitingArc`, `ZeroArc`, et `EmptyingArc`. 

De plus, une nouvelle méthode `isExecutable()` a été ajoutée à la classe `Arc` pour les arcs entrants (`EnteringArc`), les arcs videurs (`EmptyingArc`), et les arcs zéros (`ZeroArc`). Cette méthode permet de déterminer si un arc est exécutable dans l'état actuel du réseau de Petri. 





