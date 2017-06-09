
public class ParanthL extends Operator {
	
	public ParanthL(String _op){
		super(_op);
		this.priority = 19;
	}

	@Override
	public Number operation(Number _e1, Number _e2, Type _type) {
		return null;
	}

	@Override
	public Number operation(Number _e, Type _type) {
		return null;
	}
}

