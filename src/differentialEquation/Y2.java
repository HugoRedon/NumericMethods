/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package differentialEquation;

/**
 *
 * @author Chilpayate
 */
public class Y2 implements DifferentialEquation {

    @Override
    public double dydx(double x, double... y) {
        return 4 - 0.3 * y[1] - 0.1 * y[0];
    }
    
}
