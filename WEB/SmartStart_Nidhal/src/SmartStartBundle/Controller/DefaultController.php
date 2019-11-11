<?php

namespace SmartStartBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;

class DefaultController extends Controller
{
    public function indexAction()
    {
        return $this->render('SmartStartBundle:Default:index.html.twig');
    }
}
