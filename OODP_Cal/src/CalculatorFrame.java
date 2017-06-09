import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class CalculatorFrame extends JFrame {
	
	Calculator c;
	static JTextArea T = new JTextArea();
	static int num = 25;
	static String input=" ";
	boolean start = false;
	static String old_input="";
	static String old="";
	static String text="";
	static JButton button[] = new JButton[num];
	static String btn[] = {
			"log", "exp", "C", "", "/", 
			"sin", "7", "8", "9", "*", 
			"cos", "4", "5", "6", "-", 
			"tan", "1", "2", "3", "+", 
			"(", ")", "0", ".", "=" 
			};
							
	ActionListener ac = new Action();
	
	static private CalculatorFrame instance;
	
	public static CalculatorFrame getInstance(){
		if (instance == null)
			instance = new CalculatorFrame();
		
		return instance;
		
	}
	
	private CalculatorFrame() {
		super("calculator");
		JFrame f= new JFrame();
		f.setSize(500, 500);
		f.setLayout(new BorderLayout());
		
		JPanel P1 = new JPanel();
		JPanel P2 = new JPanel();
		
	
		T.setEditable(false);
		P1.add(T);
		P2.setLayout(new GridLayout(5,5));
		
		for (int i=0; i<num; i++){
			button[i] = new JButton(btn[i]);
			button[i].addActionListener(ac);
			P2.add(button[i]);
		}
		
		f.add(P1,BorderLayout.NORTH);
		f.add(P2,BorderLayout.CENTER);
		f.setVisible(true);
	}

	
	class Action implements ActionListener {
		public void actionPerformed(ActionEvent e){
			try{
				String operator = "+-*/cossintanexplog";
				old = text;
				
				text = e.getActionCommand();
				
				if (operator.indexOf(text) != -1){
					if (operator.indexOf(old) != -1){
						throw new Exception();
					}
				}
			
				if (text.equals("=")){
					
					input += '=';
					c = new Calculator(input);
					input= "";
					start = true;
					
					T.setText(c.getResult());
				
				}
				
				else if (text.equals("C")){
					input = "";
					T.setText(input);
				}
				
				else if (start == true){
					input = text;
					T.setText(input);
					start = false;
				}
				
				else{
					input += text;
					T.setText(input);
				}
				
				old_input += old;
			}catch(Exception ee){};
			
		}
	}



}