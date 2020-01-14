<?php

// src/AppBundle/Form/RegistrationType.php

namespace SmartBundle\Form;

use Symfony\Component\Form\Extension\Core\Type\HiddenType;

use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\ChoiceType;
use Symfony\Component\Form\FormBuilderInterface;

class RegistrationType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options)
    {

        $builder->add('type_user', ChoiceType::class, [
            'choices'  => [
                'Client' => "Client",
                'freelancer' => "freelancer",


            ],])->add('Nationalite')->add('CV')->add('Description')->add('Nom_company')
            ->add('Description_company')->add('image_freelancer')->add('image_client')->
            add('etat', HiddenType::class, [
                'data' => "encours",]);



    }

    public function getParent()
    {
        return 'FOS\UserBundle\Form\Type\RegistrationFormType';
    }

    public function getBlockPrefix()
    {
        return 'app_user_registration';
    }

    // For Symfony 2.x
    public function getName()
    {
        return $this->getBlockPrefix();
    }
}