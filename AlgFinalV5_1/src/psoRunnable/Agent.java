/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psoRunnable;



import java.util.Random;
import psoRelated.PBest;
import psoRelated.PriceLocation;
import static psoRelated.Process.execute;
import psoRelated.Seller;
import psoRelated.Velocity;
import ui.Resultset;

/**
 *
 * @author Lig37
 */
public class Agent extends Seller implements Runnable,Resultset{
    private static int count = 0;
    int agentID;
    double relativeX;//relative position on canvas
    double relativeY;
    private String name = "";
    private PBest pbest;

    public PBest getPbest() {
        return pbest;
    }

    public void setPbest(PBest pbest) {
        this.pbest = pbest;
    }
    

    public double getRelativeX(PriceLocation location) {
        return relativeX = (int)location.getLoc()[0]*10;
    }


    public double getRelativeY(PriceLocation location) {
        return relativeY = (int)location.getLoc()[1]*10;
    }

    public int getAgentID() {
        return agentID;
    }

    public void setAgentID(int agentID) {
        this.agentID = agentID;
    }


    public Agent(double estimateRev, double LOC_Y_LOW,double LOC_Y_HIGH){
        this.agentID = count;
        Random generator = new Random();

        // randomize location inside a space defined in Problem Set
        //the greater price should end with less sale in qty in general, 
        //but might flustrate a little due to other factors
			double[] loc = new double[2];
                        double vibrateR = 0.8 + generator.nextDouble() * (1 - 0.8);
			loc[1] = LOC_Y_LOW + generator.nextDouble() * (LOC_Y_HIGH - LOC_Y_LOW);
                        loc[0] = vibrateR * estimateRev/loc[1];
			
        PriceLocation location = new PriceLocation(loc);
			// randomize velocity in the range defined in Problem Set
			double[] vel = new double[2];
                        vel[0] = 1 + generator.nextDouble() * (3 - 1);
			vel[1] = 2 + generator.nextDouble() * (1 - 2);
			Velocity v = new Velocity(vel);
                        this.setLocation(location);
			this.setVelocity(v);
                        
        PBest pbest = new PBest();
        pbest.setLocation(location);
        pbest.setFitness(evaluate(location));
        pbest.setParticleID(agentID);
        this.setPbest(pbest);
        count++;
        }
    
    
    @Override
    public void run() {

         
          execute();
 
      
    }
    
  

}
