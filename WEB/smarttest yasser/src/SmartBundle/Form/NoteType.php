<?php

namespace SmartBundle\Form;

use blackknight467\StarRatingBundle\Form\RatingType;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\ChoiceType;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;

class NoteType extends AbstractType
{
    /**
     * {@inheritdoc}
     */
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder->add('note', ChoiceType::class, [
            'choices'  => [
                '0' => "0",
                '1' => "1",
                '2' => "2",
                '3' => "3",
                '4' => "4",
                '5' => "5",
                ],])
        ->add('idfreelancer')->
        add('Ajouter',SubmitType::class ,
            ['attr'=>['formnovalidate'=>'formnovalidate']]);



    }/**
     * {@inheritdoc}
     */
    public function configureOptions(OptionsResolver $resolver)
    {
        $resolver->setDefaults(array(
            'data_class' => 'SmartBundle\Entity\Note'
        ));
    }

    /**
     * {@inheritdoc}
     */
    public function getBlockPrefix()
    {
        return 'smartbundle_note';
    }


}
