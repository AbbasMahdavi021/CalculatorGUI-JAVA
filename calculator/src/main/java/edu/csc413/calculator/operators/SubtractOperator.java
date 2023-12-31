package edu.csc413.calculator.operators;

import edu.csc413.calculator.evaluator.Operand;

public class SubtractOperator extends Operator {

    public int priority() {
        return 1;
    }

    public Operand execute(Operand operandOne, Operand operandTwo){
        int resultSub = operandOne.getOpValue() - operandTwo.getOpValue();
        return new Operand(resultSub);
    }
}
