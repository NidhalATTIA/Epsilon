<?php

namespace AnnonceBundle\Controller;

use AnnonceBundle\Entity\Freelancer;
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

    public function ReadProfilAction(){
        $user=$this->getDoctrine()->getRepository(User::class)->findAll();
        $categorie_skills=$this->getDoctrine()->getRepository(CategorieSkills::class)->findAll();
        $skills=$this->getDoctrine()->getRepository(Skills::class)->findAll();
        $freelancer=$this->getDoctrine()->getRepository(Freelancer::class)->findAll();
        //add the list of clubs to the render function as input to base
        return $this->render('@Annonce/Default/ProfilFreelancer.html.twig',array('a'=>$user,'b'=>$categorie_skills,'c'=>$skills,'d'=>$freelancer));
    }




}
