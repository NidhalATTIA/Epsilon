<?php

namespace FormationBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Categorieannonce
 *
 * @ORM\Table(name="categorieannonce", indexes={@ORM\Index(name="categorieA", columns={"categorieA"})})
 * @ORM\Entity
 */
class Categorieannonce
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
     * @ORM\Column(name="categorieA", type="string", length=30, nullable=false)
     */
    private $categoriea;


}

