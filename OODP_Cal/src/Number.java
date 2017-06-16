/* Number Class is for storing every single number as Number Element
 * This extends Element class and its type is integer or float
 * This has int and float field, but has no setter or getter method 
 * which is for only the child of this class has setter or getter method according to their type 
 */
public class Number extends Element{

	protected int integer;
	protected float floating_point;
	
	Number(){}
	
	Number(String _value) {
		super(_value);
	}
}
