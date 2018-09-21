package swingworker;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

public class MyFrame extends JFrame {

	/**
	 * This class shows how the run processes in the a thread different from the GUI thread or the Event Dispatch Queue 
	 * and yet be able to write back results of a longer process to the GUI
	 */
	private static final long serialVersionUID = 1L;

	private Container pane;
	
	private JButton btn, hbtn;
	
	private JTextField field;
	
	private String title;
	
	private volatile SwingWorker<String,Integer> worker;
	
	private JPanel panel;
	
	private Integer count;
	
	public MyFrame(String var) {
		this.title = var;
		this.setTitle(title);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);		
		init();
	} // end of constructor()
	
	private void init() {
		this.count = 0;
		this.pane = this.getContentPane();
		this.btn = new JButton("GO");
		this.hbtn = new JButton("Halt");
		this.btn.addActionListener((x) -> this.go());
		this.hbtn.addActionListener((x) -> this.halt());
		this.field = new JTextField("0");
		this.panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		this.panel.add(btn);
		this.panel.add(hbtn);		
		pane.add(field, BorderLayout.NORTH);
		pane.add(panel, BorderLayout.SOUTH);		
	} // end of init()
	
	public void start() {
		this.pack();
		this.setVisible(true);
	} // end of start()
	
	private void go() {						// Triggered by the 'GO'-button 
		 worker = new SwingWorker<>() {   		// Must be a new instance every time you call the method. Anonymous version and 
			 									// must be inside the GUI class to access all components.
			@Override
			protected String doInBackground() { // Creates a GUI independent background thread that is started with 'worker.execute()' 
				while(!worker.isCancelled()) {	// You can write to the GUI from here for as long as the cancelled-flag is not set on the worker object.			
					publish(count);				// Publishes the result of the background thread by sending it to process()-method
					count++;
				}
				return "Done";					// When the method is done an object or null is sent to the done()-method 
			} // doInBackground()
			

			@Override
			protected void process(List<Integer> chunks) { 	        // This is the actual method that writes data from the logic thread to the GUI thread.				
				Integer value = chunks.get(chunks.size()-1); 		// The results may be delivered in chunks, so try to get the last item and write it.
				field.setText(value.toString());
			} // end of process()


			@Override
			protected void done() {								// Once the background thread is finished it triggeres the done()-method. If you override it you may write things to the GUI from here.				
			try {
				field.setText(this.get());						// This get()- call gets the final value of the backgroud calculation 
			} catch (InterruptedException | ExecutionException | CancellationException e) {				
				System.out.println("Process interrupted.");
			}				
			}};													// end of SwingWorker implementation	
			
			worker.execute();									// Starts the swing Worker process
	} // end of go()
	
	private void halt() {
		this.worker.cancel(true);								// This call sets the cancelled flag on the worker object	
	} // end of halt()
} // end of class
