package observer;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;


/**
 * This class creates a simple JFrame including a JTextField and a JButton. A document listener is assigned to the 
 * model of the TextField that reports changes to the shell. Furthermore there is an ActionListener assigned to the 
 * JButton that grabs what's currently in the text field and prints it to the shell. Then the ActionListener disposes off the
 * the window resources. 
 * @author user
 *
 */
public class TextField extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Container pane;
	
	private LayoutManager manager;
	
	private JButton btn;
	
	private JTextField field;
	
	private String $input;
	
	private Listener l;
	
	static {										  // Static block that is parsed at runtime and before the class is instantiated 
		JFrame.setDefaultLookAndFeelDecorated(true);  // Sets the default look and feel. Needs to be set before any JComponent is instantiated.
	}
	
	/**
	 * Understanding Swing in general : http://www.oracle.com/technetwork/java/architecture-142923.html
	 * @param title
	 */
	public TextField(String title) {
		super(title);								// Sets title
		this.setSize(200, 100);						// Sets window size
		manager = new BorderLayout();				// Sets the LayoutManager 
		pane = this.getContentPane();				// Instantiates the ContentPane
		pane.setLayout(manager);					// Assigns the manager to the pane
		field = new JTextField(10);					// Instantiates the TextField		
		l = new Listener();							// Intantiates the DokumentListener as Instance field 
		field.getDocument().addDocumentListener(l);	// Using models: https://docs.oracle.com/javase/tutorial/uiswing/components/model.html	
		btn = new JButton("OK");					// Instantiates JButton
		btn.addActionListener((x)-> {				// Adds an ActionListener to theJButton Lamda style 
			$input = field.getText();				
			System.out.println($input);
			this.dispose();							// Closes the window but keeps the swing thread alive. 
			});		
		pane.add(field, BorderLayout.NORTH); 		
		pane.add(btn,BorderLayout.SOUTH);		
	} // end of constructor()
	
	public Listener getListener() {
		return this.l;
	}
	
	public boolean start() {
		if(this.isShowing())						
			return false;
		else
			this.setVisible(true);					// Start or restart the window
		return true;
	}
} // end of class
