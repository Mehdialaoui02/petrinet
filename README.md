# Petrinet Project

## Vue d'ensemble

Le réseau de Petri est un modèle mathématique largement utilisé pour décrire et analyser les systèmes concurrents et distribués. Dans le contexte d'une application informatique implémentant un réseau de Petri, le processus de développement est souvent soutenu par des tests unitaires, et JUnit 5 est l'outil de test privilégié pour cette tâche.
</br>
La structure du projet est la suivante : </br>
├───src </br>
│	└───mehdi </br>
└───tests 
    <p>
Le projet est structuré autour de deux fichiers principaux : le fichier src qui abrite l'ensemble du code source du réseau de Petri, et le fichier tests qui regroupe tous les tests unitaires nécessaires pour garantir la robustesse et la fiabilité du système.
	</p>
	<p>
Le répertoire src contient la mise en œuvre concrète du réseau de Petri, où chaque composant du modèle est soigneusement défini et intégré pour former une représentation fonctionnelle du système. Ce fichier constitue le cœur de l'application, mettant en œuvre les fonctionnalités essentielles du réseau de Petri.
	</p>
En parallèle, le répertoire tests contient une série de tests unitaires écrits avec JUnit 5. Ces tests visent à évaluer chaque composant du réseau de Petri de manière isolée, assurant ainsi que chaque élément fonctionne correctement de manière indépendante.
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

1. **Importer le projet** : Importez le projet  dans votre environnement de développement Java préféré.

2. **Exécuter le code** : Vous pouvez exécuter le code principal depuis votre IDE en lançant la classe correspondante ( clic droit --> Run as --> java application ). Pour tester une classe, vous pouvez lancer la classe test correspondante ( clic droit --> Run as --> JUnit Test ).


## Lien entre les modèles de Conception et l'implémentation 

La principale évolution entre la conception initiale et la mise en œuvre du projet Petrinet réside dans la transformation de la classe `Arc` en une classe abstraite. Initialement, dans la conception, la classe `Arc` n'était pas déclarée comme abstraite. Cependant, lors de la mise en œuvre, nous avons reconnu la nécessité de cette abstraction en raison du fait que l'on ne peut pas instancier directement un arc générique, car un arc doit être soit entrant, soit sortant. Ainsi, au lieu de créer des instances d'un arc générique, nous instancions des sous-classes spécialisées telles que `EnteringArc`, `ExitingArc`, `ZeroArc`, et `EmptyingArc`. Cette modification a été effectuée pour encapsuler le comportement général des arcs tout en permettant des spécialisations spécifiques pour différents types d'arcs. En adoptant cette approche, nous avons renforcé la structure du projet, alignant davantage le code avec les principes de l'héritage et de la spécialisation. Cela facilite l'extension du système avec de nouveaux types d'arcs tout en préservant la cohérence de la modélisation du réseau de Petri.

Cette modification a facilité l'extension du projet et la manipulation des sous-classes :  `EnteringArc`, `ExitingArc`, `ZeroArc`, et `EmptyingArc`. 

De plus, une nouvelle méthode `isExecutable()` a été ajoutée à la classe `Arc` pour les arcs entrants (`EnteringArc`), les arcs videurs (`EmptyingArc`), et les arcs zéros (`ZeroArc`). Cette méthode permet de déterminer si un arc est exécutable dans l'état actuel du réseau de Petri. Nous avons aussi redéfini la méthode `execute()` dans les sous-classes  `EnteringArc`, `ExitingArc`, `ZeroArc`, et `EmptyingArc` : 