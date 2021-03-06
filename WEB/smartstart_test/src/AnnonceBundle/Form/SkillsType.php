<?php

namespace AnnonceBundle\Form;

use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;


class SkillsType extends AbstractType
{
    /**
     * {@inheritdoc}
     */
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder->add('skill')->
        add('idcategorie', EntityType::class,array('class'=>'AnnonceBundle:CategorieSkills','choice_label'=> 'categorie', 'multiple'=> false))
            ->add('Submit', SubmitType::class,['attr' => ['formnovalidate' => 'formnovalidate']]);
    }/**
     * {@inheritdoc}
     */
    public function configureOptions(OptionsResolver $resolver)
    {
        $resolver->setDefaults(array(
            'data_class' => 'AnnonceBundle\Entity\Skills'
        ));
    }

    /**
     * {@inheritdoc}
     */
    public function getBlockPrefix()
    {
        return 'AnnonceBundle_Skills';
    }


}
