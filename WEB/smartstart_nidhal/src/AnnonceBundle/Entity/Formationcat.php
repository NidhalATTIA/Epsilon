<?php

namespace AnnonceBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Formationcat
 *
 * @ORM\Table(name="formationcat", indexes={@ORM\Index(name="idFreelancer", columns={"idFreelancer"}), @ORM\Index(name="idFormation", columns={"idFormation"})})
 * @ORM\Entity
 */
class Formationcat
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
     * @var integer
     *
     * @ORM\Column(name="idFreelancer", type="integer", nullable=true)
     */
    private $idfreelancer;

    /**
     * @var integer
     *
     * @ORM\Column(name="idFormation", type="integer", nullable=true)
     */
    private $idformation;

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
     * @return int
     */
    public function getIdfreelancer()
    {
        return $this->idfreelancer;
    }

    /**
     * @param int $idfreelancer
     */
    public function setIdfreelancer($idfreelancer)
    {
        $this->idfreelancer = $idfreelancer;
    }

    /**
     * @return int
     */
    public function getIdformation()
    {
        return $this->idformation;
    }

    /**
     * @param int $idformation
     */
    public function setIdformation($idformation)
    {
        $this->idformation = $idformation;
    }


}

