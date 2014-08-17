package differentialEquation.solver.rungekutta;

/**
 *
 * @author Hugo Redon Rivera
 */
public class Fcubica implements differentialEquation.DifferentialEquation {

    @Override
    public double dydx(double x, double... y) {
        return -2 * Math.pow(x,3) + 12 *Math.pow(x,2) - 20 * x + 8.5;
    }
    
}
