<?php

namespace AnnonceBundle\Repository;

use Doctrine\ORM\EntityRepository;
use AnnonceBundle\Entity\Annonce;
use Doctrine\ORM\NonUniqueResultException;
use Doctrine\ORM\Query;
use AnnonceBundle\Entity\Postulation;


class AnnonceRepository extends EntityRepository
{

    /**
     * get all posts
     *
     * @return array
     */

    public function findProfileById($id)
    {
        return $this->getEntityManager()
            ->createQuery(
                "SELECT a
       FROM AnnonceBundle:Freelancer
       a WHERE a.idF = :idF"
            )
            ->setParameter('idF', $id)
            ->getResult();
    }

    public function findPostuleById($id)
    {
        return $this->getEntityManager()
            ->createQuery(
                "SELECT p
       FROM AnnonceBundle:Postulation
       p WHERE p.idfreelancer = :idfreelancer"
            )
            ->setParameter('idfreelancer', $id)
            ->getResult();
    }
    public function findpostulationById($id)
    {
        return $this->getEntityManager()
            ->createQuery(
                "SELECT p
       FROM AnnonceBundle:Postulation
       p WHERE p.idannonce = :idannonce"
            )
            ->setParameter('idannonce', $id)
            ->getResult();
    }
    /**
     * get one by id
     *
     * @param integer $id
     *
     * @return object or null
     */



}
