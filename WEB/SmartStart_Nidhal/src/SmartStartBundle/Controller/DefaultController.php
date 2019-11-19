<?php

namespace SmartStartBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;

class DefaultController extends Controller
{
    public function indexAction()
    {
        return $this->render('@SmartStart/Default/index.html.twig');
    }
}
