package observer;

public class Controller {

	public static void main(String[] args) throws InterruptedException {
		TextField tf = new TextField("Watchful");							//Instantiates a class which prepares a simple window including an EventListener
		tf.start();															// Calls a method that initialises the prepared window.		
		Thread.sleep(10000);					
		if (tf.start())														// In case the window has been closed within the first 10 seconds of opening, it gets restarted at this point.
			System.out.println("Restarted");
		else
			System.out.println("Still running");

	} // end of main()
} // end of class