package prateekj.expressionEvaluator;

public class Evaluator {
    public double getEvaluated(String expression){
        String[] temp = expression.split(" ");
        return Double.parseDouble(temp[0])+Double.parseDouble(temp[2]);
    }
}
