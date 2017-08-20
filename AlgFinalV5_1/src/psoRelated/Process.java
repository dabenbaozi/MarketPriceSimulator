/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psoRelated;

import static java.lang.Math.abs;
import static java.lang.Thread.sleep;
import java.sql.ResultSet;
import java.util.Random;
import static psoRelated.Seller.evaluate;
import psoRunnable.Agent;
import static ui.MainJFrame.elasticity;
import ui.MyCanvas;
import ui.Resultset;
import static ui.Resultset.resultSet;

/**
 *
 * @author Lig37
 */
public class Process implements Resultset {

    //for each execute...
//    public void execute(int agentID){
//        
//        
//        step1: set self pbset as fitness value
//                2.method-get a range to set pbest; if distance < xxx, get larger one
//                        3.
//                        
//    }
    public static void execute() {
        GBest instance = new GBest();
        instance.setFitness(resultSet.get(0).getFitnessValue());
        instance.setLocation(resultSet.get(0).getLocation());
        instance.setParticleID(resultSet.get(0).getAgentID());
        //necessary constants;
        double C1 = 2.0;
        double C2 = 2.0;
        double W_UPPERBOUND = 1.0;
        double W_LOWERBOUND = 0.0;
        Random generator = new Random();
        
        
        
        
        
      
        for (int i = 0; i < resultSet.size(); i++) {

          //    while(i<resultSet.size()){
          //  try {
               // sleep(2*1000);
                                //这里可以写你自己要运行的逻辑代码
               
        
        
            Agent a = resultSet.get(i);

            //set the local best as a's own fitness value
//        a.getPbest().setParticleID(a.getAgentID());
//        a.getPbest().setFitness(evaluate(a.getLocation()));
//        a.getPbest().setLocation(a.getLocation());
            for (Agent b : resultSet) {

                //set range with in 20*20    
                double locationXDiff = abs(b.getLocation().getLoc()[0] - a.getLocation().getLoc()[0]);
                double locationYDiff = abs(b.getLocation().getLoc()[1] - a.getLocation().getLoc()[1]);
                if (locationXDiff < 30 || locationYDiff < 30) {
                    if (b.getFitnessValue() > a.getPbest().getFitness()) {
                        System.out.println("here!!");
                        a.setPbest(b.getPbest());

                        //calculate velocity:
                        /*        
                Main moving function: either lower price and increase sell qty or increase price of lose some sell on qty 
                plus other possible factors-volatile by randomized numbers
                E = {(X2-X1)/X1}/{(Y2-Y1)/Y1}
                Y2={[Y1(X2-X1)/e]/X1} +Y1
                X2={e*(Y2-Y1) *X1}/Y1+X1
                即：
                X2 = (Vy/X1)*e*X1+X1
                Y2 = Vx/(X*e*Y1)+Y1
                         */
                        double[] newVel = new double[2];
                        double[] newLoc = new double[2];
                        double currentX = a.getLocation().getLoc()[0];
                        double currentY = a.getLocation().getLoc()[1];
                        //double currentProfit = currentX * currentY;
                        System.out.println("currentx" + currentX);
                        System.out.println("currenty" + currentY);
                        int t = 0;
                        double w;
                        w = W_UPPERBOUND - (((double) t) / 100) * (W_UPPERBOUND - W_LOWERBOUND);
                        double r1 = 1 + (generator.nextDouble() * (2 - 1));


                        newVel[1] = r1 * (currentY - a.getPbest().getLocation().getLoc()[1])/60;
                        newVel[0] = elasticity * (newVel[1] / currentY);

                        //update new location:
                        Velocity vel = new Velocity(newVel);
                        a.setVelocity(vel);

                        newLoc[0] = a.getLocation().getLoc()[0] + newVel[0];
                        newLoc[1] = a.getLocation().getLoc()[1] - newVel[1];
                        PriceLocation loc = new PriceLocation(newLoc);
                        a.setLocation(loc);

                    }


                }
                //start to update gbest value:
                if (b.getPbest().getFitness() < instance.getFitness()) {
                    instance.setLocation(b.getPbest().getLocation());
                    instance.setFitness(b.getPbest().getFitness());
                    instance.setParticleID(b.getPbest().getParticleID());
                    System.out.println("Global best updated!!!!!!!!!!");
                }
                

            }
// System.out.println("一分钟运行一次");
         //   } catch (InterruptedException e) {
                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
        }
        }
       
    
}
