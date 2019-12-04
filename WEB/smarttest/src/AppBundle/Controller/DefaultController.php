<?php

namespace AppBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Routing\Annotation\Route;

class DefaultController extends Controller
{
    /**
     * @Route("/", name="homepage")
     */
    public function indexAction()
    {
        // replace this example code with whatever you need
     //   return $this->render('default/index.html.twig', [
         //   'base_dir' => realpath($this->getParameter('kernel.project_dir')).DIRECTORY_SEPARATOR,
     //   ]);
    return $this->render('base.html.twig');

    }

    /**
     * @Route("/smart/show", name="showfeed")
     */
    public function adminAction()
    {
        // replace this example code with whatever you need
        //   return $this->render('default/index.html.twig', [
        //   'base_dir' => realpath($this->getParameter('kernel.project_dir')).DIRECTORY_SEPARATOR,
        //   ]);
        return $this->render('base2.html.twig');
    }

}
