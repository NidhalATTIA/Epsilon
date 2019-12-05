<?php

namespace App\Entity;

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

