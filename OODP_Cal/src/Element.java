
public class Element{	

	protected enum Type {OP, INT, FLOAT};
	protected Type type;
	protected String value;
	
	Element(){}
	
	Element(String _value) {
		value = _value;
	}; 
	
	public void setType(Type _type){
		type = _type;
	}
	
	public Type getType(){
		return type;
	}	
	
	public String getValue()
	{
		return value;
	}
	
	public void setValue(String _value){
		value = _value;
	}
}

