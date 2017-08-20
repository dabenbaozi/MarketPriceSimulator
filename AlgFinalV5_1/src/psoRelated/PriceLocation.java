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


public class PriceLocation {
	// position
	private double[] loc;
         public static boolean stop = true;
	public PriceLocation(double[] loc) {
		super();
		this.loc = loc;
	}

    public PriceLocation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	public double[] getLoc() {
		return loc;
	}

	public void setLoc(double[] loc) {
		this.loc = loc;
	}
	
        
        @Override
        public String toString(){
            String a  = String.valueOf(loc[0]);
        return a;
        }
}


