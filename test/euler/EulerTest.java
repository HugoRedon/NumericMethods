/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import differentialEquation.solver.euler.Euler;
import differentialEquation.DifferentialEquation;
import differentialEquation.F1;
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
public class EulerTest {
    double tol;
    public EulerTest() {
        tol = 0.0001;
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

    @Test
    public void solveTest() {
        Euler e = new Euler();
        
        double[][] expResult = {
            {0,1},
            {0.5,5.25},
            {1,5.875},
            {1.5,5.125}
        };
    
        DifferentialEquation f1 = new F1();
        
        double[] initialCondition = {0,1};
        double lastX = 1.5;
        double step = 0.5;
        double[][] result =e.solve( f1, initialCondition,lastX,step);
        
        assertArrayEquals(expResult, result);
       
    }
    
    @Test 
    public void solveODETest(){
        Euler  e = new Euler();
        double[][]  expResult ={
            {0,4,6},
            {0.5,3,6.9},
            {1,2.25,7.715},
            {1.5,1.6875,8.44525}
        };
        
        DifferentialEquation y1 = new Y1();
        DifferentialEquation y2 = new Y2();
        
        ODESystem sis = new ODESystem(y1,y2);
        
        double[] initialCondition = {0,4,6};
        double lastX = 1.5;
        double step = 0.5;
        
        double[][] result = e.solveOde(sis,initialCondition, lastX, step);
   
     //   assertArrayEquals(expResult, result  );
        
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
