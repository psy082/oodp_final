import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class CalculatorFrame extends JFrame {
	
	static JTextArea T = new JTextArea();
	static int num = 25;
	static String input="";
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
							
	ActionListener ac=new Action();
	
	public CalculatorFrame() {
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
					//input 보내기
					input = "";
					T.setText(input);
				}
				
				else if (text.equals("C")){
					input = "";
					T.setText(input);
				}
				
				else{
					input += text;
					T.setText(input);
				}
				
				old_input += old;
			}catch(Exception ee){};
			
		}
	}
	
	public static void main(String[] args){
		new CalculatorFrame();
	}



}