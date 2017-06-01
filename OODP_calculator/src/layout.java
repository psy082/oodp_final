
import java.awt.*;
import javax.swing.*;

public class layout{
	
	//setLayout(new GridLayout(4,4));
	
	public static void main(String[] args){
		JFrame f= new JFrame();
		f.setSize(500, 500);
		f.setLayout(new BorderLayout());
		
		JPanel P1 = new JPanel();
		JPanel P2 = new JPanel();
		
		int num = 16;
		
		JTextField T = new JTextField("", 30);
		
		P1.add(T);
		
		P2.setLayout(new GridLayout(4,4));
		JButton button[] = new JButton[num];
		String btn[] = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "C", "0", "=", "+"};
		
		for (int i=0; i<num; i++){
			button[i] = new JButton(btn[i]);
			P2.add(button[i]);
		}
		
		f.add(P1,BorderLayout.NORTH);
		f.add(P2,BorderLayout.CENTER);
		f.setVisible(true);
	}
}
