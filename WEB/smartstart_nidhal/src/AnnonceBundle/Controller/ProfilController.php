<?php

namespace AnnonceBundle\Controller;

use AnnonceBundle\Entity\Freelancer;
use AnnonceBundle\Entity\Client;
use AnnonceBundle\Entity\Admin;
use AnnonceBundle\Entity\User;
use AnnonceBundle\Entity\Skills;
use AnnonceBundle\Entity\CategorieSkills;
//use http\Client\Curl\User;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;
use AnnonceBundle\Form\ProfilType;

class ProfilController extends Controller
{
    public function ProfilAction($ref)
    {
        return $this->render('@Annonce/Default/ProfilClient.html.twig',array('r'=>$ref));
    }


    // FREELANCER
    public function ReadProfilAction(){
        $user = $this->container->get('security.token_storage')->getToken()->getUser();
        $user->getId();
        $Postulation=$this->getDoctrine()->getRepository(freelancer::class)->findProfileById($user);
        return $this->render('@Annonce/Default/ProfilFreelancer.html.twig',array('Postulation'=>$Postulation));
    }

    //CLIENT
    public function ReadProfilCAction(){
        $user = $this->container->get('security.token_storage')->getToken()->getUser();
        $user->getId();
        $Postulation=$this->getDoctrine()->getRepository(client::class)->findProfileById($user);
        return $this->render('@Annonce/Default/ProfilClient.html.twig',array('Postulation'=>$Postulation));
    }

    //ADMIN
    public function ReadProfilAAction(){
        $user = $this->container->get('security.token_storage')->getToken()->getUser();
        $user->getId();
        $Postulation=$this->getDoctrine()->getRepository(admin::class)->findProfileById($user);
        return $this->render('@Annonce/Default/ProfilAdmin.html.twig',array('Postulation'=>$Postulation));
    }


    public function DetailProfilAction(){
        $user = $this->container->get('security.token_storage')->getToken()->getUser();
        $user->getId();
        $Postulation=$this->getDoctrine()->getRepository(freelancer::class)->findProfileById($user);
        return $this->render('@Annonce/Default/ProfilFreelancer.html.twig',array(

            'Skill'=>$Postulation->getSkill()));

    }



}
