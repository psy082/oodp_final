import java.util.Stack;
/* ToPostFix class is for transforming infix notation to postfix notation
 * ToPostFix class gets infix notation stored in stack and makes it postfix notation
 * postfix notation is also stored in stack
 */
public class ToPostFix {
	
	private Stack<Element> infix;
	private Stack<Element> postfix;

	//ToPostFix constructor gets infix notation and calls transformPostFix method
	ToPostFix(Stack<Element> _infix){
		infix = _infix;
		postfix = new Stack<Element>();
		
		transformPostFix();
	}
	
	
	public void transformPostFix(){
		
		//Operators each have operation priority 
		//Another op stack need to store operators according to their priority
		//Operators are stored in op stack temperarily before stored in stack
		Stack<Operator> op = new Stack<Operator>();
		
		//Infix notation is read from the begin to end
		for(Element e: infix){
			//if element is operator, it is narrowed to its real instance
			if(e instanceof Plus){
				Plus temp = (Plus)e;
				
				//if op stack is empty, new operator is stored in op stack to compare priority to later operator
				//and if there is left parantheses, the operator is stored in stack directly 
				if(!op.isEmpty() && op.peek().getPriority() != 19){
					//If it go over two conditions, pop every operator which has higher priority than the new operator
					//and stores poped operator into postfix stack
					while(!op.isEmpty() && temp.getPriority() <= op.peek().getPriority()){
						postfix.add(op.pop());
					}
					//After the comparision priority, the new operator is stored in op stack
					op.push(temp);
				}
				else{
					op.push(temp);
				}
			}
			else if(e instanceof Minus){
				Minus temp = (Minus)e;	
				
				if(!op.isEmpty() && op.peek().getPriority() != 19){
					while(!op.isEmpty() && temp.getPriority() <= op.peek().getPriority()){
						postfix.add(op.pop());
					}
					op.push(temp);
				}
				else{
					op.push(temp);
				}
			}
			else if(e instanceof Multiply){
				Multiply temp = (Multiply)e;
				
				if(!op.isEmpty() && op.peek().getPriority() != 19){
					while(!op.isEmpty() && temp.getPriority() <= op.peek().getPriority()){
						postfix.add(op.pop());
					}
					op.push(temp);
				}
				else{
					op.push(temp);
				}
			}	
			else if(e instanceof Division){
				Division temp = (Division)e;
				
				if(!op.isEmpty() && op.peek().getPriority() != 19){
					while(!op.isEmpty() && temp.getPriority() <= op.peek().getPriority()){
						postfix.add(op.pop());
					}
					op.push(temp);
				}
				else{
					op.push(temp);
				}
			}
			//If the Element is left paranthesis, it is stored in op stack to tie a bunch of operator before right paranthesis
			else if(e instanceof ParanthL){
				ParanthL temp = (ParanthL)e;
				op.push(temp);
			}
			//If the Element is right paranthesis, is pops every operator and stores them into postfix stack until it meets left paranthesis
			else if(e instanceof ParanthR){
				Operator top = 	op.pop();
				
				while(!(top instanceof ParanthL)){
					postfix.add(top);
					top = op.pop();
				}
			}
			//Non of above cases, it is number
			//So, nubmer is store in postfix stack
			else{
				postfix.add(e);
			}
		}
		
		//The lest of operators stored in op stack is transfered into postfix stack
		while(!op.isEmpty()){
			postfix.add(op.pop());
		}
	}
	
	//getpostFix method returns postfix stack
	public Stack<Element> getPostFix(){
		return postfix;
	}
}
