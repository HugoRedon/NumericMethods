/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package differentialEquation;

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
public class DifferentialEquationTest {
    
    double tol;
    public DifferentialEquationTest() {
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
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void dydxTest(){
        DifferentialEquation f1 = new F1();
        
        double expResult = 8.5;
        double result = f1.dydx(0,1);
        
        assertEquals(expResult, result, tol);
        
    }
}
