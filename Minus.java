
public class Minus extends Operator{

	public Minus(){
		this.priority=12;
		this.id='-';
	}
	
	public int operate(int a, int b) {
		return a-b;
	}
	
	public char getChar(){
		return id;
	}

}

