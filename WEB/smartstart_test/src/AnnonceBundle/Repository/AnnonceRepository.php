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

    // DQL Nidhal
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

    // DQL Kaffel
    public function findAnnonceById($id)
    {
        return $this->getEntityManager()
            ->createQuery(
                "SELECT a
       FROM AnnonceBundle:Annonce
       a WHERE a.idClient = :idClient"
            )
            ->setParameter('idClient', $id)
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

    public function AffichePostule()
    {
        return $this->getEntityManager()
            ->createQuery(
                "SELECT p
       FROM AnnonceBundle:Annonce
       p WHERE p.Etat = :Etat"
            )
            ->setParameter('Etat', 'NULL')
            ->execute();

    }

    public function AfficheAnnoncehistorique($id)
    {
        return $this->getEntityManager()
            ->createQuery(
                "SELECT p
       FROM AnnonceBundle:Annonce
       p WHERE p.Etat = :Etat AND p.idClient = :idClient"
            )
            ->setParameter('Etat', 'NULL')
            ->setParameter('idClient', $id)
            ->execute();

    }

    public function AffichepostulationAccepte($id)
    {
        return $this->getEntityManager()
            ->createQuery(
                "SELECT a
       FROM AnnonceBundle:Annonce a JOIN 
      AnnonceBundle:Postulation p WITH a.id=p.idannonce WHERE p.idfreelancer = :idfreelancer AND a.Etat = :Etat"
            )
            ->setParameter('idfreelancer', $id)
            ->setParameter('Etat', 1)
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
