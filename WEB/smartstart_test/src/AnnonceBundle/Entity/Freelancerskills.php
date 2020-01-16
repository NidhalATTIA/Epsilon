<?php

namespace AnnonceBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Freelancerskills
 *
 * @ORM\Table(name="freelancerskills", indexes={@ORM\Index(name="idfreeskills", columns={"idFreelancer"}), @ORM\Index(name="fkskill5", columns={"skill"})})
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
     *   @ORM\JoinColumn(name="skill", referencedColumnName="ID")
     * })
     */
    private $skills;

        /**
     * @var \User
     *
     * @ORM\ManyToOne(targetEntity="User")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="idFreelancer", referencedColumnName="id")
     * })
     */
    private $idfreelancer;

    /**
     * @var \CategorieSkills
     *
     * @ORM\ManyToOne(targetEntity="CategorieSkills")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="idCategorie", referencedColumnName="id_categorie")
     * })
     */
    private $idCategorie;

    /**
     * @return int
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * @param int $id
     */
    public function setId($id)
    {
        $this->id = $id;
    }

    /**
     * @return \Skills
     */
    public function getSkills()
    {
        return $this->skills;
    }

    /**
     * @param \Skills $skills
     */
    public function setSkills($skills)
    {
        $this->skills = $skills;
    }

    /**
     * @return \User
     */
    public function getIdfreelancer()
    {
        return $this->idfreelancer;
    }

    /**
     * @param \User $idfreelancer
     */
    public function setIdfreelancer($idfreelancer)
    {
        $this->idfreelancer = $idfreelancer;
    }

    /**
     * @return \CategorieSkills
     */
    public function getIdCategorie()
    {
        return $this->idCategorie;
    }

    /**
     * @param \CategorieSkills $idCategorie
     */
    public function setIdCategorie($idCategorie)
    {
        $this->idCategorie = $idCategorie;
    }



}

