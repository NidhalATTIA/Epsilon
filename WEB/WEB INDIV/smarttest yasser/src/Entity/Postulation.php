<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Postulation
 *
 * @ORM\Table(name="postulation", indexes={@ORM\Index(name="idFreelancer", columns={"idFreelancer"}), @ORM\Index(name="idAnnonce", columns={"idAnnonce"})})
 * @ORM\Entity
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
    private $dateajout;
    /**
     * @var \FosUser
     *
     * @ORM\ManyToOne(targetEntity="FosUser")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_Client", referencedColumnName="id")
     * })
     */
    private $idfreelancer;

    /**
     * @var \Annonce
     *
     * @ORM\ManyToOne(targetEntity="Annonce")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="idAnnonce", referencedColumnName="ID")
     * })
     */
    private $idannonce;


}

