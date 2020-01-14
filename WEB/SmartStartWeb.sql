-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mar. 14 jan. 2020 à 11:24
-- Version du serveur :  5.7.19
-- Version de PHP :  7.0.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `smartstartweb`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Prenom` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Email` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `MotDePass` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Nationalite` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Fonction` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Image` longblob NOT NULL,
  `Date_inscri` datetime NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Email` (`Email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `annonce`
--

DROP TABLE IF EXISTS `annonce`;
CREATE TABLE IF NOT EXISTS `annonce` (
  `id_client` int(11) DEFAULT NULL,
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Titre` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `DESCRIPTION` text COLLATE utf8_unicode_ci NOT NULL,
  `dateAjout` datetime NOT NULL,
  `idCategorieA` int(11) DEFAULT NULL,
  `Skill` int(11) DEFAULT NULL,
  `Etat` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `id_client` (`id_client`),
  KEY `idfskilla` (`Skill`),
  KEY `categorieAfk` (`idCategorieA`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `annonce`
--

INSERT INTO `annonce` (`id_client`, `ID`, `Titre`, `DESCRIPTION`, `dateAjout`, `idCategorieA`, `Skill`, `Etat`) VALUES
(6, 7, 'Poste de developpeur Web', 'Require JavaFX Skills', '2019-12-05 07:12:56', 1, 16, 0),
(6, 8, 'Poste de designer', 'Skills en photoshop requis', '2019-12-05 07:13:38', 1, 21, 0),
(6, 9, 'annonce 12', 'test', '2019-12-05 09:48:47', 2, 21, 0);

-- --------------------------------------------------------

--
-- Structure de la table `categorieannonce`
--

DROP TABLE IF EXISTS `categorieannonce`;
CREATE TABLE IF NOT EXISTS `categorieannonce` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categorieA` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `categorieA` (`categorieA`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `categorieannonce`
--

INSERT INTO `categorieannonce` (`id`, `categorieA`) VALUES
(2, 'Full Time'),
(3, 'Half Time'),
(1, 'PFA');

-- --------------------------------------------------------

--
-- Structure de la table `categorieformation`
--

DROP TABLE IF EXISTS `categorieformation`;
CREATE TABLE IF NOT EXISTS `categorieformation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categorieF` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `categorieformation`
--

INSERT INTO `categorieformation` (`id`, `categorieF`) VALUES
(1, 'Developpement Web'),
(3, 'programmation'),
(4, 'Management'),
(5, 'SoftSkills');

-- --------------------------------------------------------

--
-- Structure de la table `categoriereclamation`
--

DROP TABLE IF EXISTS `categoriereclamation`;
CREATE TABLE IF NOT EXISTS `categoriereclamation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categorieR` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `categoriereclamation`
--

INSERT INTO `categoriereclamation` (`id`, `categorieR`) VALUES
(2, 'Reclamation 2');

-- --------------------------------------------------------

--
-- Structure de la table `categorie_skills`
--

DROP TABLE IF EXISTS `categorie_skills`;
CREATE TABLE IF NOT EXISTS `categorie_skills` (
  `id_categorie` int(11) NOT NULL AUTO_INCREMENT,
  `categorie` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id_categorie`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `categorie_skills`
--

INSERT INTO `categorie_skills` (`id_categorie`, `categorie`) VALUES
(9, 'Web dev'),
(10, 'App dev'),
(11, 'IT'),
(12, 'Software'),
(13, 'Media'),
(14, 'Digital'),
(15, 'Architecture'),
(16, 'Civil Engineering'),
(17, 'Translation'),
(18, 'Delevry');

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Prenom` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Email` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Nationalite` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Nom_company` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `MotDePass` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Description_company` text COLLATE utf8_unicode_ci NOT NULL,
  `ImageClient` longblob NOT NULL,
  `Date_inscri` datetime NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Prenom` (`Prenom`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `commentaire_forum`
--

DROP TABLE IF EXISTS `commentaire_forum`;
CREATE TABLE IF NOT EXISTS `commentaire_forum` (
  `idfreelancer` int(11) DEFAULT NULL,
  `id_sujet` int(11) DEFAULT NULL,
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Contenu` text COLLATE utf8_unicode_ci NOT NULL,
  `dateAjout` datetime NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `idSujet_fk` (`id_sujet`),
  KEY `idFf_fk` (`idfreelancer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `feedbackc`
--

DROP TABLE IF EXISTS `feedbackc`;
CREATE TABLE IF NOT EXISTS `feedbackc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_freelancer` int(11) DEFAULT NULL,
  `contenu` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `id_Client` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_freelancer` (`id_freelancer`),
  KEY `id_Client` (`id_Client`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `feedbackc`
--

INSERT INTO `feedbackc` (`id`, `id_freelancer`, `contenu`, `id_Client`) VALUES
(1, 1, 'Bravo', 3),
(2, 1, 'good', 1),
(3, 7, 'Satisfait', 6),
(4, 7, 'très bien', 3),
(5, 7, 'Bravo', 6);

-- --------------------------------------------------------

--
-- Structure de la table `formation`
--

DROP TABLE IF EXISTS `formation`;
CREATE TABLE IF NOT EXISTS `formation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Titre` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `description` text COLLATE utf8_unicode_ci NOT NULL,
  `lieu` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `prix` int(11) NOT NULL,
  `nbParticipants` int(11) NOT NULL,
  `dateDebut` date NOT NULL,
  `dateFin` date NOT NULL,
  `idCategorieF` int(11) DEFAULT NULL,
  `idClient` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idClient` (`idClient`),
  KEY `categorie` (`idCategorieF`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `formation`
--

INSERT INTO `formation` (`id`, `Titre`, `description`, `lieu`, `prix`, `nbParticipants`, `dateDebut`, `dateFin`, `idCategorieF`, `idClient`) VALUES
(1, 'Formation JS', 'Developpement avec JavaScript', 'Lac 2, Tunis', 160, 25, '2019-12-08', '2019-12-30', 1, NULL),
(3, 'Formation Angular', 'Angular for beginners', 'Marsa, Tunis', 250, 15, '2019-12-08', '2019-12-25', 1, 6);

-- --------------------------------------------------------

--
-- Structure de la table `formationcat`
--

DROP TABLE IF EXISTS `formationcat`;
CREATE TABLE IF NOT EXISTS `formationcat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idFreelancer` int(11) DEFAULT NULL,
  `idFormation` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idFreelancer` (`idFreelancer`),
  KEY `idFormation` (`idFormation`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `formationcat`
--

INSERT INTO `formationcat` (`id`, `idFreelancer`, `idFormation`) VALUES
(2, 2, 1);

-- --------------------------------------------------------

--
-- Structure de la table `fos_user`
--

DROP TABLE IF EXISTS `fos_user`;
CREATE TABLE IF NOT EXISTS `fos_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `username_canonical` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `email_canonical` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `salt` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `last_login` datetime DEFAULT NULL,
  `confirmation_token` varchar(180) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password_requested_at` datetime DEFAULT NULL,
  `roles` longtext COLLATE utf8_unicode_ci NOT NULL COMMENT '(DC2Type:array)',
  `nom` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `prenom` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `type_user` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `etat` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `nationalite` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `cv` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `image_freelancer` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `nom_company` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `image_client` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `description_company` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQ_957A647992FC23A8` (`username_canonical`),
  UNIQUE KEY `UNIQ_957A6479A0D96FBF` (`email_canonical`),
  UNIQUE KEY `UNIQ_957A6479C05FB297` (`confirmation_token`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `fos_user`
--

INSERT INTO `fos_user` (`id`, `username`, `username_canonical`, `email`, `email_canonical`, `enabled`, `salt`, `password`, `last_login`, `confirmation_token`, `password_requested_at`, `roles`, `nom`, `prenom`, `type_user`, `etat`, `nationalite`, `cv`, `description`, `image_freelancer`, `nom_company`, `image_client`, `description_company`) VALUES
(1, 'sahsi', 'sahsi', 'housbaaz@esprit.tn', 'housbaaz@esprit.tn', 1, NULL, '$2y$13$DvzAsJgHyw44Y44vyvItV.yGytHTaLEV0gfgSZrX3ShjOcSdTjLoS', '2019-12-05 07:02:59', NULL, NULL, 'a:1:{i:0;s:11:\"ROLE_CLIENT\";}', 'baazoug', 'houssem', 'Client', '', '', '', '', '', 'nidhalcompany', '', ''),
(2, 'houssem', 'houssem', 'houssem@esprit.tn', 'houssem@esprit.tn', 1, NULL, '$2y$13$UkqCCx.jv19Si/p75szO6u.T1G48WdnBYebs/3ED0AAkGF0MohNty', '2020-01-11 11:48:13', NULL, NULL, 'a:1:{i:0;s:10:\"ROLE_AGENT\";}', 'houssem', 'kaffel', 'freelancer', 'Valide', '', '', '', '', '', '', ''),
(3, 'admin', 'admin', 'admin@esprit.tn', 'admin@esprit.tn', 1, NULL, '$2y$13$UoR3uIv46lLNkB2lRyVpUetR3G4UUVxvzVRYTYUKQjTOacI3H7kZe', '2019-12-05 09:42:21', NULL, NULL, 'a:2:{i:0;s:10:\"ROLE_AGENT\";i:1;s:10:\"ROLE_ADMIN\";}', 'root', 'root', '', '', '', '', '', '', '', '', ''),
(6, 'Attia', 'attia', 'nidhal.attia@esprit.tn', 'nidhal.attia@esprit.tn', 1, NULL, '$2y$13$h/ecZw8HLWCIk3WtqMjIgum/zkgnjVAgiE0/WQOm/.yb/Kda9vxEG', '2019-12-05 09:47:43', NULL, NULL, 'a:1:{i:0;s:11:\"ROLE_CLIENT\";}', 'Attia', 'Nidhal', 'Client', '', 'Tunisienne', '#', 'Chef de Projet', '#', 'VERMEG', '#', 'Banking Company'),
(7, 'Kaffel', 'kaffel', 'houssem@gmail.com', 'houssem@gmail.com', 1, NULL, '$2y$13$6C46pZvqoaqW2laydq3f0OZDZVPJB8NQk9QY.Rgn.RVobfLqLolYu', '2020-01-11 11:49:48', NULL, NULL, 'a:0:{}', 'Kaffel', 'Houssem', 'freelancer', 'Valide', 'Allemande', 'CV_Houssem.pdf', 'Ingénieur FullStack', '#', '#', '#', '#');

-- --------------------------------------------------------

--
-- Structure de la table `freelancer`
--

DROP TABLE IF EXISTS `freelancer`;
CREATE TABLE IF NOT EXISTS `freelancer` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Description` text COLLATE utf8_unicode_ci NOT NULL,
  `Skill` int(11) DEFAULT NULL,
  `Freelancer` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDX_4C2ED1E89FFCCB73` (`Skill`),
  KEY `IDX_4C2ED1E8373D238` (`Freelancer`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `freelancer`
--

INSERT INTO `freelancer` (`ID`, `Description`, `Skill`, `Freelancer`) VALUES
(5, 'Fullstack', 15, 2),
(7, 'Developer Full Stack', 23, 7),
(8, 'devdev', 16, 2);

-- --------------------------------------------------------

--
-- Structure de la table `freelancerskills`
--

DROP TABLE IF EXISTS `freelancerskills`;
CREATE TABLE IF NOT EXISTS `freelancerskills` (
  `skill` int(11) DEFAULT NULL,
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `idFreelancer` int(11) DEFAULT NULL,
  `idCategorie` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `idfreeskills` (`idFreelancer`),
  KEY `IDX_A2DE75DFB597FD62` (`idCategorie`),
  KEY `fkskill5` (`skill`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `historiquereclamation`
--

DROP TABLE IF EXISTS `historiquereclamation`;
CREATE TABLE IF NOT EXISTS `historiquereclamation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Attribution` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `GSM` double NOT NULL,
  `dateCreation` date NOT NULL,
  `etat` int(11) NOT NULL,
  `MotifReclamation` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `motifRec` (`MotifReclamation`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `historiquereclamation`
--

INSERT INTO `historiquereclamation` (`id`, `Attribution`, `GSM`, `dateCreation`, `etat`, `MotifReclamation`) VALUES
(1, 'Demande d\'info', 22696810, '2019-12-04', 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `job`
--

DROP TABLE IF EXISTS `job`;
CREATE TABLE IF NOT EXISTS `job` (
  `id_freelancer` int(11) DEFAULT NULL,
  `id_client` int(11) DEFAULT NULL,
  `skill` int(11) DEFAULT NULL,
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Titre` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `DESCRIPTION` text COLLATE utf8_unicode_ci NOT NULL,
  `dateAjout` datetime NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `idclientfk` (`id_client`),
  KEY `idskillfk` (`skill`),
  KEY `id_freelancer` (`id_freelancer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `note`
--

DROP TABLE IF EXISTS `note`;
CREATE TABLE IF NOT EXISTS `note` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `note` int(11) NOT NULL,
  `idClient` int(11) NOT NULL,
  `idfreelancer` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `noteC_fk` (`idClient`),
  KEY `noteF_fk` (`idfreelancer`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `note`
--

INSERT INTO `note` (`ID`, `note`, `idClient`, `idfreelancer`) VALUES
(1, 3, 1, 2),
(4, 4, 6, 7);

-- --------------------------------------------------------

--
-- Structure de la table `postulation`
--

DROP TABLE IF EXISTS `postulation`;
CREATE TABLE IF NOT EXISTS `postulation` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Contenu` text COLLATE utf8_unicode_ci NOT NULL,
  `dateAjout` datetime NOT NULL,
  `idAnnonce` int(11) DEFAULT NULL,
  `idFreelancer` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `idFreelancer` (`idFreelancer`),
  KEY `idAnnonce` (`idAnnonce`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `postulation`
--

INSERT INTO `postulation` (`ID`, `Contenu`, `dateAjout`, `idAnnonce`, `idFreelancer`) VALUES
(2, 'je participe', '2019-12-05 09:45:28', 7, 7);

-- --------------------------------------------------------

--
-- Structure de la table `reclamation`
--

DROP TABLE IF EXISTS `reclamation`;
CREATE TABLE IF NOT EXISTS `reclamation` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Titre` text COLLATE utf8_unicode_ci NOT NULL,
  `Contenu` text COLLATE utf8_unicode_ci NOT NULL,
  `dateAjout` datetime NOT NULL,
  `IdClient` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `idcR_fk` (`IdClient`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `reclamationf`
--

DROP TABLE IF EXISTS `reclamationf`;
CREATE TABLE IF NOT EXISTS `reclamationf` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Titre` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Contenu` text COLLATE utf8_unicode_ci NOT NULL,
  `dateAjout` datetime NOT NULL,
  `IdFreelancer` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `idf_rec` (`IdFreelancer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `review`
--

DROP TABLE IF EXISTS `review`;
CREATE TABLE IF NOT EXISTS `review` (
  `idfreelancer` int(11) DEFAULT NULL,
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Contenu` text COLLATE utf8_unicode_ci NOT NULL,
  `dateAjout` datetime NOT NULL,
  `idClient` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `idC_fk` (`idClient`),
  KEY `idfreelancer` (`idfreelancer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `skills`
--

DROP TABLE IF EXISTS `skills`;
CREATE TABLE IF NOT EXISTS `skills` (
  `id_categorie` int(11) DEFAULT NULL,
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Skill` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDX_D5311670C9486A13` (`id_categorie`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `skills`
--

INSERT INTO `skills` (`id_categorie`, `ID`, `Skill`) VALUES
(9, 15, 'Symfony'),
(10, 16, 'java'),
(13, 17, 'Photograph'),
(14, 18, 'Community Manager'),
(16, 19, 'Road'),
(17, 20, 'en - fr'),
(15, 21, 'Designer'),
(13, 23, 'CM'),
(9, 24, 'dev');

-- --------------------------------------------------------

--
-- Structure de la table `subscribtion`
--

DROP TABLE IF EXISTS `subscribtion`;
CREATE TABLE IF NOT EXISTS `subscribtion` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_client` int(11) DEFAULT NULL,
  `ID_Freelancer` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `subC_fk` (`ID_client`),
  KEY `subF_fk` (`ID_Freelancer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `sujet_forum`
--

DROP TABLE IF EXISTS `sujet_forum`;
CREATE TABLE IF NOT EXISTS `sujet_forum` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Titre` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `Contenu` text COLLATE utf8_unicode_ci NOT NULL,
  `date` datetime NOT NULL,
  `IdFreelancer` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `idFreelancer_fk` (`IdFreelancer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
CREATE TABLE IF NOT EXISTS `ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categorie` int(11) DEFAULT NULL,
  `offre` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `service` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `motifReclamation` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `image` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `categorie` (`categorie`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `ticket`
--

INSERT INTO `ticket` (`id`, `categorie`, `offre`, `service`, `motifReclamation`, `image`) VALUES
(1, 2, 'Offre 1', 'Client', 'Demande information', 'C:\\wamp\\www\\smartstart_test\\'),
(2, 2, 'Arnaque', 'Paiement', 'Le client \"X\" ne m\'a pas payé', 'C:\\wamp64\\tmp\\php44E5.tmp'),
(3, 2, 'Arnaque', 'livraison', 'vol', 'C:\\wamp64\\tmp\\php9737.tmp');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `annonce`
--
ALTER TABLE `annonce`
  ADD CONSTRAINT `FK_F65593E570D00902` FOREIGN KEY (`idCategorieA`) REFERENCES `categorieannonce` (`id`),
  ADD CONSTRAINT `FK_F65593E59FFCCB73` FOREIGN KEY (`Skill`) REFERENCES `skills` (`ID`),
  ADD CONSTRAINT `FK_F65593E5E173B1B8` FOREIGN KEY (`id_client`) REFERENCES `fos_user` (`id`);

--
-- Contraintes pour la table `commentaire_forum`
--
ALTER TABLE `commentaire_forum`
  ADD CONSTRAINT `FK_A776D18187CCD2` FOREIGN KEY (`idfreelancer`) REFERENCES `freelancer` (`ID`),
  ADD CONSTRAINT `FK_A776D1C09618AD` FOREIGN KEY (`id_sujet`) REFERENCES `sujet_forum` (`ID`);

--
-- Contraintes pour la table `feedbackc`
--
ALTER TABLE `feedbackc`
  ADD CONSTRAINT `FK_63DB2FEDE6DFB48E` FOREIGN KEY (`id_Client`) REFERENCES `fos_user` (`id`),
  ADD CONSTRAINT `FK_63DB2FEDE9A4513F` FOREIGN KEY (`id_freelancer`) REFERENCES `fos_user` (`id`);

--
-- Contraintes pour la table `formation`
--
ALTER TABLE `formation`
  ADD CONSTRAINT `FK_404021BFA455ACCF` FOREIGN KEY (`idClient`) REFERENCES `fos_user` (`id`),
  ADD CONSTRAINT `FK_404021BFEEB49CA1` FOREIGN KEY (`idCategorieF`) REFERENCES `categorieformation` (`id`);

--
-- Contraintes pour la table `freelancer`
--
ALTER TABLE `freelancer`
  ADD CONSTRAINT `FK_4C2ED1E8373D238` FOREIGN KEY (`Freelancer`) REFERENCES `fos_user` (`id`),
  ADD CONSTRAINT `FK_4C2ED1E89FFCCB73` FOREIGN KEY (`Skill`) REFERENCES `skills` (`ID`);

--
-- Contraintes pour la table `freelancerskills`
--
ALTER TABLE `freelancerskills`
  ADD CONSTRAINT `FK_A2DE75DF5E3DE477` FOREIGN KEY (`skill`) REFERENCES `skills` (`ID`),
  ADD CONSTRAINT `FK_A2DE75DFB597FD62` FOREIGN KEY (`idCategorie`) REFERENCES `categorie_skills` (`id_categorie`),
  ADD CONSTRAINT `FK_A2DE75DFCEDACF02` FOREIGN KEY (`idFreelancer`) REFERENCES `fos_user` (`id`);

--
-- Contraintes pour la table `historiquereclamation`
--
ALTER TABLE `historiquereclamation`
  ADD CONSTRAINT `FK_D57F2E95438806B7` FOREIGN KEY (`MotifReclamation`) REFERENCES `ticket` (`id`);

--
-- Contraintes pour la table `job`
--
ALTER TABLE `job`
  ADD CONSTRAINT `FK_FBD8E0F85E3DE477` FOREIGN KEY (`skill`) REFERENCES `skills` (`ID`),
  ADD CONSTRAINT `FK_FBD8E0F8E173B1B8` FOREIGN KEY (`id_client`) REFERENCES `client` (`ID`),
  ADD CONSTRAINT `FK_FBD8E0F8E9A4513F` FOREIGN KEY (`id_freelancer`) REFERENCES `freelancer` (`ID`);

--
-- Contraintes pour la table `note`
--
ALTER TABLE `note`
  ADD CONSTRAINT `FK_CFBDFA148187CCD2` FOREIGN KEY (`idfreelancer`) REFERENCES `fos_user` (`id`),
  ADD CONSTRAINT `FK_CFBDFA14A455ACCF` FOREIGN KEY (`idClient`) REFERENCES `fos_user` (`id`);

--
-- Contraintes pour la table `postulation`
--
ALTER TABLE `postulation`
  ADD CONSTRAINT `FK_DA7D4E9BCEDACF02` FOREIGN KEY (`idFreelancer`) REFERENCES `fos_user` (`id`),
  ADD CONSTRAINT `FK_DA7D4E9BE6ECF817` FOREIGN KEY (`idAnnonce`) REFERENCES `annonce` (`ID`);

--
-- Contraintes pour la table `reclamation`
--
ALTER TABLE `reclamation`
  ADD CONSTRAINT `FK_CE6064045D23CE99` FOREIGN KEY (`IdClient`) REFERENCES `client` (`ID`);

--
-- Contraintes pour la table `reclamationf`
--
ALTER TABLE `reclamationf`
  ADD CONSTRAINT `FK_71708F9DD6EB14FA` FOREIGN KEY (`IdFreelancer`) REFERENCES `freelancer` (`ID`);

--
-- Contraintes pour la table `review`
--
ALTER TABLE `review`
  ADD CONSTRAINT `FK_794381C68187CCD2` FOREIGN KEY (`idfreelancer`) REFERENCES `freelancer` (`ID`),
  ADD CONSTRAINT `FK_794381C6A455ACCF` FOREIGN KEY (`idClient`) REFERENCES `client` (`ID`);

--
-- Contraintes pour la table `skills`
--
ALTER TABLE `skills`
  ADD CONSTRAINT `FK_D5311670C9486A13` FOREIGN KEY (`id_categorie`) REFERENCES `categorie_skills` (`id_categorie`);

--
-- Contraintes pour la table `subscribtion`
--
ALTER TABLE `subscribtion`
  ADD CONSTRAINT `FK_B9E6A0319AF4514D` FOREIGN KEY (`ID_client`) REFERENCES `client` (`ID`),
  ADD CONSTRAINT `FK_B9E6A031DB6C2E2` FOREIGN KEY (`ID_Freelancer`) REFERENCES `freelancer` (`ID`);

--
-- Contraintes pour la table `sujet_forum`
--
ALTER TABLE `sujet_forum`
  ADD CONSTRAINT `FK_EB9769EDD6EB14FA` FOREIGN KEY (`IdFreelancer`) REFERENCES `freelancer` (`ID`);

--
-- Contraintes pour la table `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `FK_97A0ADA3497DD634` FOREIGN KEY (`categorie`) REFERENCES `categoriereclamation` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
