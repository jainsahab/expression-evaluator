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
        if(operands.size() == 1 && operators.size()== 1){
            Double Operand1 = (Double) operands.pop();
            Character operator = (Character) operators.pop();
            operands.push(Double.parseDouble(operator.toString().concat(Operand1.toString())));
        }
        while(operands.size() != 1){
            Double Operand1 = (Double) operands.pop();
            Double Operand2 = (Double) operands.pop();
            Character operator;
            try {
                operator = (Character) operators.pop();
            }
            catch (EmptyStackException e){
                operator = '+';
            }
            result = methodMap.get(operator).operation(Operand1, Operand2);
            operands.push(result);
        }
        result = (Double) operands.pop();
        return result;
    }

    public Stack getOperands(String expression) {
        Stack operands = new Stack();
        String[] expressionParts = expression.split(" ");
        for (int index=expressionParts.length-1 ; index >= 0 ; index--) {
            if(expressionParts[index].equals(""))
                continue;
            if(!isOperator(expressionParts[index]))
                operands.push(Double.parseDouble(expressionParts[index]));
        }
        return operands;
    }

    public Stack getOperators(String expression) {
        Stack<Character> operators = new Stack<Character>();
        String[] expressionParts = expression.split(" ");
        for (int index=expressionParts.length-1 ; index >= 0 ; index--) {
            if(expressionParts[index].equals(""))
                continue;
            if(isOperator(expressionParts[index]))
                operators.push(expressionParts[index].charAt(0));
        }
        return operators;
    }

    public double getEvaluated(String expression){
        if(expression.matches(".*['+','-','*','/','^']$"))
            throw new IllegalArgumentException();
        Map<Character, Operation> methodMap = createMap();
        expression = makeStandardForm(expression);
        if(expression.contains("("))
            expression = evaluateBracket(expression);
        Stack operands = getOperands(expression);
        Stack<Character> operators = getOperators(expression);
        Double result = evaluateExpression(operands,operators,methodMap);
        return result;
    }

    String makeStandardForm(String expression) {
        Boolean consecutive = isConsecutive(expression);
        StringBuilder result = new StringBuilder();
        expression = expression.replaceAll("\\+", " + ")
                               .replaceAll("--","+")
                               .replaceAll("-", " - ")
                               .replaceAll("\\*", " * ")
                               .replaceAll("/", " / ")
                               .replaceAll("\\^", " ^ ")
                               .replaceFirst("^ - ", "-")
                               .replaceFirst("^\\( - ", "(-")
                               .replaceAll("\\) *\\(",") * (");

        if(consecutive)
            expression = expression.replaceAll("  - ", " -");
        if(expression.matches(".*[0-9]\\(.*"))
            expression = expression.replaceAll("\\(", " * (");
        String[] temp = expression.split(" ");
        for (String s : temp) {
            if(!s.equals(""))
                result.append(s);
            if(!s.equals("(") && !s.equals("-") && !s.equals(""))
                result.append(" ");
        }
        return result.toString().substring(0,result.length()-1);
    }

    private boolean isConsecutive(String expression) {
        boolean result = false;
        for (int i = 0 ; i < expression.length()-2 ; i++){
            result = isOperator(String.valueOf(expression.charAt(i))) && isOperator(String.valueOf(expression.charAt(i+1)));
            if(result)
                return result;
        }
        return  result;
    }

    public String evaluateBracket(String expression) {
        Map<Character, Operation> methodMap = createMap();
        if(!expression.contains("("))
            return expression;
        int openBracketIndex= expression.lastIndexOf("(");
        int closeBracketIndex = expression.indexOf(")", openBracketIndex);
        String innerExpression = expression.substring(openBracketIndex+1,closeBracketIndex);
        Stack operands = getOperands(innerExpression);
        Stack<Character> operators = getOperators(innerExpression);
        Double result = evaluateExpression(operands, operators, methodMap);
        expression = expression.replace("("+innerExpression+")", Double.toString(result));
        return (evaluateBracket(expression));
    }
}


