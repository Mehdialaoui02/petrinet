# Petrinet Project

## Vue d'ensemble

Le réseau de Petri est un modèle mathématique largement utilisé pour décrire et analyser les systèmes concurrents et distribués. Dans le contexte d'une application informatique implémentant un réseau de Petri, le processus de développement est souvent soutenu par des tests unitaires, et JUnit 5 est l'outil de test privilégié pour cette tâche.
</br>
La structure du projet est la suivante : </br>
├───pne-editor.org.pneditor.petrinet.models.alaoui_benkmil </br>
│	
└───pne-editor.org.pneditor.petrinet.adapters.alaoui_benkmil </br>
    └─── PetriNetAdapter.java
    └─── ArcAdapter.java
    └─── PlaceAdapter.java
    └─── TransitionAdapter.java
    
Le projet principal est structuré autour de deux paquets principaux : le paquet models.alaoui_benkmil qui abrite l'ensemble du code source du réseau de Petri, et le paquets Adapters.alaoui_benkmil qui regroupe tous les tests unitaires nécessaires pour garantir la robustesse et la fiabilité du système. 
	</p>
	<p>
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
Le projet Petrinet a été étendu pour inclure de nouvelles classes qui facilitent l'adaptation des classes de notre code d'implémentation avec celles de l'éditeur. Ces nouvelles classes jouent un rôle crucial dans la création d'une passerelle entre notre code d'implémentation existant et le cadre fourni par l'éditeur, permettant ainsi une compatibilité et une interaction transparente entre les composants des deux environnements.
Les nouvelles classes ajoutées sont ArcAdapter, PetriNetAdapter, PlaceAdapter et finalement TransitionAdapte. Ces classes facilitent l'adaptation des classes d'arc de notre code avec celles de l'éditeur.

##Lancement du code 
Pour utiliser le code, vous pouvez suivre ces étapes :

    Importer le projet : Importez le projet dans votre environnement de développement Java préféré.

    Exécuter le code : Vous pouvez exécuter le code principal depuis votre IDE en lançant la classe correspondante ( clic droit --> Run as --> java application ). Pour lancer l'éditeur, vous pouvez lancerle pne-editor ( clic droit --> Run as --> java application ).

##Lien entre les modèles de Conception et l'implémentation

La transformation majeure entre la conception initiale et l'implémentation finale du projet Petrinet se manifeste par la redéfinition de la classe Arc en une classe abstraite. Initialement, dans la conception, la classe Arc n'était pas abstraite, mais lors de la mise en œuvre, il est devenu évident que cette abstraction était nécessaire. Cela découle de la réalisation qu'il est impossible d'instancier directement un arc générique, étant donné qu'un arc doit être soit entrant, soit sortant. Ainsi, plutôt que de créer des instances d'un arc générique, nous avons opté pour l'instanciation de sous-classes spécialisées telles que EnteringArc, ExitingArc, ZeroArc et EmptyingArc. Cette modification a été apportée dans le but d'encapsuler le comportement général des arcs tout en permettant des spécialisations spécifiques pour différents types d'arcs. En adoptant cette approche, la structure du projet a été renforcée, alignant davantage le code avec les principes d'héritage et de spécialisation. Cela facilite l'extension du système avec de nouveaux types d'arcs tout en maintenant la cohérence de la modélisation du réseau de Petri.
L'ajout de cette abstraction a grandement simplifié l'extension du projet et la manipulation des sous-classes, telles que EnteringArc, ExitingArc, ZeroArc et EmptyingArc.
Par ailleurs, une nouvelle méthode, isExecutable(), a été introduite dans la classe Arc pour les arcs entrants (EnteringArc), les arcs videurs (EmptyingArc) et les arcs zéros (ZeroArc). Cette méthode permet de déterminer si un arc est exécutable dans l'état actuel du réseau de Petri. De plus, la méthode execute() a été redéfinie dans chacune des sous-classes EnteringArc, ExitingArc, ZeroArc et EmptyingArc pour refléter les spécificités de chaque type d'arc.
En cours d'intégration, des ajustements ont également été apportés pour compléter le code initial, incluant l'ajout de quelques méthodes importantes oubliées. Ces modifications comprennent l'ajout des méthodes abstraites isExiting() et isEntering() dans la classe Arc, ainsi que les méthodes removeArc() dans les classes PetriNet, Transition et Place. De plus, des méthodes telles que removePlace(), addPlace() et addArc() ont été introduites pour garantir la complétude fonctionnelle du code. Bien que ces modifications aient dérogé à la notion initiale de ne pas altérer le code existant, elles ont été cruciales pour assurer la robustesse et la cohérence de l'ensemble du système Petrinet.
