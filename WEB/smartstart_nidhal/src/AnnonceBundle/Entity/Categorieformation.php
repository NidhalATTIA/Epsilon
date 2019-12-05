<?php

namespace AnnonceBundle\Entity;

use Doctrine\ORM\Mapping as ORM;
use Symfony\Bridge\Doctrine\Validator\Constraints\UniqueEntity;

/**
 * Categorieformation
 *
 * @ORM\Table(name="categorieformation")
 * @ORM\Entity
 */

/**
 * Categorieformation
 *
 * @ORM\Table()
 * @ORM\Entity
 * @UniqueEntity("categorief") // c'est ici que je declare le champs unique
 */

class Categorieformation
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
     * @ORM\Column(name="categorieF", type="string", length=30, nullable=false)
     */

    private $categorief;

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
    public function getCategorief()
    {
        return $this->categorief;
    }

    /**
     * @param string $categorief
     */
    public function setCategorief($categorief)
    {
        $this->categorief = $categorief;
    }


}

