
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
	
	protected Type resolve_type(Number e1, Number e2){
		if(e1.getType() ==Type.INT && e2.getType() ==Type.INT){
			return Type.INT;
		}
		else{
			return Type.FLOAT;
		}
			
	}
	
	abstract public Number operation(Number _e1, Number _e2, Type _type);
	
	abstract public Number operation(Number _e, Type _type);
}

