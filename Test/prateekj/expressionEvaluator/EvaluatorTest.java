package prateekj.expressionEvaluator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by prateekj on 1/20/14.
 */
public class EvaluatorTest {
    @Test
    public void evaluator_should_return_Four_for_the_sum_of_one_and_three() throws Exception {
        Evaluator evaluator = new Evaluator();
        double expected = 4;
        assertEquals(expected,evaluator.getEvaluated("1 + 3"),0.0000);
    }

    @Test
    public void evaluator_should_return_Four_point_Five_for_the_sum_of_two_point_two_and_two_point_three() throws Exception {
        Evaluator evaluator = new Evaluator();
        double expected = 4.5;
        assertEquals(expected,evaluator.getEvaluated("2.2 + 2.3"),0.0000);
    }

    @Test
    public void evaluator_should_return_three_for_subtraction_of_seven_and_four() throws Exception {
        Evaluator evaluator = new Evaluator();
        double expected = 3;
        assertEquals(expected,evaluator.getEvaluated("7 - 4"),0.0000);
    }

    @Test
    public void evaluator_should_return_twelve_for_multiplication_of_three_and_four() throws Exception {
        Evaluator evaluator = new Evaluator();
        double expected = 12;
        assertEquals(expected,evaluator.getEvaluated("3 * 4"),0.0000);
    }

    @Test
    public void evaluator_should_return_four_for_division_of_twelve_by_three() throws Exception {
        Evaluator evaluator = new Evaluator();
        double expected = 4;
        assertEquals(expected,evaluator.getEvaluated("12 / 3"),0.0000);
    }

    @Test
    public void evaluator_should_return_eight_for_two_raise_to_power_three() throws Exception {
        Evaluator evaluator = new Evaluator();
        double expected = 8;
        assertEquals(expected,evaluator.getEvaluated("2 ^ 3"),0.0000);
    }

    @Test
    public void isOperator_should_return_true_as_plus_is_a_Operator() throws Exception {
        Evaluator evaluator = new Evaluator();
        boolean expected = true;
        assertEquals(expected,evaluator.isOperator("+"));
    }

    @Test
    public void isOperator_should_return_false_as_One_is_not_Operator() throws Exception {
        Evaluator evaluator = new Evaluator();
        boolean expected = true;
        assertEquals(expected,evaluator.isOperator("+"));
    }

    @Test
    public void evaluator_should_return_five_for_three_plus_four_minus_two() throws Exception {
        Evaluator evaluator = new Evaluator();
        double expected = 5;
        assertEquals(expected,evaluator.getEvaluated("3 + 4 - 2"),0.0000);
    }

    @Test
    public void evaluator_should_return_17_for_addition_of_4_2_6_5() throws Exception {
        Evaluator evaluator = new Evaluator();
        double expected = 17;
        assertEquals(expected,evaluator.getEvaluated("4 + 2 + 6 + 5"),0.0000);
    }

    @Test
    public void evaluator_should_return_48_for_multiplication_of_3_4_4() throws Exception {
        Evaluator evaluator = new Evaluator();
        double expected = 48;
        assertEquals(expected,evaluator.getEvaluated("3 * 4 * 4"),0.0000);
    }

    @Test
    public void evaluator_should_return_5_for_division_of_30_3_2() throws Exception {
        Evaluator evaluator = new Evaluator();
        double expected = 5;
        assertEquals(expected,evaluator.getEvaluated("30 / 3 / 2"),0.0000);
    }

    @Test
    public void test_to_evaluate_simple_bracket() throws Exception {
        Evaluator evaluator = new Evaluator();
        String expected = "2 + 8.0";
        assertEquals(expected,evaluator.evaluateBracket("2 + (3 + 5)"));
    }

    @Test
    public void test_to_evaluate_single_bracket() throws Exception {
        Evaluator evaluator = new Evaluator();
        double expected = 10;
        assertEquals(expected,evaluator.getEvaluated("2 + (3 + 5)"),0.0000);
    }

    @Test
    public void test_to_evaluate_two_parallel_bracket() throws Exception {
        Evaluator evaluator = new Evaluator();
        double expected = 34;
        assertEquals(expected,evaluator.getEvaluated("2 + (3 + 5) + (4 * 6)"),0.0000);
    }

    @Test
    public void test_to_evaluate_three_parallel_bracket() throws Exception {
        Evaluator evaluator = new Evaluator();
        double expected = 40;
        assertEquals(expected,evaluator.getEvaluated("2 + (3 + 5) + (4 * 6) + (24 / 4)"),0.0000);
    }
}
