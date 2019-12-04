<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Freelancerskills
 *
 * @ORM\Table(name="freelancerskills", indexes={@ORM\Index(name="idfreeskills", columns={"idFreelancer"}), @ORM\Index(name="fkskill5", columns={"skill5"})})
 * @ORM\Entity
 */
class Freelancerskills
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
     * @var \Skills
     *
     * @ORM\ManyToOne(targetEntity="Skills")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="skill5", referencedColumnName="ID")
     * })
     */
    private $skill5;

    /**
     * @var \FosUser
     *
     * @ORM\ManyToOne(targetEntity="FosUser")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_freelancer", referencedColumnName="id")
     * })
     */
    private $idfreelancer;


}

