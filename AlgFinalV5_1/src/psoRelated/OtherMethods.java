/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psoRelated;

import java.util.ArrayList;

/**
 *
 * @author Lig37
 */
public class OtherMethods {

    public static int getMaxPos(double[] list) {
        int pos = 0;
        double maxValue = list[0];

        for (int i = 0; i < list.length; i++) {
            if (list[i] > maxValue) {
                pos = i;
                maxValue = list[i];
            }
        }

        return pos;
    }

    public static double ERR_TOLERANCE = 1E-20;
// the smaller the tolerance, the more accurate compares to the markte price,  but the number of iteration will increases

    public static double getMaxValue(PriceLocation pc) {
        double maxValue = pc.getLoc()[0];
        if (pc.getLoc()[1] > pc.getLoc()[0]) {
            maxValue = pc.getLoc()[1];
        }
        return maxValue;
    }

    //method to find 2nd layer highest     
    public static double getMaxValueInO(ArrayList<PriceLocation> objectTrail) {
        double maxValueInO;
        double[] tempResult = new double[objectTrail.size()];
        int i = 0;
        for (PriceLocation pc : objectTrail) {
            double result = getMaxValue(pc);
            tempResult[i] = result;
            i++;
        }
        maxValueInO = tempResult[0];
        for (int j = 0; j < tempResult.length-1; j++) {
            if (tempResult[j] > maxValueInO) {
                maxValueInO = tempResult[j];
            }
        }
        return maxValueInO;
    }

    public static double getMaxValueInResultSet(ArrayList<ArrayList> iterationResultSet) {
        double maxValueInI;
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXresultsetXXXXXXXXXXXXXXXXXXXXXXXX"+iterationResultSet.size());
        double[] tempResult = new double[iterationResultSet.size()];
        int i = 0;
        for (ArrayList<PriceLocation> objectTrail : iterationResultSet) {
            double result = getMaxValueInO(objectTrail);
            tempResult[i] = result;
            i++;
        }
        maxValueInI = tempResult[0];
        for (int j = 0; j < tempResult.length-1; j++) {
            if (tempResult[j] > maxValueInI) {
                maxValueInI = tempResult[j];
            }
        }

        return maxValueInI;
    }

    public static int getRelativePos(double x, double maxValueInI) {
        int relativeX = (int) (x / maxValueInI * 100);
        return relativeX;

    }

}
