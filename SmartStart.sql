-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Oct 21, 2019 at 08:10 PM
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
(1, 'client1', 'prenomC', 'EmailC', 'tunisie', 'esprit', 'esprit', 'esprit test'),
(2, 'baazoug', 'houssem', 'fgdfhj', 'tunisien', 'sahsicompa', '123', 'asdfsrgdhtfj');

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

--
-- Dumping data for table `Commentaire_forum`
--

INSERT INTO `Commentaire_forum` (`ID`, `id_sujet`, `idfreelancer`, `Contenu`) VALUES
(1, 1, 1, 'commentaire modifier'),
(3, 1, 1, 'commentaire'),
(4, 1, 1, 'commentaire'),
(5, 1, 1, 'commentaire'),
(6, 1, 1, 'commentaire'),
(7, 1, 1, 'commentaire');

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

--
-- Dumping data for table `Freelancer`
--

INSERT INTO `Freelancer` (`ID`, `Nom`, `Prenom`, `Email`, `MotDePass`, `Nationalite`, `CV`, `Description`) VALUES
(1, 'baazoug', 'houssem', 'houssembaazoug@', 'test', 'tunisien', 'cv', 'cv cv');

-- --------------------------------------------------------

--
-- Table structure for table `FreelancerSkills`
--

CREATE TABLE `FreelancerSkills` (
  `ID` int(11) NOT NULL,
  `idFreelancer` int(11) NOT NULL,
  `skill1` int(11) NOT NULL,
  `skill2` int(11) NOT NULL,
  `skill3` int(11) NOT NULL,
  `skill4` int(11) NOT NULL,
  `skill5` int(11) NOT NULL
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
-- Table structure for table `Reclamation`
--

CREATE TABLE `Reclamation` (
  `ID` int(11) NOT NULL,
  `Titre` text NOT NULL,
  `Contenu` text NOT NULL,
  `IdFreelancer` int(11) NOT NULL,
  `IdClient` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Reclamation`
--

INSERT INTO `Reclamation` (`ID`, `Titre`, `Contenu`, `IdFreelancer`, `IdClient`) VALUES
(1, 'reclamation 1 modifiee', 'contemu de la reclamation modifiee', 1, 1),
(3, 'reclamation 1', 'contemu de la reclamation', 1, 1),
(4, 'reclamation 1', 'contemu de la reclamation', 1, 1),
(5, 'reclamation 1', 'contemu de la reclamation', 1, 1),
(6, 'reclamation 1', 'contemu de la reclamation', 1, 1),
(7, 'reclamation 1', 'contemu de la reclamation', 1, 1),
(8, 'reclamation 1', 'contemu de la reclamation', 1, 1),
(9, 'reclamation 1', 'contemu de la reclamation', 1, 1),
(11, 'reclamation 1 modifiee', 'contemu de la reclamation modifiee', 1, 1),
(12, 'reclamation 1', 'contemu de la reclamation', 1, 1),
(13, 'reclamation 1', 'contemu de la reclamation', 1, 1),
(14, 'reclamation 1', 'contemu de la reclamation', 1, 1),
(15, 'reclamation 1', 'contemu de la reclamation', 1, 1);

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

--
-- Dumping data for table `Review`
--

INSERT INTO `Review` (`ID`, `idClient`, `idfreelancer`, `Contenu`) VALUES
(3, 1, 1, 'review modifier'),
(4, 1, 1, 'review'),
(5, 1, 1, 'review'),
(6, 1, 1, 'review'),
(7, 1, 1, 'review'),
(8, 1, 1, 'review'),
(9, 1, 1, 'review'),
(10, 1, 1, 'review'),
(11, 1, 1, 'review'),
(12, 1, 1, 'review'),
(13, 1, 1, 'review');

-- --------------------------------------------------------

--
-- Table structure for table `Skills`
--

CREATE TABLE `Skills` (
  `ID` int(11) NOT NULL,
  `Skill` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Skills`
--

INSERT INTO `Skills` (`ID`, `Skill`) VALUES
(1, 'web'),
(2, 'java');

-- --------------------------------------------------------

--
-- Table structure for table `Subscribtion`
--

CREATE TABLE `Subscribtion` (
  `ID` int(11) NOT NULL,
  `ID_client` int(11) NOT NULL,
  `ID_Freelancer` int(11) NOT NULL
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
-- Dumping data for table `Sujet_forum`
--

INSERT INTO `Sujet_forum` (`ID`, `Titre`, `Contenu`, `IdFreelancer`) VALUES
(1, 'test', 'test', 1),
(5, 'test avec la modification', 'contenu du test avec la modification', 1),
(6, 'test', 'contenu du test', 1),
(7, 'test', 'contenu du test', 1),
(8, 'test', 'contenu du test', 1),
(9, 'test', 'contenu du test', 1),
(10, 'test', 'contenu du test', 1),
(11, 'test', 'contenu du test', 1),
(12, 'test', 'contenu du test', 1),
(13, 'test', 'contenu du test', 1),
(14, 'test', 'contenu du test', 1),
(15, 'test', 'contenu du test', 1),
(16, 'test', 'contenu du test', 1),
(17, 'test', 'contenu du test', 1),
(18, 'test', 'contenu du test', 1),
(19, 'test', 'contenu du test', 1),
(20, 'test', 'contenu du test', 1),
(21, 'test', 'contenu du test', 1),
(22, 'test', 'contenu du test', 1),
(23, 'test', 'contenu du test', 1);

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
-- Indexes for table `FreelancerSkills`
--
ALTER TABLE `FreelancerSkills`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `idfreeskills` (`idFreelancer`),
  ADD KEY `fkskill1` (`skill1`),
  ADD KEY `fkskill3` (`skill3`),
  ADD KEY `fkskill2` (`skill2`),
  ADD KEY `fkskill5` (`skill5`),
  ADD KEY `fkskill4` (`skill4`);

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
-- Indexes for table `Reclamation`
--
ALTER TABLE `Reclamation`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `idcR_fk` (`IdClient`),
  ADD KEY `idfR_fk` (`IdFreelancer`);

--
-- Indexes for table `Review`
--
ALTER TABLE `Review`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `idC_fk` (`idClient`),
  ADD KEY `idfreelancer` (`idfreelancer`);

--
-- Indexes for table `Skills`
--
ALTER TABLE `Skills`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `Subscribtion`
--
ALTER TABLE `Subscribtion`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `subC_fk` (`ID_client`),
  ADD KEY `subF_fk` (`ID_Freelancer`);

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
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `Commentaire_forum`
--
ALTER TABLE `Commentaire_forum`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `Freelancer`
--
ALTER TABLE `Freelancer`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `FreelancerSkills`
--
ALTER TABLE `FreelancerSkills`
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
-- AUTO_INCREMENT for table `Reclamation`
--
ALTER TABLE `Reclamation`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `Review`
--
ALTER TABLE `Review`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `Skills`
--
ALTER TABLE `Skills`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `Subscribtion`
--
ALTER TABLE `Subscribtion`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Sujet_forum`
--
ALTER TABLE `Sujet_forum`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

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
-- Constraints for table `FreelancerSkills`
--
ALTER TABLE `FreelancerSkills`
  ADD CONSTRAINT `fkskill1` FOREIGN KEY (`skill1`) REFERENCES `Skills` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fkskill2` FOREIGN KEY (`skill2`) REFERENCES `Skills` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fkskill3` FOREIGN KEY (`skill3`) REFERENCES `Skills` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fkskill4` FOREIGN KEY (`skill4`) REFERENCES `Skills` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fkskill5` FOREIGN KEY (`skill5`) REFERENCES `Skills` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `idfreeskills` FOREIGN KEY (`idFreelancer`) REFERENCES `Freelancer` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

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
-- Constraints for table `Reclamation`
--
ALTER TABLE `Reclamation`
  ADD CONSTRAINT `idcR_fk` FOREIGN KEY (`IdClient`) REFERENCES `Client` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `idfR_fk` FOREIGN KEY (`IdFreelancer`) REFERENCES `Freelancer` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Review`
--
ALTER TABLE `Review`
  ADD CONSTRAINT `idC_fk` FOREIGN KEY (`idClient`) REFERENCES `Client` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `idF_fk2` FOREIGN KEY (`idfreelancer`) REFERENCES `Freelancer` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Subscribtion`
--
ALTER TABLE `Subscribtion`
  ADD CONSTRAINT `subC_fk` FOREIGN KEY (`ID_client`) REFERENCES `Client` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `subF_fk` FOREIGN KEY (`ID_Freelancer`) REFERENCES `Freelancer` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Sujet_forum`
--
ALTER TABLE `Sujet_forum`
  ADD CONSTRAINT `idFreelancer_fk` FOREIGN KEY (`IdFreelancer`) REFERENCES `Freelancer` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
