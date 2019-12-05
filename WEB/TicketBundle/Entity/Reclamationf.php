<?php

namespace TicketBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Reclamationf
 *
 * @ORM\Table(name="reclamationf", indexes={@ORM\Index(name="idf_rec", columns={"IdFreelancer"})})
 * @ORM\Entity
 */
class Reclamationf
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
     * @ORM\Column(name="Titre", type="string", length=50, nullable=false)
     */
    private $titre;

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
    private $dateajout;

    /**
     * @var \Freelancer
     *
     * @ORM\ManyToOne(targetEntity="Freelancer")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="IdFreelancer", referencedColumnName="ID")
     * })
     */
    private $idfreelancer;


}

