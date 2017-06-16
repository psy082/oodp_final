import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/* Layout for calculation that has button, text field etc.
 */
public class CalculatorFrame extends JFrame {
   
   Calculator c;
   static JTextArea T = new JTextArea();
   static int num = 20;                               // number of buttons
   static String input=" ";                           // equation
   boolean start = false;                             // whether new equation starts
   static String old_input="";                        // equation until the last
   static String old="";
   static String text="";                             // value coming from buttons
   
   static JButton button[] = new JButton[num];
   static String btn[] = { // value of buttons
         "(", ")", "C", "/", 
         "7", "8", "9", "*", 
         "4", "5", "6", "-", 
         "1", "2", "3", "+", 
         "", "0", ".", "=" 
         };
                     
   ActionListener ac = new Action();
   
   /*
    * For SingleTone pattern 
    */
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
      P1.add(T);                                    // attach the text filed on the panel
      P2.setLayout(new GridLayout(5,4));
      
      // attach the buttons on the panel	   
      for (int i=0; i<num; i++){ 
         button[i] = new JButton(btn[i]);
         button[i].addActionListener(ac);
         P2.add(button[i]);
      }
      
      // attach the panel on the frame
      f.add(P1,BorderLayout.NORTH); 
      f.add(P2,BorderLayout.CENTER);
      f.setVisible(true);
   }

   
   class Action implements ActionListener {
      public void actionPerformed(ActionEvent e){
         try{
            String operator = "+-*/";
            old = text;
            
            text = e.getActionCommand();
            
	    // when operation comes in succession
            if (operator.indexOf(text) != -1){ 
               if (operator.indexOf(old) != -1){
                  throw new Exception();             // error
               }
            }
		 
            // when the equation ends
            if (text.equals("=")){ 
               
               input += '=';
               c = new Calculator(input);
               input= "";
               start = true;
               
               T.setText(c.getResult());
            
            }
		 
            //when Clear button is pressed
            else if (text.equals("C")){ 
               input = "";
               T.setText(input);
            }
		 
            // when the equation starts
            else if (start == true){ 
               input = text;
               T.setText(input);
               start = false;
            }
            
	    //when the equation goes on
            else{ 
               input += text;
               T.setText(input);
            }
            
            old_input += old;
         }catch(Exception ee){}     
      }
   }
}
