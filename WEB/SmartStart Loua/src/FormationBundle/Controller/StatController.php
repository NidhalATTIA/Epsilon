<?php

namespace FormationBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Ob\HighchartsBundle\Highcharts\Highchart;
use FormationBundle\Entity\Formation;
class StatController extends Controller
{
    public function statAction()
    {
        /*$formation = $this->getDoctrine()->getRepository(formation::class)->findAll();
        //Pie chart
        $ob = new Highchart();
        $ob->chart->renderTo('linechart');
        $ob->title->text('Répartition des participations aux formations');
        $ob->plotOptions->pie(array(
            'allowPointSelect' => true,
            'cursor' => 'pointer',
            'dataLabels' => array('enabled' => false),
            'showInLegend' => true
        ));
        /*   $data = array(
               array('Programmation', 45.0),
               array('Developpement Web', 26.8),
               array('SoftSkills', 12.8),
               array('Mobile', 8.5),
               array('Managment', 6.2),
               array('Autres', 0.7),
           );

        for ($i = 0; $i < count($formation); ++$i) {
            $data[] = array($formation[$i]->getTitre(), $formation[$i]->getNbparticipants());

            $ob->series(array(array('type' => 'pie', 'name' => 'Browser share', 'data' => $data)));

            return $this->render('@Formation/Formation/stat.html.twig', array('chart' => $ob));


        }*/
        /*$formation = $this->getDoctrine()->getRepository(Foire::class)->findAll();
       $ob = new Highchart();
       $ob->chart->renderTo('linechart');
       $ob->title->text('Browser market shares at a specific website in 2010');
       $ob->plotOptions->pie(array(
           'allowPointSelect' => true,
           'cursor' => 'pointer',
           'dataLabels' => array('enabled' => false),
           'showInLegend' => true
       ));

       /* $data = array(
            array('Firefox', 45.0),
            array('IE', 26.8),
            array('Chrome', 12.8),
            array('Safari', 8.5),
            array('Opera', 6.2),
            array('Others', 0.7),
        );

       for ($i = 1; $i < count($formation); ++$i) {
           $data[] = array($formation[$i]->gettitreFoire(), $formation[$i]->getprixFoire());


           $ob->series(array(array('type' => 'pie', 'name' => 'Browser share', 'data' => $data)));
           return $this->render('@Cite/Foire/Stat.html.twig', array(
               'chart' => $ob
           ));
       }*/
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
        return $this->render('@Formation/Formation/stat.html.twig', array(
            'chart' => $ob));
    }



}


