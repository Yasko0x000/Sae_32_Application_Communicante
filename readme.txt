[Chat MySQL] --> Chat en java en connexion au Serveur MySQL

[Chat UDP]	 --> Chat en java utilisant le protocole UDP sans table ou verification

[Serveur.Client & MySQL] --> Test Serveur et Client, ajout d'un utilisatuer et login à la BDD sous MySQL à travers l'inteface graphique java ou le fichier clientScenario


Le fichier .SQL est à importer sur votre propre BDD (soit xampp, wamp, etc en localhost 
ou bien directement sur le serveur RT https://rt-projet.pu-pm.univ-fcomte.fr/phpmyadmin/)


Ajouter la librairies "exec-maven-plugin-3.0.0.jar" si vous relevez des bug (Sur out put il est indiqué erreur Maeven 3.0.0)

Effectuer la connexxion à la bdd : Aller dans Service > Click droit sur "Databases" > New Connection > 
	> Dans Driver selectionner MySQL (Connector/J driver) || Fichier disponible dans le dossier si non afficher lors de la selection||
	> Dans Driver File(s) faire add et ajouter "mysql-connector-java-8.0.25.jar" > next > laisser sur le port 3306 (sauf si vous l'avez changé depuis les parametres xampp)
> Username root et pas de mdp > puis next et finish