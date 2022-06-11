package edu.csc413.calculator.evaluator;

import edu.csc413.calculator.exceptions.InvalidTokenException;
import edu.csc413.calculator.operators.*;

import java.util.Stack;
import java.util.StringTokenizer;

public class Evaluator {

    private Stack<Operand> operandStack;
    private Stack<Operator> operatorStack;
    private StringTokenizer expressionTokenizer;
    private final String delimiters = "() +/*-^";

    public Evaluator() {
        operandStack = new Stack<>();
        operatorStack = new Stack<>();
    }

    public int evaluateExpression(String expression) throws InvalidTokenException {
        String expressionToken;

        // The 3rd argument is true to indicate that the delimiters should be used
        // as tokens, too. But, we'll need to remember to filter out spaces.
        this.expressionTokenizer = new StringTokenizer(expression, this.delimiters, true);

        // initialize operator stack - necessary with operator priority schema
        // the priority of any operator in the operator stack other than
        // the usual mathematical operators - "+-*/" - should be less than the priority
        // of the usual operators


        while (this.expressionTokenizer.hasMoreTokens()) {
            // filter out spaces
            if (!(expressionToken = this.expressionTokenizer.nextToken()).equals(" ")) {
                // check if token is an operand
                if (Operand.check(expressionToken)) {
                    operandStack.push(new Operand(expressionToken));
                } else {
                    if (!Operator.check(expressionToken)) {
                        throw new InvalidTokenException(expressionToken);
                    }

                    Operator newOperator = Operator.getOperator(expressionToken);

                    if ((operatorStack.isEmpty()) || (newOperator.priority() == 0)) {
                        operatorStack.push(newOperator);
                    } else {
                        if ((newOperator.priority() == -1)) {
                            while (operatorStack.peek().priority() != 0) {
                                processExp ();
                            }
                            if (operatorStack.peek().priority() == 0) {
                                operatorStack.pop();
                            }
                        } else {
                            while ((operatorStack.peek().priority() >= newOperator.priority())) {
                                processExp ();

                                if (operatorStack.isEmpty()) {
                                    break;
                                }
                            }
                            operatorStack.push(newOperator);
                        }
                    }
                }
            }
        }
        while (!operatorStack.isEmpty()) {
            processExp ();
        }
        return operandStack.pop().getOpValue();
    }

    private void processExp () {
        Operator operatorFromStack = operatorStack.pop();
        Operand operandTwo = operandStack.pop();
        Operand operandOne = operandStack.pop();
        Operand result = operatorFromStack.execute(operandOne, operandTwo);
        operandStack.push(result);
    }
}


    // Control gets here when we've picked up all of the tokens; you must add
    // code to complete the evaluation - consider how the code given here
    // will evaluate the expression 1+2*3
    // When we have no more tokens to scan, the operand stack will contain 1 2
    // and the operator stack will have + * with 2 and * on the top;
    // In order to complete the evaluation we must empty the stacks,
    // that is, we should keep evaluating the operator stack until it is empty;
    // Suggestion: create a method that processes the operator stack until empty.
