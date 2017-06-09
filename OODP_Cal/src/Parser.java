import java.util.Stack;


public class Parser {
	
	private String input;
	
	private Stack<Element> infix;
		
	Parser(String _input) {
		infix = new Stack<Element>();
		input = _input;
		parsing();
	}
	
	public void parsing() {
	
		String number = "";
		
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
	

	public Stack<Element> getInfix(){
		return infix;
	}
	
}