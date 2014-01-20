package prateekj.client;

import prateekj.expressionEvaluator.Evaluator;

/**
 * Created by prateekj on 1/20/14.
 */
public class EvaluatorMain {
    public static void main(String[] args) {
        if(args.length == 0){
            System.out.println("no expression found");
            return;
        }
        Evaluator evaluator = new Evaluator();
        System.out.println(evaluator.getEvaluated(args[0]));
    }
}
