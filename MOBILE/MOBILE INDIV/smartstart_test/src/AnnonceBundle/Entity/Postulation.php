<?php

namespace AnnonceBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Postulation
 *
 * @ORM\Table(name="postulation", indexes={@ORM\Index(name="idFreelancer", columns={"idFreelancer"}), @ORM\Index(name="idAnnonce", columns={"idAnnonce"})})
 * @ORM\Entity(repositoryClass="AnnonceBundle\Repository\AnnonceRepository")
 */
class Postulation
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
     * @ORM\Column(name="Contenu", type="text", length=65535, nullable=false)
     */
    private $contenu;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="dateAjout", type="datetime", nullable=false)
     */
    private $dateajout = 'CURRENT_TIMESTAMP';

    /**
     * @var \Annonce
     *
     * @ORM\ManyToOne(targetEntity="Annonce")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="idAnnonce", referencedColumnName="ID")
     * })
     */
    private $idannonce;

    /**
     * @var \Freelancer
     *
     * @ORM\ManyToOne(targetEntity="User")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="idFreelancer", referencedColumnName="id")
     * })
     */
    private $idfreelancer;

    /**
     * Postulation constructor.
     * @param \DateTime $dateajout
     */

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
    public function getContenu()
    {
        return $this->contenu;
    }

    /**
     * @param string $contenu
     */
    public function setContenu($contenu)
    {
        $this->contenu = $contenu;
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
     * @return \Annonce
     */
    public function getIdannonce()
    {
        return $this->idannonce;
    }

    /**
     * @param \Annonce $idannonce
     */
    public function setIdannonce($idannonce)
    {
        $this->idannonce = $idannonce;
    }

    /**
     * @return \Freelancer
     */
    public function getIdfreelancer()
    {
        return $this->idfreelancer;
    }

    /**
     * @param \Freelancer $idfreelancer
     */
    public function setIdfreelancer($idfreelancer)
    {
        $this->idfreelancer = $idfreelancer;
    }


}