import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.lang.Character;

public class Calculator {
	
	public static void main(String[] args)
	{
		Scanner stdin = new Scanner(System.in);
		String input = "(1+1)*2+1*2+1*3$";
		String postfixfix = "";
		int result =0;
		
		Element plus = new Plus();
		Element minus = new Minus();
		Element multiply = new Multiply();
		Element division = new Division();
		Element paranthR = new ParanthR();
		Element paranthL = new ParanthL();
		Element EOS = new EOS();
		
		Stack<Element> stack1 = new Stack<Element>();
		Stack<Element> stack2 = new Stack<Element>();
		ArrayList<Element> infix = new ArrayList<Element>();
		ArrayList<Element> postfix = new ArrayList<Element>();
		
		/*
		 * change infix : string -> arrayinfix
		 */
		for(int i=0;i<input.length();i++){
			if(input.charAt(i)=='$')
				infix.add(EOS);
			if(input.charAt(i)=='+')
				infix.add(plus);
			if(input.charAt(i)=='-')
				infix.add(minus);
			if(input.charAt(i)=='*')
				infix.add(multiply);
			if(input.charAt(i)=='/')
				infix.add(division);
			if(input.charAt(i)=='(')
				infix.add(paranthR);
			if(input.charAt(i)==')')
				infix.add(paranthL);
			if(Character.isDigit(input.charAt(i)))
			{
				Element operand = new Operand();
				operand.setId(input.charAt(i));
				infix.add(operand);
			}
		}
		
		/* infix to postffix */
		
		for(int i=0;i<infix.size();i++){
			
			if((infix.get(i).getChar())=='$')
			{
				while(!stack1.isEmpty())
					postfix.add(stack1.pop());
				break;
			}
			if((Character.isDigit(infix.get(i).getChar()))){
				postfix.add(infix.get(i));
			}
			else if((infix.get(i).getChar())==')')
			{
				while(!stack1.isEmpty() && stack1.peek().getChar() != '('){
						postfix.add(stack1.pop());
				}
			}
			else
			{
				if (!stack1.isEmpty() && infix.get(i).priority <= stack1.peek().priority) 
				{
                    postfix.add(stack1.pop());
                }
                stack1.push(infix.get(i));
			}
		}
		
		/*
		 * print out postfix result
		 */
		
		for(int i=0;i<postfix.size();i++)
			System.out.println(postfix.get(i).getChar());
		
		
		for(int i=0;i<postfix.size();i++)
		{
			if(postfix.get(i).getChar()=='(')
		       	continue;
			
			if(Character.isDigit(postfix.get(i).getChar()))
			{
				stack2.push(postfix.get(i));
				System.out.println("push! : "+stack2.peek());
			}
			
			else
			{
				Element op1=new Operand();
				Element op2=new Operand();
				Element op3=new Operand();
				
				int num1;
				int num2;
				
				op1=stack2.pop();
				op2=stack2.pop();
				
				
				num1=Character.digit(op1.getChar(), 10);
				num2=Character.digit(op2.getChar(), 10);
				
				System.out.println(num1);
				System.out.println(num2);
				
				char sel = postfix.get(i).getChar();
				System.out.println(sel);
				
				switch(sel)
				{
					case '+':
						result = num2+num1;
						break;
					case '-':
						result = num2-num1;
						break;
					case '*':
						result = num2*num1;
						break;
					case '/':
						if(num1==0){
							System.out.println("Arithmetic exception");
							break;
						}
						result = num2/num1;
						break;
				}
				
				System.out.println(result);
			
				if(result<10)
					op3.setId(Character.forDigit(result,10));  //TODO : Character.fordigit메소드는 9가 넘어가는 수를 char로 변환시켜주지 못함ㅠㅠ
			
				
				
				
				System.out.println("breakpoint; stage result:"+Character.digit(op3.getChar(), 10));
				
				stack2.push(op3);
				System.out.println("push stage result!:"+op3);
				
			}
			
		
			System.out.println("Calculation result"+result);
				
	}
}
}


	
	
	
	
	


