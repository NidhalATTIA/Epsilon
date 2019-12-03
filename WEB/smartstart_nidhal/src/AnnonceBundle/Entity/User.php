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
         * @return string
         */
        public function getPrenom()
        {
            return $this->prenom;
        }

        /**
         * @param string $prenom
         */
        public function setPrenom($prenom)
        {
            $this->prenom = $prenom;
        }

 public function __construct()
	    {
        	        parent::__construct();
// your own logic
	    }
 	 }

