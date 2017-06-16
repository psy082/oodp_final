import java.util.Stack;
/* Evaluator class is for calculating postfix expression and makes result value
 */
public class Evaluator {
	private Stack<Element> postfix;
	private Number result; 
	
	//Evaluator constructor store postfix notation and calls evaluate method
	Evaluator(Stack<Element> _postfix){
		postfix = _postfix;
		result = new Number();
		
		evaluate();
	}
	
	//evaluate method calculates postfix expression
	public void evaluate(){
		
		//Temperary result of operation is stored in number stack
		Stack<Number> number = new Stack<Number>();
		
		//postfix expression is read from begin to end
		for(Element e: postfix){
			if(e.getType() == Element.Type.INT){
				IntegerNumber temp = (IntegerNumber)e;
				number.push(temp);
			}
			else if(e.getType() == Element.Type.FLOAT){
				FloatNumber temp = (FloatNumber)e;
				number.push(temp);
			}
			//If operation is apeared, calculates previous two numbers by using operator
			else{
				Operator temp = (Operator)e;
				Number num2 = number.pop();
				Number num1 = number.pop();
				number.push(temp.Evaluate(num1, num2));
			}
		}
		
		//After the end loop calculating, final result is made in number stack  
		result = number.peek();
	}
	
	//getResult returns the result
	public Number getResult(){
		return result;
	}
}
