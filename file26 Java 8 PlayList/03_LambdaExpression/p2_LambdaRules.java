/*
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
                    LAMBDA EXPRESSION RULES
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

As we already discussed a lambda expression is an anonymous function that doesn't have any -

    1. modifier        
    2. return type
    3. function name 




~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
Characterstics/ More Rules to make Lambda expression much shorter
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~



~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
Rule 1 : Parameter 'Types' are Optional
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
                                   │
(int a, int b) ->                  │                     (a, b) -> 
{                            ______│____________         {
    return a+b;              │_converted to => │              return a+b; 
}                                  │                     }
                                   │
                                   │
------------------------------------------------------------------------------------------
Reason
    The compiler already knows the parameter types from the Functional Interface.

Therefore,
    Parameter Types are Optional.





~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
Rule 2 : Parentheses are optional => ()
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
                                        │
(name) ->                               │                      name ->
{                                 ______│____________          {
    System.out.println(name);     │_converted_to => │               System.out.println(name);    
}                                       │                      }
                                        │
                                        │
------------------------------------------------------------------------------------------
Reason
    If there is only ONE parameter parentheses be removed

------------------------------------------------------------
No Parameter () ->
    Parentheses are Mandatory.

------------------------------------------------------------
Two or More Parameters (a, b) ->
    Parentheses are Mandatory.

------------------------------------------------------------







~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
Rule 3 : Curly Braces are optional ==>  { }
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
                                   │
(a, b) ->                          │                      
{                            ______│____________         
    return a+b;              │_converted to => │          (a, b) -> return a+b; 
}                                  │                     
                                   │
                                   │
------------------------------------------------------------------------------------------
Reason
    if there is only ONE statement in the function body paranthesis can be removed

------------------------------------------------------------
If there are multiple statements
    Curly Braces are Mandatory.






~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
Rule 4 : Return Keyword
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
                                  │                      
                            ______│____________         
(a, b) ->  return a+b;      │_converted to => │          (a, b) -> a+b; 
                                   │                     
                                   │
------------------------------------------------------------
Reason
    When there is a single expression and no curly braces,
    Java automatically returns its value.

So, 
    The return keyword is also removed.

Important
    If Curly Braces are present, return is compulsory.

Correct

    (a, b) ->
    {
        return a + b;
    }

Incorrect

    (a, b) ->
    {
        a + b;
    }






~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
Rule 5 : Lambda Operator
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

Java uses (->) arrow operator

This is called the Lambda Operator.

It separates Parameters from Method Body.

Correct
    (a, b) -> a + b

Incorrect
    (a, b) => a + b

Incorrect
    (a, b) = > a + b






~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
Rules Summary
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

+--------------------------------------------------------------------+
| Rule                                        | Allowed              |
+--------------------------------------------------------------------+
| Remove Parameter Types                      | ✔ Yes                |
| Remove Parentheses (One Parameter)          | ✔ Yes                |
| Remove Parentheses (Two Parameters)         | ✘ No                 |
| Remove Curly Braces (One Statement)         | ✔ Yes                |
| Remove Curly Braces (Multiple Statements)   | ✘ No                 |
| Remove Return Keyword                       | ✔ Yes (No Braces)    |
+--------------------------------------------------------------------+


*/