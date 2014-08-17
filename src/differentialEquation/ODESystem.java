package differentialEquation;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Hugo Redon Rivera
 */
public class ODESystem {
    ArrayList<DifferentialEquation> ode = new ArrayList<>();
    
    public ODESystem(DifferentialEquation... odes){
        ode.addAll(Arrays.asList(odes));
    }
    
    public DifferentialEquation getDifferentialEquation(int index){
        return ode.get(index);
    }
    public int getNumberOfDifferentialEquations(){
        return ode.size();
    }
    public void addODE(DifferentialEquation eq){
        ode.add(eq);
    }
    
}
