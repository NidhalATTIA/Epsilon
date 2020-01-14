<?php

namespace AnnonceBundle\Controller;



use AnnonceBundle\Entity\Categoriereclamation;
use AnnonceBundle\Form\RechercheType;
use AnnonceBundle\Form\CategoriereclamationType;
use AnnonceBundle\Entity\Ticket;
use mysql_xdevapi\CollectionRemove;
use mysql_xdevapi\TableDelete;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;


class CategoriereclamationController extends Controller
{
    public function afficherAction()
    {
        $categoriereclamations = $this->getDoctrine()->getRepository(Categoriereclamation::class)->findAll();

        return $this->render('@Annonce/Categoriereclamation/Afficher.html.twig', array('Categoriereclamation' => $categoriereclamations));
    }

    public function deleterAction($id){
        $em = $this->getDoctrine()->getManager();
        $categoriereclamation=$em->getRepository(Categoriereclamation::class)->find($id);
        $em->remove($categoriereclamation);
        $em->flush();
        return $this->redirectToRoute("categorie_gestion");
    }

    public function createrAction(Request $request){
        $categoriereclamation = new Categoriereclamation();
        $form = $this->createForm(CategoriereclamationType::class, $categoriereclamation);  //ta3ml form fergha
        $form = $form->handleRequest($request);
        if ($form->isValid()){
            $em = $this->getDoctrine()->getManager();
            $em->persist($categoriereclamation); //rani nheb na3mml 7keya
            $em->flush(); //refrechi
            return $this->redirectToRoute('categorie_gestion');
        }
        return $this->render('@Annonce/Categoriereclamation/creater.html.twig',array('f'=> $form->createView()));
    }

    public function editrAction(Request $request, $id){
        $em = $this->getDoctrine()->getManager();
        $categoriereclamation=$em->getRepository(Categoriereclamation::class)->find($id);
        $form = $this->createForm(CategoriereclamationType::class, $categoriereclamation);
        $form = $form->handleRequest($request);

        if ($form->isValid()){
            $em = $this->getDoctrine()->getManager();
            $em->persist($categoriereclamation);
            $em->flush();
            return $this->redirectToRoute('categorie_gestion');
        }

        return $this->render('@Annonce/Categoriereclamation/editr.html.twig',array('f'=> $form->createView()));
    }

    public function rechercherrAction(Request $request)
    {$categoriereclamation = new Categoriereclamation();
        $form= $this->createForm(RechercherType::class, $categoriereclamation);
        $form= $form->handleRequest($request);
        if($form->isSubmitted()) {
            $categoriereclamation = $this->getDoctrine()
                ->getRepository(Categoriereclamation::class)
                ->findBy(array('categorier'=> $categoriereclamation
                    ->getOffre()));}
        else {
            $categoriereclamation = $this->getDoctrine()->getRepository(Categoriereclamation::class)
                ->findAll();}
        return $this->render("@Annonce/Categoriereclamation/rechercherr.html.twig",
            array("form"=>$form->createView(),'categoriereclamation'=> $categoriereclamation));



    }

}
