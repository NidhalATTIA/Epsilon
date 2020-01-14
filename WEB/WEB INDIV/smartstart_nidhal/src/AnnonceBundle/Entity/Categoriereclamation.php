<?php

namespace AnnonceBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Categoriereclamation
 *
 * @ORM\Table(name="categoriereclamation")
 * @ORM\Entity
 */
class Categoriereclamation
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
    public function getCategorier()
    {
        return $this->categorier;
    }

    /**
     * @param string $categorier
     */
    public function setCategorier($categorier)
    {
        $this->categorier = $categorier;
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
     * @ORM\Column(name="categorieR", type="string", length=30, nullable=false)
     */
    private $categorier;


}

