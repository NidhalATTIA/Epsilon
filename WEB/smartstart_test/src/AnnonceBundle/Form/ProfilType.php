<?php

namespace AnnonceBundle\Form;

use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;


class ProfilType extends AbstractType
{
    /**
     * {@inheritdoc}
     */
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder->add('Description')->
        add('Skill', EntityType::class,array('class'=>'AnnonceBundle:CategorieSkills','choice_label'=> 'categorie', 'multiple'=> false))->
        add('Skill', EntityType::class,array('class'=>'AnnonceBundle:Skills','choice_label'=> 'Skill', 'multiple'=> false))
            ->add('save', SubmitType::class,['attr' => ['formnovalidate' => 'formnovalidate']]);
    }


    /**
     * {@inheritdoc}
     */
    public function configureOptions(OptionsResolver $resolver)
    {
        $resolver->setDefaults(array(
            'data_class' => 'AnnonceBundle\Entity\Freelancer'
        ));
    }

    /**
     * {@inheritdoc}
     */
    public function getBlockPrefix()
    {
        return 'AnnonceBundle_Freelancer';
    }


}
