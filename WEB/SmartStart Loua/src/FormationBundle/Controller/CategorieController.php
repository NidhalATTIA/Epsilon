<?php

namespace FormationBundle\Controller;

use FormationBundle\Entity\Categorieformation;
use FormationBundle\Form\RechercheCType;
use FormationBundle\Form\CategorieformationType;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;

class CategorieController extends Controller
{

    public function afficheCAction(Request $request) {
        $catF = new Categorieformation();
        $form=$this->createForm(RechercheCType::class,$catF);
        $form =$form->handleRequest($request);
        if($form->isSubmitted()){
            $catF = $this->getDoctrine()->getRepository(Categorieformation::class)->findBy(array('categorief'=>$catF->getCategorief()));}
        else{
            $catF = $this->getDoctrine()->getRepository(Categorieformation::class)->findAll();}
        return $this->render('@Formation/CategorieFormation/afficheAdmin.html.twig',array("form"=>$form->createView(),'categorie'=>$catF));

    }

    public function createCAction(Request $request){
        $catF = new Categorieformation;
        $form = $this->createForm(CategorieformationType::class, $catF);
        $form = $form->handleRequest($request);
        if ($form->isValid()){
            $em = $this->getDoctrine()->getManager();
            $em->persist($catF);
            $em->flush(); //refrechi
            return $this->redirectToRoute('afficheC');
        }
        return $this->render('@Formation/CategorieFormation/createC.html.twig',array('f'=> $form->createView()));
    }

    public function deleteCAction($id){
        $em = $this->getDoctrine()->getManager();
        $catF=$em->getRepository(Categorieformation::class)->find($id);
        $em->remove($catF);
        $em->flush();
        return $this->redirectToRoute("afficheC");
    }


    public function updateCAction(Request $request, $id){
        $em = $this->getDoctrine()->getManager();
        $catF=$em->getRepository(Categorieformation::class)->find($id);
        $form = $this->createForm(CategorieformationType::class, $catF);
        $form = $form->handleRequest($request);

        if ($form->isValid()){
            $em = $this->getDoctrine()->getManager();
            $em->persist($catF);
            $em->flush();
            return $this->redirectToRoute('afficheC');
        }

        return $this->render('@Formation/CategorieFormation/updateC.html.twig',array('f'=> $form->createView()));
    }




}
