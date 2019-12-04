<?php

namespace AnnonceBundle\Controller;

use AnnonceBundle\Entity\User;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Form\Extension\Core\Type\TextareaType;
use Symfony\Component\HttpFoundation\Request;

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
        $em=$this->getDoctrine()->getManager();

        $ticket=$em->getRepository(User::class)->find(1);

        $form = $this->createFormBuilder()
            ->add('message', TextareaType::class)
            ->add('email', TextareaType::class)
            ->add('send', SubmitType::class)
            ->getForm();
        $form->handleRequest($request);
        $message = $form["message"]->getData();

        if ($form->isSubmitted() && $form->isValid()) {
            if ($request->isMethod('POST'))
               $email =$form["email"]->getData();
                    $message = $form["message"]->getData();
                $message = \Swift_Message::newInstance()
                    ->setSubject('Response from admin Smart Start')
                    ->setFrom('attianidhal@gmail.com')
                    ->setTo($email)
                    ->setCharset('utf-8')
                    ->setContentType('text/html')
                    ->setBody($message);
                $this->get('mailer')->send($message);

                //return $this->render('@Annonce/Default/ContactUs.html.twig', array('f' => $form->createView()));


            }
            return $this->render('@Annonce/API/MailAdmin.html.twig',array('f' => $form->createView()));

        }

    public function SendEmailAction(Request $request)
    {
        $em=$this->getDoctrine()->getManager();

        $ticket=$em->getRepository(User::class)->find(1);

        $form = $this->createFormBuilder()
            ->add('message', TextareaType::class)
            ->add('send', SubmitType::class)
            ->getForm();
        $form->handleRequest($request);
        $message = $form["message"]->getData();

        if ($form->isSubmitted() && $form->isValid()) {
            if ($request->isMethod('POST'))
                $email =$this->getUser()->getEmail();
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
        return $this->render('@Annonce/API/ContactUs.html.twig',array('f' => $form->createView()));

    }

    }
