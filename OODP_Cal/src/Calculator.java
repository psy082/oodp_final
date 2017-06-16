/* Top class of calculator implementation
 * Calculator class has Parser, ToPostFix, Evaluator instance
 * The series of processing among three instance final result is made
 */
public class Calculator {
	
	private Parser p;
	private ToPostFix pf;
	private Evaluator ev;
	private String input;
	private String result;
	
	//Calculator constructor instantiates Parser, ToPostFix, Evaluate class
	//Each of input gets from each of outputs 
	//Parser passes its result to ToPostFix, ToPostFix passes its result to Evaluator
	//The result of Evaluator is stored in result variable of string
	Calculator(String _input)
	{
		input = _input;
		p = new Parser(input);
		pf = new ToPostFix(p.getInfix());
		ev = new Evaluator(pf.getPostFix());
		
		//The result is transformed to string in spites of its type
		if(ev.getResult().getType() == Element.Type.INT){
			IntegerNumber temp = (IntegerNumber)ev.getResult();
			result = Integer.toString(temp.getInteger());
		}
		else {
			FloatNumber temp = (FloatNumber)ev.getResult();
			result = Float.toString(temp.getFloat());
		}
	}
	
	//getResult method returns result
	public String getResult(){
		return result;
	}
	

}
