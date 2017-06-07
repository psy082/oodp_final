import java.util.Stack;

public class ToPostFix {
	
	private Stack<Element> infix;
	private Stack<Element> postfix;

	ToPostFix(Stack<Element> _infix){
		infix = _infix;
		postfix = new Stack<Element>();
		
		transformPostFix();
	}
	
	public void transformPostFix(){
		
		Stack<Operator> op = new Stack<Operator>();
		
		for(Element e: infix){
			if(e instanceof Plus){
				Plus temp = (Plus)e;
				
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
			else if(e instanceof ParanthL){
				ParanthL temp = (ParanthL)e;
				op.push(temp);
			}
			else if(e instanceof ParanthR){
				Operator top = 	op.pop();
				
				while(!(top instanceof ParanthL)){
					postfix.add(top);
					top = op.pop();
				}
			}
			else{
				postfix.add(e);
			}
		}
		
		while(!op.isEmpty()){
			postfix.add(op.pop());
		}
	}
	
	public Stack<Element> getPostFix(){
		return postfix;
	}
}
