<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Feedbackc
 *
 * @ORM\Table(name="feedbackc", indexes={@ORM\Index(name="id_freelancer", columns={"id_freelancer"}), @ORM\Index(name="id_Client", columns={"id_Client"})})
 * @ORM\Entity
 */
class Feedbackc
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
     * @ORM\Column(name="contenu", type="string", length=150, nullable=false)
     */
    private $contenu;

    /**
     * @var \FosUser
     *
     * @ORM\ManyToOne(targetEntity="FosUser")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_Client", referencedColumnName="id")
     * })
     */
    private $idClient;

    /**
     * @var \FosUser
     *
     * @ORM\ManyToOne(targetEntity="FosUser")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_freelancer", referencedColumnName="id")
     * })
     */
    private $idFreelancer;


}

