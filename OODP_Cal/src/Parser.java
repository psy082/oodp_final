import java.util.Stack;
/* Parser class is for parsing infix expression and storing it into the stack
 */
public class Parser {
	
	private String input;
	
	private Stack<Element> infix;
		
	//Parser constructor stores expression and calls parsing method 
	//Infix notation which is stored in stack is made by parsing method
	Parser(String _input) {
		infix = new Stack<Element>();
		input = _input;
		parsing();
	}
	//parsing method reads every single inputs and stores into stack
	public void parsing() {
	
		
		//Is is imporatant that seperates numbers and operator in the process of parsing
		//To do this, String number variable is used
		String number = "";
		
		//If input is digit, digit is stored in number variable
		//Also, if there is dot, dot is stored in number variable
		for(int i = 0; i < input.length(); i++){
			switch (input.charAt(i)){
			
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
			case '.': {
				number += input.charAt(i);
				break;
			}
		        //before plus operator is stored in stack, push_number method is called to store a unit of number
			//if there is paranthesis before plus operator, number variable is empty
			//In this case, it makes error to call push_number 
		        //so, only number is not empty push_number method is called to avoid error
			case '+': {
				if(number != ""){
					push_number(number);
					number = "";
				}
				infix.push(new Plus("+"));
				break;
			}
			case '-': {
				if(number != ""){
					push_number(number);
					number = "";
				}
				infix.push(new Minus("-"));
				break;
			}
			case '*': {
				if(number != ""){
					push_number(number);
					number = "";
				}
				infix.push(new Multiply("*"));
				break;
			}
			case '/': {
				if(number != ""){
					push_number(number);
					number = "";
				}
				infix.push(new Division("/"));
				break;
			}
			//It can not be the cases number is before left paranthesis in expression
			//So, only storing left paranthesis is done
			case '(': {
				infix.push(new ParanthL("("));
				break;
			}
			case ')': {
				if(number != ""){
					push_number(number);
					number = "";
				}
				infix.push(new ParanthR(")"));
				break;
			}
			//equal operator means that expression is finished 
			//If there is number before the equal operator, number is stored in stack 
			//Otherwise, breaks the loop
			case '=': {
				if(number != ""){
					push_number(number);
					number = "";
				}
				break;
			}		
			default: {
				break;
			}
			}
		}
	}
	
	//push_number method is to store a unit of number into the stack 
	//if a unit of number has dot, it means that that number is floating point number
	//so, in this case this number is stored in stack as FloatNumber instance
	//In the other case, that number is stroed in stack as IntegerNumber instance
	public void push_number(String number) {
		if(number.contains(".")){
			if(number.charAt(number.length() - 1) == '.')
			{
				number += '0';
				infix.push(new FloatNumber(number));
			}
			else
			{
				infix.push(new FloatNumber(number));	
			}
		}
		else {
			infix.push(new IntegerNumber(number));
		}
	}
	
	//getInfix method returns infix stack
	public Stack<Element> getInfix(){
		return infix;
	}
}
