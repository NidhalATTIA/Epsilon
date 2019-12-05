<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * User
 *
 * @ORM\Table(name="client", uniqueConstraints={@ORM\UniqueConstraint(name="Prenom", columns={"Prenom"})})
 * @ORM\Entity
 */
class Client
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
     * @ORM\Column(name="Nom", type="string", length=20, nullable=false)
     */
    private $nom;

    /**
     * @var string
     *
     * @ORM\Column(name="Prenom", type="string", length=20, nullable=false)
     */
    private $prenom;

    /**
     * @var string
     *
     * @ORM\Column(name="Email", type="string", length=20, nullable=false)
     */
    private $email;

    /**
     * @var string
     *
     * @ORM\Column(name="Nationalite", type="string", length=20, nullable=false)
     */
    private $nationalite;

    /**
     * @var string
     *
     * @ORM\Column(name="Nom_company", type="string", length=20, nullable=false)
     */
    private $nomCompany;

    /**
     * @var string
     *
     * @ORM\Column(name="MotDePass", type="string", length=20, nullable=false)
     */
    private $motdepass;

    /**
     * @var string
     *
     * @ORM\Column(name="Description_company", type="text", length=65535, nullable=false)
     */
    private $descriptionCompany;

    /**
     * @var string
     *
     * @ORM\Column(name="ImageClient", type="blob", nullable=false)
     */
    private $imageclient;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="Date_inscri", type="datetime", nullable=false)
     */
    private $dateInscri;


}

