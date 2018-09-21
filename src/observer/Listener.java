package observer;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;


public class Listener implements DocumentListener{

	
	@Override
	public void insertUpdate(DocumentEvent e) {
		try {
			System.out.println(e.getType().toString() + " " + e.getDocument().getText(e.getDocument().getLength() -1,1));
			
		} catch (BadLocationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	} // end of insertUpdate()

	@Override
	public void removeUpdate(DocumentEvent e) {
		System.out.println(e.getType().toString());		
	} // end of removeUpdate()

	@Override
	public void changedUpdate(DocumentEvent e) {
		System.out.println(e.getType().toString());
		
	} // end of changedUpdate()

} // end of class
