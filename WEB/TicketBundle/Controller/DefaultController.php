<?php

namespace TicketBundle\Controller;

use Symfony\Component\HttpFoundation\Request;
use TicketBundle\Entity\Historiquereclamation;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use TicketBundle\Form\HistoriquereclamationType;

class DefaultController extends Controller
{
    public function indexAction()
    {
        return $this->render('base1.html.twig');
    }
    public function createEAction(Request $request){
        $historiquereclamation = new Historiquereclamation();
        $form = $this->createForm(HistoriquereclamationType::class, $historiquereclamation);  //ta3ml form fergha
        $form = $form->handleRequest($request);
        if ($form->isValid()){
            $em = $this->getDoctrine()->getManager();
            $em->persist($historiquereclamation); //rani nheb na3mml 7keya
            $em->flush(); //refrechi
            return $this->redirectToRoute('Ticket_AfficheH');
        }
        return $this->render('@Ticket/Historiquereclamation/createE.html.twig',array('f'=> $form->createView()));
    }
}
