
import java.awt.event.WindowAdapter; 
import java.awt.event.WindowEvent;

import javax.swing.JFrame;


public class Frame extends JFrame {

	public Frame(String name) {
		super(name);

		WindowAdapter wa = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		};

		addWindowListener(wa);
		setVisible(true);
		setDefaultCloseOperation(Frame.DO_NOTHING_ON_CLOSE);
	}

}