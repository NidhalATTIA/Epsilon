<?php

namespace TicketBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Ticket
 *
 * @ORM\Table(name="ticket", indexes={@ORM\Index(name="categorie", columns={"categorie"})})
 * @ORM\Entity
 */
class Ticket
{
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
    public function getOffre()
    {
        return $this->offre;
    }

    /**
     * @param string $offre
     */
    public function setOffre($offre)
    {
        $this->offre = $offre;
    }

    /**
     * @return string
     */
    public function getService()
    {
        return $this->service;
    }

    /**
     * @param string $service
     */
    public function setService($service)
    {
        $this->service = $service;
    }

    /**
     * @return string
     */
    public function getMotifreclamation()
    {
        return $this->motifreclamation;
    }

    /**
     * @param string $motifreclamation
     */
    public function setMotifreclamation($motifreclamation)
    {
        $this->motifreclamation = $motifreclamation;
    }

    /**
     * @return string
     */
    public function getImage()
    {
        return $this->image;
    }

    /**
     * @param string $image
     */
    public function setImage($image)
    {
        $this->image = $image;
    }

    /**
     * @return \Categoriereclamation
     */
    public function getCategorie()
    {
        return $this->categorie;
    }

    /**
     * @param \Categoriereclamation $categorie
     */
    public function setCategorie($categorie)
    {
        $this->categorie = $categorie;
    }
    /**
     * @var integer
     *
     * @ORM\Column(name="id", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $id;

    /**
     * @var string
     *
     * @ORM\Column(name="offre", type="string", length=30, nullable=false)
     */
    private $offre;

    /**
     * @var string
     *
     * @ORM\Column(name="service", type="string", length=30, nullable=false)
     */
    private $service;

    /**
     * @var string
     *
     * @ORM\Column(name="motifReclamation", type="string", length=30, nullable=false)
     */
    private $motifreclamation;

    /**
     * @var string
     *
     * @ORM\Column(name="image", type="string", length=30, nullable=false)
     */
    private $image;

    /**
     * @var \Categoriereclamation
     *
     * @ORM\ManyToOne(targetEntity="Categoriereclamation")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="categorie", referencedColumnName="id")
     * })
     */
    private $categorie;


}

