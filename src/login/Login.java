package login;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {

	/**
	 * This class shows some principles of how to layout a GUI window. Reusing code to set Constraints and ActionListener.
	 * It is also a good reference point for further information on the different components (see links) 
	 * TUTORIAL ON: JComponent class ->
	 * https://docs.oracle.com/javase/tutorial/uiswing/components/jcomponent.html
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Container pane;

	private LayoutManager manager; // Using LayoutManagers:
									// https://docs.oracle.com/javase/tutorial/uiswing/layout/using.html

	private GridBagConstraints constraint;

	private JLabel name, pass;

	private JTextField nfield; // Using JTextComponents:
								// https://docs.oracle.com/javase/tutorial/uiswing/components/text.html

	private JPasswordField pfield;

	private JButton okbtn, escbtn; // Using Key Bindings:
									// https://docs.oracle.com/javase/tutorial/uiswing/misc/keybinding.html

	

	static {
		JFrame.setDefaultLookAndFeelDecorated(true); // Setting an L&F:
														// https://docs.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
	}

	public Login(String title) {
		super(title);
		this.setSize(250, 150); // Setting properties:
								// https://docs.oracle.com/javase/tutorial/essential/environment/properties.html
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(new ImageIcon("C:\\Users\\user\\Pictures\\default.jpg").getImage());
		this.setResizable(false);
		init();
		config();
		
	}
	
	public void start() {
		this.setVisible(true);
	}

	private void init() {
		pane = this.getContentPane(); // The return type of this call is an awt.Container. If you'd like to use
										// JComponent functionality
										// create your own JPanel object and call JFrame.setContentPane(jpanel)
		manager = new GridBagLayout();
		constraint = new GridBagConstraints();
		name = new JLabel("Username");
		pass = new JLabel("Password");
		nfield = new JTextField();
		pfield = new JPasswordField();
		okbtn = new JButton("OK");
		okbtn.setFont(new Font("Verdana", Font.BOLD, 10)); // Sets the font family, font type, and font size
		okbtn.addActionListener((x) -> this.Button(okbtn)); // Set an ActionListener via Lamda and call an instance method
		okbtn.setName("OK-Button");
		escbtn = new JButton("CANCEL");
		escbtn.setForeground(Color.RED); // Sets the color of the characters
		escbtn.setName("ESC-Button");
		escbtn.addActionListener((x) -> this.Button(escbtn)); // Set an ActionListener via Lamda and call an instance method
	} // end of init()

	private void config() {
		pane.setLayout(manager);
		pane.setBackground(Color.LIGHT_GRAY); // Sets colour to the background
		constrainer(4, 0, 0, 1, name);
		constrainer(4, 0, 1, 1, pass);
		constrainer(4, 1, 0, 2, nfield);
		constrainer(4, 1, 1, 2, pfield);
		constrainer(4, 1, 2, 1, okbtn);
		constrainer(4, 2, 2, 1, escbtn);
	} // end of config()

	private void constrainer(int inset, int x, int y, int width, JComponent comp) {
		constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.insets = new Insets(inset, inset, inset, inset);
		constraint.gridx = x;
		constraint.gridy = y;
		constraint.gridwidth = width;
		pane.add(comp, constraint); // The call frame.add(JComponent) will work as well as the add()-method of contentPane has been overridden.
	} // end of constrainer()

	private void Button(JComponent btn) {
		btn = (JButton) btn;
		if (btn.getName().equals(okbtn.getName())) {
			System.out.println("Jupp, you pressed the OK-Button");
		} else {
			System.out.println("The action came from the component with Z-index: " + this.getComponentZOrder(btn));
		}
	} // end of Button

} // end of class
