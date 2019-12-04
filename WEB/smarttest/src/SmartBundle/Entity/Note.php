<?php

namespace SmartBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Note
 *
 * @ORM\Table(name="note", indexes={@ORM\Index(name="noteC_fk", columns={"idClient"}), @ORM\Index(name="noteF_fk", columns={"IdFreelancer"})})
 * @ORM\Entity
 * @ORM\Entity(repositoryClass="SmartBundle\Repository\NoteRepository")
 */
class Note
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
     * @var integer
     *
     * @ORM\Column(name="note", type="integer", nullable=false)
     */
    private $note;

     /**
 * @var \User
 *
 * @ORM\ManyToOne(targetEntity="User")
 * @ORM\JoinColumns({
 *   @ORM\JoinColumn(name="idClient", referencedColumnName="id", nullable=false)
 * })
 */
    private $idclient;
    /**
     * @var \User
     *
     * @ORM\ManyToOne(targetEntity="User")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="idfreelancer", referencedColumnName="id", nullable=false)
     * })
     */
    private $idfreelancer;

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
     * @return int
     */
    public function getNote()
    {
        return $this->note;
    }

    /**
     * @param int $note
     */
    public function setNote($note)
    {
        $this->note = $note;
    }

    /**
     * @return \User
     */
    public function getIdclient()
    {
        return $this->idclient;
    }

    /**
     * @param \User $idclient
     */
    public function setIdclient($idclient)
    {
        $this->idclient = $idclient;
    }


}

