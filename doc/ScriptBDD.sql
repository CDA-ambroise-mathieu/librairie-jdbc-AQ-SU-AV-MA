DROP DATABASE IF EXISTS librairie_bdd;
CREATE DATABASE librairie_bdd;

--TABLE UTILISATEUR--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `inscrit` tinyint(1) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;


--TABLE LIVRE--

DROP TABLE IF EXISTS livre;
CREATE TABLE livre (
	id SMALLINT auto_increment NOT NULL,
	libelle varchar(30) NOT NULL,
	auteur varchar(30) NULL,
	edition varchar(30) NULL,
	annee_parution SMALLINT NULL,
	quantite_en_stock INT NULL,
	prix_unitaire DOUBLE NOT NULL,
	CONSTRAINT livre_pk PRIMARY KEY (id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- TABLE COMMANDE --

DROP TABLE IF EXISTS commande;
CREATE TABLE commande(



)
ENGINE=InnoDB DEFAULT CHARSET=utf8;




-- TABLE OPTIONNELLE TYPE ETAT COMMANDE

DROP TABLE IF EXISTS etat;
CREATE TABLE etat(
id SMALLINT auto_increment NOT NULL,
etat_commande varchar(30) NOT NULL,
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*
1- En préparation
2- Validée
3- En cours de livraison
4- Livrée
5- Annulée
