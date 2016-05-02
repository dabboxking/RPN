package com.reyme.rpn;

/**
 * Created by reyme on 4/30/16.
 */
public class RPNCalculator {

    // only digits
    private static final String OPERAND_REGEX = "^-?[0-9]\\d*(\\.\\d+)?$";
    // only one occurrence of '-','+','/','*'
    private static final String OPERATOR_REGEX = "[-+/*]{1}";
    private static String[] rpnStore = new String[10];
    private static float operandA;
    private static float operandB;
    private static int MAX_SIZE = 10;

    /**
     * Processes user's input
     * @param in
     */
    public void processUserInput(String in) {
        if(isOperand(in)) {
            System.out.println("operand: " + in);
            // add to rpnStore
            add(in);
        } else if(isOperator(in)) {
            System.out.println("operator: " + in);
            evaluate(rpnStore,in);
        } else if("q".equalsIgnoreCase(in)){
            System.out.println("Exiting!");
        } else {
            System.out.println("Invalid Input!");
        }
    }

    /**
     *
     * @param store
     * @return true if and only if store has two operands in first and
     * second indexes and operator in third index
     */
    public static boolean canEvaluate(String[] store) {
        return isOperand(store[0]) && isOperand(store[1]);
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
     * Evaluates the given expression by taking the first two arguments
     * from rpnStore then applies the operator to the two operands
     * @param store
     * @param operator
     * @return
     */
    public static String evaluate(String[] store,String operator) {
        String result = "";
        if(canEvaluate(store) && operator != null) {
            operandA = Float.parseFloat(store[0]);
            operandB = Float.parseFloat(store[1]);
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

            rpnStore[0] = result;
            shift();
            System.out.println("output: " + rpnStore[0]);
        }
        return result;
    }

    /**
     * Starting from index 1 shift rpnStore values to the left
     */
    public static void shift() {
        for(int i = 1; i < rpnStore.length -1; i++ ) {
            rpnStore[i] = rpnStore[i+1];
        }
    }

    /**
     * @param operand
     * @return true if and only if the given operand matches {@link RPNCalculator#OPERAND_REGEX}
     */
    public static boolean isOperand(String operand) {
        if(operand == null) {
            return false;
        }
        return operand.matches(OPERAND_REGEX);
    }

    /**
     * @param operator
     * @return true if and only if the given operand matches {@link RPNCalculator#OPERATOR_REGEX}
     */
    public static boolean isOperator(String operator) {
        if(operator == null) {
            return false;
        }
        return operator.matches(OPERATOR_REGEX);
    }

}
