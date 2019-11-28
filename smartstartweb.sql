-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  jeu. 28 nov. 2019 à 14:46
-- Version du serveur :  5.7.19
-- Version de PHP :  5.6.31

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
  PRIMARY KEY (`ID`),
  KEY `id_client` (`id_client`),
  KEY `idfskilla` (`Skill`),
  KEY `categorieAfk` (`idCategorieA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `categorieformation`
--

DROP TABLE IF EXISTS `categorieformation`;
CREATE TABLE IF NOT EXISTS `categorieformation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categorieF` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `categorie_skills`
--

DROP TABLE IF EXISTS `categorie_skills`;
CREATE TABLE IF NOT EXISTS `categorie_skills` (
  `id_categorie` int(11) NOT NULL AUTO_INCREMENT,
  `categorie` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id_categorie`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `categorie_skills`
--

INSERT INTO `categorie_skills` (`id_categorie`, `categorie`) VALUES
(1, 'Web');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
  `dateDébut` date NOT NULL,
  `dateFin` date NOT NULL,
  `idCategorieF` int(11) DEFAULT NULL,
  `idClient` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idClient` (`idClient`),
  KEY `categorie` (`idCategorieF`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQ_957A647992FC23A8` (`username_canonical`),
  UNIQUE KEY `UNIQ_957A6479A0D96FBF` (`email_canonical`),
  UNIQUE KEY `UNIQ_957A6479C05FB297` (`confirmation_token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `freelancer`
--

DROP TABLE IF EXISTS `freelancer`;
CREATE TABLE IF NOT EXISTS `freelancer` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Prenom` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Email` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `MotDePass` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Nationalite` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `CV` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Description` text COLLATE utf8_unicode_ci NOT NULL,
  `ImageFreelancer` longblob NOT NULL,
  `Date_inscri` datetime NOT NULL,
  `Skill` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Email` (`Email`),
  KEY `IDX_4C2ED1E89FFCCB73` (`Skill`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `freelancerskills`
--

DROP TABLE IF EXISTS `freelancerskills`;
CREATE TABLE IF NOT EXISTS `freelancerskills` (
  `skill5` int(11) DEFAULT NULL,
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `idFreelancer` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `idfreeskills` (`idFreelancer`),
  KEY `fkskill5` (`skill5`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
  `idClient` int(11) DEFAULT NULL,
  `IdFreelancer` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `noteC_fk` (`idClient`),
  KEY `noteF_fk` (`IdFreelancer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
  KEY `id_categorie` (`id_categorie`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `skills`
--

INSERT INTO `skills` (`id_categorie`, `ID`, `Skill`) VALUES
(1, 2, 'Symfony');

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

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `annonce`
--
ALTER TABLE `annonce`
  ADD CONSTRAINT `FK_F65593E570D00902` FOREIGN KEY (`idCategorieA`) REFERENCES `categorieannonce` (`id`),
  ADD CONSTRAINT `FK_F65593E59FFCCB73` FOREIGN KEY (`Skill`) REFERENCES `skills` (`ID`),
  ADD CONSTRAINT `FK_F65593E5E173B1B8` FOREIGN KEY (`id_client`) REFERENCES `client` (`ID`);

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
  ADD CONSTRAINT `FK_63DB2FEDE6DFB48E` FOREIGN KEY (`id_Client`) REFERENCES `client` (`ID`),
  ADD CONSTRAINT `FK_63DB2FEDE9A4513F` FOREIGN KEY (`id_freelancer`) REFERENCES `freelancer` (`ID`);

--
-- Contraintes pour la table `formation`
--
ALTER TABLE `formation`
  ADD CONSTRAINT `FK_404021BFA455ACCF` FOREIGN KEY (`idClient`) REFERENCES `client` (`ID`),
  ADD CONSTRAINT `FK_404021BFEEB49CA1` FOREIGN KEY (`idCategorieF`) REFERENCES `categorieformation` (`id`);

--
-- Contraintes pour la table `freelancer`
--
ALTER TABLE `freelancer`
  ADD CONSTRAINT `FK_4C2ED1E89FFCCB73` FOREIGN KEY (`Skill`) REFERENCES `skills` (`ID`);

--
-- Contraintes pour la table `freelancerskills`
--
ALTER TABLE `freelancerskills`
  ADD CONSTRAINT `FK_A2DE75DF4A8EF2D5` FOREIGN KEY (`skill5`) REFERENCES `skills` (`ID`),
  ADD CONSTRAINT `FK_A2DE75DFCEDACF02` FOREIGN KEY (`idFreelancer`) REFERENCES `freelancer` (`ID`);

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
  ADD CONSTRAINT `FK_CFBDFA14A455ACCF` FOREIGN KEY (`idClient`) REFERENCES `client` (`ID`),
  ADD CONSTRAINT `FK_CFBDFA14D6EB14FA` FOREIGN KEY (`IdFreelancer`) REFERENCES `freelancer` (`ID`);

--
-- Contraintes pour la table `postulation`
--
ALTER TABLE `postulation`
  ADD CONSTRAINT `FK_DA7D4E9BCEDACF02` FOREIGN KEY (`idFreelancer`) REFERENCES `freelancer` (`ID`),
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
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
