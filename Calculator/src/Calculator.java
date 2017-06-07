
public class Calculator {
	
	private Parser p;
	private ToPostFix pf;
	private Evaluator ev;
	private String input;
	private String result;
	
	Calculator(String _input)
	{
		input = _input;
		p = new Parser(input);
		pf = new ToPostFix(p.getInfix());
		ev = new Evaluator(pf.getPostFix());
		
		if(ev.getResult().getType() == Element.Type.INT){
			IntegerNumber temp = (IntegerNumber)ev.getResult();
			result = Integer.toString(temp.getInteger());
		}
		else {
			FloatNumber temp = (FloatNumber)ev.getResult();
			result = Float.toString(temp.getFloat());
		}
	}
	
	public String getResult(){
		return result;
	}
	
	static public void main(String[] args){
		String in = "(1+2)*2=";
		
		Calculator c = new Calculator(in);
		System.out.println(c.getResult());
	}
}
