<?php

namespace AnnonceBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Freelancer
 *
 * @ORM\Table(name="freelancer")
 * @ORM\Entity
 */
class Freelancer
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
     * @ORM\Column(name="Description", type="text", length=65535, nullable=false)
     */
    private $description;


    /**
     * @var \idSkills
     *
     * @ORM\ManyToOne(targetEntity="Skills")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="Skill", referencedColumnName="ID")
     * })
     */
    private $skill;

    /**
     * @var \idF
     *
     * @ORM\ManyToOne(targetEntity="User")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="Freelancer", referencedColumnName="id")
     * })
     */
    private $idF;

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
     * @return string
     */
    public function getDescription()
    {
        return $this->description;
    }

    /**
     * @param string $description
     */
    public function setDescription($description)
    {
        $this->description = $description;
    }



    /**
     * @return \idSkills
     */
    public function getSkill()
    {
        return $this->skill;
    }

    /**
     * @param \idSkills $skill
     */
    public function setSkill($skill)
    {
        $this->skill = $skill;
    }

    /**
     * @return \idF
     */
    public function getIdF()
    {
        return $this->idF;
    }

    /**
     * @param \idF $idF
     */
    public function setIdF($idF)
    {
        $this->idF = $idF;
    }



}

