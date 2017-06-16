/* Operator Class is for storing every single operator to calculate
 * This extends Element class and its type is OP and the type of every its children is also OP
 * Operator class is abstract class which has abstract method, operation
 * evaluate method is template method which defers calculation to its child
 * Its child class completes operation method to calculate
 */ 
public abstract class Operator extends Element{
	
	protected int priority;
	protected String op;
	
	public Operator(String _op)
	{
		super(_op);
		type = Type.OP;
		op = _op;
	}
	
	protected int getPriority() {
		return priority;
	}

	protected void setPriority(int _priority) {
		priority = _priority;
	}
	
	protected String getOp() {
		return op;
	}
	
	protected void setOp(String _op)
	{
		op = _op;
	}
	
	//Evaluate method is template method which is completed in child of Operator Class, by overriding operation method
	protected Number Evaluate(Number e1, Number e2)
	{
		Type re_type = resolve_type(e1, e2);
		Number result = new Number();
		
		if(re_type == Type.INT){
			result = operation(new IntegerNumber(e1.getValue()), new IntegerNumber(e2.getValue()), Type.INT);
		}
		else{
			result = operation(new FloatNumber(e1.getValue()), new FloatNumber(e2.getValue()), Type.FLOAT);
		}
			
		return result;
	}
	
	//resolve_type method is for let evaluator know which type will be right, from the two of Number inputs
	protected Type resolve_type(Number e1, Number e2){
		if(e1.getType() ==Type.INT && e2.getType() ==Type.INT){
			return Type.INT;
		}
		else{
			return Type.FLOAT;
		}
			
	}
	
	//operation method is hook method which is overriden in the child of Operator class
	abstract public Number operation(Number _e1, Number _e2, Type _type);
	
	abstract public Number operation(Number _e, Type _type);
}

