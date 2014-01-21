package prateekj.expressionEvaluator;

import java.util.Stack;

public class Evaluator {
    double addOperands(Double Operator1,Double Operator2){
        return  Operator1+Operator2;
    }
    double subtractOperands(Double Operator1,Double Operator2){
        return  Operator1-Operator2;
    }
    double productOfOperands(Double Operator1, Double Operator2) {
        return Operator1*Operator2;
    }

    double divisionOfOperands(Double Operator1, Double Operator2) {
        return Operator1/Operator2;
    }

    double powerOfOperands(Double Operator1, Double Operator2) {
        return Math.pow(Operator1,Operator2);
    }

    boolean isOperator(String expressionPart) {
        String possibleOperators = "+-*/^";
        return possibleOperators.contains(expressionPart);
    }

    public Double evaluateExpression(Stack operands, Stack operators) {
        Double result = null;
        while(operands.size() != 1){
            Double Operator1 = (Double) operands.pop();
            Double Operator2 = (Double) operands.pop();
            String operator = (String) operators.pop();
            if(operator.equals("+"))
                result = addOperands(Operator1,Operator2);
            if(operator.equals("-"))
                result =  subtractOperands(Operator1, Operator2);
            if(operator.equals("*"))
                result =  productOfOperands(Operator1, Operator2);
            if(operator.equals("/"))
                result =  divisionOfOperands(Operator1, Operator2);
            if(operator.equals("^"))
                result =  powerOfOperands(Operator1, Operator2);
            operands.push(result);
        }
        return result;
    }

    public double getEvaluated(String expression){
        Stack operands = new Stack();
        Stack operators = new Stack();
        String[] expressionParts = expression.split(" ");
        for (int index=expressionParts.length-1 ; index >= 0 ; index--) {
            if(isOperator(expressionParts[index])) {
                operators.push(expressionParts[index]);
            }
            else {
                operands.push(Double.parseDouble(expressionParts[index]));
            }
        }
        Double result = evaluateExpression(operands, operators);
        return result;
    }
}
