package innerclasses;


public class Controller {
	
	
	/**
	 * This class shows what happens to a JFrame when the dispose()-method is called and
	 * when the WindowEvent.WINDOW_CLOSING is send to the event-dispatch queue.
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		MyFrame m = new MyFrame();
		m.start();						// Starts the window
		Thread.sleep(10000);
		m.stop();						// Stops the window		
		Thread.sleep(2000);
		m.start();						// Restarts the window		
		Thread.sleep(2000);
		m.kill();						// Closes the application 
		Thread.sleep(1000);				// unreachable code	
		System.out.println("Going too...");

	} // end of main()
} // end of class
