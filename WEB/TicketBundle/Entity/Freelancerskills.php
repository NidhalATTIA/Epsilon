<?php

namespace TicketBundle\Entity;

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
     * @var \Freelancer
     *
     * @ORM\ManyToOne(targetEntity="Freelancer")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="idFreelancer", referencedColumnName="ID")
     * })
     */
    private $idfreelancer;

    /**
     * @var \Skills
     *
     * @ORM\ManyToOne(targetEntity="Skills")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="skill5", referencedColumnName="ID")
     * })
     */
    private $skill5;


}

