<?php

namespace AnnonceBundle\Controller;

use AnnonceBundle\Entity\Freelancer;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;
use AnnonceBundle\Form\FreelancerType;

class SkillsController extends Controller
{
    public function ShowSkillsAction($ref)
    {
        return $this->render('@Annonce/Skills/ShowSkills.html.twig',array('r'=>$ref));
    }

    public function ReadSkillsAction(){
        $skills=$this->getDoctrine()->getRepository(Skills::class)->findAll();
        //add the list of clubs to the render function as input to base
        return $this->render('@Annonce/Skills/ReadSkills.html.twig',array('s'=>$skills));
    }


    public function CreateProfilAction(Request $request){
        $Freelancer = new Freelancer();
        $form = $this->createForm(FreelancerType::class, $Freelancer);
        $form = $form->handleRequest($request);
        if ($form->isValid()){
            $em = $this->getDoctrine()->getManager();
            $em->persist($Freelancer);
            $em->flush();
            return $this->redirectToRoute('Profil');
        }
        return $this->render('@Annonce/Skills/CreateProfil.html.twig',array('f'=> $form->createView()));
    }


    public function DeleteSkillsAction($id){
        $em = $this->getDoctrine()->getManager();
        $skills=$em->getRepository(Skills::class)->find($id);
        $em->remove($skills);
        $em->flush();
        return $this->redirectToRoute("SkillsRead");
    }


    public function UpdateSkillsAction(Request $request, $id)
    {
        $em = $this->getDoctrine()->getManager();
        $skills = $em->getRepository(Skills::class)->find($id);
        $form = $this->createForm(SkillsType::class, $skills);
        $form = $form->handleRequest($request);

        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->persist($skills);
            $em->flush();
            return $this->redirectToRoute('SkillsRead');
        }

        return $this->render('@Annonce/Skills/UpdateSkills.html.twig', array('f' => $form->createView()));
    }

}
