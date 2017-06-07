# oodp_final
oodp final project - calculator application

This is description of overall Calculator package.
------------------------------------------------------

  A <>- B : B is component of A


<p>Calculator <>- Parser            - Parser takes input and make it infix notation. infix is stored in Stack.       </p>
<p>           <>- ToPostFix         - ToPostFix takes infix and change it postfix. postfix is also stored in Stack.  </p>
<p>           <>- Evaluator         - Evaluator makes evaluated result by calculating postfix notation.              </p>

Calculator class has two private values. One is raw expression for calculating. The other is result of calculation.
 

   A <-- B : B extends A    
   <li>A <- B : B implements A </li>
-------------------------------------------------------

 Element <-- Opearator, Number
 
 Operator <-- Plus, Minus, Multiply, Division, ParanthR, ParanthL
 
 Number <-- IntegerNumber, FloatNumber
