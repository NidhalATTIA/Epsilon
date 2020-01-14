<?php

namespace FormationBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Subscribtion
 *
 * @ORM\Table(name="subscribtion", indexes={@ORM\Index(name="subC_fk", columns={"ID_client"}), @ORM\Index(name="subF_fk", columns={"ID_Freelancer"})})
 * @ORM\Entity
 */
class Subscribtion
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
     * @var \Client
     *
     * @ORM\ManyToOne(targetEntity="Client")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="ID_client", referencedColumnName="ID")
     * })
     */
    private $idClient;

    /**
     * @var \Freelancer
     *
     * @ORM\ManyToOne(targetEntity="Freelancer")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="ID_Freelancer", referencedColumnName="ID")
     * })
     */
    private $idFreelancer;


}

