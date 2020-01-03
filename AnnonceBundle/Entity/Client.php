<?php

namespace AnnonceBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Client
 *
 * @ORM\Table(name="client", uniqueConstraints={@ORM\UniqueConstraint(name="Prenom", columns={"Prenom"})})
 * @ORM\Entity
 */
class Client
{
    /**
     * @var integer
     *
     * @ORM\Column(name="ID", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $id;

    /**
     * @var string
     *
     * @ORM\Column(name="Nom", type="string", length=20, nullable=false)
     */
    private $nom;

    /**
     * @var string
     *
     * @ORM\Column(name="Prenom", type="string", length=20, nullable=false)
     */
    private $prenom;

    /**
     * @var string
     *
     * @ORM\Column(name="Email", type="string", length=20, nullable=false)
     */
    private $email;

    /**
     * @var string
     *
     * @ORM\Column(name="Nationalite", type="string", length=20, nullable=false)
     */
    private $nationalite;

    /**
     * @var string
     *
     * @ORM\Column(name="Nom_company", type="string", length=20, nullable=false)
     */
    private $nomCompany;

    /**
     * @var string
     *
     * @ORM\Column(name="MotDePass", type="string", length=20, nullable=false)
     */
    private $motdepass;

    /**
     * @var string
     *
     * @ORM\Column(name="Description_company", type="text", length=65535, nullable=false)
     */
    private $descriptionCompany;

    /**
     * @var string
     *
     * @ORM\Column(name="ImageClient", type="blob", nullable=false)
     */
    private $imageclient;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="Date_inscri", type="datetime", nullable=false)
     */
    private $dateInscri = 'CURRENT_TIMESTAMP';

    /**
     * @return int
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * @param int $id
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

    /**
     * @return string
     */
    public function getEmail()
    {
        return $this->email;
    }

    /**
     * @param string $email
     */
    public function setEmail($email)
    {
        $this->email = $email;
    }

    /**
     * @return string
     */
    public function getNationalite()
    {
        return $this->nationalite;
    }

    /**
     * @param string $nationalite
     */
    public function setNationalite($nationalite)
    {
        $this->nationalite = $nationalite;
    }

    /**
     * @return string
     */
    public function getNomCompany()
    {
        return $this->nomCompany;
    }

    /**
     * @param string $nomCompany
     */
    public function setNomCompany($nomCompany)
    {
        $this->nomCompany = $nomCompany;
    }

    /**
     * @return string
     */
    public function getMotdepass()
    {
        return $this->motdepass;
    }

    /**
     * @param string $motdepass
     */
    public function setMotdepass($motdepass)
    {
        $this->motdepass = $motdepass;
    }

    /**
     * @return string
     */
    public function getDescriptionCompany()
    {
        return $this->descriptionCompany;
    }

    /**
     * @param string $descriptionCompany
     */
    public function setDescriptionCompany($descriptionCompany)
    {
        $this->descriptionCompany = $descriptionCompany;
    }

    /**
     * @return string
     */
    public function getImageclient()
    {
        return $this->imageclient;
    }

    /**
     * @param string $imageclient
     */
    public function setImageclient($imageclient)
    {
        $this->imageclient = $imageclient;
    }

    /**
     * @return \DateTime
     */
    public function getDateInscri()
    {
        return $this->dateInscri;
    }

    /**
     * @param \DateTime $dateInscri
     */
    public function setDateInscri($dateInscri)
    {
        $this->dateInscri = $dateInscri;
    }



}

