/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;
import psoRelated.PriceLocation;
import psoRunnable.Agent;
import static ui.Resultset.resultSet;

/**
 *
 * @author Lig37
 */
public class MyCanvas extends JPanel {

//    public MyCanvas() {
//        this.repaint();//data changed and easy way to call repaint
//
//    }

   // @Override
    @Override
    public void paint(Graphics g) {
    
        Graphics2D g2d = (Graphics2D) g;
        setMaximumSize(new Dimension(1000, 1000));
        setBackground(Color.white);
        setVisible(true);
        setFocusable(false);

 for(Agent a: resultSet){
    g2d.fillOval((int)a.getRelativeX(a.getLocation()),(int)a.getRelativeY(a.getLocation()),10,10);
        System.out.println("Relative x:"+(int)a.getRelativeX(a.getLocation()));
        System.out.println("Relative y:"+(int)a.getRelativeY(a.getLocation()));
      //  repaint();
     
    }
       repaint();
        
    }
    
        //////////////////////////////////////////////////////////////////////////
       



    public void drawDot(Graphics g, ArrayList<ArrayList> iterationResultSet, int i) {
        Graphics2D g2d = (Graphics2D) g;
        ArrayList<PriceLocation> objectTrail = iterationResultSet.get(i);
        for (int j = 0; j < objectTrail.size(); j++) {
            int x = (int) objectTrail.get(0).getLoc()[0];
            int y = (int) objectTrail.get(1).getLoc()[1];
            System.out.println("x:" + x);
            System.out.println("y" + y);
            g.drawLine(x, y, x, y);

        }

    }

    
     public void drawOval(Graphics g, ArrayList<ArrayList> iterationResultSet, int i) {
      Graphics2D g2d = (Graphics2D) g;
           g2d.fillOval(1, 5, 5, 5);//draw a filled circle with r=5px;
           g2d.setColor(Color.red);
        }
    

}

//按照canvas的比例来找dot的位置

