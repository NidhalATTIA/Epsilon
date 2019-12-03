<?php

namespace AnnonceBundle\Controller;

use AnnonceBundle\Entity\Freelancer;
use AnnonceBundle\Entity\Skills;
use AnnonceBundle\Form\ProfilType;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;
use AnnonceBundle\Form\SkillsType;

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
        return $this->render('@Annonce/Skills/CreateSkills.html.twig',array('f'=> $form->createView()));
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


    public function showDetailAction(Request $request, $id){
        $em = $this->getDoctrine()->getManager();
        $Freelancer=$em->getRepository(Freelancer::class)->find($id);   //recuperer el ligne ta3 el id
        return $this->render('@Annonce/Skills/ProfilFreelancer.html.twig',array(

            'Email'=>$Freelancer->getEmail(),
            'Skills'=>$Freelancer->getSkill(),


        ));

    }

    public function AddSkillAction(Request $request )
    {

        $Freelancer= new Freelancer;
        $user = $this->container->get('security.token_storage')->getToken()->getUser();
        $user->getId();
        $form = $this->createForm(ProfilType::class, $Freelancer);
        $form = $form->handleRequest($request);
        if ($form->isValid()){
            $em = $this->getDoctrine()->getManager();
            $Freelancer->setIdF($user);
            $em->persist($Freelancer);
            $em->flush();
            return $this->redirectToRoute('FreelancerProfil');
        }
        return $this->render('@Annonce/Skills/AddSkills.html.twig',array('f'=> $form->createView()));
    }
}
