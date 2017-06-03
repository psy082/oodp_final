

public class Division extends Operator{

	public Division()
	{
		this.priority=13;
		this.id='/';
	}

	public int operate(int a, int b) {
		return a/b;
	}
	
	public char getChar(){
		return id;
	}

}

