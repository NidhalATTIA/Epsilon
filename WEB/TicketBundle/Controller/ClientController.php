<?php

namespace TicketBundle\Controller;



use TicketBundle\Entity\Client;
use TicketBundle\Form\RechercheType;
use TicketBundle\Form\ClientType;
use TicketBundle\Entity\Ticket;
use mysql_xdevapi\CollectionRemove;
use mysql_xdevapi\TableDelete;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;


class ClientController extends Controller
{
    public function afficheCAction()
    {
        $client = $this->getDoctrine()->getRepository(Client::class)->findAll();

        return $this->render('@Ticket/User/AfficheC.html.twig', array('Client' => $client));
    }

    public function deleteCAction($id){
        $em = $this->getDoctrine()->getManager();
        $client=$em->getRepository(Client::class)->find($id);
        $em->remove($client);
        $em->flush();
        return $this->redirectToRoute("client_gestion");
    }



}
