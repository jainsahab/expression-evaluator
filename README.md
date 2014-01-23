expression-evaluator
====================

**Expression-Evaluator** utility helps you to evaluate a Mathematical Expression.



####How to  Use the Tool
You have to  run the build file and download extract zip file

unzip the zip file and go to folder where file has extracted and set the current Path as
> **EVALUATOR_HOME**

####HOW TO RUN?
in the PATH environment variable append the string as given below, to run shell scripts
>    *%EVALUATOR_HOME%/bin

That's it, Now you are ready to run these commands
####RUN COMMANDS

`run.sh "2 + 3"`

#### VERSION 0.6 (SUPPORTING TYPE INDEPENDENCY AND NESTED BRACKETS )

    Expression-Evaluator will accept a string expression which would have space between operands and operators .
    It can have any operator i.e. "+ - * / ^"
    It may have Brackets.


    SAMPLE: "1.5 + (2.5 + (1.5 * 1.5))" = 6.25
            "2 + (3 * (1 + 2)) + (4 / (4 / 2))" = 13



#### VERSION 0.5 (SUPPORTING PARALLEL BRACKETS)

    Expression-Evaluator will accept a string expression which would have space between operands and operators .
    It can have any operator i.e. "+ - * / ^"
    It may have Brackets.
    It should not contain decimal point numbers, only integers are allowed.


    SAMPLE: "2 + (3 + 5)" = 10
            "2 + (3 + 5) + (4 * 6)" = 34


#### VERSION 0.4 (PERFORM EVERY OPERATION WITH NEGATIVE INTEGERS TOO)

    Expression-Evaluator will accept a string expression which would have  space between operands and operators .
    It can have any operator i.e. "+ - * / ^"
    It should not have Brackets.
    It should not contain decimal point numbers, only integers are allowed.


    SAMPLE: "2 + 3 * -4" = 20
            "3 * 5 - -1" = 16


#### VERSION 0.3 (PERFORM EVERY OPERATION WITH ANY NUMBER OF OPERANDS)

    Expression-Evaluator will accept a string expression which would have  space between operands and operators .
    It can have any operator i.e. "+ - * / ^"
    It should not have Brackets.
    It should not contain negative numbers.
    It should not contain decimal point numbers, only integers are allowed.


    SAMPLE: "2 + 3 * 4" = 20
            "3 * 5 - 1" = 14



#### VERSION 0.2 (PERFORM EVERY OPERATION BUT WITH TWO OPERANDS ONLY)

    Expression-Evaluator will accept a string expression which would have  space between operands and operators .
    It can have any operator i.e. "+ - * / ^"
    It should not have Brackets.
    It should not contain negative numbers.
    It should not contain decimal point numbers, only integers are allowed.


    SAMPLE: "2 + 3" = 5
            "3 * 5" = 15
            "16 - 4" = 12
            "15 / 5" = 3
            "2 ^ 3" = 8




#### VERSION 0.1 (PERFORM ADDITION ONLY)

    Our Program will accept a string expression which would have  space between operands and operators .
    It would have only one operator i.e. ‘+’ [Plus Operator]
    It should not have Brackets.
    It should not contain negative numbers.
    It should not contain decimal point numbers, only integers are allowed.


    SAMPLE: "2 + 3"



##### Possible BUGs

> - expression like "1" i.e single value throws exception
> - expression like "1+2" i.e absence of space around operands and operators throws exception