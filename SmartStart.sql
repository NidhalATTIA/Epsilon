-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Oct 15, 2019 at 12:49 PM
-- Server version: 5.7.23
-- PHP Version: 7.1.22

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `SmartStart`
--

-- --------------------------------------------------------

--
-- Table structure for table `Admin`
--

CREATE TABLE `Admin` (
  `ID` int(11) NOT NULL,
  `Nom` varchar(20) NOT NULL,
  `Prenom` varchar(20) NOT NULL,
  `Email` varchar(20) NOT NULL,
  `MotDePass` varchar(20) NOT NULL,
  `Nationalite` varchar(20) NOT NULL,
  `Fonction` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Annonce`
--

CREATE TABLE `Annonce` (
  `ID` int(11) NOT NULL,
  `Titre` varchar(30) NOT NULL,
  `DESCRIPTION` text NOT NULL,
  `id_client` int(11) NOT NULL,
  `Skills` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Client`
--

CREATE TABLE `Client` (
  `ID` int(11) NOT NULL,
  `Nom` varchar(20) NOT NULL,
  `Prenom` varchar(20) NOT NULL,
  `Email` varchar(20) NOT NULL,
  `Nationalite` varchar(20) NOT NULL,
  `Nom_company` varchar(20) NOT NULL,
  `MotDePass` varchar(20) NOT NULL,
  `Description_company` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Client`
--

INSERT INTO `Client` (`ID`, `Nom`, `Prenom`, `Email`, `Nationalite`, `Nom_company`, `MotDePass`, `Description_company`) VALUES
(1, 'client1', 'prenomC', 'EmailC', 'tunisie', 'esprit', 'esprit', 'esprit test');

-- --------------------------------------------------------

--
-- Table structure for table `Commentaire_forum`
--

CREATE TABLE `Commentaire_forum` (
  `ID` int(11) NOT NULL,
  `id_sujet` int(11) NOT NULL,
  `idfreelancer` int(11) NOT NULL,
  `Contenu` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Freelancer`
--

CREATE TABLE `Freelancer` (
  `ID` int(11) NOT NULL,
  `Nom` varchar(20) NOT NULL,
  `Prenom` varchar(20) NOT NULL,
  `Email` varchar(20) NOT NULL,
  `MotDePass` varchar(20) NOT NULL,
  `Nationalite` varchar(20) NOT NULL,
  `CV` varchar(20) NOT NULL,
  `Description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Note`
--

CREATE TABLE `Note` (
  `ID` int(11) NOT NULL,
  `note` int(11) NOT NULL,
  `idClient` int(11) NOT NULL,
  `IdFreelancer` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Postulation`
--

CREATE TABLE `Postulation` (
  `ID` int(11) NOT NULL,
  `idFreelancer` int(11) NOT NULL,
  `idAnnonce` int(11) NOT NULL,
  `Contenu` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Review`
--

CREATE TABLE `Review` (
  `ID` int(11) NOT NULL,
  `idClient` int(11) NOT NULL,
  `idfreelancer` int(11) NOT NULL,
  `Contenu` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Sujet_forum`
--

CREATE TABLE `Sujet_forum` (
  `ID` int(11) NOT NULL,
  `Titre` varchar(30) NOT NULL,
  `Contenu` text NOT NULL,
  `IdFreelancer` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Admin`
--
ALTER TABLE `Admin`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `Email` (`Email`);

--
-- Indexes for table `Annonce`
--
ALTER TABLE `Annonce`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `id_client` (`id_client`) USING BTREE;

--
-- Indexes for table `Client`
--
ALTER TABLE `Client`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `Prenom` (`Prenom`);

--
-- Indexes for table `Commentaire_forum`
--
ALTER TABLE `Commentaire_forum`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `idSujet_fk` (`id_sujet`),
  ADD KEY `idFf_fk` (`idfreelancer`);

--
-- Indexes for table `Freelancer`
--
ALTER TABLE `Freelancer`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `Email` (`Email`);

--
-- Indexes for table `Note`
--
ALTER TABLE `Note`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `noteC_fk` (`idClient`),
  ADD KEY `noteF_fk` (`IdFreelancer`);

--
-- Indexes for table `Postulation`
--
ALTER TABLE `Postulation`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `idFreelancer` (`idFreelancer`),
  ADD KEY `idAnnonce` (`idAnnonce`);

--
-- Indexes for table `Review`
--
ALTER TABLE `Review`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `idC_fk` (`idClient`),
  ADD KEY `idfreelancer` (`idfreelancer`);

--
-- Indexes for table `Sujet_forum`
--
ALTER TABLE `Sujet_forum`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `idFreelancer_fk` (`IdFreelancer`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Admin`
--
ALTER TABLE `Admin`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Annonce`
--
ALTER TABLE `Annonce`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Client`
--
ALTER TABLE `Client`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `Commentaire_forum`
--
ALTER TABLE `Commentaire_forum`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Freelancer`
--
ALTER TABLE `Freelancer`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Note`
--
ALTER TABLE `Note`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Postulation`
--
ALTER TABLE `Postulation`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Review`
--
ALTER TABLE `Review`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Sujet_forum`
--
ALTER TABLE `Sujet_forum`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Annonce`
--
ALTER TABLE `Annonce`
  ADD CONSTRAINT `idfkClient` FOREIGN KEY (`id_client`) REFERENCES `Client` (`ID`);

--
-- Constraints for table `Commentaire_forum`
--
ALTER TABLE `Commentaire_forum`
  ADD CONSTRAINT `idFf_fk` FOREIGN KEY (`idfreelancer`) REFERENCES `Freelancer` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `idSujet_fk` FOREIGN KEY (`id_sujet`) REFERENCES `Sujet_forum` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Note`
--
ALTER TABLE `Note`
  ADD CONSTRAINT `noteC_fk` FOREIGN KEY (`idClient`) REFERENCES `Client` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `noteF_fk` FOREIGN KEY (`IdFreelancer`) REFERENCES `Freelancer` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Postulation`
--
ALTER TABLE `Postulation`
  ADD CONSTRAINT `idA_fk` FOREIGN KEY (`idAnnonce`) REFERENCES `Annonce` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `idF_fk` FOREIGN KEY (`idFreelancer`) REFERENCES `Freelancer` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Review`
--
ALTER TABLE `Review`
  ADD CONSTRAINT `idC_fk` FOREIGN KEY (`idClient`) REFERENCES `Client` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `idF_fk2` FOREIGN KEY (`idfreelancer`) REFERENCES `Freelancer` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Sujet_forum`
--
ALTER TABLE `Sujet_forum`
  ADD CONSTRAINT `idFreelancer_fk` FOREIGN KEY (`IdFreelancer`) REFERENCES `Freelancer` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
