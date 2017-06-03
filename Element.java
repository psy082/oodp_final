
public class Element implements ElementFactory{
	
	protected int priority;
	protected char id;

	public Element()
	{
		priority = 0;
	}
	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
	public char getChar(){
		return id;
	}
	public void setId(char n){
		id=n;
	}
	
	public void operation(Element e1, Element e2){}
	@Override
	public void operation(Element e) {
		// TODO Auto-generated method stub
		
	}
}

