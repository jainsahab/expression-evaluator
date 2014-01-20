package prateekj.expressionEvaluator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by prateekj on 1/20/14.
 */
public class EvaluatorTest {
    @Test
    public void test_should_return_Four_for_the_sum_of_one_and_three() throws Exception {
        Evaluator evaluator = new Evaluator();
        double expected = 4;
        assertEquals(expected,evaluator.getEvaluated("1 + 3"),0.0000);
    }

    @Test
    public void test_should_return_Four_point_Five_for_the_sum_of_two_point_two_and_two_point_three() throws Exception {
        Evaluator evaluator = new Evaluator();
        double expected = 4.5;
        assertEquals(expected,evaluator.getEvaluated("2.2 + 2.3"),0.0000);
    }
}
