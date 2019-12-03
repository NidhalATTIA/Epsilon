<?php

namespace AnnonceBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;

class DefaultController extends Controller
{
    public function indexAction()
    {
        return $this->render('base.html.twig');
    }

    public function ContactUsAction()
    {
        return $this->render('@Annonce/Default/ContactUs.html.twig');
    }

    public function AccueilAdminAction()
    {
        return $this->render('@Annonce/Default/AccueilAdmin.html.twig');
    }

    public function AccueilClientAction()
    {
        return $this->render('@Annonce/Default/AccueilClient.html.twig');
    }

    public function AccueilFreelancerAction()
    {
        return $this->render('@Annonce/Default/AccueilFreelancer.html.twig');
    }

    public function ProfilAdminAction()
    {
        return $this->render('@Annonce/Default/ProfilAdmin.html.twig');
    }

    public function ProfilClientAction()
    {
        return $this->render('@Annonce/Default/ProfilClient.html.twig');
    }

    public function ProfilFreelancerAction()
    {
        return $this->render('@Annonce/Default/ProfilFreelancer.html.twig');
    }

}
