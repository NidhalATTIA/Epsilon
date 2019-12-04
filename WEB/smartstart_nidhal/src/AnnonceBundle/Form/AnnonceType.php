<?php

namespace AnnonceBundle\Form;

use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;


class AnnonceType extends AbstractType
{
    /**
     * {@inheritdoc}
     */
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder->add('Titre')->add('DESCRIPTION')->add('idcategoriea')->add('idcategoriea', EntityType::class,array('class'=>'AnnonceBundle:Categorieannonce','choice_label'=>'categoriea','multiple'=>false))->add('Skill', EntityType::class,array('class'=>'AnnonceBundle:Skills','choice_label'=>'Skill','multiple'=>false))
            ->add('save',SubmitType::class);
    }/**
 * {@inheritdoc}
 */
    public function configureOptions(OptionsResolver $resolver)
    {
        $resolver->setDefaults(array(
            'data_class' => 'AnnonceBundle\Entity\Annonce'
        ));
    }

    /**
     * {@inheritdoc}
     */
    public function getBlockPrefix()
    {
        return 'AnnonceBundle_Annonce';
    }


}
