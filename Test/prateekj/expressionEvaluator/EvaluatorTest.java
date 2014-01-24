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

    @Test
    public void test_to_evaluate_two_nested_brackets() throws Exception {
        Evaluator evaluator = new Evaluator();
        double expected = 11;
        assertEquals(expected,evaluator.getEvaluated("2 + (3 * (1 + 2))"),0.0000);
    }

    @Test
    public void test_to_evaluate_two_parallel_and_nested_brackets_between_them() throws Exception {
        Evaluator evaluator = new Evaluator();
        double expected = 13;
        assertEquals(expected,evaluator.getEvaluated("2 + (3 * (1 + 2)) + (4 / (4 / 2))"),0.0000);
    }

    @Test
    public void test_to_evaluate_one_nested_brackets_() throws Exception {
        Evaluator evaluator = new Evaluator();
        double expected = 6.25;
        assertEquals(expected,evaluator.getEvaluated("1.5 + (2.5 + (1.5 * 1.5))"),0.0000);
    }


    @Test
    public void createSpace() throws Exception {
        Evaluator evaluator = new Evaluator();
        String expected = "4 + 3";
        assertEquals(expected,evaluator.makeStandardForm("4+3"));
    }

    @Test
    public void createSpace2() throws Exception {
        Evaluator evaluator = new Evaluator();
        String expected = "43 + 3";
        assertEquals(expected,evaluator.makeStandardForm("43 +3"));
    }

    @Test
    public void createSpace3() throws Exception {
        Evaluator evaluator = new Evaluator();
        String expected = "4 + (3 + 2)";
        assertEquals(expected,evaluator.makeStandardForm("4+(3+2)"));
    }

    @Test
    public void createSpace4() throws Exception {
        Evaluator evaluator = new Evaluator();
        String expected = "5 + (6 + 2)";
        assertEquals(expected,evaluator.makeStandardForm("5 + (6+2)"));
    }

    @Test
    public void createSpace5() throws Exception {
        Evaluator evaluator = new Evaluator();
        String expected = "56 + 2 + (6 + 2)";
        assertEquals(expected,evaluator.makeStandardForm("56+2+ (6+2)"));
    }

    @Test
    public void createSpace6() throws Exception {
        Evaluator evaluator = new Evaluator();
        String expected = "(1 + (2))";
        assertEquals(expected,evaluator.makeStandardForm("(1   +(     2))"));
    }

    @Test
    public void createSpace7() throws Exception {
        Evaluator evaluator = new Evaluator();
        String expected = "(-1 + (2))";
        assertEquals(expected,evaluator.makeStandardForm("(-1   +(2))"));
    }

    @Test
    public void createSpace8() throws Exception {
        Evaluator evaluator = new Evaluator();
        String expected = "(-1 -(2))";
        assertEquals(expected,evaluator.makeStandardForm("(-1   -(2))"));
    }

    @Test
    public void test_to_evaluate_expression_with_no_space_() throws Exception {
        Evaluator evaluator = new Evaluator();
        double expected = 3;
        assertEquals(expected,evaluator.getEvaluated("1+2"),0.0000);
    }

    @Test
    public void test_to_evaluate_expression_with_no_space_and_a_bracket() throws Exception {
        Evaluator evaluator = new Evaluator();
        double expected = 3;
        assertEquals(expected,evaluator.getEvaluated("(1+2)"),0.0000);
    }

    @Test
    public void test_to_evaluate_expression_with_unnecessary_spaces_and_a_nested_bracket() throws Exception {
        Evaluator evaluator = new Evaluator();
        double expected = 3;
        assertEquals(expected,evaluator.getEvaluated("(1   +(2))"),0.0000);
    }

    @Test
    public void test_to_evaluate_expression_with_unnecessary_spaces_and_nested_bracket_and_space_inside_it() throws Exception {
        Evaluator evaluator = new Evaluator();
        double expected = 3;
        assertEquals(expected,evaluator.getEvaluated("(1   +(     2))"),0.0000);
    }

    @Test
    public void test_to_evaluate_expression_with_unnecessary_spaces_with_minus_option() throws Exception {
        Evaluator evaluator = new Evaluator();
        double expected = -3;
        assertEquals(expected,evaluator.getEvaluated("(-1   -(2))"),0.0000);
    }

    @Test
    public void test_to_evaluate_expression_with_unnecessary_brackets() throws Exception {
        Evaluator evaluator = new Evaluator();
        double expected = 20;
        assertEquals(expected,evaluator.getEvaluated("(((((((20)))))))"),0.0000);
    }

    @Test
    public void test_to_evaluate_expression_with_unnecessary_brackets_and_minus_option() throws Exception {
        Evaluator evaluator = new Evaluator();
        double expected = -19;
        assertEquals(expected,evaluator.getEvaluated("(((1-((((20)))))))"),0.0000);
    }

    @Test
    public void test_to_evaluate_expression_with_nested_brackets_and_minus_option() throws Exception {
        Evaluator evaluator = new Evaluator();
        double expected = 13;
        assertEquals(expected,evaluator.getEvaluated("2+(3*(1+2))+(4/(4-2))"),0.0000);
    }

    @Test
    public void test_to_evaluate_expression_with_consecutive_signs() throws Exception {
        Evaluator evaluator = new Evaluator();
        double expected = -1;
        assertEquals(expected,evaluator.getEvaluated("1.5+-2.5"),0.0000);
    }

    @Test
    public void test_to_evaluate_expression_without_giving_symbol() throws Exception {
        Evaluator evaluator = new Evaluator();
        double expected = 7;
        assertEquals(expected,evaluator.getEvaluated("1(3+4)"),0.0000);
    }

    @Test
    public void test_to_evaluate_expression_without_giving_symbol_2() throws Exception {
        Evaluator evaluator = new Evaluator();
        double expected = 49;
        assertEquals(expected,evaluator.getEvaluated("(3+4)(6+1)"),0.0000);
    }

    @Test
    public void test_to_evaluate_simple_expression() throws Exception {
        Evaluator evaluator = new Evaluator();
        double expected = 21;
        assertEquals(expected,evaluator.getEvaluated("23+(-2)"),0.0000);
    }

    @Test
    public void some_specific_test_cases() throws Exception {
        Evaluator evaluator = new Evaluator();
        double expected = 0.125;
            assertEquals(expected,evaluator.getEvaluated("(2 ^ -3)"),0.0000);
    }

    @Test
    public void some_specific_test_cases_2() throws Exception {
        Evaluator evaluator = new Evaluator();
        double expected = -1;
        assertEquals(expected,evaluator.getEvaluated("((-1))"),0.0000);
    }

    @Test(expected=IllegalArgumentException.class)
    public void some_specific_test_cases_3() throws Exception {
        Evaluator evaluator = new Evaluator();
        double expected = -1;
        assertEquals(expected,evaluator.getEvaluated("22+"),0.0000);
    }

    @Test
    public void some_specific_test_cases_4() throws Exception {
        Evaluator evaluator = new Evaluator();
        double expected = 1.5;
        assertEquals(expected,evaluator.getEvaluated("1.25 -- 0.25"),0.0000);
    }


    @Test
    public void some_specific_test_cases_5() throws Exception {
        Evaluator evaluator = new Evaluator();
        double expected = 3;
        assertEquals(expected,evaluator.getEvaluated("24-3/7"),0.0000);
    }

    @Test
    public void some_specific_test_cases_6() throws Exception {
        Evaluator evaluator = new Evaluator();
        double expected = 2;
        assertEquals(expected,evaluator.getEvaluated("1--1"),0.0000);
    }

    @Test
    public void some_specific_test_cases_7() throws Exception {
        Evaluator evaluator = new Evaluator();
        double expected = -1;
        assertEquals(expected,evaluator.getEvaluated("1*-1"),0.0000);
    }
}
