/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psoRelated;

/**
 *
 * @author Lig37
 */
public class Best {
    PriceLocation location;
    int particleID;
    double fitness;

    public PriceLocation getLocation() {
        return location;
    }

    public void setLocation(PriceLocation location) {
        this.location = location;
    }

   

    public int getParticleID() {
        return particleID;
    }

    public void setParticleID(int particleID) {
        this.particleID = particleID;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }
    
    
}
