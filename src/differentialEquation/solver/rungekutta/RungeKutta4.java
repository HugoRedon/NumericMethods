package differentialEquation.solver.rungekutta;

import differentialEquation.DifferentialEquation;
import differentialEquation.ODESystem;
import java.util.ArrayList;

/**
 *
 * @author Hugo Redon Rivera
 */
public class RungeKutta4 {
    
    public double[][] solve(DifferentialEquation diferentialEquation, double[] initialCondition, double lastX, double step ) {
        double x = initialCondition[0];
        double y = initialCondition[1];
        
        int n  = (int) ((lastX - x)/ step) +1;
        
        double[][] result = new double[n][2];
        
        result[0] = initialCondition;
        
       for(int i = 1; i < n; i++){
           double k1 =diferentialEquation.dydx(x, y);
           double k2 = diferentialEquation.dydx(x + step / 2,y + k1 * step /2);
           double k3 = diferentialEquation.dydx(x+ step / 2, y + k2 * step /2);
           double k4 = diferentialEquation.dydx(x + step, k3 * step);
                   
            double m = (1d/6d) * (k1 + 2 * k2 + 2 * k3 + k4);
           y = y + m* step;
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
            
            
            //k1
            double[]k1 = new double[y.length];
            for ( int j = 0; j < y.length; j++){                   
               k1[j] =sis.getDifferentialEquation(j).dydx(x, y);
            }  
            double[] yfork2 = new double[y.length];
            for(int j = 0; j < y.length; j++){
                yfork2[j] = y[j] + k1[j]* step / 2d;
            }
             double xfork2 = x +step /2d;
             
            //k2
            double[] k2 = new double[y.length];
            for(int j = 0; j<y.length; j++){
                k2[j]  = sis.getDifferentialEquation(j).dydx(xfork2, yfork2);
            }
          double[] yfork3 = new double[y.length];
            for(int j = 0; j < y.length; j++){
                yfork3[j] = y[j] + k2[j]* step / 2d;
            }
             double xfork3 = x +step/2d;
             
             //k3
            double[] k3 = new double[y.length];
            for(int j = 0; j<y.length; j++){
                k3[j]  = sis.getDifferentialEquation(j).dydx(xfork3, yfork3);
            }
          double[] yfork4 = new double[y.length];
            for(int j = 0; j < y.length; j++){
                yfork4[j] = y[j] + k3[j]* step;
            }
             double xfork4 = x +step;
             
             //k4
            double[] k4 = new double[y.length];
            for(int j = 0; j<y.length; j++){
                k4[j]  = sis.getDifferentialEquation(j).dydx(xfork4, yfork4);
            }
     
            double[] newY = new double[y.length];
            for(int j = 0; j < y.length; j++){
                double m = (1d/6d) * (k1[j] + 2 * k2[j] + 2 * k3[j] + k4[j]);           
                newY[j] = y[j] + m* step; 
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
