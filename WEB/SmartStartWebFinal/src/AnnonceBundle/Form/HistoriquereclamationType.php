<?php

namespace AnnonceBundle\Form;

use AnnonceBundle\Entity\Historiquereclamation;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Doctrine\ORM\Mapping\Entity;

use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;

class HistoriquereclamationType extends AbstractType
{
    /**
     * {@inheritdoc}
     */
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder->add('attribution')
            ->add('motifreclamation', EntityType::class,array('class'=>'AnnonceBundle:ticket','choice_label'=>'motifreclamation','multiple'=>false))
            ->add('gsm')
            ->add('datecreation')
            ->add('Traitement',SubmitType::class);

    }/**
     * {@inheritdoc}
     */
    public function configureOptions(OptionsResolver $resolver)
    {
        $resolver->setDefaults(array(
            'data_class' => 'AnnonceBundle\Entity\Historiquereclamation'
        ));
    }

    /**
     * {@inheritdoc}
     */
    public function getBlockPrefix()
    {
        return 'annoncebundle_historiquereclamation';
    }




}
