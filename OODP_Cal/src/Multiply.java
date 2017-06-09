
public class Multiply extends Operator{

	public Multiply(String _op){
		super(_op);
		priority = 13;
	}

	@Override
	public Number operation(Number _e1, Number _e2, Type _type) {
		if(_type == Type.INT){
			IntegerNumber e1 = (IntegerNumber)_e1;
			IntegerNumber e2 = (IntegerNumber)_e2;
			
			return new IntegerNumber(Integer.toString(e1.getInteger() * e2.getInteger()));
		}
		if(_type == Type.FLOAT){
			FloatNumber e1 = (FloatNumber)_e1;
			FloatNumber e2 = (FloatNumber)_e2;
			
			return new FloatNumber(Float.toString(e1.getFloat() * e2.getFloat()));
		}		
		return null;
	}

	@Override
	public Number operation(Number e, Type _type) {
		return null;
	}
	
}

