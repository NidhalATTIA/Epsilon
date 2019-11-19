<?php

namespace SmartStartBundle\Controller;

use SmartStartBundle\Entity\Skills;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;
use SmartStartBundle\Form\SkillsType;

class SkillsController extends Controller
{
    public function ShowSkillsAction($ref)
    {
        return $this->render('@SmartStart/Skills/ShowSkills.html.twig',array('r'=>$ref));
    }

    public function ReadSkillsAction(){
        $skills=$this->getDoctrine()->getRepository(Skills::class)->findAll();
        //add the list of clubs to the render function as input to base
        return $this->render('@SmartStart/Skills/ReadSkills.html.twig',array('s'=>$skills));
    }


    public function CreateSkillsAction(Request $request){
        $skills = new Skills();
        $form = $this->createForm(SkillsType::class, $skills);
        $form = $form->handleRequest($request);
        if ($form->isValid()){
            $em = $this->getDoctrine()->getManager();
            $em->persist($skills);
            $em->flush();
            return $this->redirectToRoute('SkillsRead');
        }
        return $this->render('@SmartStart/Skills/CreateSkills.html.twig',array('f'=> $form->createView()));
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

        return $this->render('@SmartStart/Skills/UpdateSkills.html.twig', array('f' => $form->createView()));
    }

}
