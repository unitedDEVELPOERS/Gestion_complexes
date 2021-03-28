-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 26 fév. 2021 à 00:18
-- Version du serveur :  10.4.17-MariaDB
-- Version de PHP : 7.4.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `complexes_sportifs`
--

-- --------------------------------------------------------

--
-- Structure de la table `arbitre`
--

CREATE TABLE `arbitre` (
  `id` int(11) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `categorie` int(11) NOT NULL,
  `complexe` int(11) NOT NULL,
  `id_utilisateur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE `categorie` (
  `id` int(11) NOT NULL,
  `designation` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id` int(11) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `solde_points` int(11) NOT NULL,
  `equipe` int(11) NOT NULL,
  `position` varchar(50) NOT NULL,
  `id_utilisateur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `competition`
--

CREATE TABLE `competition` (
  `id` int(11) NOT NULL,
  `designation` varchar(100) NOT NULL,
  `date_creation` datetime NOT NULL,
  `date_debut` datetime NOT NULL,
  `nbre_equipes` int(11) NOT NULL,
  `categorie` int(11) NOT NULL,
  `complexe` int(11) NOT NULL,
  `prix_participation` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `equipe`
--

CREATE TABLE `equipe` (
  `id` int(11) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `nbre_joueur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `matche`
--

CREATE TABLE `matche` (
  `id` int(11) NOT NULL,
  `date_creation` datetime NOT NULL,
  `date_match` datetime NOT NULL,
  `equipe1` int(11) DEFAULT NULL,
  `equipe2` int(11) DEFAULT NULL,
  `resultat_eq1` int(11) DEFAULT NULL,
  `resultat_eq2` int(11) DEFAULT NULL,
  `valide` tinyint(1) NOT NULL,
  `terrain` int(11) NOT NULL,
  `arbitre` int(11) NOT NULL,
  `niveau_competition` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `niveau_competition`
--

CREATE TABLE `niveau_competition` (
  `id` int(11) NOT NULL,
  `designation` varchar(100) NOT NULL,
  `date_debut` datetime NOT NULL,
  `competition` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `participation`
--

CREATE TABLE `participation` (
  `id` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `competition` int(11) NOT NULL,
  `equipe` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `penalite`
--

CREATE TABLE `penalite` (
  `id` int(11) NOT NULL,
  `designation` varchar(30) NOT NULL,
  `nbre_points_retires` int(11) NOT NULL,
  `complexe` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `penalite_joueur`
--

CREATE TABLE `penalite_joueur` (
  `id` int(11) NOT NULL,
  `heure` time NOT NULL,
  `penalite` int(11) NOT NULL,
  `arbitre` int(11) NOT NULL,
  `joueur` int(11) NOT NULL,
  `matche` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `proprietaire_complexe`
--

CREATE TABLE `proprietaire_complexe` (
  `id` int(11) NOT NULL,
  `raison_sociale` varchar(100) NOT NULL,
  `matricule_fiscale` varchar(100) NOT NULL,
  `verifie` tinyint(1) NOT NULL DEFAULT 0,
  `id_utilisateur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

CREATE TABLE `reservation` (
  `id` int(11) NOT NULL,
  `date_creation` datetime NOT NULL,
  `date_reseration` datetime NOT NULL,
  `validee` tinyint(1) NOT NULL,
  `client` int(11) NOT NULL,
  `terrain` int(11) NOT NULL,
  `createur` int(11) NOT NULL DEFAULT 0,
  `montant` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `terrain`
--

CREATE TABLE `terrain` (
  `id` int(11) NOT NULL,
  `designation` varchar(50) NOT NULL,
  `description` text DEFAULT NULL,
  `adresse` varchar(100) NOT NULL,
  `image` varchar(100) DEFAULT NULL,
  `disponible` tinyint(1) NOT NULL,
  `prix_location` decimal(10,0) NOT NULL,
  `complexe` int(11) NOT NULL,
  `categorie` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(32) NOT NULL,
  `role` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `arbitre`
--
ALTER TABLE `arbitre`
  ADD PRIMARY KEY (`id`),
  ADD KEY `complexe` (`complexe`),
  ADD KEY `complexe_2` (`complexe`),
  ADD KEY `categorie` (`categorie`);

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`),
  ADD KEY `equipe` (`equipe`),
  ADD KEY `id_utilisateur` (`id_utilisateur`);

--
-- Index pour la table `competition`
--
ALTER TABLE `competition`
  ADD PRIMARY KEY (`id`),
  ADD KEY `categorie` (`categorie`),
  ADD KEY `competition_ibfk_2` (`complexe`);

--
-- Index pour la table `equipe`
--
ALTER TABLE `equipe`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `matche`
--
ALTER TABLE `matche`
  ADD PRIMARY KEY (`id`),
  ADD KEY `arbitre` (`arbitre`),
  ADD KEY `equipe1` (`equipe1`),
  ADD KEY `equipe2` (`equipe2`),
  ADD KEY `niveau_competition` (`niveau_competition`),
  ADD KEY `terrain` (`terrain`);

--
-- Index pour la table `niveau_competition`
--
ALTER TABLE `niveau_competition`
  ADD PRIMARY KEY (`id`),
  ADD KEY `competition` (`competition`);

--
-- Index pour la table `participation`
--
ALTER TABLE `participation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `competition` (`competition`),
  ADD KEY `equipe` (`equipe`);

--
-- Index pour la table `penalite`
--
ALTER TABLE `penalite`
  ADD PRIMARY KEY (`id`),
  ADD KEY `penalite_ibfk_1` (`complexe`);

--
-- Index pour la table `penalite_joueur`
--
ALTER TABLE `penalite_joueur`
  ADD PRIMARY KEY (`id`),
  ADD KEY `arbitre` (`arbitre`),
  ADD KEY `joueur` (`joueur`),
  ADD KEY `matche` (`matche`),
  ADD KEY `penalite` (`penalite`);

--
-- Index pour la table `proprietaire_complexe`
--
ALTER TABLE `proprietaire_complexe`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_utilisateur` (`id_utilisateur`);

--
-- Index pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `client` (`client`),
  ADD KEY `terrain` (`terrain`);

--
-- Index pour la table `terrain`
--
ALTER TABLE `terrain`
  ADD PRIMARY KEY (`id`),
  ADD KEY `categorie` (`categorie`),
  ADD KEY `complexe` (`complexe`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `arbitre`
--
ALTER TABLE `arbitre`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `competition`
--
ALTER TABLE `competition`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `equipe`
--
ALTER TABLE `equipe`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `matche`
--
ALTER TABLE `matche`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `niveau_competition`
--
ALTER TABLE `niveau_competition`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `participation`
--
ALTER TABLE `participation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `penalite`
--
ALTER TABLE `penalite`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `penalite_joueur`
--
ALTER TABLE `penalite_joueur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `proprietaire_complexe`
--
ALTER TABLE `proprietaire_complexe`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `terrain`
--
ALTER TABLE `terrain`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `arbitre`
--
ALTER TABLE `arbitre`
  ADD CONSTRAINT `arbitre_ibfk_1` FOREIGN KEY (`categorie`) REFERENCES `categorie` (`id`),
  ADD CONSTRAINT `arbitre_ibfk_2` FOREIGN KEY (`complexe`) REFERENCES `proprietaire_complexe` (`id`);

--
-- Contraintes pour la table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `client_ibfk_1` FOREIGN KEY (`equipe`) REFERENCES `equipe` (`id`),
  ADD CONSTRAINT `client_ibfk_2` FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `competition`
--
ALTER TABLE `competition`
  ADD CONSTRAINT `competition_ibfk_1` FOREIGN KEY (`categorie`) REFERENCES `categorie` (`id`),
  ADD CONSTRAINT `competition_ibfk_2` FOREIGN KEY (`complexe`) REFERENCES `categorie` (`id`);

--
-- Contraintes pour la table `matche`
--
ALTER TABLE `matche`
  ADD CONSTRAINT `matche_ibfk_1` FOREIGN KEY (`arbitre`) REFERENCES `arbitre` (`id`),
  ADD CONSTRAINT `matche_ibfk_2` FOREIGN KEY (`equipe1`) REFERENCES `equipe` (`id`),
  ADD CONSTRAINT `matche_ibfk_3` FOREIGN KEY (`equipe2`) REFERENCES `equipe` (`id`),
  ADD CONSTRAINT `matche_ibfk_4` FOREIGN KEY (`niveau_competition`) REFERENCES `niveau_competition` (`id`),
  ADD CONSTRAINT `matche_ibfk_5` FOREIGN KEY (`terrain`) REFERENCES `terrain` (`id`);

--
-- Contraintes pour la table `niveau_competition`
--
ALTER TABLE `niveau_competition`
  ADD CONSTRAINT `niveau_competition_ibfk_1` FOREIGN KEY (`competition`) REFERENCES `competition` (`id`);

--
-- Contraintes pour la table `participation`
--
ALTER TABLE `participation`
  ADD CONSTRAINT `participation_ibfk_1` FOREIGN KEY (`competition`) REFERENCES `competition` (`id`),
  ADD CONSTRAINT `participation_ibfk_2` FOREIGN KEY (`equipe`) REFERENCES `equipe` (`id`);

--
-- Contraintes pour la table `penalite`
--
ALTER TABLE `penalite`
  ADD CONSTRAINT `penalite_ibfk_1` FOREIGN KEY (`complexe`) REFERENCES `arbitre` (`id`);

--
-- Contraintes pour la table `penalite_joueur`
--
ALTER TABLE `penalite_joueur`
  ADD CONSTRAINT `penalite_joueur_ibfk_1` FOREIGN KEY (`arbitre`) REFERENCES `arbitre` (`id`),
  ADD CONSTRAINT `penalite_joueur_ibfk_2` FOREIGN KEY (`joueur`) REFERENCES `client` (`id`),
  ADD CONSTRAINT `penalite_joueur_ibfk_3` FOREIGN KEY (`matche`) REFERENCES `matche` (`id`),
  ADD CONSTRAINT `penalite_joueur_ibfk_4` FOREIGN KEY (`penalite`) REFERENCES `penalite` (`id`);

--
-- Contraintes pour la table `proprietaire_complexe`
--
ALTER TABLE `proprietaire_complexe`
  ADD CONSTRAINT `proprietaire_complexe_ibfk_1` FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`client`) REFERENCES `client` (`id`),
  ADD CONSTRAINT `reservation_ibfk_2` FOREIGN KEY (`terrain`) REFERENCES `terrain` (`id`);

--
-- Contraintes pour la table `terrain`
--
ALTER TABLE `terrain`
  ADD CONSTRAINT `terrain_ibfk_1` FOREIGN KEY (`categorie`) REFERENCES `categorie` (`id`),
  ADD CONSTRAINT `terrain_ibfk_2` FOREIGN KEY (`complexe`) REFERENCES `proprietaire_complexe` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
