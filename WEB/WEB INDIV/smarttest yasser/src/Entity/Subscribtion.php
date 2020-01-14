<?php

namespace App\Entity;

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

