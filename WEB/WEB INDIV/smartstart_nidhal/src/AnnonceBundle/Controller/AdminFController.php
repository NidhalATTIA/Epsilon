<?php

namespace AnnonceBundle\Controller;

use AnnonceBundle\Entity\Feedbackc;
use AnnonceBundle\Entity\User;
use AnnonceBundle\Form\adminVType;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\JsonResponse;


class AdminFController extends Controller
{


    public function updateAction($id)
    {/*
        $em = $this->getDoctrine()->getManager();
        $feed = $em->getRepository(User::class)->find($id);


      $form = $this->createForm(adminVType::class, $feed);
        $from = $form->handleRequest($request);

        if ($form->isValid()) {
            $em->persist($feed);
            $em->flush();
            return $this->redirectToRoute('club_redirect');
        }
        return $this->render('@Smart/Security/admin_creat.html.twig', array('f' => $form->createView()));
*/
      $personne = new User();
        $em = $this->getDoctrine()->getManager();
        $feed = $em->getRepository(User::class)->find($id);
        if($feed->getEtat() =="encours"){
            $feed->setEtat("Valide");}
      else{ $feed->setEtat("encours");}
        $em->persist($feed);
        $em->flush();

        return $this->redirectToRoute('club_redirect');

    }




}
