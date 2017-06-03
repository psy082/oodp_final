
public class Plus extends Operator{

	public Plus(){
		this.id='+';
		this.priority=12;
	}
	
	public int operate(int a, int b) {
		return a+b;
	}
	public char getChar(){
		return id;

}
}

