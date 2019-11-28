<?php

namespace AnnonceBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Skills
 *
 * @ORM\Table(name="skills", indexes={@ORM\Index(name="id_categorie", columns={"id_categorie"})})
 * @ORM\Entity
 */
class Skills
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
     * @ORM\Column(name="Skill", type="string", length=30, nullable=false)
     */
    private $skill;

    /**
     * @var \CategorieSkills
     *
     * @ORM\ManyToOne(targetEntity="CategorieSkills")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_categorie", referencedColumnName="id_categorie")
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
     * @return string
     */
    public function getSkill()
    {
        return $this->skill;
    }

    /**
     * @param string $skill
     */
    public function setSkill($skill)
    {
        $this->skill = $skill;
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

