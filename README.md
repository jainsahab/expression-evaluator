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


#### VERSION 0.2 (PERFORM EVERY OPERATION BUT WITH TWO OPERANDS ONLY)

    Our Program will accept a string expression which would have  space between operands and operators .
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