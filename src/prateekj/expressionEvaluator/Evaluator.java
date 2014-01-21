package prateekj.expressionEvaluator;

import java.util.*;

interface Operation {
    double operation(double Operand1,double Operand2);
}

public class Evaluator {
    private Map<Character, Operation> createMap() {
        Map<Character, Operation> methodMap = new HashMap<Character, Operation>();
        methodMap.put('+',new Operation() {
            @Override
            public double operation(double operand1, double operand2) {
                return  operand1+operand2;
            }
        });
        methodMap.put('-',new Operation() {
            @Override
            public double operation(double operand1, double operand2) {
                return  operand1-operand2;
            }
        });
        methodMap.put('*',new Operation() {
            @Override
            public double operation(double operand1, double operand2) {
                return  operand1*operand2;
            }
        });
        methodMap.put('/',new Operation() {
            @Override
            public double operation(double operand1, double operand2) {
                return  operand1/operand2;
            }
        });
        methodMap.put('^',new Operation() {
            @Override
            public double operation(double operand1, double operand2) {
                return  Math.pow(operand1,operand2);
            }
        });
        return methodMap;
    }

    boolean isOperator(String expressionPart) {
        String possibleOperators = "+-*/^";
        return possibleOperators.contains(expressionPart);
    }

    public Double evaluateExpression(Stack operands, Stack operators,Map<Character, Operation> methodMap) {
        Double result = null;
        while(operands.size() != 1){
            Double Operator1 = (Double) operands.pop();
            Double Operator2 = (Double) operands.pop();
            Character operator = (Character) operators.pop();
            result = methodMap.get(operator).operation(Operator1, Operator2);
            operands.push(result);
        }
        return result;
    }

    public double getEvaluated(String expression){
        Map<Character, Operation> methodMap = createMap();
        Stack operands = new Stack();
        Stack<Character> operators = new Stack<Character>();
        String[] expressionParts = expression.split(" ");
        for (int index=expressionParts.length-1 ; index >= 0 ; index--) {
            if(isOperator(expressionParts[index]))
                operators.push((expressionParts[index].charAt(0)));
            else
                operands.push(Double.parseDouble(expressionParts[index]));
        }
        Double result = evaluateExpression(operands, operators,methodMap);
        return result;
    }
}
