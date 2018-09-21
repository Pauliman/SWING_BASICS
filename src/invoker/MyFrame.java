package invoker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class MyFrame extends JFrame {
	
	/**
	 * This class just provides a simple Button and TextField plus a nested class implementing an ActionListener
	 * and a public method setButton. While the ActionListener is a class-internal functionality that is executed on the Event Dispatch Queue,
	 * the setButton()-method is called from an external process which is also executed from the EDQ.
	 */
	private static final long serialVersionUID = 1L;

	private Container pane;
	
	private LayoutManager manager;
	
	private JTextField field;
	
	private JButton btn;
	
	public MyFrame() {
		System.out.println("The GUI is on the Event-Dispatch-Thread: " + SwingUtilities.isEventDispatchThread());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pane = this.getContentPane();
		this.manager = new BorderLayout();
		pane.setLayout(manager);
		this.btn = new JButton("Reverse");
		this.btn.setPreferredSize(new Dimension(100,50));
		this.btn.addActionListener(new MyListener());
		this.field = new JTextField();
		this.field.setPreferredSize(new Dimension(100,50));
		pane.add(btn, BorderLayout.SOUTH);
		pane.add(field, BorderLayout.NORTH);
		this.pack();
	}
	
	public boolean start() {						// Sets the window to visible
		if(this.isShowing())
			return false;
		else
			this.setVisible(true);
		return true;
	} // end of start()	
	
	private class MyListener implements ActionListener{				// Nested class implementing the event listener 
		@Override
		public void actionPerformed(ActionEvent e) {
			StringBuilder a = new StringBuilder(field.getText());
			a.reverse();
			field.setText(a.toString());
		} // end of ActionPerformed()		
	} // end of nested class

	// Accessed from outside to manipulate the background color of the button.
	public void setButton(Color color) {
		btn.setBackground(color);
	} // end of setButton()	
} // end of class
