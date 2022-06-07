package edu.csc413.calculator.operators;

import edu.csc413.calculator.evaluator.Operand;

public class CloseParOperator extends Operator {

    public int priority() {
        return 0;
    }

    public Operand execute(Operand operandOne, Operand operandTwo){
        return new Operand(0);
    }
}
