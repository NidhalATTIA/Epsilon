<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Historiquereclamation
 *
 * @ORM\Table(name="historiquereclamation", indexes={@ORM\Index(name="motifRec", columns={"MotifReclamation"})})
 * @ORM\Entity
 */
class Historiquereclamation
{
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
     * @ORM\Column(name="Attribution", type="string", length=30, nullable=false)
     */
    private $attribution;

    /**
     * @var float
     *
     * @ORM\Column(name="GSM", type="float", precision=10, scale=0, nullable=false)
     */
    private $gsm;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="dateCreation", type="date", nullable=false)
     */
    private $datecreation;

    /**
     * @var integer
     *
     * @ORM\Column(name="etat", type="integer", nullable=true)
     */
    private $etat;

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
    public function getAttribution()
    {
        return $this->attribution;
    }

    /**
     * @param string $attribution
     */
    public function setAttribution($attribution)
    {
        $this->attribution = $attribution;
    }

    /**
     * @return float
     */
    public function getGsm()
    {
        return $this->gsm;
    }

    /**
     * @param float $gsm
     */
    public function setGsm($gsm)
    {
        $this->gsm = $gsm;
    }

    /**
     * @return \DateTime
     */
    public function getDatecreation()
    {
        return $this->datecreation;
    }

    /**
     * @param \DateTime $datecreation
     */
    public function setDatecreation($datecreation)
    {
        $this->datecreation = $datecreation;
    }

    /**
     * @return int
     */
    public function getEtat()
    {
        return $this->etat;
    }

    /**
     * @param int $etat
     */
    public function setEtat($etat)
    {
        $this->etat = $etat;
    }

    /**
     * @return \Ticket
     */
    public function getMotifreclamation()
    {
        return $this->motifreclamation;
    }

    /**
     * @param \Ticket $motifreclamation
     */
    public function setMotifreclamation($motifreclamation)
    {
        $this->motifreclamation = $motifreclamation;
    }

    /**
     * @var \Ticket
     *
     * @ORM\ManyToOne(targetEntity="Ticket")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="MotifReclamation", referencedColumnName="id")
     * })
     */
    private $motifreclamation;


}

