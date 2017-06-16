/* ParanthL class extends Operator class and this is for storing left paranthesis 
 * The purpose of this class is marking operation priority so, its operation method is null
 */
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

