package javaDoc;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
/**
 *The ImprovedCalculator program calculates the maximum and minimum number
 * @author Gizem Ece Yılmaz
 * @version build 1.8.0_72-b15
 */


public class ImprovedCalculator extends JFrame {
	JButton button1,button2 ;
	JLabel label1, label2, label3, label4,label5,label6,label7,label8;
	JTextField textField1, textField2, textField3, textField4, textField5;
	JRadioButton maxnumber, minnumber;
	int number1,number2,number3,number4,number5,result;


	public ImprovedCalculator(){
		setSize(400,400);
		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("My Calculator");

		JPanel myPanel = new JPanel(new GridLayout(8,2));


		label1 = new JLabel("First Number");
		myPanel.add(label1);
		textField1 = new JTextField("",5);
		myPanel.add(textField1);
		label2 = new JLabel("Second Number");
		myPanel.add(label2);
		textField2 = new JTextField("",5);
		myPanel.add(textField2);
		label3 = new JLabel("Third Number");
		myPanel.add(label3);
		textField3 = new JTextField(" ",5);
		myPanel.add(textField3);
		label4 = new JLabel("Forth Number");
		myPanel.add(label4);
		textField4 = new JTextField(" ",5);
		myPanel.add(textField4);
		label5 = new JLabel("Fifth Number");
		myPanel.add(label5);
		textField5 = new JTextField(" ", 5);
		myPanel.add(textField5);
		label6 = new JLabel("Select");
		myPanel.add(label6);

		maxnumber = new JRadioButton("max-number");
		minnumber = new JRadioButton("min-number");
		ButtonGroup operation = new ButtonGroup();

		operation.add(maxnumber);
		operation.add(minnumber);

		JPanel operPanel = new JPanel(new GridLayout(1,2));
		operPanel.add(maxnumber);
		operPanel.add(minnumber);
		maxnumber.setSelected(true);
		myPanel.add(operPanel);

		label7 = new JLabel("Result");
		myPanel.add(label7);
		label8 = new JLabel("");
		myPanel.add(label8);

		button1 = new JButton("Calculate");
		myPanel.add(button1);
		button2 = new JButton("Clear");
		myPanel.add(button2);

		ListenForButton lForButton = new ListenForButton();
		button1.addActionListener(lForButton);
		button2.addActionListener(lForButton);

		add (myPanel);
		setVisible(true);
		setResizable(true);

	}
	/**
	 * The ListenForButton method defines what should be done when an user performs 
	 * a certain action.
	 * 
	 * @author Gizem Ece Yilmaz
	 *
	 */
	public class ListenForButton implements ActionListener{
		/**
		 * The actionPerformed is invoked when an action occur
		 * @param ActionEvent
		 * @param event
		 * 
		 */

		public void actionPerformed(ActionEvent event){
			if(event.getSource()==button1){
				try{

					number1=Integer.parseInt(textField1.getText().trim());
					number2=Integer.parseInt(textField2.getText().trim());
					number3=Integer.parseInt(textField3.getText().trim());
					number4=Integer.parseInt(textField4.getText().trim());
					number5=Integer.parseInt(textField5.getText().trim());
				}
				catch(NumberFormatException excep){
					JOptionPane.showMessageDialog(ImprovedCalculator.this, "Please enter the right info","Error",JOptionPane.ERROR_MESSAGE);
					System.exit(0);

				}
				if(maxnumber.isSelected()){ 
					result = max(number1,number2,number3, number4,number5);
					label8.setText(Integer.toString(result));


				}else{ 
					result = min(number1,number2,number3, number4,number5);
					label8.setText(Integer.toString(result));
				}
			}else if(event.getSource()==button2){
				textField1.setText("");
				textField2.setText("");
				textField3.setText("");
				textField4.setText("");
				textField5.setText("");
				label8.setText(" ");

			}
		}
	}
	/**
	 * it returns maximum number in the list
	 * @param n
	 * @return the maximum number 
	 */
	public static int max(int... n) {
		int i = 0;
		int max = n[i];

		while (++i < n.length)
			if (n[i] > max)
				max = n[i];

		return max;
	}
	/**
	 * it returns minimum number in the list
	 * @param n
	 * @return the minimum number
	 */
	public static int min(int... n) {
		int i = 0;
		int min = n[i];

		while (++i < n.length)
			if (n[i] < min)
				min= n[i];

		return min;
	}
	/**
	 * This is the main method which makes use of Calculator method.
	 * @param args
	 * @return nothing
	 */

	public static void main(String[] args) {
		new ImprovedCalculator();

	}

}
