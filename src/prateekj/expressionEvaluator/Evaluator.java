package prateekj.expressionEvaluator;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        result = (Double) operands.pop();
        return result;
    }

    public Stack getOperands(String expression) {
        Stack operands = new Stack();
        String[] expressionParts = expression.split(" ");
        for (int index=expressionParts.length-1 ; index >= 0 ; index--) {
            if(!isOperator(expressionParts[index]))
                operands.push(Double.parseDouble(expressionParts[index]));
        }
        return operands;
    }

    public Stack getOperators(String expression) {
        Stack<Character> operators = new Stack<Character>();
        String[] expressionParts = expression.split(" ");
        for (int index=expressionParts.length-1 ; index >= 0 ; index--) {
            if(isOperator(expressionParts[index]))
                operators.push(expressionParts[index].charAt(0));
        }
        return operators;
    }

    public double getEvaluated(String expression){
        Map<Character, Operation> methodMap = createMap();
        if(expression.contains("("))
            expression = evaluateBracket(expression);
        Stack operands = getOperands(expression);
        Stack<Character> operators = getOperators(expression);
        Double result = evaluateExpression(operands,operators,methodMap);
        return result;
    }

    public String evaluateBracket(String expression) {
        Map<Character, Operation> methodMap = createMap();
        if(!expression.contains("("))
            return expression;
        int openBracketIndex= expression.indexOf("(");
        int closeBracketIndex = expression.indexOf(")");
        String innerExpression = expression.substring(openBracketIndex+1,closeBracketIndex);
        Stack operands = getOperands(innerExpression);
        Stack<Character> operators = getOperators(innerExpression);
        Double result = evaluateExpression(operands, operators, methodMap);
        expression = expression.replace("("+innerExpression+")", Double.toString(result));
        return (evaluateBracket(expression));
    }
}


