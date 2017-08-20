/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psoRelated;

import ui.Resultset;

/**
 *
 * @author Lig37
 */
public class GBest extends Best {
   // private static GBest instance = null;
   
    GBest(){
    
    }
    //global best
    
    
    
    //private constructor to avoid client applications to use constructor
//    GBest(){}
//
//   public static GBest getInstance(){
//   if(instance == null){
//        instance = new GBest();
//        //initate gbest with value=1st thread/agent
//        instance.setFitness(resultSet.get(0).getFitnessValue());
//        instance.setLocation(resultSet.get(0).getLocation());
//        instance.setParticleID(resultSet.get(0).getAgentID());
//   }
//   return instance;
//   }

}
