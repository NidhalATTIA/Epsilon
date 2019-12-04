<?php

namespace AnnonceBundle\Controller;



use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use AnnonceBundle\Entity\Historiquereclamation;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpFoundation\Request;
use AnnonceBundle\Form\HistoriquereclamationType;
use AnnonceBundle\Form\RechercheType;


class HistoriquereclamationController extends Controller
{
    public function indexAction(Request $request)
    {
        return $this->render('baseClient.html.twig');
    }

    public function index1Action(Request $request)
    {
        return $this->render('baseFreelancer.html.twig');
    }

    public function readHAction()
    {
        $historique = $this->getDoctrine()->getRepository(Historiquereclamation::class)->findAll();

        return $this->render('@Annonce/Historiquereclamation/AfficheH.html.twig', array('Historiquereclamation' => $historique));
    }

    public function deleteHAction($id)
    {
        $em = $this->getDoctrine()->getManager();
        $reclamation = $em->getRepository(Historiquereclamation::class)->find($id);
        $em->remove($reclamation);
        $em->flush();
        return $this->redirectToRoute("Ticket_AfficheH");
    }

    public function createHAction(Request $request)
    {
        $historiquereclamation = new Historiquereclamation();
        $form = $this->createForm(HistoriquereclamationType::class, $historiquereclamation);  //ta3ml form fergha
        $form = $form->handleRequest($request);
        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->persist($historiquereclamation); //rani nheb na3mml 7keya
            $em->flush(); //refrechi
            return $this->redirectToRoute('Ticket_AfficheH');
        }
        return $this->render('@Annonce/Historiquereclamation/createH.html.twig', array('f' => $form->createView()));
    }

    public function editHAction(Request $request, $id)
    {
        $em = $this->getDoctrine()->getManager();
        $historiquereclamation = $em->getRepository(Historiquereclamation::class)->find($id);
        $form = $this->createForm(HistoriquereclamationType::class, $historiquereclamation);
        $form = $form->handleRequest($request);

        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $historiquereclamation->setEtat(1);

            $em->persist($historiquereclamation);
            $em->flush();
            return $this->redirectToRoute('Ticket_AfficheH');
        }

        return $this->render('@Annonce/Historiquereclamation/editH.html.twig', array('f' => $form->createView()));
    }

    public function rechercherHAction(Request $request)
    {
        $historiquereclamation = new Historiquereclamation();
        $form = $this->createForm(RechercheType::class, $historiquereclamation);
        $form = $form->handleRequest($request);
        if ($form->isSubmitted()) {
            $ticket = $this->getDoctrine()
                ->getRepository(Historiquereclamation::class)
                ->findBy(array('offre' => $historiquereclamation
                    ->getOffre()));
        } else {
            $ticket = $this->getDoctrine()->getRepository(Historiquereclamation::class)
                ->findAll();
        }
        return $this->render("@Annonce/Historiquereclamation/rechercherH.html.twig",
            array("form" => $form->createView(), 'historiquereclamation' => $historiquereclamation));

    }


    public function editeAction(Request $request, $id)
    {
        $em = $this->getDoctrine()->getManager();
        $historiquereclamation = $em->getRepository(Historiquereclamation::class)->find($id);
        $form = $this->createForm(HistoriquereclamationType::class, $historiquereclamation);
        $form = $form->handleRequest($request);

        if ($form->isValid()) {

            $em->persist($historiquereclamation);
            $em->flush();
            return $this->redirectToRoute('Ticket_AfficheH');
        }

        return $this->render('@Annonce/Historiquereclamation/editE.html.twig', array('f' => $form->createView()));
    }


}