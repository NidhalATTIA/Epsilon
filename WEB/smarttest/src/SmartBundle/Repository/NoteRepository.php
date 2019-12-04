<?php


namespace SmartBundle\Repository;


use Doctrine\ORM\EntityRepository;
use SmartBundle\Entity\Note;
use Doctrine\ORM\NonUniqueResultException;
use Doctrine\ORM\Query;



class NoteRepository extends EntityRepository
{
    /**
     * get all posts
     *
     * @return array
     */
    public function findFormationById($id){
        return $this->getEntityManager()
            ->createQuery(
                "SELECT a FROM SmartBundle:Note
                a where a.idFreelancer=:idFreelancer"
            )
            ->setParameter('idFreelancer',$id)
            ->getResult();
    }

}
