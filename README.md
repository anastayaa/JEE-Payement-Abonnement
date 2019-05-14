# JEE-Payement-Abonnement
Payement d'abonnement:MVC2, DAO, JPA, Hibernate, JSTL, Maven

JEE-Payement-Abonnement est un projet sous forme d'une application web dédié à un service paiement par carte bancaire, dont les clients sont l'abonné et l'agent de l'agence.

Les vues du projet:

Vue Authentification pour l'authentification via la base donnees.

Vue Abonné: On affiche toutes les informations de l'abonné, a savoir le nom, le prenom... et des champs remplir des informations de la carte bleue.

Vue Succes: si le payement est passé avec succes.

vue Agent: Affichage des abonnés avec leurs informations en ce qui concerne le payement.

les paquetages du projet:

Package Configs: connection vers la base données (Singleton)

Package Controllers: Les controleurs du projet (Les servlets)

Package Dao (DATA Acces Object): L'acces a la base de données en utilisant JPA et Hibernate

Package Filters: La restriction de l'acces vers l'application

Package Models: Les models (entités)

Package services: Code métier


