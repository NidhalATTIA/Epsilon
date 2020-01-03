<?php

namespace AnnonceBundle\Entity;

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
    public function getCv()
    {
        return $this->cv;
    }

    /**
     * @param string $cv
     */
    public function setCv($cv)
    {
        $this->cv = $cv;
    }

    /**
     * @return string
     */
    public function getDescription()
    {
        return $this->description;
    }

    /**
     * @param string $description
     */
    public function setDescription($description)
    {
        $this->description = $description;
    }

    /**
     * @return string
     */
    public function getImagefreelancer()
    {
        return $this->imagefreelancer;
    }

    /**
     * @param string $imagefreelancer
     */
    public function setImagefreelancer($imagefreelancer)
    {
        $this->imagefreelancer = $imagefreelancer;
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

