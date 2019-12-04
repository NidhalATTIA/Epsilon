<?php

namespace AnnonceBundle\Controller;

use AnnonceBundle\Entity\Feedbackc;
use AnnonceBundle\Entity\User;
use AnnonceBundle\Form\FeedbackcType;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;

class FeedbackController extends Controller
{
    public function indexAction()
    {
        return $this->render('@Annonce/Default/index.html.twig');
    }
    public function readAction(Request $request)
    {

        $feedbacks=$this->getDoctrine()->getRepository(Feedbackc::class)->findAll();

        $paginator = $this->get('knp_paginator');
        $pagination = $paginator->paginate(
            $feedbacks, /* query NOT result */
            $request->query->getInt('page', 1),3/*page number*/
             /*limit per page*/
        );
        $user = $this->container->get('security.token_storage')->getToken()->getUser();
        if ($user->getTypeUser()=="Client")
        return $this->render('@Annonce/Default/readC.html.twig',array('Feed'=>$pagination));
        else
        return $this->render('@Annonce/Default/read.html.twig',array('Feed'=>$pagination));
    }

    public function createAction(Request $request)

        { $Feed = new Feedbackc();

            $form = $this-> createForm(FeedbackcType::class,$Feed);
          $Feed->setIdClient($this->getUser());

            $form = $form -> handleRequest($request);
            if($form->isValid() and $form -> isSubmitted()){
                $em = $this->getDoctrine()->getManager();
                $em->persist($Feed);
                $em->flush();
                return $this ->redirectToRoute('smart_showfeed');}

            $user = $this->container->get('security.token_storage')->getToken()->getUser();
            if ($user->getTypeUser()=="Client")
                return $this->render('@Annonce/Default/createC.html.twig', array('f' => $form->createView()));
            else
                return $this->render('@Annonce/Default/create.html.twig', array('f' => $form->createView()));

        }

    public function supprimerAction($id)
    {  $em=$this->getDoctrine()->getManager();
        $feed= $em->getRepository(Feedbackc::class)->find($id);
        $em->remove($feed);
        $em->flush();

        return $this->redirectToRoute("smart_showfeed");
    }

    public function updateAction(Request $request,$id)
    {
        $em = $this->getDoctrine()->getManager();
        $feed = $em->getRepository(Feedbackc::class)->find($id);
        $form = $this->createForm(FeedbackcType::class, $feed);
        $from = $form->handleRequest($request);
        if ($form->isValid()) {
            $em->persist($feed);
            $em->flush();
            return $this->redirectToRoute('smart_showfeed');
        }

        $user = $this->container->get('security.token_storage')->getToken()->getUser();
        if ($user->getTypeUser()=="Client")
            return $this->render('@Annonce/Default/createC.html.twig', array('f' => $form->createView()));
        else
            return $this->render('@Annonce/Default/create.html.twig', array('f' => $form->createView()));

    }




}
