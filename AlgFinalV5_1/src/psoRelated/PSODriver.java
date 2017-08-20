/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psoRelated;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import psoRunnable.Agent;
import psoRunnable.Swarm;
import ui.MyCanvas;
import static ui.Resultset.resultSet;


/**
 *
 * @author Lig37
 */



// this is a driver class to execute the PSO process
//PSO final project B- demo

public class PSODriver {
	public static void main(String args[]) {
       
                JFrame frame = new JFrame();
                MyCanvas myCanvas = new MyCanvas();
                frame.setVisible(true);
                frame.setSize(1024,1024);
                frame.add(myCanvas);//修改
                //int SWARM_SIZE,double estimateRev, double LOC_Y_LOW,double LOC_Y_HIGH
                Swarm swarm = new Swarm(50,1000,10,100);
              
                               
                //give value to resultSet so other classes could know value
                for(int i = 0; i<swarm.getMyRunnable().size();i++){
                resultSet.add(swarm.getMyRunnable().get(i));
                }
                //init thread
                for(int x = 0; x <swarm.getMyRunnable().size();x++){
                    Agent a = swarm.getMyRunnable().get(x);
                    a.run();
                    
                    System.out.println("thread start" + a.getAgentID());
                }
                    
//                }
        }
}
                
                
                
                
