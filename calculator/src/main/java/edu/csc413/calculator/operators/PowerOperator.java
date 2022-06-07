package edu.csc413.calculator.operators;

import edu.csc413.calculator.evaluator.Operand;

public class PowerOperator extends Operator {

    public int priority() {
        return 3;
    }

    public Operand execute(Operand operandOne, Operand operandTwo){
        int resultPow = (int) Math.pow(operandOne.getOpValue(), operandTwo.getOpValue());
        return new Operand(resultPow);
    }
}