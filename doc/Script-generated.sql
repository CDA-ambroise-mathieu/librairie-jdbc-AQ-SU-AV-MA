#------------------------------------------------------------
#        Script MariaDB
#------------------------------------------------------------

 drop database if exists librairie;
 create or replace DATABASE librairie;
 ALTER DATABASE librairie CHARACTER SET utf8 COLLATE utf8_general_ci;
 USE librairie;


#------------------------------------------------------------
# Creation de l utilisateur bdd
#------------------------------------------------------------

CREATE USER IF NOT EXISTS 'librairie_user'@'%';
alter user 'librairie_user'@'%' identified by 'pwd';
grant all privileges on librairie.* to 'librairie_user'@'%';

#------------------------------------------------------------
# Table: Utilisateur
#------------------------------------------------------------

CREATE TABLE Utilisateur(
        id_utilisateur Int  Auto_increment  NOT NULL ,
        nom            Varchar (50) NOT NULL ,
        prenom         Varchar (50) NOT NULL ,
        role           Varchar (50) NOT NULL ,
        num_compte     Int NOT NULL ,
        login          Varchar (50) NOT NULL ,
        password       Varchar (200) NOT null,
        inscrit        Boolean not null,
        masque         Boolean not null
	,CONSTRAINT Utilisateur_PK PRIMARY KEY (id_utilisateur)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Adresse
#------------------------------------------------------------

CREATE TABLE Adresse(
        id_adresse  Int  Auto_increment  NOT NULL ,
        voie        Varchar (50) NOT NULL ,
        rue         Varchar (50) NOT NULL ,
        cpt_adresse Varchar (50) NOT NULL ,
        lieu_dit    Varchar (50) NOT NULL ,
        CP          Int NOT NULL ,
        localite    Varchar (50) NOT NULL ,
        pays        Varchar (50) NOT NULL
	,CONSTRAINT Adresse_PK PRIMARY KEY (id_adresse)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Commande
#------------------------------------------------------------

CREATE TABLE Commande(
        id_commande    Int  Auto_increment  NOT NULL ,
        date_commade   Date NOT NULL ,
        nb_articles    Int NOT NULL ,
        etat           Int NOT NULL COMMENT "etat --> 1 - 5 correspond a l'etat de la commande"  ,
        id_utilisateur Int NOT NULL ,
        id_adresse     Int NOT NULL
	,CONSTRAINT Commande_PK PRIMARY KEY (id_commande)

	,CONSTRAINT Commande_Utilisateur_FK FOREIGN KEY (id_utilisateur) REFERENCES Utilisateur(id_utilisateur)
	,CONSTRAINT Commande_Adresse0_FK FOREIGN KEY (id_adresse) REFERENCES Adresse(id_adresse)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Livre
#------------------------------------------------------------

CREATE TABLE Livre(
        id_livre       Int  Auto_increment  NOT NULL ,
        libelle        Varchar (50) NOT NULL ,
        auteur         Varchar (50) NOT NULL ,
        edition        Varchar (50) NOT NULL ,
        annee_parution Int NOT NULL ,
        qte_stock      Int NOT NULL ,
        prix_unitaire  Double NOT NULL
	,CONSTRAINT Livre_PK PRIMARY KEY (id_livre)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Constituer
#------------------------------------------------------------

CREATE TABLE Constituer(
        id_commande Int NOT NULL ,
        id_livre    Int NOT NULL
	,CONSTRAINT Constituer_PK PRIMARY KEY (id_commande,id_livre)

	,CONSTRAINT Constituer_Commande_FK FOREIGN KEY (id_commande) REFERENCES Commande(id_commande)
	,CONSTRAINT Constituer_Livre0_FK FOREIGN KEY (id_livre) REFERENCES Livre(id_livre)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Habiter
#------------------------------------------------------------

CREATE TABLE Habiter(
        id_utilisateur Int NOT NULL ,
        id_adresse     Int NOT NULL
	,CONSTRAINT Habiter_PK PRIMARY KEY (id_utilisateur,id_adresse)

	,CONSTRAINT Habiter_Utilisateur_FK FOREIGN KEY (id_utilisateur) REFERENCES Utilisateur(id_utilisateur)
	,CONSTRAINT Habiter_Adresse0_FK FOREIGN KEY (id_adresse) REFERENCES Adresse(id_adresse)
)ENGINE=InnoDB;

