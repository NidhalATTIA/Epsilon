<?php

namespace AnnonceBundle\Controller;

use AnnonceBundle\Entity\Note;
use AnnonceBundle\Entity\User;
use AnnonceBundle\Form\NoteType;
use AnnonceBundle\Form\RechercheType;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;

class NoteController extends Controller
{
    public function indexAction()
    {
        return $this->render('AnnonceBundle:Default:index.html.twig');
    }

    public function readAction()
    {
        $note=$this->getDoctrine()->getRepository(Note::class)->findAll();

        $user = $this->container->get('security.token_storage')->getToken()->getUser();
        if ($user->getTypeUser()=="Client")
        return $this->render('@Annonce/Default/readnoteC.html.twig',array('note'=>$note));
        else
            return $this->render('@Annonce/Default/readnote.html.twig',array('note'=>$note));
    }


    public function creatAction(Request $request)
    {
        $note = new Note();

        $form = $this->createForm(NoteType::class, $note);
        $note->setIdclient($this->getUser());

        $form = $form->handleRequest($request);
        if ($form->isValid() and $form->isSubmitted()) {
            $em = $this->getDoctrine()->getManager();
            $em->persist($note);
            $em->flush();
            return $this->redirectToRoute('read_note');
        }
        $user = $this->container->get('security.token_storage')->getToken()->getUser();
        if ($user->getTypeUser()=="Client")
            return $this->render('@Annonce/Default/createnoteC.html.twig', array('form' => $form->createView()));
        else
            return $this->render('@Annonce/Default/createnote.html.twig', array('form' => $form->createView()));


    }
    public function supprimernoteAction($id)
    {  $em=$this->getDoctrine()->getManager();
        $feed= $em->getRepository(Note::class)->find($id);
        $em->remove($feed);
        $em->flush();
        return $this->redirectToRoute("read_note");
    }

    public function rechercheAction(Request $request){
        $note = new Note();
        $form = $this->createForm(RechercheType::class,$note);
        $form->handleRequest($request);
        if($form->isSubmitted()){
            $notes = $this->getDoctrine()
                ->getRepository(Note::class)
                ->findBy(array('note'=>$note->getNote()));}

        else{
            $notes =$this ->getDoctrine()->getRepository(Note::class)->findAll();
        }

        $user = $this->container->get('security.token_storage')->getToken()->getUser();
        if ($user->getTypeUser()=="Client")
            return$this->render('@Annonce/Default/readnoteC.html.twig',array('form'=> $form->createView(),
                'note'=>$notes));
        else
            return$this->render('@Annonce/Default/readnote.html.twig',array('form'=> $form->createView(),
                'note'=>$notes));


    }



}
