package menubar;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

/**
 * This class provides a simple example of the Swing menu bar which is neither part of the JFrame nor the content pane.
 * It sits between the two and comes very handy when you want to categorize many options.
 * @author user
 *
 */

public class MenuBar  {
	
	private JFrame frame;
	private Container pane;
	private String title, name_1, name_2, name_3;
	
	public MenuBar(String title, String var_1, String var_2, String var_3) {
		this.title = title;
		this.name_1 = var_1;
		this.name_2 = var_2;
		this.name_3 = var_3;		
		init();
	} // end of constructor()
	
	private void init() {
		frame = new JFrame(title);						//  Creates the main JFrame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pane = frame.getContentPane();					//  Retrieves the content pane		
		pane.setLayout(new BorderLayout(10,10));		// Sets the layout manager				
		pane.add(makeTextField(),BorderLayout.CENTER);
		pane.add(makeTextField(), BorderLayout.EAST);
		pane.add(makeTextField(), BorderLayout.WEST);
		pane.add(makeTextField(), BorderLayout.NORTH);
		pane.add(makeTextField(), BorderLayout.SOUTH);
		frame.setJMenuBar(makeMenuBar());
		frame.pack();
		frame.setVisible(true);
	} // end of init()
	
	private JMenuBar makeMenuBar() {
		JMenuBar temp = new JMenuBar();
		temp.add(makeMenu(name_1));		
		temp.add(makeMenu(name_2));
		temp.add(makeMenu(name_3));
		return temp;
	}
	
	private JMenu makeMenu(String name) {
		JMenu temp =  new JMenu(name);
		temp.add(makeMenuItem(name+" Opt_1"));
		temp.addSeparator();
		temp.add(makeMenuItem(name+" Opt_2"));
		temp.addSeparator();
		temp.add(makeMenuItem(name + " Opt_3"));	
		return temp;
	} // end of makeMenu()
	
	private JMenuItem makeMenuItem(String name) {
		JMenuItem temp = new JMenuItem(name);
		if(name.startsWith("File")){
		temp.addActionListener((x) -> pane.getComponent(0).setBackground(Color.BLACK));
		} else if (name.startsWith("Edit")) {
			temp.addActionListener((x) -> pane.getComponent(0).setBackground(Color.BLUE));	
		} else {
			temp.addActionListener((x) -> pane.getComponent(0).setBackground(Color.GREEN));
		}
		return temp;		
	} // end of makeMenu()
	
	// Configures the JTextFields
	private JTextField makeTextField() {
		JTextField temp = new JTextField();
		temp.setText("Text Text Text");						// Sets the text			
		temp.setFont(new Font("Times", Font.BOLD, 20));		// Sets the Font (family, style, size)
		temp.setHorizontalAlignment(JTextField.CENTER);		// Alignment within the TextField
		temp.setBackground(Color.LIGHT_GRAY);				// Background colour
		temp.setForeground(Color.GREEN);					// Text colour
		return temp;
	} // end of makeTextField()
	
	

} // end of class
