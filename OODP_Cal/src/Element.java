/* Element Class is element class for all of components of Calculator 
 * Element Class can be extended to Number or Operator elements  
 * This has enumerator type which determines type of element.
 */ 
public class Element{	

	//Chillren of Elements are one of three types, OP, INT, FLOAT. 
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

