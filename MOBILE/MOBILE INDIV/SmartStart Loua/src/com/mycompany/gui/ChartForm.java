/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.renderers.SimpleSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.PieChart;
import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.Formation;
import com.mycompany.Service.ServiceFormation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author SouhaiKr
 */
public class ChartForm {

    Form f;
        Resources theme;

    
    /**
     * Creates a renderer for the specified colors.
     */
    private DefaultRenderer buildCategoryRenderer(int[] colors) {
        DefaultRenderer renderer = new DefaultRenderer();
        renderer.setLabelsTextSize(15);
        renderer.setLegendTextSize(15);
        renderer.setMargins(new int[]{20, 30, 15, 0});
        for (int color : colors) {
            SimpleSeriesRenderer r = new SimpleSeriesRenderer();
            r.setColor(color);
            renderer.addSeriesRenderer(r);
        }
        return renderer;
    }

    /**
     * Builds a category series using the provided values.
     *
     * @param titles the series titles
     * @param values the values
     * @return the category series
     */
    
    protected CategorySeries buildCategoryDataset(String title, double[] values) {
        CategorySeries series = new CategorySeries(title);
        int k = 0;
        for (double value : values) {
            k++ ;
            if (k==1)
            {
            series.add("Formation SoftSkills", value);
            }
            else if (k==2)
            {
            series.add("Management", value);
            }
            else if (k==3)
            {
            series.add("Formation WEB", value);
            }
            else 
            {
            series.add("Programmation", value);
            }
            
        }
       
        return series;
    }

    public ChartForm() {
         theme = UIManager.initFirstTheme("/theme");
        Toolbar.setGlobalToolbar(true);

        // Generate the values
        ServiceFormation sf = new ServiceFormation();
        int i = 0;
        int j = 0;
        int l = 0;
        int m = 0;
        
        for (Formation r : sf.getlist()) {

            if (r.getIdCategorieF().getCategorief().equals("SoftSkills")) {
                i++;

            }
            else if (r.getIdCategorieF().getCategorief().equals("management")) {
                j++;

            }
            else if (r.getIdCategorieF().getCategorief().equals("Développement web")) {
                l++;

            }
       
            else {
                m++;
            }

        }
        System.out.println(i);
        System.out.println(j);
        System.out.println(m);
        System.out.println(l);
        
        double[] values = new double[]{i, j, m, l};

        // Set up the renderer
        int[] colors = new int[]{ColorUtil.BLUE, ColorUtil.GREEN, ColorUtil.MAGENTA, ColorUtil.CYAN};// ColorUtil.YELLOW,
        DefaultRenderer renderer = buildCategoryRenderer(colors);
        renderer.setZoomButtonsVisible(true);
        renderer.setZoomEnabled(true);
        renderer.setChartTitleTextSize(20);
        renderer.setDisplayValues(true);
        renderer.setShowLabels(true);
        SimpleSeriesRenderer r = renderer.getSeriesRendererAt(0);
        r.setGradientEnabled(true);
        r.setGradientStart(0, ColorUtil.BLUE);
        r.setGradientStop(0, ColorUtil.GREEN);
        r.setHighlighted(true);

        // Create the chart ... pass the values and renderer to the chart object.
        PieChart chart = new PieChart(buildCategoryDataset("Project budget", values), renderer);

        // Wrap the chart in a Component so we can add it to a form
        ChartComponent c = new ChartComponent(chart);

        // Create a form and show it.
        f = new Form("Statistiques");
        f.setLayout(new BorderLayout());
        f.addComponent(BorderLayout.CENTER, c);
        f.show();
        
        
        
        
         f.getToolbar().addCommandToLeftBar("Back", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               FormationFreelancer t = new FormationFreelancer();
                ServiceFormation sf = new ServiceFormation();
                ArrayList<Formation> list = new ArrayList();
                        sf.getlist();
            
                try {
                    t.afficher();
                } catch (IOException ex) {
                    
                }                
                t.getForm().show();

            }
        });


    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
