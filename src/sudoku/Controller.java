package sudoku;




/**
 * This class shows the difference between JFrame.pack() and JFrame.setSize(x,y)
 * These properties should be handled in a mutually exclusive way. 
 * @author Pauliman
 *
 */
public class Controller {

	public static void main(String[] args) {
		new Grid(800,800, "Fixed Size");
		new Grid("Packed");		
	} // end of main()

} // end of class
