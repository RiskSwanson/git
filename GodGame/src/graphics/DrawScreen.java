package graphics;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class DrawScreen {
	public static void main(String[] a) {
	  
		Dimension screenSize = getScreenSize();
		int width = (int)screenSize.getWidth();
		int height = (int)screenSize.getHeight();

		JFrame window = new JFrame();
		window.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		//window.setUndecorated(true);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().add(new Canvas());
		window.setVisible(true);
	}
	private static Dimension getScreenSize(){
		return Toolkit.getDefaultToolkit().getScreenSize();
	} 
	  
}