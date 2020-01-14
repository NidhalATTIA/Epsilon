<?php

namespace AnnonceBundle\Controller;

use AnnonceBundle\Entity\Freelancer;
use AnnonceBundle\Entity\Client;
use AnnonceBundle\Entity\Admin;
use AnnonceBundle\Entity\User;
use AnnonceBundle\Entity\Skills;
use AnnonceBundle\Entity\CategorieSkills;
//use http\Client\Curl\User;
use FOS\UserBundle\Model\UserInterface;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;
use AnnonceBundle\Form\ProfilType;
use Symfony\Component\Security\Core\Exception\AccessDeniedException;

class ProfilController extends Controller
{
    public function ProfilAction($ref)
    {
        return $this->render('@Annonce/Default/ProfilClient.html.twig',array('r'=>$ref));
    }


    // FREELANCER
    public function ReadProfilFAction(){
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

    public function showAction()
    {
        $user = $this->getUser();
        if (!is_object($user) || !$user instanceof UserInterface) {
            throw new AccessDeniedException('This user does not have access to this section.');
        }

        return $this->render('@FOSUser/Profile/show.html.twig', array(
            'user' => $user,
        ));

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
