package edu.csc413.calculator.operators;

import edu.csc413.calculator.evaluator.Operand;

public class MultiplyOperator extends Operator {

    public int priority() {
        return 2;
    }

    public Operand execute(Operand operandOne, Operand operandTwo){
        int resultMul = operandOne.getValue() * operandTwo.getValue();
        return new Operand(resultMul);

    }
}