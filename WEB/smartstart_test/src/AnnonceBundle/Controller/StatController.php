<?php

namespace AnnonceBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Ob\HighchartsBundle\Highcharts\Highchart;
use AnnonceBundle\Entity\Formation;
class StatController extends Controller
{
    public function statAction()
    {

        $ob = new Highchart();
        $em=$this->getDoctrine()->getManager();
        $ob->chart->renderTo('piechart');
        $ob->title->text('Répartition des participations aux formations');

        $formations=$em->getRepository(Formation::class)->findAll();
        $ob->plotOptions->pie(array(
            'allowPointSelect'  => true,
            'cursor'    => 'pointer',
            'dataLabels'    => array('enabled' => false),
            'showInLegend'  => true
        ));

        $data = array();
        $stat=['Formation Tittle','nbre de participants'];
        foreach ($formations as $formation){
            $stat=array();
            array_push($stat,$formation->getTitre(),$formation->getNbparticipants());
            $stat=[$formation->getTitre(),$formation->getNbparticipants()];
            array_push($data,$stat);
        }
        $ob->getData()->setArrayToDataTable($data);
        $ob->series(array(array('type' => 'pie','name' => 'Browser share', 'data' => $data)));
        return $this->render('@Annonce/Formation/stat.html.twig', array(
            'chart' => $ob));
    }



}


