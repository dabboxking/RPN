package com.reyme.rpn;

/**
 * Created by reyme on 4/30/16.
 */

import junit.framework.TestCase;

public class RPNCalculatorTest extends TestCase {

    private String[] emptyStore;
    private String[] oneInStore;
    private String[] twoInStore;
    private String[] manyInStore;
    private String[] addStore;
    private String[] subStore;
    private String[] multiStore;
    private String[] divStore;
    private String[] oooStore;

    public void setUp(){
        emptyStore = new String[3];

        oneInStore = new String[3];
        oneInStore[0] = "1";

        twoInStore = new String[3];
        twoInStore[0] = "1";
        twoInStore[1] = "2";

        manyInStore = new String[3];
        manyInStore[0] = "1";
        manyInStore[1] = "2";
        manyInStore[2] = "3";

        addStore = new String[3];
        addStore[0] = "1";
        addStore[1] = "2";
        addStore[2] = "+";

        subStore = new String[3];
        subStore[0] = "1";
        subStore[1] = "2";
        subStore[2] = "-";

        multiStore = new String[3];
        multiStore[0] = "1";
        multiStore[1] = "2";
        multiStore[2] = "*";

        divStore = new String[3];
        divStore[0] = "1";
        divStore[1] = "2";
        divStore[2] = "/";

        oooStore = new String[3];
        oooStore[0] = "1";
        oooStore[1] = "0";
        oooStore[2] = "/";
    }

    /**
     * Test for {@link RPNCalculator#evaluate(String[])}
     */
    public void testEvaluate() {
        String emptyResult = RPNCalculator.evaluate(emptyStore);
        assertEquals("",emptyResult);

        String oneInStoreResult = RPNCalculator.evaluate(oneInStore);
        assertEquals("",oneInStoreResult);

        String twoInStoreResult = RPNCalculator.evaluate(twoInStore);
        assertEquals("",twoInStoreResult);

        String manyInStoreResult = RPNCalculator.evaluate(manyInStore);
        assertEquals("",manyInStoreResult);

        String addResult = RPNCalculator.evaluate(addStore);
        assertEquals("3.0",addResult);

        String subResult = RPNCalculator.evaluate(subStore);
        assertEquals("-1.0",subResult);

        String multiResult = RPNCalculator.evaluate(multiStore);
        assertEquals("2.0",multiResult);

        String divResult = RPNCalculator.evaluate(divStore);
        assertEquals("0.5",divResult);

        String oooResult = RPNCalculator.evaluate(oooStore);
        assertEquals("Infinity",oooResult);
    }

    /**
     * Test for {@link RPNCalculator#canEvaluate(String[])}
     */
    public void testCanEvaluate() {
        boolean resultA = RPNCalculator.canEvaluate(emptyStore);
        assertFalse(resultA);

        boolean resultB = RPNCalculator.canEvaluate(oneInStore);
        assertFalse(resultB);

        boolean resultC = RPNCalculator.canEvaluate(twoInStore);
        assertFalse(resultC);

        boolean resultD = RPNCalculator.canEvaluate(manyInStore);
        assertFalse(resultD);

        boolean resultE = RPNCalculator.canEvaluate(addStore);
        assertTrue(resultE);
    }

    /**
     * Test for {@link RPNCalculator#isOperand(String)}
     */
    public void testIsOperand() {

        assertFalse(RPNCalculator.isOperand(""));
        assertFalse(RPNCalculator.isOperand(null));
        assertFalse(RPNCalculator.isOperand("a"));
        assertFalse(RPNCalculator.isOperand("A"));
        assertFalse(RPNCalculator.isOperand("-+/*"));
        assertFalse(RPNCalculator.isOperand("1a"));

        assertTrue(RPNCalculator.isOperand("1"));
        assertTrue(RPNCalculator.isOperand("123"));
        assertTrue(RPNCalculator.isOperand("1.0"));
        assertTrue(RPNCalculator.isOperand("-1"));
        assertTrue(RPNCalculator.isOperand("-1.0"));
    }

    /**
     * Test for {@link RPNCalculator#isOperator(String)}
     */
    public void testIsOperator() {

        assertFalse(RPNCalculator.isOperator(""));
        assertFalse(RPNCalculator.isOperator(null));
        assertFalse(RPNCalculator.isOperator("1"));
        assertFalse(RPNCalculator.isOperator("a"));
        assertFalse(RPNCalculator.isOperator("--"));
        assertFalse(RPNCalculator.isOperator("++"));
        assertFalse(RPNCalculator.isOperator("**"));
        assertFalse(RPNCalculator.isOperator("//"));
        assertFalse(RPNCalculator.isOperator("-/"));


        assertTrue(RPNCalculator.isOperator("-"));
        assertTrue(RPNCalculator.isOperator("+"));
        assertTrue(RPNCalculator.isOperator("/"));
        assertTrue(RPNCalculator.isOperator("*"));

    }
}
