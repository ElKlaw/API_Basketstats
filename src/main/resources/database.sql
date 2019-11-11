DROP DATABASE IF EXISTS BddDevBasketstats;
CREATE DATABASE BddDevBasketstats;

CREATE USER 'basketstats'@'localhost' IDENTIFIED BY 'basketstats';

GRANT ALL PRIVILEGES ON *.* TO 'basketstats'@'localhost' WITH GRANT OPTION;

Use BddDevBasketstats;
SET names 'utf8';
/*------------------ DROP DES TABLES ------------------*/
DROP TABLE IF EXISTS ClubVille;
DROP TABLE IF EXISTS JoueurEquipe;

DROP TABLE IF EXISTS Utilisateur;
DROP TABLE IF EXISTS Role;
DROP TABLE IF EXISTS RoleUtilisateur;
DROP TABLE IF EXISTS Joueur;
DROP TABLE IF EXISTS Equipe;
DROP TABLE IF EXISTS Club;
DROP TABLE IF EXISTS Event;
DROP TABLE IF EXISTS Matchs;
DROP TABLE IF EXISTS Entrainement;
DROP TABLE IF EXISTS Autre;
DROP TABLE IF EXISTS Lieu;
DROP TABLE IF EXISTS Salle;
DROP TABLE IF EXISTS Ville;
DROP TABLE IF EXISTS StatistiqueJoueur;
DROP TABLE IF EXISTS StatistiqueEquipe;
DROP TABLE IF EXISTS Presence;



/*------------------ TABLE JOUEUR ------------------*/

CREATE TABLE Joueur(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nom VARCHAR(100),
	prenom VARCHAR(100),
	sexe ENUM('Homme','Femme'),
	dateNaissance DATE	
);

/*------------------ TABLE Utilisateur ------------------*/
CREATE TABLE Utilisateur(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	identifiant VARCHAR(100) UNIQUE,
	motdepasse VARCHAR(200),
	email VARCHAR(200),
	idJoueur INT NOT NULL,
	secret VARCHAR(200),
	FOREIGN KEY (idJoueur) REFERENCES Joueur(id)
);

/*------------------ TABLE Role ------------------*/
CREATE TABLE Role(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(100)
);

/*------------------ TABLE RoleUtilisateur ------------------*/
CREATE TABLE RoleUtilisateur(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	idRole INT NOT NULL,
	idUtilisateur INT NOT NULL,
	FOREIGN KEY (idRole) REFERENCES Role(id),
	FOREIGN KEY (idUtilisateur) REFERENCES Utilisateur(id)
);

/*------------------ TABLE CLUB ------------------*/

CREATE TABLE Club(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	codeClub VARCHAR(50),
	nom VARCHAR(200),
	url VARCHAR(200) UNIQUE,
	nomComplet VARCHAR(200),
	sport VARCHAR(50)
);

/*------------------ TABLE EQUIPE ------------------*/

CREATE TABLE Equipe(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	saison VARCHAR(12),
	phase INT,
	nom VARCHAR(200), 
	category VARCHAR(30),
	sexe VARCHAR(50), 
	niveau VARCHAR(40), 
	division VARCHAR(30), 
	poule VARCHAR(30), 
	idClub INT NOT NULL,
	FOREIGN KEY (idClub) REFERENCES Club(id)
);
/*------------------ TABLE VILLE ------------------*/

CREATE TABLE Ville(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nom VARCHAR(100),
	codeDepartement INT,
	departement VARCHAR(40),
	region VARCHAR(60),
	codePostal INT,
	pays VARCHAR(60)
);

/*------------------ TABLE ADRESSE ------------------*/

CREATE TABLE Adresse(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	numRue INT,
	nomRue VARCHAR(100),
	longitude DECIMAL(15,10),
	latitude DECIMAL(15,10),
	idVille INT NOT NULL,
	FOREIGN KEY (idVille) REFERENCES Ville(id)
);

/*------------------ TABLE LIEU ------------------*/

CREATE TABLE Lieu(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nom VARCHAR(100),
	idAdresse INT NOT NULL,
	salle BOOLEAN DEFAULT FALSE,
	idClub INT,
	FOREIGN KEY (idClub) REFERENCES Club(id),
	FOREIGN KEY (idAdresse) REFERENCES Adresse(id)
);

/*------------------ TABLE MATCHS ------------------*/

CREATE TABLE Matchs(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	dateMatch DATE,
	domicile BOOLEAN DEFAULT NULL,
	heureMatch TIME,
	heureRDV TIME,
	idEquipe INT NOT NULL,
	adversaire VARCHAR(100),
	scoreEquipe INT,
	scoreAdversaire INT,
	infosSup VARCHAR(255),
	FOREIGN KEY (idEquipe) REFERENCES Equipe(id)
);
/*------------------ TABLE EVENT ------------------*/

CREATE TABLE Event(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	title VARCHAR(255) NOT NULL,
	dateDebut DATETIME NOT NULL,
	dateFin DATETIME NOT NULL,
	infosSup VARCHAR(255),
	typeEvent ENUM('MATCH','ENTRAINEMENT','AUTRE'),
	recurent BOOLEAN DEFAULT FALSE,
	freq VARCHAR(255),
	bymonth VARCHAR(255),
	bymonthday VARCHAR(255),
	byweekday VARCHAR(255),
	idMatch INT,
	idLieu INT NOT NULL,
	FOREIGN KEY (idMatch) REFERENCES Matchs(id),
	FOREIGN KEY (idLieu) REFERENCES Lieu(id)
);

/*------------------ TABLE STATISTIQUE JOUEUR ------------------*/

CREATE TABLE StatistiqueJoueur(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	idJoueur INT NOT NULL,
	idMatchs INT NOT NULL, 
	idEquipe INT NOT NULL, 
	minutes INT(2),
	points INT(3),
	rebonds INT(2),
	passes INT(2),
	perteBalles INT(2),
	contres INT(2),
	TR INT(2),
	TT INT(2),
	troisPTST INT(2),
	troisPTSR INT(2),
	LFT INT(2),
	LFR INT(2),
	faute INT(2),
	FOREIGN KEY (idJoueur) REFERENCES Joueur(id),
	FOREIGN KEY (idMatchs) REFERENCES Matchs(id),
	FOREIGN KEY (idEquipe) REFERENCES Equipe(id)
);

/*------------------ TABLE STATISTIQUE EQUIPE ------------------*/

CREATE TABLE StatistiqueEquipe(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	idMatchs INT NOT NULL,
	idEquipe INT NOT NULL,
	points INT(3),
	rebonds INT(2),
	passes INT(2),
	perteBalles INT(2),
	contres INT(2),
	TR INT(2),
	TT INT(2),
	troisPTST INT(2),
	troisPTSR INT(2),
	LFT INT(2),
	LFR INT(2),
	faute INT(2),
	FOREIGN KEY (idMatchs) REFERENCES Matchs(id),
	FOREIGN KEY (idEquipe) REFERENCES Equipe(id)
);

/*------------------ TABLE PRESENCE ------------------*/

CREATE TABLE Presence(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	idJoueur INT NOT NULL,
	idEvent INT NOT NULL,
	typePresent ENUM('OUI','NON','INDECIS','ATTENTE'),
	FOREIGN KEY (idJoueur) REFERENCES Joueur(id),
	FOREIGN KEY (idEvent) REFERENCES Event(id)
);

/*------------------ TABLE CLUBVILLE ------------------*/

CREATE TABLE ClubVille(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	idClub INT NOT NULL, 
	idVille INT NOT NULL,
	FOREIGN KEY (idClub) REFERENCES Club(id),
	FOREIGN KEY (idVille) REFERENCES Ville(id)
);

/*------------------ TABLE JOUEUREQUIPE ------------------*/

CREATE TABLE JoueurEquipe(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	idJoueur INT NOT NULL,
	idEquipe INT NOT NULL,
	FOREIGN KEY (idJoueur) REFERENCES Joueur(id),
	FOREIGN KEY (idEquipe) REFERENCES Equipe(id)
);

/*------------------ TABLE JOUEURCLUB ------------------*/

CREATE TABLE JoueurClub(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	idJoueur INT NOT NULL,
	idClub INT NOT NULL,
	FOREIGN KEY (idJoueur) REFERENCES Joueur(id),
	FOREIGN KEY (idClub) REFERENCES Club(id)
);

/*------------------ TABLE EVENTEQUIPE ------------------*/

CREATE TABLE EventEquipe(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	idEvent INT NOT NULL,
	idEquipe INT NOT NULL,
	FOREIGN KEY (idEvent) REFERENCES Event(id),
	FOREIGN KEY (idEquipe) REFERENCES Equipe(id)
);


/*------------------ TABLE EVENTCLUB ------------------*/

CREATE TABLE EventClub(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	idEvent INT NOT NULL,
	idClub INT NOT NULL,
	FOREIGN KEY (idEvent) REFERENCES Event(id),
	FOREIGN KEY (idClub) REFERENCES Club(id)
);

/*-----------------------------------------DATA-----------------------------------*/

/* ------------------------  VALEUR Joueur ----------------------------*/

/*---- Homme ----*/
INSERT INTO Joueur VALUES (1,'nomH1','prenomH1','Homme','2008-11-06');
INSERT INTO Joueur VALUES (2,'nomH2','prenomH2','Homme','2006-12-06');
INSERT INTO Joueur VALUES (3,'nomH3','prenomH3','Homme','2004-01-06');
INSERT INTO Joueur VALUES (4,'nomH4','prenomH4','Homme','2002-02-06');
INSERT INTO Joueur VALUES (5,'nomH5','prenomH5','Homme','2000-03-06');
INSERT INTO Joueur VALUES (6,'nomH6','prenomH6','Homme','1998-04-06');
INSERT INTO Joueur VALUES (7,'nomH7','prenomH7','Homme','1996-05-06');
INSERT INTO Joueur VALUES (8,'nomH8','prenomH8','Homme','1994-06-06');
INSERT INTO Joueur VALUES (9,'nomH9','prenomH9','Homme','1992-07-06');
INSERT INTO Joueur VALUES (10,'nomH10','prenomH10','Homme','1990-08-06');
INSERT INTO Joueur VALUES (11,'nomH11','prenomH11','Homme','2008-11-06');
INSERT INTO Joueur VALUES (12,'nomH12','prenomH12','Homme','2006-12-06');
INSERT INTO Joueur VALUES (13,'nomH13','prenomH13','Homme','2004-01-06');
INSERT INTO Joueur VALUES (14,'nomH14','prenomH14','Homme','2002-02-06');
INSERT INTO Joueur VALUES (15,'nomH15','prenomH15','Homme','2000-03-06');
INSERT INTO Joueur VALUES (16,'nomH16','prenomH16','Homme','1998-04-06');
INSERT INTO Joueur VALUES (17,'nomH17','prenomH17','Homme','1996-05-06');
INSERT INTO Joueur VALUES (18,'nomH18','prenomH18','Homme','1994-06-06');
INSERT INTO Joueur VALUES (19,'nomH19','prenomH19','Homme','1992-07-06');
INSERT INTO Joueur VALUES (20,'nomH20','prenomH20','Homme','1990-08-06');


/*---- Femme ----*/
INSERT INTO Joueur VALUES (21,'nomF1','prenomF1','Femme','2008-11-06');
INSERT INTO Joueur VALUES (22,'nomF2','prenomF2','Femme','2006-12-06');
INSERT INTO Joueur VALUES (23,'nomF3','prenomF3','Femme','2004-01-06');
INSERT INTO Joueur VALUES (24,'nomF4','prenomF4','Femme','2002-02-06');
INSERT INTO Joueur VALUES (25,'nomF5','prenomF5','Femme','2000-03-06');
INSERT INTO Joueur VALUES (26,'nomF6','prenomF6','Femme','1998-04-06');
INSERT INTO Joueur VALUES (27,'nomF7','prenomF7','Femme','1996-05-06');
INSERT INTO Joueur VALUES (28,'nomF8','prenomF8','Femme','1994-06-06');
INSERT INTO Joueur VALUES (29,'nomF9','prenomF9','Femme','1992-07-06');
INSERT INTO Joueur VALUES (30,'nomF10','prenomF10','Femme','1990-08-06');
INSERT INTO Joueur VALUES (31,'nomF11','prenomF11','Femme','2008-11-06');
INSERT INTO Joueur VALUES (32,'nomF12','prenomF12','Femme','2006-12-06');
INSERT INTO Joueur VALUES (33,'nomF13','prenomF13','Femme','2004-01-06');
INSERT INTO Joueur VALUES (34,'nomF14','prenomF14','Femme','2002-02-06');
INSERT INTO Joueur VALUES (35,'nomF15','prenomF15','Femme','2000-03-06');
INSERT INTO Joueur VALUES (36,'nomF16','prenomF16','Femme','1998-04-06');
INSERT INTO Joueur VALUES (37,'nomF17','prenomF17','Femme','1996-05-06');
INSERT INTO Joueur VALUES (38,'nomF18','prenomF18','Femme','1994-06-06');
INSERT INTO Joueur VALUES (39,'nomF19','prenomF19','Femme','1992-07-06');
INSERT INTO Joueur VALUES (40,'nomF20','prenomF20','Femme','1990-08-06');

/* ------------------------  VALEUR Club ----------------------------*/

INSERT INTO Club VALUES (1,'491170B','LMB','lmb49','Lamboisière Martin Basket','BasketBall');
INSERT INTO Club VALUES (2,'411180B','PL','parislevalloisbasket','Paris Levallois','BasketBall');

/* ------------------------  VALEUR Equipe ----------------------------*/

/*---- Equipe Homme ----*/
INSERT INTO Equipe VALUES (1,2017/2018,1,'Equipe Masculine 1','Sénior','Masculin','Départemental','4','A',1);
INSERT INTO Equipe VALUES (2,2017/2018,2,'Equipe Masculine 2','U20','Masculin','Régional','1','C',1);
INSERT INTO Equipe VALUES (3,2017/2018,NULL,'Equipe Masculine 3','U17','Masculin','National','1','B',2);
INSERT INTO Equipe VALUES (4,2017/2018,1,'Equipe Masculine 4','U15','Masculin','Départemental','4','A',2);


/*---- Equipe Femme ----*/
INSERT INTO Equipe VALUES (5,2017/2018,1,'Equipe Féminine 1','Sénior','Féminine','Départemental','1','A',1);
INSERT INTO Equipe VALUES (6,2017/2018,2,'Equipe Féminine 2','U20','Féminine','Régional','2','C',1);
INSERT INTO Equipe VALUES (7,2017/2018,NULL,'Equipe Féminine 3','U17','Féminine','National','3','B',2);
INSERT INTO Equipe VALUES (8,2017/2018,1,'Equipe Féminine 4','U15','Féminine','Départemental','2','A',2);

/* ------------------------  VALEUR Ville ----------------------------*/

INSERT INTO Ville VALUES (1,'Saint Léger des Bois',49,'Maine-et-Loire','Pays-de-la-Loire',49170,'FRANCE');
INSERT INTO Ville VALUES (2,'Saint Lambert la Potherie',49,'Maine-et-Loire','Pays-de-la-Loire',49170,'FRANCE');
INSERT INTO Ville VALUES (3,'Saint Martin du Fouilloux',49,'Maine-et-Loire','Pays-de-la-Loire',49170,'FRANCE');
INSERT INTO Ville VALUES (4,'Saint Jean de Linières',49,'Maine-et-Loire','Pays-de-la-Loire',49170,'FRANCE');
INSERT INTO Ville VALUES (5,'Levallois-Perret',92,'Hauts-de-Seine','Île-de-France',92300,'FRANCE');

/* ------------------------  VALEUR Salle ----------------------------*/

INSERT INTO Lieu VALUES(1,TRUE, 'Salle de la Coudre',6,'rue Ferrières',NULL,NULL,1,1);
INSERT INTO Lieu VALUES(2,TRUE, 'Palais des sports Marcel-Cerdan',141,'rue Danton',NULL,NULL,5,2);

/* ------------------------  VALEUR JoueurEquipe ----------------------------*/

/* Joueur Equipe Club1*/
INSERT INTO JoueurEquipe VALUES(NULL,1,1);
INSERT INTO JoueurEquipe VALUES(NULL,1,2);
INSERT INTO JoueurEquipe VALUES(NULL,2,1);
INSERT INTO JoueurEquipe VALUES(NULL,2,2);
INSERT INTO JoueurEquipe VALUES(NULL,3,1);
INSERT INTO JoueurEquipe VALUES(NULL,3,2);
INSERT INTO JoueurEquipe VALUES(NULL,4,1);
INSERT INTO JoueurEquipe VALUES(NULL,4,2);
INSERT INTO JoueurEquipe VALUES(NULL,5,1);
INSERT INTO JoueurEquipe VALUES(NULL,5,2);
INSERT INTO JoueurEquipe VALUES(NULL,6,1);
INSERT INTO JoueurEquipe VALUES(NULL,6,2);
INSERT INTO JoueurEquipe VALUES(NULL,7,1);
INSERT INTO JoueurEquipe VALUES(NULL,7,2);
INSERT INTO JoueurEquipe VALUES(NULL,8,1);
INSERT INTO JoueurEquipe VALUES(NULL,8,2);

INSERT INTO JoueurEquipe VALUES(NULL,9,2);
INSERT INTO JoueurEquipe VALUES(NULL,10,1);

/* Joueur Club 2*/
INSERT INTO JoueurEquipe VALUES(NULL,11,3);
INSERT INTO JoueurEquipe VALUES(NULL,11,4);
INSERT INTO JoueurEquipe VALUES(NULL,12,3);
INSERT INTO JoueurEquipe VALUES(NULL,12,4);
INSERT INTO JoueurEquipe VALUES(NULL,13,3);
INSERT INTO JoueurEquipe VALUES(NULL,13,4);
INSERT INTO JoueurEquipe VALUES(NULL,14,3);
INSERT INTO JoueurEquipe VALUES(NULL,14,4);
INSERT INTO JoueurEquipe VALUES(NULL,15,3);
INSERT INTO JoueurEquipe VALUES(NULL,15,4);
INSERT INTO JoueurEquipe VALUES(NULL,16,3);
INSERT INTO JoueurEquipe VALUES(NULL,16,4);
INSERT INTO JoueurEquipe VALUES(NULL,17,3);
INSERT INTO JoueurEquipe VALUES(NULL,17,4);
INSERT INTO JoueurEquipe VALUES(NULL,18,3);
INSERT INTO JoueurEquipe VALUES(NULL,18,4);

INSERT INTO JoueurEquipe VALUES(NULL,19,4);
INSERT INTO JoueurEquipe VALUES(NULL,20,3);

/*---Joueuse----*/
/*Club 1 */
INSERT INTO JoueurEquipe VALUES(NULL,21,5);
INSERT INTO JoueurEquipe VALUES(NULL,21,6);
INSERT INTO JoueurEquipe VALUES(NULL,22,5);
INSERT INTO JoueurEquipe VALUES(NULL,22,6);
INSERT INTO JoueurEquipe VALUES(NULL,23,5);
INSERT INTO JoueurEquipe VALUES(NULL,23,6);
INSERT INTO JoueurEquipe VALUES(NULL,24,5);
INSERT INTO JoueurEquipe VALUES(NULL,24,6);
INSERT INTO JoueurEquipe VALUES(NULL,25,5);
INSERT INTO JoueurEquipe VALUES(NULL,25,6);
INSERT INTO JoueurEquipe VALUES(NULL,26,5);
INSERT INTO JoueurEquipe VALUES(NULL,26,6);
INSERT INTO JoueurEquipe VALUES(NULL,27,5);
INSERT INTO JoueurEquipe VALUES(NULL,27,6);
INSERT INTO JoueurEquipe VALUES(NULL,28,5);
INSERT INTO JoueurEquipe VALUES(NULL,28,6);

INSERT INTO JoueurEquipe VALUES(NULL,29,5);
INSERT INTO JoueurEquipe VALUES(NULL,30,6);

/*Club 2*/
INSERT INTO JoueurEquipe VALUES(NULL,31,7);
INSERT INTO JoueurEquipe VALUES(NULL,31,8);
INSERT INTO JoueurEquipe VALUES(NULL,32,7);
INSERT INTO JoueurEquipe VALUES(NULL,32,8);
INSERT INTO JoueurEquipe VALUES(NULL,33,7);
INSERT INTO JoueurEquipe VALUES(NULL,33,8);
INSERT INTO JoueurEquipe VALUES(NULL,34,7);
INSERT INTO JoueurEquipe VALUES(NULL,34,8);
INSERT INTO JoueurEquipe VALUES(NULL,35,7);
INSERT INTO JoueurEquipe VALUES(NULL,35,8);
INSERT INTO JoueurEquipe VALUES(NULL,36,7);
INSERT INTO JoueurEquipe VALUES(NULL,36,8);
INSERT INTO JoueurEquipe VALUES(NULL,37,7);
INSERT INTO JoueurEquipe VALUES(NULL,37,8);
INSERT INTO JoueurEquipe VALUES(NULL,38,7);
INSERT INTO JoueurEquipe VALUES(NULL,38,8);

INSERT INTO JoueurEquipe VALUES(NULL,39,7);
INSERT INTO JoueurEquipe VALUES(NULL,40,8);

/* ------------------------  VALEUR ClubVille ----------------------------*/

INSERT INTO ClubVille VALUES(NULL,1,1);
INSERT INTO ClubVille VALUES(NULL,1,2);
INSERT INTO ClubVille VALUES(NULL,1,3);
INSERT INTO ClubVille VALUES(NULL,1,4);
INSERT INTO ClubVille VALUES(NULL,2,5);











/* ---------------------------------------------------------------------------------------- Paramètre ---------------------------------------------------------------------------------------*/
/*------------------ TABLE SPORT ------------------*/
CREATE TABLE Sport(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nom VARCHAR(255),
	disponible BOOLEAN DEFAULT TRUE
);
/*------------------ TABLE CATEGORIE ------------------*/
CREATE TABLE Categorie(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	idSport INT NOT NULL,
	nom VARCHAR(255),
	FOREIGN KEY (idSport) REFERENCES Sport(id)
);
/*------------------ TABLE NIVEAU ------------------*/
CREATE TABLE Niveau(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	idSport INT NOT NULL,
	nom VARCHAR(255),
	FOREIGN KEY (idSport) REFERENCES Sport(id)
);
/*------------------ TABLE DIVISION ------------------*/
CREATE TABLE Division(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	idNiveau INT NOT NULL,
	nom VARCHAR(255),
	FOREIGN KEY (idNiveau) REFERENCES Niveau(id)
);
/*------------------ TABLE POULE ------------------*/
CREATE TABLE Poule(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	idDivision INT NOT NULL,
	nom VARCHAR(255),
	FOREIGN KEY (idDivision) REFERENCES Division(id)
);

INSERT INTO Sport VALUES(NULL,'BasketBall',TRUE);
INSERT INTO Sport VALUES(NULL,'Football',TRUE);
INSERT INTO Sport VALUES(NULL,'Handball',TRUE);
INSERT INTO Sport VALUES(NULL,'Tennis',TRUE);

INSERT INTO Categorie VALUES(NULL,1,'Sénior');
INSERT INTO Categorie VALUES(NULL,1,'U20');
INSERT INTO Categorie VALUES(NULL,1,'U17');
INSERT INTO Categorie VALUES(NULL,1,'U15');
INSERT INTO Categorie VALUES(NULL,1,'U13');
INSERT INTO Categorie VALUES(NULL,1,'U11');
INSERT INTO Categorie VALUES(NULL,1,'U9');

INSERT INTO Niveau VALUES(NULL,1,'National');
INSERT INTO Niveau VALUES(NULL,1,'Régional');
INSERT INTO Niveau VALUES(NULL,1,'Départemental');

INSERT INTO Division VALUES(NULL,1,'1');
INSERT INTO Division VALUES(NULL,1,'2');
INSERT INTO Division VALUES(NULL,1,'3');
INSERT INTO Division VALUES(NULL,2,'1');
INSERT INTO Division VALUES(NULL,2,'2');
INSERT INTO Division VALUES(NULL,2,'3');
INSERT INTO Division VALUES(NULL,3,'1');
INSERT INTO Division VALUES(NULL,3,'2');
INSERT INTO Division VALUES(NULL,3,'3');
INSERT INTO Division VALUES(NULL,3,'4');
INSERT INTO Division VALUES(NULL,3,'5');

INSERT INTO Poule VALUES(NULL,1,'A');
INSERT INTO Poule VALUES(NULL,2,'A');
INSERT INTO Poule VALUES(NULL,3,'A');
INSERT INTO Poule VALUES(NULL,3,'B');
INSERT INTO Poule VALUES(NULL,4,'A');
INSERT INTO Poule VALUES(NULL,5,'A');
INSERT INTO Poule VALUES(NULL,5,'B');
INSERT INTO Poule VALUES(NULL,6,'A');
INSERT INTO Poule VALUES(NULL,6,'B');
INSERT INTO Poule VALUES(NULL,7,'A');
INSERT INTO Poule VALUES(NULL,8,'A');
INSERT INTO Poule VALUES(NULL,8,'B');
INSERT INTO Poule VALUES(NULL,9,'A');
INSERT INTO Poule VALUES(NULL,9,'B');
INSERT INTO Poule VALUES(NULL,9,'C');
INSERT INTO Poule VALUES(NULL,10,'A');
INSERT INTO Poule VALUES(NULL,10,'B');
INSERT INTO Poule VALUES(NULL,10,'C');
INSERT INTO Poule VALUES(NULL,10,'D');
INSERT INTO Poule VALUES(NULL,10,'E');
INSERT INTO Poule VALUES(NULL,11,'A');
INSERT INTO Poule VALUES(NULL,11,'B');
INSERT INTO Poule VALUES(NULL,11,'C');
INSERT INTO Poule VALUES(NULL,11,'D');
INSERT INTO Poule VALUES(NULL,11,'E');
INSERT INTO Poule VALUES(NULL,11,'F');

INSERT INTO Role VALUES(NULL,'USER');
INSERT INTO Role VALUES(NULL,'ADMIN');
