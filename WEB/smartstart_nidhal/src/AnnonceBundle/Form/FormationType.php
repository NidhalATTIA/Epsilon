<?php

namespace AnnonceBundle\Form;

use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;

class FormationType extends AbstractType
{
    /**
     * {@inheritdoc}
     */
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder->add('titre')
            ->add('idCategorieF',EntityType::class,array('class'=>'AnnonceBundle:CategorieFormation','choice_label'=>'categorieF','multiple'=>false))
            ->add('description')->add('lieu')->add('prix')->add('nbparticipants')->add('datedebut')->add('datefin')
            ->add('idClient',EntityType::class,array('class'=>'AnnonceBundle:Client','choice_label'=>'Nom_company','multiple'=>false))
            ->add('save',SubmitType::class);
    }/**
     * {@inheritdoc}
     */
    public function configureOptions(OptionsResolver $resolver)
    {
        $resolver->setDefaults(array(
            'data_class' => 'AnnonceBundle\Entity\Formation'
        ));
    }

    /**
     * {@inheritdoc}
     */
    public function getBlockPrefix()
    {
        return 'annoncebundle_formation';
    }


}
