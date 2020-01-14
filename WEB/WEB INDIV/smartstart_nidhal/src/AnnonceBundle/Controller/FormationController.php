<?php

namespace AnnonceBundle\Controller;

use AnnonceBundle\Entity\Formationcat;
use AnnonceBundle\Form\FormationcatType;
use AnnonceBundle\Form\FormationType;
use AnnonceBundle\Form\RechercheLType;
use AnnonceBundle\Entity\Formation;
use mysql_xdevapi\CollectionRemove;
use mysql_xdevapi\TableDelete;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;
use AnnonceBundle\Repository\FormationRepository;

class FormationController extends Controller
{

    public function accueilCAction(Request $request)
    {
        return $this->render('baseClient.html.twig');
    }

    public function accueilFAction(Request $request)
    {
        return $this->render('baseFreelancer.html.twig');
    }

    public function deleteLAction($id)
    {
        $em = $this->getDoctrine()->getManager();
        $formation = $em->getRepository(Formation::class)->find($id);
        $em->remove($formation);
        $em->flush();
        return $this->redirectToRoute("afficheFormationClient");
    }

    public function createAction(Request $request)
    {
        $formation = new Formation;
        $formation1 = new Formation;

        $user = $this->container->get('security.token_storage')->getToken()->getUser();
        $user->getId();

        $form = $this->createForm(FormationType::class, $formation);
        $form = $form->handleRequest($request);
        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $formation->setIdClient($user);
//$a=date('d/m/y');
//$formation1->setDate(\DateTime::createFromFormat('d/m/Y',$a));

            $date_debut = $formation->getDatedebut();
            $datefin = $formation->getDatefin();
            if ($datefin > $date_debut ) {
                $em->persist($formation);
                $em->flush();
                return $this->redirectToRoute("afficheFormationClient");
            } else {

                echo "<script>alert(\" Attention ! Verifier bien les dates\")</script>";
            }
        }
        return $this->render('@Annonce/Formation/createFormation.html.twig', array('f' => $form->createView()));
    }

    public function updateAction(Request $request, $id)
    {
        $em = $this->getDoctrine()->getManager();
        $formation = $em->getRepository(Formation::class)->find($id);
        $form = $this->createForm(FormationType::class, $formation);
        $form = $form->handleRequest($request);

        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->persist($formation);
            $em->flush();
            return $this->redirectToRoute('afficheFormationClient');
        }

        return $this->render('@Annonce/Formation/updateFormation.html.twig', array('f' => $form->createView()));
    }

    public function afficheAction(Request $request)
    {
        $user = $this->container->get('security.token_storage')->getToken()->getUser();
        $user->getId();
        $formation = new Formation();
        $form = $this->createForm(RechercheLType::class, $formation);
        $form = $form->handleRequest($request);
        if ($form->isSubmitted()) {
            $formation = $this->getDoctrine()->getRepository(Formation::class)->findBy(array('titre' => $formation->getTitre()));


            /* if ( !$formation)
             {
                 //throw $this->createNotFoundException("cette formation n'existe pas.");
                // return $this->render('@Formation/Formation/alerte.html.twig');
                // echo "<script language=\"javascript\">alert(\"cette formation n'existe pas \")</script>";
             }*/

        } else {
            //$formation = $this->getDoctrine()->getRepository(Formation::class)->findFormationById($user);
            $formation = $this->getDoctrine()->getRepository(Formation::class)->findAll();
        }
        return $this->render('@Annonce/Formation/afficheFormationClient.html.twig', array("form" => $form->createView(), 'formation' => $formation));

    }


    public function AccueilAction()
    {
        //fetching objects (clubs) from Database
        $formation = $this->getDoctrine()->getRepository(Formation::class)->findAll();
        //add the list of clubs to the render function as input to base
        return $this->render('@Annonce/Formation/afficheFormationFreelancer.html.twig', array('formation' => $formation));
    }


    public function participerAction($id, Request $request)
    {

        $formationCat = new Formationcat();
        $f1 = $this->createForm(FormationcatType::class, $formationCat);
        $f1 = $f1->handleRequest($request);

        $em = $this->getDoctrine()->getManager();
        $formation = $em->getRepository(formation::class)->find($id);
        $f = $this->createForm(FormationType::class, $formation);
        $f = $f->handleRequest($request);

        $idclient = $formation->getIdclient();
        $idcategorie = $formation->getIdcategorief();
        $titre = $formation->getTitre();
        $description = $formation->getDescription();
        $lieu = $formation->getLieu();
        $prix = $formation->getPrix();
        $nbr = $formation->getNbparticipants();
        $date_debut = $formation->getDatedebut();
        $date_fin = $formation->getDatefin();

        $formation->setIdclient($idclient);
        $formation->setIdcategorief($idcategorie);
        $formation->setTitre($titre);
        $formation->setDescription($description);
        $formation->setLieu($lieu);
        $formation->setPrix($prix);
        $user = $this->container->get('security.token_storage')->getToken()->getUser()->getId();
        $catform = $em->getRepository(formationCat::class)->findOneBy(array('idformation' => $id, 'idfreelancer' => $user));
        //$formationCat->setUser($user);

        $formationCat->setIdfreelancer($user);
        $formationCat->setIdformation($formation->getId());

        $formation->setDatedebut($date_debut);
        $formation->setDatefin($date_fin);
        $formation->setNbparticipants($nbr + 1);
        //$formation->setIdFormation($id);
        $formation->setId($id);

        //  $formation = $this->getDoctrine()->getRepository(formation::class)->findBy(array('id' => $id));
        // return $this->render('@Formation/Formation/detail1FormationEssai.html.twig', array('formation' => $formation,'catform' => $catform,'nbr'=>$nbr ));

        if ($catform == null) {
            $em = $this->getDoctrine()->getManager();
            $em->persist($formation);
            $em->persist($formationCat);
            $em->flush();
            return $this->redirectToRoute('acceptee');
        } else if ($nbr == 0) {
            echo "<script language='javascript'>";
            echo "if(!alert('no more places left')){
            window.location.load();}";
            echo "</script>";
        } else {
            echo "<script language='javascript'>";
            echo "if(!alert('tu as deja particpé')){
            window.location.load();}";
            echo "</script>";
            //  return $this->redirectToRoute('annuler');
        }
    }


    public function annulerAction($id, Request $request)
    {
        $user = $this->container->get('security.token_storage')->getToken()->getUser()->getId();
        $formationCat = $this->getDoctrine()->getRepository(formationCat::class)->findOneBy(array('idfreelancer' => $user, 'idformation' => $id));
        $em = $this->getDoctrine()->getManager();
        $formation = $em->getRepository(formation::class)->findOneBy(array('id' => $id));
        var_dump($formation);
        $f = $this->createForm(formationType::class, $formation);
        $f = $f->handleRequest($request);

        $idclient = $formation->getIdclient();
        $idcategorie = $formation->getIdcategorief();
        $titre = $formation->getTitre();
        $description = $formation->getDescription();
        $lieu = $formation->getLieu();
        $prix = $formation->getPrix();
        $nbr = $formation->getNbparticipants();
        $date_debut = $formation->getDatedebut();
        $date_fin = $formation->getDatefin();

        $formation->setIdclient($idclient);
        $formation->setIdcategorief($idcategorie);
        $formation->setTitre($titre);
        $formation->setDescription($description);
        $formation->setLieu($lieu);
        $formation->setPrix($prix);
        $formationCat->setIdfreelancer($user);
        $formationCat->setIdformation($formation->getId());

        $formation->setDatedebut($date_debut);
        $formation->setDatefin($date_fin);
        $formation->setNbparticipants($nbr - 1);

        $em = $this->getDoctrine()->getManager();
        $em->persist($formation);
        $em->remove($formationCat);
        $em->flush();
        return $this->redirectToRoute('afficheFormationFreelancer');
    }

    public function detail1Action($id)
    {
        $formation = $this->getDoctrine()->getRepository(formation::class)->findBy(array('id' => $id));
        return $this->render('@Annonce/Formation/detail1Formation.html.twig', array('formation' => $formation));
    }

    public function accepteeAction()
    {
        return $this->render('@Annonce/Formation/accepteeFormation.html.twig');
    }

 /*   public function retourAction()
    {
        $formation = $this->getDoctrine()->getRepository(Formation::class)->findAll();
        return $this->render('@Formation/Formation/afficheFormationFreelancer.html.twig', array('formation' => $formation));
    }*/

    public function listAction(Request $request)
    {
        $user=$this->container->get('security.token_storage')->getToken()->getUser()->getId();
        $formationCat=$this->getDoctrine()->getRepository(formationCat::class)->findBy(array('idfreelancer'=>$user));

        $list=array();
        for($i = 0; $i < count($formationCat); ++$i){
            $idformation=$formationCat[$i]->getIdformation();

            $formation=$this->getDoctrine()->getRepository(formation::class)->find($idformation);
            //var_dump($categorie);

            if($formation!=null){
                $list[$i]=$formation;
            }
        }
        return $this->render('@Annonce/Formation/listFormation.html.twig',array('list'=>$list));


    }

  /*  public function list2Action($id,Request $request){
        $formationCat=$this->getDoctrine()->getRepository(formationCat::class)->findBy(array('idformation'=>$id));
        $list=array();
        $userManager = $this->get('fos_user.user_manager');
        for($i = 0; $i < count($formationCat); ++$i){
            $userId=$formationCat[$i]->getIdfreelancer();
            $users = $userManager->findUserBy(array('id'=>$userId));
            $list[$i]=$users;
        }
        //var_dump($list);
        return $this->render('@Formation/Formation/listParticipant.html.twig',array('list'=>$list,'nom'=>$users));
    }*/




}