<?php

namespace TicketBundle\Controller;



use Symfony\Component\HttpFoundation\File\UploadedFile;
use TicketBundle\Form\RechercheType;
use TicketBundle\Form\TicketType;
use TicketBundle\Entity\Ticket;
use mysql_xdevapi\CollectionRemove;
use mysql_xdevapi\TableDelete;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;


class TicketController extends Controller
{
    public function afficheAction()
    {
        $formations = $this->getDoctrine()->getRepository(Ticket::class)->findAll();

        return $this->render('@Ticket/Ticket/Affiche.html.twig', array('Tickets' => $formations));
    }

    public function deleteAction($id){
        $em = $this->getDoctrine()->getManager();
        $reclamation=$em->getRepository(Ticket::class)->find($id);
        $em->remove($reclamation);
        $em->flush();
        return $this->redirectToRoute("ticket_gestion");
    }

    public function createAction(Request $request){
        $ticket = new Ticket();
        $form = $this->createForm(TicketType::class, $ticket);  //ta3ml form fergha
        $form = $form->handleRequest($request);
        if ($form->isValid()){
            /**
             * @var UploadedFile $file
             */
            $file=$ticket->getImage();
            $em = $this->getDoctrine()->getManager();
            $em->persist($ticket); //rani nheb na3mml 7keya
            $em->flush(); //refrechi
            return $this->redirectToRoute('ticket_gestion');
        }
        return $this->render('@Ticket/Ticket/create.html.twig',array('f'=> $form->createView()));

    }

    public function editAction(Request $request, $id){
        $em = $this->getDoctrine()->getManager();
        $ticket=$em->getRepository(Ticket::class)->find($id);
        $form = $this->createForm(TicketType::class, $ticket);
        $form = $form->handleRequest($request);

        if ($form->isValid()){
            $em = $this->getDoctrine()->getManager();
            $em->persist($ticket);
            $em->flush();
            return $this->redirectToRoute('ticket_gestion');
        }

        return $this->render('@Ticket/Ticket/edit.html.twig',array('f'=> $form->createView()));
    }

    public function rechercherAction(Request $request)
    {$ticket = new Ticket();
        $form= $this->createForm(RechercheType::class, $ticket);
        $form= $form->handleRequest($request);
        if($form->isSubmitted()) {
            $ticket = $this->getDoctrine()
                ->getRepository(Ticket::class)
                ->findBy(array('offre'=> $ticket
                    ->getOffre()));}
        else {
            $ticket = $this->getDoctrine()->getRepository(Ticket::class)
                ->findAll();}
        return $this->render("@Ticket/Ticket/rechercher.html.twig",
            array("form"=>$form->createView(),'ticket'=> $ticket));



    }


    public function pdfAction(Ticket $ticket)
    {
        $snappy = $this->get('knp_snappy.pdf');

        $html = $this->renderView('Ticket/pdf.html.twig', array(
            'ticket' => $ticket,
        ));

        $filename = 'myFirstSnappyPDF';

        return new Response(
            $snappy->getOutputFromHtml($html),
            200,
            array(
                'Content-Type'          => 'application/pdf',
                'Content-Disposition'   => 'inline; filename="'.$filename.'.pdf"'
            )
        );
    }



}
