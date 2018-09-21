package innerclasses;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * This class uses an inner class to access the components of a window.
 * An ActionListener is implemented in the inner class and receives events
 * from the window's button. It then takes the content of the text field, reverses it
 * and writes it back to the field. It demonstrates how to trigger small events with GUI-modifying effects.
 * @author pauliman
 *
 */
public class MyFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Container pane;
	
	private LayoutManager manager;
	
	private JTextField field;
	
	private JButton btn;
	
	public MyFrame() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pane = this.getContentPane();
		this.manager = new BorderLayout();
		pane.setLayout(manager);
		this.btn = new JButton("Reverse");
		this.btn.setBackground(Color.BLUE);
		this.btn.setPreferredSize(new Dimension(100,30));
		this.btn.addActionListener(new MyListener());
		this.field = new JTextField();
		this.field.setPreferredSize(new Dimension(100,15));
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
	
	public boolean stop() {							// Stops the window and releases all resources
		if(this.isShowing())
			this.dispose();
		else
			return false;
		return true;
	} // end of stop()
	
	public void kill() {							// Closes the entire application including the controller
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}
	
	// Nested class implementing the event listener in the pre-Lamda way. Runs in the Event Dispatch Thread and has access to all GUI resources. 
	private class MyListener implements ActionListener{				
		@Override
		public void actionPerformed(ActionEvent e) {
			StringBuilder a = new StringBuilder(field.getText());
			a.reverse();
			field.setText(a.toString());
		} // end of ActionPerformed()
		
	} // end of nested class

} // end of class
