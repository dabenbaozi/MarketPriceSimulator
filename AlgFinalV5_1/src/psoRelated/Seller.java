/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psoRelated;

import java.util.Random;



public class Seller {
	private double fitnessValue;//how comfortble the seller is feeling with his price in the market
	private Velocity velocity;// store the Velocity in an array to accommodate multi-dimensional problem space
	public PriceLocation location;
	
        
	public Seller() {
		super();
	}

	public Seller(double fitnessValue, Velocity velocity, PriceLocation location) {
		super();
		this.fitnessValue = fitnessValue;
		this.velocity = velocity;
		this.location = location;
	}
        
        
        //x = demand, y = price, constructor to init sellers
        public Seller(double estimateRev, double LOC_Y_LOW,double LOC_Y_HIGH){
        
        }

	public Velocity getVelocity() {
		return velocity;
	}

	public void setVelocity(Velocity velocity) {
		this.velocity = velocity;
	}

	public PriceLocation getLocation() {
		return location;
	}

	public void setLocation(PriceLocation location) {
		this.location = location;
	}

	public double getFitnessValue() {
		fitnessValue = evaluate(location);
		return fitnessValue;
	}
    
    public static double evaluate(PriceLocation location) {
        double result = 0;//price, quantity, other factors
        double x = location.getLoc()[0]; // the "x" part of the location//demand
        double y = location.getLoc()[1]; // the "y" part of the location//price
        result = x * y;//looking for maximum result-profit = price*qty
//        System.out.println("location x:" + x);
//        System.out.println("location y:" + y);
//        System.out.println("location result:" + result);
        return result;
    }
        
       
        
        
}
