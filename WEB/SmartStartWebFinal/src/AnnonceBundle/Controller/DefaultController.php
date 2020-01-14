<?php

namespace AnnonceBundle\Controller;

use AnnonceBundle\Entity\CategorieSkills;
use AnnonceBundle\Entity\Freelancer;
use AnnonceBundle\Entity\Freelancerskills;
use AnnonceBundle\Entity\Skills;
use AnnonceBundle\Entity\SujetForum;
use AnnonceBundle\Entity\User;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Form\Extension\Core\Type\TextareaType;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Serializer\Normalizer\ObjectNormalizer;
use Symfony\Component\Serializer\Serializer;

class DefaultController extends Controller
{
    public function indexAction()
    {
        return $this->render('base.html.twig');
    }

    public function ContactUsAction()
    {
        return $this->render('@Annonce/Default/ContactUs.html.twig');
    }

    public function AccueilAdminAction()
    {
        return $this->render('@Annonce/Default/AccueilAdmin.html.twig');
    }

    public function AccueilClientAction()
    {
        return $this->render('@Annonce/Default/AccueilClient.html.twig');
    }

    public function AccueilFreelancerAction()
    {
        return $this->render('@Annonce/Default/AccueilFreelancer.html.twig');
    }

    public function ProfilAdminAction()
    {
        return $this->render('@Annonce/Default/ProfilAdmin.html.twig');
    }

    public function ProfilClientAction()
    {
        return $this->render('@Annonce/Default/ProfilClient.html.twig');
    }

    public function ProfilFreelancerAction()
    {
        return $this->render('@Annonce/Default/ProfilFreelancer.html.twig');
    }

    public function SendEmail1Action(Request $request)
    {
        $em = $this->getDoctrine()->getManager();

        $ticket = $em->getRepository(User::class)->find(1);

        $form = $this->createFormBuilder()
            ->add('message', TextareaType::class)
            ->add('email', TextareaType::class)
            ->add('send', SubmitType::class)
            ->getForm();
        $form->handleRequest($request);
        $message = $form["message"]->getData();

        if ($form->isSubmitted() && $form->isValid()) {
            if ($request->isMethod('POST'))
                $email = $form["email"]->getData();
            $message = $form["message"]->getData();
            $message = \Swift_Message::newInstance()
                ->setSubject('Response from admin Smart Start')
                ->setFrom('nidhal.attia@esprit.tn')
                ->setTo($email)
                ->setCharset('utf-8')
                ->setContentType('text/html')
                ->setBody($message);
            $this->get('mailer')->send($message);

            //return $this->render('@Annonce/Default/ContactUs.html.twig', array('f' => $form->createView()));


        }
        return $this->render('@Annonce/API/MailAdmin.html.twig', array('f' => $form->createView()));

    }

    public function SendEmailAction(Request $request)
    {
        $em = $this->getDoctrine()->getManager();

        $ticket = $em->getRepository(User::class)->find(1);

        $form = $this->createFormBuilder()
            ->add('message', TextareaType::class)
            ->add('send', SubmitType::class)
            ->getForm();
        $form->handleRequest($request);
        $message = $form["message"]->getData();

        if ($form->isSubmitted() && $form->isValid()) {
            if ($request->isMethod('POST'))
                $email = $this->getUser()->getEmail();
            $message = $form["message"]->getData();
            $message = \Swift_Message::newInstance()
                ->setSubject('Contact Us')
                ->setFrom($email)
                ->setTo('attianidhal@gmail.com')
                ->setCharset('utf-8')
                ->setContentType('text/html')
                ->setBody($message);
            $this->get('mailer')->send($message);

        }
        return $this->render('@Annonce/API/ContactUs.html.twig', array('f' => $form->createView()));

    }

    ####################################### MOBILE NIDHAL #######################################

    public function JsonAuthAction(Request $req)  // AUTHENTIFICATION
    {
        //fetching objects (clubs) from Database
        $serializer = new Serializer([new ObjectNormalizer()]);
        $username = $req->get('username');
        $password = $req->get('password');

        $em = $this->getDoctrine()->getManager();
        $RAW_QUERY = 'SELECT * FROM User Where User.email =:status AND User.prenom =:pass ;';
        $statement = $em->getConnection()->prepare($RAW_QUERY);
        $statement ->bindvalue('status',$username);
        $statement ->bindvalue('pass',$password);
        $statement->execute();
        $Forums = $statement->fetchAll();
        if($Forums != null){
            $formatted = $serializer->normalize("success");
        }
        else {
            $formatted = $serializer->normalize("incorrect");
        }

        //add the list of clubs to the render function as input to base

        return new JsonResponse($formatted);

    }

    public function JsonProfileFAction($id) // AFFICHAGE PROFIL
    {
        //fetching objects (clubs) from Database

        $Forums = $this->getDoctrine()->getRepository(User::class)->find($id);

        $serializer = new Serializer([new ObjectNormalizer()]);
        $formatted = $serializer->normalize($Forums);
        //add the list of clubs to the render function as input to base

        return new JsonResponse($formatted);
    }

    public function JsonModifyProfileAction(Request $req, $id) // MODIFIER PROFILE
    {
        //fetching objects (clubs) from Database
        $em = $this->getDoctrine()->getManager();
        $user = $this->getDoctrine()->getRepository(User::class)->find($id);
        $serializer = new Serializer([new ObjectNormalizer()]);
        if ($user != null) {

            $formatted = $serializer->normalize($user);

            if ($req->get("username") != null) {
                $user->setUsername($req->get("username"));
            }

            if ($req->get("lastname") != null) {
                $user->setNom($req->get("lastname"));
            }

            if ($req->get("name") != null) {
                $user->setPrenom($req->get("name"));
            }

            if ($req->get("email") != null) {
                $user->setEmail($req->get("email"));
            }

            $em->persist($user);
            $em->flush();
        } else {
            $formatted = $serializer->normalize("NO results ya bro");
        }
        //add the list of clubs to the render function as input to base

        return new JsonResponse($formatted);

    }

    public function JsonSkillsAfficheAction() //AFFICHAGE SKILLS
    {
        //fetching objects (clubs) from Database AFFICHAGE SKILLS

        $Forums = $this->getDoctrine()->getRepository(Skills::class)->findAll();
        $Frees = array();

        $serializer = new Serializer([new ObjectNormalizer()]);
        $formatted = $serializer->normalize($Forums);

        //add the list of clubs to the render function as input to base

        return new JsonResponse($formatted);

    }

    public function JsonAddSkillAction(Request $req) //ADD SKILL
    {
        //fetching objects (clubs) from Database
        $em = $this->getDoctrine()->getManager();
        $user = $this->getDoctrine()->getRepository(User::class)->find($req->get('user'));
        $categorie = $this->getDoctrine()->getRepository(CategorieSkills::class)->find($req->get('categorie'));
        $skills = $this->getDoctrine()->getRepository(Skills::class)->find($req->get('skills'));
        $Sujet = new Freelancerskills();
        $Sujet->setIdCategorie($categorie);
        $Sujet->setSkills($skills);
        $Sujet->setIdfreelancer($user);

        if ($Sujet->getIdCategorie() != null && $Sujet->getSkills() != null) {

            $em->persist($Sujet);
            $em->flush();

            $serializer = new Serializer([new ObjectNormalizer()]);
            $formatted = $serializer->normalize($Sujet);

            return new JsonResponse($formatted);
        } else {
            return new JsonResponse(" Something went wrong");
        }


        //add the list of clubs to the render function as input to base

    }

    public function JsonDeleteSkillAction($id) //DELETE SKILLS
    {
        //fetching objects (clubs) from Database
        $em = $this->getDoctrine()->getManager();
        $skills = $this->getDoctrine()->getRepository(Freelancerskills::class)->find($id);
        $serializer = new Serializer([new ObjectNormalizer()]);
        if ($skills != null) {

            $em->remove($skills);
            $em->flush();

            $formatted = $serializer->normalize("deleted");
        } else {
            $formatted = $serializer->normalize("NO results ya bro");
        }
        //add the list of clubs to the render function as input to base

        return new JsonResponse($formatted);

    }

    ########################## Mobile Baazoug ################################

}