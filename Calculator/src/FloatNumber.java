public class FloatNumber extends Number{

	FloatNumber(String _value)
	{
		super(_value);
		type = Type.FLOAT;
		floating_point = Float.parseFloat(value);
	}

	public void setFloat(float value){
		floating_point = value;
	}
	
	public float getFloat(){
		return floating_point;
	}
}
