
public class Multiply extends Operator{

	public Multiply(){
		this.priority=13;
		this.id='*';
	}
	public int operate(int a, int b) {
		return a*b;
	}
	
	public char getChar(){
		return id;

}
}

