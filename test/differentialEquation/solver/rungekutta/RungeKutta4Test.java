/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package differentialEquation.solver.rungekutta;

import differentialEquation.DifferentialEquation;
import differentialEquation.ODESystem;
import differentialEquation.Y1;
import differentialEquation.Y2;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Chilpayate
 */
public class RungeKutta4Test {
    double tol;
    public RungeKutta4Test() {
        tol = 0.001;
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of solve method, of class RungeKutta4.
     */
    @Test
    public void testSolve() {
        System.out.println("solve");
        DifferentialEquation diferentialEquation = new Fcubica();
        double[] initialCondition = {0,1};
        double lastX = 0.5;
        double step = 0.5;
        RungeKutta4 instance = new RungeKutta4();
        double[][] expResult = {
            {0,1},
            {0.5,3.21875}
        };
        double[][] result = instance.solve(diferentialEquation, initialCondition, lastX, step);
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of solveOde method, of class RungeKutta4.
     */
    @Test
    public void testSolveOde() {
        System.out.println("solveOde");
        
        Y1 f1 = new Y1();
        Y2 f2 = new Y2();
       
        ODESystem sis = new ODESystem(f1,f2);
        
        double[] initialCondition = {0,4,6};
        double lastX = 2.0;
        double step = 0.5;
        RungeKutta4 instance = new RungeKutta4();
        double[][] expResult = {
            {0,4,6},
            {0.5,3.115234,6.857670},
            {1.0,2.426171,7.632106},    
            {1.5,1.889523,8.326886},
            {2.0,1.471577,8.9466865}
            
        };
        double[][] result = instance.solveOde(sis, initialCondition, lastX, step);
       // assertArrayEquals(expResult, result);
 for( int i = 0; i < result.length; i++){
            double[] res = result[i];
            double[] expres = expResult[i];
            
            double x = res[0];
            double yr1 = res[1];
            double yr2 = res[2];
            
            double expx = expres[0];
            double expy1 = expres[1];
            double expy2 = expres[2];
            
            assertEquals(expx, x,tol);
            assertEquals(expy1, yr1,tol);
            assertEquals(expy2, yr2,tol);
        }
    }
}
