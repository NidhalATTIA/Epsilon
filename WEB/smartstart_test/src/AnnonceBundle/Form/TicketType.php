<?php

namespace AnnonceBundle\Form;

use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\FileType;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use AnnonceBundle\Entity\Ticket;

class TicketType extends AbstractType
{
    /**
     * {@inheritdoc}
     */
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder->add('offre')->add('service')
            ->add('categorie', EntityType::class,array('class'=>'AnnonceBundle:Categoriereclamation','choice_label'=>'CategorieR','multiple'=>false))
            ->add('motifreclamation')
            ->add('image', FileType::class,array('label'=>'inserer image'))
            ->add('save',SubmitType::class);
    }/**
 * {@inheritdoc}
 */
    public function configureOptions(OptionsResolver $resolver)
    {
        $resolver->setDefaults(array(
            'data_class' => 'AnnonceBundle\Entity\Ticket'
        ));
    }

    /**
     * {@inheritdoc}
     */
    public function getBlockPrefix()
    {
        return 'annoncebundle_ticket';
    }


}
