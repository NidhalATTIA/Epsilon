<?php

namespace SmartBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Freelancer
 *
 * @ORM\Table(name="freelancer", uniqueConstraints={@ORM\UniqueConstraint(name="Email", columns={"Email"})})
 * @ORM\Entity
 */
class Freelancer
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
     * @ORM\Column(name="MotDePass", type="string", length=20, nullable=false)
     */
    private $motdepass;

    /**
     * @var string
     *
     * @ORM\Column(name="Nationalite", type="string", length=20, nullable=false)
     */
    private $nationalite;

    /**
     * @var string
     *
     * @ORM\Column(name="CV", type="string", length=20, nullable=false)
     */
    private $cv;

    /**
     * @var string
     *
     * @ORM\Column(name="Description", type="text", length=65535, nullable=false)
     */
    private $description;

    /**
     * @var string
     *
     * @ORM\Column(name="ImageFreelancer", type="blob", nullable=false)
     */
    private $imagefreelancer;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="Date_inscri", type="datetime", nullable=false)
     */
    private $dateInscri = 'CURRENT_TIMESTAMP';

    /**
     * Freelancer constructor.
     * @param int $id
     * @param string $nom
     * @param string $prenom
     * @param string $email
     * @param string $motdepass
     * @param string $nationalite
     * @param string $cv
     * @param string $description
     * @param string $imagefreelancer
     * @param \DateTime $dateInscri
     */
    public function __construct($id, $nom, $prenom, $email, $motdepass, $nationalite, $cv, $description, $imagefreelancer, \DateTime $dateInscri)
    {
        $this->id = $id;
        $this->nom = $nom;
        $this->prenom = $prenom;
        $this->email = $email;
        $this->motdepass = $motdepass;
        $this->nationalite = $nationalite;
        $this->cv = $cv;
        $this->description = $description;
        $this->imagefreelancer = $imagefreelancer;
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
    public function getMotdepass()
    {
        return $this->motdepass;
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
    public function getCv()
    {
        return $this->cv;
    }

    /**
     * @return string
     */
    public function getDescription()
    {
        return $this->description;
    }

    /**
     * @return string
     */
    public function getImagefreelancer()
    {
        return $this->imagefreelancer;
    }

    /**
     * @return \DateTime
     */
    public function getDateInscri()
    {
        return $this->dateInscri;
    }


}

