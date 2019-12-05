<?php

namespace TicketBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * CommentaireForum
 *
 * @ORM\Table(name="commentaire_forum", indexes={@ORM\Index(name="idSujet_fk", columns={"id_sujet"}), @ORM\Index(name="idFf_fk", columns={"idfreelancer"})})
 * @ORM\Entity
 */
class CommentaireForum
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
     * @var \Freelancer
     *
     * @ORM\ManyToOne(targetEntity="Freelancer")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="idfreelancer", referencedColumnName="ID")
     * })
     */
    private $idfreelancer;

    /**
     * @var \SujetForum
     *
     * @ORM\ManyToOne(targetEntity="SujetForum")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_sujet", referencedColumnName="ID")
     * })
     */
    private $idSujet;


}

