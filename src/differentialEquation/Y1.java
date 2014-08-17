/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package differentialEquation;

/**
 *
 * @author Chilpayate
 */
public class Y1 implements DifferentialEquation {

    @Override
    public double dydx(double x, double... y) {
        return -0.5 * y[0]; 
    }
    
}
