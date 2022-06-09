package edu.csc413.calculator.operators;

import edu.csc413.calculator.evaluator.Operand;

public class DivideOperator extends Operator {

    public int priority() {
        return 2;
    }

    public Operand execute(Operand operandOne, Operand operandTwo){
        int resultDiv = operandOne.getOpValue() / operandTwo.getOpValue();
        return new Operand(resultDiv);

    }
}
