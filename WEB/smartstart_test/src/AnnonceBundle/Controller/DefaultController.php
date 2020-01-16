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
use Symfony\Component\Serializer\Encoder\JsonEncoder;
use Symfony\Component\Serializer\Encoder\XmlEncoder;
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

    public function JsonLoginAction($username,$password)
    {
        $user_manager = $this->get('fos_user.user_manager');
        $factory = $this->get('security.encoder_factory');
        $user = $user_manager->findUserByUsername($username);
        $encoders = array(new XmlEncoder(), new JsonEncoder());

        $normalizer = new ObjectNormalizer();
        $normalizer->setCircularReferenceLimit(2);
// Add Circular reference handler
        $normalizer->setCircularReferenceHandler(function ($object) {
            return $object;
        });
        $normalizers = array($normalizer);
        $encoder = $factory->getEncoder($user);
        $users = $this->getDoctrine()->getRepository(User::class)->findBy(array('username'=>$username));
        $bool = ($encoder->isPasswordValid($user->getPassword(),$password,$user->getUsername())) ? "true" : "false";
        if($bool == "true" )
        {
            $serializer = new Serializer($normalizers, $encoders);
            $formatted = $serializer->normalize($users);
            return new JsonResponse($formatted);
        }
        else
        {
            $serializer = new Serializer([new ObjectNormalizer()]);
            $formatted = $serializer->normalize(false);
            return new JsonResponse($formatted);
        }
    }

    public function JsonProfileFAction($id) // AFFICHAGE PROFIL
    {
        //fetching objects (clubs) from Database
        $arr = array();
        $Forums = $this->getDoctrine()->getRepository(User::class)->find($id);
        array_push($arr,$Forums);
        $serializer = new Serializer([new ObjectNormalizer()]);
        $formatted = $serializer->normalize($arr);
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

    public function JsonSkillsAfficheAction($id) //AFFICHAGE SKILLS
    {
        //fetching objects (clubs) from Database AFFICHAGE SKILLS

        $user = $this->getDoctrine()->getRepository(Freelancerskills::class)->findBy(array('idfreelancer'=>$id));
        $serializer = new Serializer([new ObjectNormalizer()]);
        $formatted = $serializer->normalize($user);
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