<?php

namespace AnnonceBundle\Controller;

use AnnonceBundle\Entity\Annonce;
use AnnonceBundle\Entity\Postulation;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use mysql_xdevapi\CollectionRemove;
use mysql_xdevapi\TableDelete;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpFoundation\Request;
use AnnonceBundle\Form\AnnonceType;
use AnnonceBundle\Form\PostulationType;
use Symfony\Component\Security\Core\User\UserInterface;
use AnnonceBundle\Repository\AnnonceRepository;




class AnnonceController extends Controller
{


    public function showFormationAction($ref)
    {
        return $this->render('@Annonce/Annonce/show.html.twig',array('r'=>$ref));
    }

    public function read1Action(){

        $user = $this->container->get('security.token_storage')->getToken()->getUser();
        $user->getId();
        $Annonce=$this->getDoctrine()->getRepository(Annonce::class)->findAnnonceById($user);

        return $this->render('@Annonce/Annonce/list.html.twig',array('Annonce'=>$Annonce));
    }

    public function read2Action(){
        //fetching objects (clubs) from Database
        $Annonce=$this->getDoctrine()->getRepository(Annonce::class)->AffichePostule();
        //add the list of clubs to the render function as input to base
        return $this->render('@Annonce/Annonce/project.html.twig',array('Annonce'=>$Annonce));
    }

    public function deleteAction($id){
        $em = $this->getDoctrine()->getManager();
        $Annonce=$em->getRepository(Annonce::class)->find($id);
        $em->remove($Annonce);
        $em->flush();
        return $this->redirectToRoute("Annonce_read1");
    }

    //ajout dynamique
    /*public function createAction(Request $request){
        $Annonce= new Annonce;
        $form = $this->createForm(AnnonceType::class, $Annonce);  //ta3ml form fergha
        $form = $form->handleRequest($request);
        if ($form->isValid()){
            $em = $this->getDoctrine()->getManager();
            $em->persist($Annonce);
            $em->flush();
            return $this->redirectToRoute('Annonce_read1');
        }
        return $this->render('@Annonce/Annonce/create.html.twig',array('f'=> $form->createView()));
    }*/


    //modif dynamique
    //cas 1 avec form
    public function updateAction(Request $request, $id){
        $em = $this->getDoctrine()->getManager();
        $Annonce=$em->getRepository(Annonce::class)->find($id);   //recuperer el ligne ta3 el id
        $form = $this->createForm(AnnonceType::class, $Annonce);  //taffichi el ligne ta3 el id
        $form = $form->handleRequest($request);

        if ($form->isValid()){
            $em = $this->getDoctrine()->getManager();
            $em->persist($Annonce);
            $em->flush();
            return $this->redirectToRoute('Annonce_read1');
        }

        return $this->render('@Annonce/Annonce/update.html.twig',array('f'=> $form->createView()));

    }

   /*public function showDetailAction(Request $request, $id){
        $em = $this->getDoctrine()->getManager();
        $Annonce=$em->getRepository(Annonce::class)->find($id);   //recuperer el ligne ta3 el id
        return $this->render('@Annonce/Annonce/Addp.html.twig',array(

            'Titre'=>$Annonce->getTitre(),
            'idCategorieA'=>$Annonce->getIdcategoriea(),
            'DESCRIPTION'=>$Annonce->getDescription(),
            'id_client'=>$Annonce->getIdClient(),
            'Skill'=>$Annonce->getSkill(),
            'dateAjout '=>$Annonce->getDateajout(),
        ));

    }*/
    public function create4Action(Request $request, $idannonce){
        $Postulation= new Postulation;
        $user = $this->container->get('security.token_storage')->getToken()->getUser();
        $annonce = $this->getDoctrine()->getRepository(Annonce::class)->find(intval($idannonce));
        $user->getId();

            $em = $this->getDoctrine()->getManager();
            $Postulation->setIdfreelancer($user);
            $Postulation->setIdannonce($annonce);
            $Postulation->setContenu($request->request->get('comment'));
            $em->persist($Postulation);
            $em->flush();
        return $this->redirectToRoute('Annonce_read3');
        return $this->render('@Annonce/Annonce/Addp.html.twig',array('id'=>$idannonce));
        }



    public function read3Action(){
        $user = $this->container->get('security.token_storage')->getToken()->getUser();
        $user->getId();
        $Postulation=$this->getDoctrine()->getRepository(Postulation::class)->findPostuleById($user);
        return $this->render('@Annonce/Annonce/postule.html.twig',array('Postulation'=>$Postulation));
    }

    public function delete2Action($id){
        $em = $this->getDoctrine()->getManager();
        $Postulation=$em->getRepository(Postulation::class)->find($id);
        $em->remove($Postulation);
        $em->flush();
        return $this->redirectToRoute("Annonce_read3");
    }


    public function update2Action(Request $request, $id){
        $em = $this->getDoctrine()->getManager();
        $Postulation=$em->getRepository(Postulation::class)->find($id);   //recuperer el ligne ta3 el id
        $form = $this->createForm(PostulationType::class, $Postulation);  //taffichi el ligne ta3 el id
        $form = $form->handleRequest($request);

        if ($form->isValid()){
            $em = $this->getDoctrine()->getManager();
            $em->persist($Postulation);
            $em->flush();
            return $this->redirectToRoute('Annonce_read3');
        }

        return $this->render('@Annonce/Annonce/upostule.html.twig',array('f'=> $form->createView()));

    }

    public function createAction(Request $request, UserInterface $user )
    {

        $Annonce= new Annonce;
        $user = $this->container->get('security.token_storage')->getToken()->getUser();
        $user->getId();
        $form = $this->createForm(AnnonceType::class, $Annonce);
        $form = $form->handleRequest($request);
        if ($form->isValid()){
            $em = $this->getDoctrine()->getManager();
            $Annonce->setEtat(0);
            $Annonce->setIdClient($user);
            $em->persist($Annonce);
            $em->flush();
            return $this->redirectToRoute('Annonce_read1');
        }
        return $this->render('@Annonce/Annonce/create.html.twig',array('f'=> $form->createView()));

    }

    public function showDetailAction(Request $request, $id){
    $Annonce = $this->getDoctrine()->getRepository(Annonce::class)->findBy(array('id' => $id));
    return $this->render('@Annonce/Annonce/Addp.html.twig', array('Annonce' => $Annonce));

   }
    public function showPostuleAction(Request $request, $id){
        $Annonce = $this->getDoctrine()->getRepository(Postulation::class)->findpostulationById($id);
        return $this->render('@Annonce/Annonce/Postulation.html.twig', array('Annonce' => $Annonce));

    }
        public function postuleokAction(Request $request, $id){
        $em = $this->getDoctrine()->getManager();
        $Annonce=$this->getDoctrine()->getRepository(Annonce::class)->find(intval($id));
        $nbr=$Annonce->getEtat();
        $Annonce->setEtat($nbr+1);
        $em->persist($Annonce);
        $em->flush();
        return $this->redirectToRoute('Annonce_read1');
        return $this->render('@Annonce/Annonce/Postualtion.html.twig',array('id'=>$id));

    }

    public function historiqueAction(Request $request, $id){
        $em = $this->getDoctrine()->getManager();
        $Annonce=$this->getDoctrine()->getRepository(Annonce::class)->find(intval($id));
        $nbr=$Annonce->getEtat();
        $Annonce->setEtat($nbr+1);
        $em->persist($Annonce);
        $em->flush();
        return $this->redirectToRoute('Annonce_read3');
        return $this->render('@Annonce/Annonce/Postualtion.html.twig',array('id'=>$id));

    }

    public function affhistoriqueAction(Request $request){
        $user = $this->container->get('security.token_storage')->getToken()->getUser();
        $user->getId();
        $Annonce=$this->getDoctrine()->getRepository(Annonce::class)->AfficheAnnoncehistorique($user);
        //add the list of clubs to the render function as input to base
        return $this->render('@Annonce/Annonce/historiqueAnnonce.html.twig',array('Annonce'=>$Annonce));
    }

    }