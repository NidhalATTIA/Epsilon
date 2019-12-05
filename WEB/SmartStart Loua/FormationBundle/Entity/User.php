<?php


namespace FormationBundle\Entity;



use FOS\UserBundle\Model\User as BaseUser;
use Doctrine\ORM\Mapping as ORM;

/**
 * @ORM\Entity
 * @ORM\Table(name="fos_user")
 */
class User extends BaseUser
{
    /**
     * @ORM\Id
     * @ORM\Column(type="integer")
     * @ORM\GeneratedValue(strategy="AUTO")
     */
    protected $id;

    public function __construct()
    {
        parent::__construct();
        // your own logic
    }

    /**
     * @return mixed
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * @param mixed $id
     */
    public function setId($id)
    {
        $this->id = $id;
    }

    /**
     * @var string
     *
     * @ORM\Column(name="Nom_company", type="string", length=20)
     */
    private $nomCompany;

    /**
     * @return string
     */
    public function getNomCompany()
    {
        return $this->nomCompany;
    }

    /**
     * @param string $nomCompany
     */
    public function setNomCompany($nomCompany)
    {
        $this->nomCompany = $nomCompany;
    }




}