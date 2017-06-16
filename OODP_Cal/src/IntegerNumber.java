/* IntegerNumber is for storing integer number
 * This has setter and getter method and its type is int
 */
public class IntegerNumber extends Number{
	
	IntegerNumber(String _value)
	{
		super(_value);
		type = Type.INT;
		integer = Integer.parseInt(value);
	}

	public void setInteger(int value){
		integer = value;
	}

	public int getInteger(){
		return integer;
	}
}
