package edu.csc413.calculator.evaluator;

/**
 * Operand class used to represent an operand
 * in a valid mathematical expression.
 */
public class Operand {
    /**
     * construct operand from string token.
     */

    private int opNum;
    public Operand(String token) {
        this.opNum = Integer.parseInt(token);
    }

    /**
     * construct operand from integer
     */
    public Operand(int value) {
        this.opNum = value;
    }

    /**
     * return value of operand
     */
    public int getOpValue() {
        return this.opNum;
    }

    /**
     * Check to see if given token is a valid
     * operand.
     */
    public static boolean check(String token) {
        try{
            Integer.parseInt(token);
        }catch (Exception ex){
            return false;
        }
        return true;
    }
}




