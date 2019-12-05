<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Categorieformation
 *
 * @ORM\Table(name="categorieformation")
 * @ORM\Entity
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


}

