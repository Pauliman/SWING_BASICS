package sudoku;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;


/**
 * This class instantiates two slightly different Sudoku grids respectively. This class does not extend JFrame. 
 * Depending on the constructor call you will get a custom sized or a packed JFrame.
 * Furthermore there are it is shown how to set the JFrame to the middle of the screen and 
 * @author Pauliman
 *
 */
public class Grid {
	
	private JFrame frame;
	private Container pane;
	private int width, height;
	private String title;	
	
	public Grid(int width, int height, String title) {
		this.width = width;
		this.height = height;		
		this.title = title;
		prepareGrid();
		init_1();		
	} // end of constructor(1)
	
	public Grid(String title) {
		this.title = title;
		prepareGrid();
		init_2();
	} // end of constructor(2)
	
	/**
	 * Prepares the window, the layout manager and all the child-objects 
	 * that go into it. 
	 */
	private void prepareGrid() {
		JFrame.setDefaultLookAndFeelDecorated(true);	// Sets the way in which every subsequent JFrame is decorated.	
		frame = new JFrame(title);						// Creates the initial JFrame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);									 // Specifies what shall be done if the exit-button is clicked.		
		frame.setIconImage(new ImageIcon("C:\\Users\\user\\Pictures\\default.jpg").getImage());  // Sets a custom picture as icon
		frame.setResizable(false);						// Set whether or not the JFrame can be resized.
		pane = frame.getContentPane();					// Retrieves the content pane which acts as the root component
		pane.setLayout(new GridLayout(9,9));			// Sets the layout manager
		fillPane();										// ->
		
	} // prepareGrid()
	
	private void init_1() {
		frame.setSize(this.width,this.height);			// Sets width and height of the JFrame manually
		frame.setLocationRelativeTo(null);				//Sets the position of the JFrame to the center of the screen, but only if the size of the JFrame is set beforehand.
		frame.setVisible(true);							// Shows the JFrame on screen
	} // end of init_1()
	
	private void init_2(){
		frame.pack();									// Packs everything a compact a possible.
		frame.setLocationRelativeTo(null);				//Sets the position of the JFrame to the center of the screen, but only if the size of the JFrame is set beforehand.
		frame.setVisible(true);							// Shows the JFrame on screen
	} // end of init_2()
	
	private void fillPane() {
		for(int i = 0; i < 81; i++) {
			pane.add(getField(i));
		}
	} // end of fillCanvas()
	
	private JTextField getField(int x) {
		JTextField field = new JTextField();
		field.setEditable(true);
		field.setEnabled(true);
		field.setName("Field_" + x);
		field.setSize(50, 50);
		field.setText("OK");
		field.setHorizontalAlignment(JTextField.CENTER);
		field.setToolTipText("Enter a number 1 - 9");
		field.setBackground(Color.LIGHT_GRAY);
		field.setVisible(true);		
		return field;
	}
} // end of class
