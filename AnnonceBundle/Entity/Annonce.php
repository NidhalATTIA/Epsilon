<?php

namespace AnnonceBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Annonce
 *
 * @ORM\Table(name="annonce", indexes={@ORM\Index(name="id_client", columns={"id_client"}), @ORM\Index(name="idfskilla", columns={"Skill"}), @ORM\Index(name="categorieAfk", columns={"idCategorieA"})})
 * @ORM\Entity(repositoryClass="AnnonceBundle\Repository\AnnonceRepository")
 */
class Annonce
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
     * @ORM\Column(name="Titre", type="string", length=30, nullable=false)
     */
    private $titre;

    /**
     * @var string
     *
     * @ORM\Column(name="DESCRIPTION", type="text", length=65535, nullable=false)
     */
    private $description;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="dateAjout", type="datetime", nullable=false)
     */
    private $dateajout = 'CURRENT_TIMESTAMP';

    /**
     * @var \Categorieannonce
     *
     * @ORM\ManyToOne(targetEntity="Categorieannonce")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="idCategorieA", referencedColumnName="id")
     * })
     */
    private $idcategoriea;

    /**
     * @var \Client
     *
     * @ORM\ManyToOne(targetEntity="User")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_client", referencedColumnName="id")
     * })
     */
    private $idClient;

    /**
     * @var \Skills
     *
     * @ORM\ManyToOne(targetEntity="Skills")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="Skill", referencedColumnName="ID")
     * })
     */
    private $skill;

    /**
     * @var integer
     *
     * @ORM\Column(name="Etat", type="integer", nullable=True)
     */
    private $Etat;

    public function __construct()
    {
        $this->dateajout = new \DateTime ();
    }

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
    public function getTitre()
    {
        return $this->titre;
    }

    /**
     * @param string $titre
     */
    public function setTitre($titre)
    {
        $this->titre = $titre;
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
     * @return \DateTime
     */
    public function getDateajout()
    {
        return $this->dateajout;
    }

    /**
     * @param \DateTime $dateajout
     */
    public function setDateajout($dateajout)
    {
        $this->dateajout = $dateajout;
    }

    /**
     * @return \Categorieannonce
     */
    public function getIdcategoriea()
    {
        return $this->idcategoriea;
    }

    /**
     * @param \Categorieannonce $idcategoriea
     */
    public function setIdcategoriea($idcategoriea)
    {
        $this->idcategoriea = $idcategoriea;
    }

    /**
     * @return \Client
     */
    public function getIdClient()
    {
        return $this->idClient;
    }

    /**
     * @param \Client $idClient
     */
    public function setIdClient($idClient)
    {
        $this->idClient = $idClient;
    }

    /**
     * @return \Skills
     */
    public function getSkill()
    {
        return $this->skill;
    }

    /**
     * @param \Skills $skill
     */
    public function setSkill($skill)
    {
        $this->skill = $skill;
    }

    /**
     * @return int
     */
    public function getEtat()
    {
        return $this->Etat;
    }

    /**
     * @param int $Etat
     */
    public function setEtat($Etat)
    {
        $this->Etat = $Etat;
    }


}

