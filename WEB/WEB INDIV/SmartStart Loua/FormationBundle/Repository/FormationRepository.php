<?php


namespace FormationBundle\Repository;

use Doctrine\ORM\EntityRepository;
use FormationBundle\Entity\Formation;
use Doctrine\ORM\NonUniqueResultException;
use Doctrine\ORM\Query;



class FormationRepository extends EntityRepository
{
    /**
     * get all posts
     *
     * @return array
     */
    public function findFormationById($id){
        return $this->getEntityManager()
            ->createQuery(
                "SELECT a FROM FormationBundle:Formation
                a where a.idclient=:idclient"
            )
            ->setParameter('idclient',$id)
            ->getResult();
    }

}