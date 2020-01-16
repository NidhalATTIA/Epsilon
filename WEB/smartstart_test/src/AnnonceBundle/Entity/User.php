<?php


	// src/AppBundle/Entity/User.php

	namespace AnnonceBundle\Entity;

	use FOS\UserBundle\Model\User as BaseUser;
	use Doctrine\ORM\Mapping as ORM;

/**
●	 * @ORM\Entity
●	 * @ORM\Table(name="fos_user")
●	 */
	class User extends BaseUser
	{
    	    /**
    ●	     * @ORM\Id
    ●	     * @ORM\Column(type="integer")
    ●	     * @ORM\GeneratedValue(strategy="AUTO")
    ●	     */
   protected $id;

        /**
         * @var string
         *
         * @ORM\Column( type="string", length=20, nullable=false)
         */
        private $nom;

        /**
         * @ORM\Column( type="string", length=20, nullable=false)
         */
        private $prenom;


        /**
         * @ORM\Column(type="string")
         */
        protected $type_user;
        /**
         * @ORM\Column(type="string")
         */
        protected $etat;

        /**
         * @ORM\Column(type="string")
         */
        protected $Nationalite;
        /**
         * @ORM\Column(type="string")
         */
        protected $CV;
        /**
         * @ORM\Column(type="string")
         */
        protected $Description;
        /**
         * @ORM\Column(type="string")
         */
        protected $ImageFreelancer;
        /**
         * @ORM\Column(type="string")
         */
        protected $Nom_company;
        /**
         * @ORM\Column(type="string")
         */
        protected $ImageClient;
        /**
         * @ORM\Column(type="string")
         */
        protected $Description_company;

        /**
         * @return mixed
         */
        public function getId()
        {
            return $this->id;
        }

        /**
         * @param mixed $id
         */
        public function setId($id)
        {
            $this->id = $id;
        }

        /**
         * @return string
         */
        public function getNom()
        {
            return $this->nom;
        }

        /**
         * @param string $nom
         */
        public function setNom($nom)
        {
            $this->nom = $nom;
        }

        /**
         * @return mixed
         */
        public function getPrenom()
        {
            return $this->prenom;
        }

        /**
         * @param mixed $prenom
         */
        public function setPrenom($prenom)
        {
            $this->prenom = $prenom;
        }

        /**
         * @return mixed
         */
        public function getEtat()
        {
            return $this->etat;
        }

        /**
         * @param mixed $etat
         */
        public function setEtat($etat)
        {
            $this->etat = $etat;
        }

        /**
         * @return mixed
         */
        public function getNationalite()
        {
            return $this->Nationalite;
        }

        /**
         * @param mixed $Nationalite
         */
        public function setNationalite($Nationalite)
        {
            $this->Nationalite = $Nationalite;
        }

        /**
         * @return mixed
         */
        public function getCV()
        {
            return $this->CV;
        }

        /**
         * @param mixed $CV
         */
        public function setCV($CV)
        {
            $this->CV = $CV;
        }

        /**
         * @return mixed
         */
        public function getDescription()
        {
            return $this->Description;
        }

        /**
         * @param mixed $Description
         */
        public function setDescription($Description)
        {
            $this->Description = $Description;
        }

        /**
         * @return mixed
         */
        public function getImageFreelancer()
        {
            return $this->ImageFreelancer;
        }

        /**
         * @param mixed $ImageFreelancer
         */
        public function setImageFreelancer($ImageFreelancer)
        {
            $this->ImageFreelancer = $ImageFreelancer;
        }

        /**
         * @return mixed
         */
        public function getNomCompany()
        {
            return $this->Nom_company;
        }

        /**
         * @param mixed $Nom_company
         */
        public function setNomCompany($Nom_company)
        {
            $this->Nom_company = $Nom_company;
        }

        /**
         * @return mixed
         */
        public function getImageClient()
        {
            return $this->ImageClient;
        }

        /**
         * @param mixed $ImageClient
         */
        public function setImageClient($ImageClient)
        {
            $this->ImageClient = $ImageClient;
        }

        /**
         * @return mixed
         */
        public function getDescriptionCompany()
        {
            return $this->Description_company;
        }

        /**
         * @param mixed $Description_company
         */
        public function setDescriptionCompany($Description_company)
        {
            $this->Description_company = $Description_company;
        }

        /**
         * @return mixed
         */
        public function getTypeUser()
        {
            return $this->type_user;
        }

        /**
         * @param mixed $type_user
         */
        public function setTypeUser($type_user)
        {
            $this->type_user = $type_user;
        }

        /**
         * @return string
         */
        public function getUsername()
        {
            return $this->username;
        }

        /**
         * @param string $username
         */
        public function setUsername($username)
        {
            $this->username = $username;
        }

        /**
         * @return string
         */
        public function getPassword()
        {
            return $this->password;
        }

        /**
         * @param string $password
         */
        public function setPassword($password)
        {
            $this->password = $password;
        }




 	 }

