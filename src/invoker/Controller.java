package invoker;

import java.awt.Color;


/**
 * This class shows how a JFrame window can be manipulated from outside the GUI-class.
 * SwingUtilities.invokeLater() puts any Runnable object on the Event Dispatch Queue 
 * so it can manipulate the GUI components as long as it can get hold of a reference to the components.
 * Since every method that is called from the EDQ runs in the Queue as well, you just need to write the required
 * functionality as public methods of the GUI class.
 */

import javax.swing.SwingUtilities;

public class Controller {

	private static MyFrame f = new MyFrame();

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {f.start();});
		
		// f.start(); Uncomment to start the GUI on the main thread. Not recommened though possible.
		
		
		while (true) {
			SwingUtilities.invokeLater(() -> f.setButton(new Color(getR(), getR(), getR()))); // This Lamda expression writes a new color to the GUI's button
			try {																			  // it calls the setButton()-method of the GUI class and is assigned
				Thread.sleep(2000);															  // to the Event Dispatch Queue via the invokeLater() call. 
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	} // end of main()

	private static float getR() {
		return (float) Math.random();
	} // end of getR()
} // end of class
