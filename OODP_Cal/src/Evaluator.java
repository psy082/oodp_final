import java.util.Stack;

public class Evaluator {
	private Stack<Element> postfix;
	private Number result; 
	
	Evaluator(Stack<Element> _postfix){
		postfix = _postfix;
		result = new Number();
		
		evaluate();
	}
	
	public void evaluate(){
		Stack<Number> number = new Stack<Number>();
		
		for(Element e: postfix){
			if(e.getType() == Element.Type.INT){
				IntegerNumber temp = (IntegerNumber)e;
				number.push(temp);
			}
			else if(e.getType() == Element.Type.FLOAT){
				FloatNumber temp = (FloatNumber)e;
				number.push(temp);
			}
			else{
				Operator temp = (Operator)e;
				Number num2 = number.pop();
				Number num1 = number.pop();
				number.push(temp.Evaluate(num1, num2));
			}
		}
		
		result = number.peek();
	}
	
	public Number getResult(){
		return result;
	}
}
