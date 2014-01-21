package prateekj.expressionEvaluator;

public class Evaluator {
    private double addOperands(Double Operator1,Double Operator2){
        return  Operator1+Operator2;
    }
    private double subtractOperands(Double Operator1,Double Operator2){
        return  Operator1-Operator2;
    }
    private double productOfOperands(Double Operator1, Double Operator2) {
        return Operator1*Operator2;
    }

    private double divisionOfOperands(Double Operator1, Double Operator2) {
        return Operator1/Operator2;
    }

    private double powerOfOperands(Double Operator1, Double Operator2) {
        return Math.pow(Operator1,Operator2);
    }

    public double getEvaluated(String expression){
        String[] expressionParts = expression.split(" ");
        String operator = expressionParts[1];
        Double Operator1 = Double.parseDouble(expressionParts[0]);
        Double Operator2 = Double.parseDouble(expressionParts[2]);
        if(operator.equals("+"))
            return addOperands(Operator1,Operator2);
        if(operator.equals("-"))
            return subtractOperands(Operator1, Operator2);
        if(operator.equals("*"))
            return productOfOperands(Operator1, Operator2);
        if(operator.equals("/"))
            return divisionOfOperands(Operator1, Operator2);
        if(operator.equals("^"))
            return powerOfOperands(Operator1, Operator2);
        return 0;
    }
}
