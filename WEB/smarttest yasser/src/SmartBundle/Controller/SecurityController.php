<?php

namespace SmartBundle\Controller;
use SmartBundle\Entity\User;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\Security;

class SecurityController extends Controller
{
    public function addAction()
    {

    }

    public function RedirectAction()
    {
        $authChecker = $this->container->get('security.authorization_checker');
        if($authChecker->isGranted('ROLE_ADMIN')){
            $user=$this->getDoctrine()->getRepository(User::class)->findAll();
            return $this->render('@Smart/Security/admin_home.html.twig',array('free'=>$user));}
         else if($authChecker->isGranted('ROLE_USER')){

             $user=$this->getDoctrine()->getRepository(User::class)->findAll();

                 return $this->render('@Smart/Security/user_home.html.twig',array('free'=>$user));
        }else
        return $this->render('@FOSUser/Security/login.html.twig' );

    }



}
