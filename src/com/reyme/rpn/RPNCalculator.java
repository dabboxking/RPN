package com.reyme.rpn;

/**
 * Created by reyme on 4/30/16.
 */
public class RPNCalculator {

    // only digits
    private static final String OPERAND_REGEX = "^-?[0-9]\\d*(\\.\\d+)?$";
    // only one occurrence of '-','+','/','*'
    private static final String OPERATOR_REGEX = "[-+/*]{1}";
    private static String[] rpnStore = new String[3];
    private static float operandA;
    private static float operandB;
    private static String operator;

    /**
     * TODO
     * @param in
     */
    public void processUserInput(String in) {
        if(isOperand(in)) {
            System.out.println("operand: " + in);
            // add to rpnStore
            add(in);
        } else if(isOperator(in) && canStoreOperator()) {
            System.out.println("operator: " + in);
            // check if calculator can evaluate
            // otherwise add operator to rpnStore
            add(in);
            evaluate(rpnStore);
        } else if("q".equalsIgnoreCase(in)){
            System.out.println("Exiting!");
        } else {
            System.out.println("Invalid Input!");
        }
    }

    /**
     *
     * @return true if and only if rpnStore has two operands stored
     */
    public static boolean canStoreOperator() {
        return isOperand(rpnStore[0]) && isOperand(rpnStore[1]);
    }

    /**
     *
     * @param store
     * @return true if and only if store has two operands in first and
     * second indexes and operator in third index
     */
    public static boolean canEvaluate(String[] store) {
        return isOperand(store[0]) && isOperand(store[1]) && isOperator(store[2]);
    }

    /**
     * Adds input into rpnStore
     * @param in
     */
    public static void add(String in) {

        for (int i = 0; i < rpnStore.length; i++) {
            if(rpnStore[i] == null) {
                rpnStore[i] = in;
                break;
            }
        }
    }

    /**
     * TODO
     * @param store
     * @return
     */
    public static String evaluate(String[] store) {
        String result = "";
        if(canEvaluate(store)) {
            operandA = Float.parseFloat(store[0]);
            operandB = Float.parseFloat(store[1]);
            operator = store[2];
            switch (operator) {
                case "+":
                    result = Float.toString(operandA + operandB);
                    break;
                case "-":
                    result = Float.toString(operandA - operandB);
                    break;
                case "/":
                    result = Float.toString(operandA / operandB);
                    break;
                case "*":
                    result = Float.toString(operandA * operandB);
                default:
                    break;
            }
            // put result back in rpnStore
            // clear store
            rpnStore = new String[3];
            rpnStore[0] = result;
            System.out.println("output: " + rpnStore[0]);
        }
        return result;
    }

    /**
     * TODO
     * @param operand
     * @return
     */
    public static boolean isOperand(String operand) {
        if(operand == null) {
            return false;
        }
        return operand.matches(OPERAND_REGEX);
    }

    /**
     * TODO
     * @param operator
     * @return
     */
    public static boolean isOperator(String operator) {
        if(operator == null) {
            return false;
        }
        return operator.matches(OPERATOR_REGEX);
    }

}
