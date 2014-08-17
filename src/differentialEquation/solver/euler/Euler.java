/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package differentialEquation.solver.euler;

import differentialEquation.DifferentialEquation;
import differentialEquation.ODESystem;

/**
 *
 * @author Chilpayate
 */
public class Euler {

    public double[][] solve(DifferentialEquation diferentialEquation, double[] initialCondition, double lastX, double step ) {
        double x = initialCondition[0];
        double y = initialCondition[1];
        
        int n  = (int) ((lastX - x)/ step) +1;
        
        double[][] result = new double[n][2];
        
        result[0] = initialCondition;
        
       for(int i = 1; i < n; i++){
           y = y + diferentialEquation.dydx(x, y) * step;
           x = i * step;
           double[] e = {x,y};
           result[i] = e;
           
       }
       
       return result;
        
        
    }

    public  double[][] solveOde(ODESystem sis, double[] initialCondition, double lastX, double step) {
        double x = initialCondition[0];
        int numberOfDependentVar = sis.getNumberOfDifferentialEquations();
        double[] y = new double[numberOfDependentVar];
        
        for(int i = 0 ; i < numberOfDependentVar; i++){
            y[i] =  initialCondition[i+1];
        }
        int n  = (int) ((lastX - x)/ step) +1;
        double[][] result = new double[n][y.length + 1];
        
        result[0] = initialCondition;
        
        for(int i = 1 ; i < n; i++){
             double[] newY = new double[y.length];
            for ( int j = 0; j < y.length; j++){
               
                newY[j] =  y[j] + sis.getDifferentialEquation(j).dydx(x, y) * step;
            }
            y = newY;
            
            x = i * step;
            double[] a = new double[y.length + 1];
            a[0] = x;
            System.arraycopy(y, 0, a, 1, y.length);
            
            
            result[i] = a;
        }
        
        
        
        
        
        return result;
    }
    

}
