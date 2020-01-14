<?php

namespace SmartBundle\Entity;

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
     * Client constructor.
     * @param int $id
     * @param string $nom
     * @param string $prenom
     * @param string $email
     * @param string $nationalite
     * @param string $nomCompany
     * @param string $motdepass
     * @param string $descriptionCompany
     * @param string $imageclient
     * @param \DateTime $dateInscri
     */
    public function __construct($id, $nom, $prenom, $email, $nationalite, $nomCompany, $motdepass, $descriptionCompany, $imageclient, \DateTime $dateInscri)
    {
        $this->id = $id;
        $this->nom = $nom;
        $this->prenom = $prenom;
        $this->email = $email;
        $this->nationalite = $nationalite;
        $this->nomCompany = $nomCompany;
        $this->motdepass = $motdepass;
        $this->descriptionCompany = $descriptionCompany;
        $this->imageclient = $imageclient;
        $this->dateInscri = $dateInscri;
    }


    /**
     * @return int
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * @return string
     */
    public function getNom()
    {
        return $this->nom;
    }

    /**
     * @return string
     */
    public function getPrenom()
    {
        return $this->prenom;
    }

    /**
     * @return string
     */
    public function getEmail()
    {
        return $this->email;
    }

    /**
     * @return string
     */
    public function getNationalite()
    {
        return $this->nationalite;
    }

    /**
     * @return string
     */
    public function getNomCompany()
    {
        return $this->nomCompany;
    }

    /**
     * @return string
     */
    public function getMotdepass()
    {
        return $this->motdepass;
    }

    /**
     * @return string
     */
    public function getDescriptionCompany()
    {
        return $this->descriptionCompany;
    }

    /**
     * @return \DateTime
     */
    public function getDateInscri()
    {
        return $this->dateInscri;
    }

    /**
     * @return string
     */
    public function getImageclient()
    {
        return $this->imageclient;
    }




}

