package graph;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class fenetre extends JFrame {
	public static void main(String args[]) {
		try {
			fenetre frame = new fenetre();
			frame.setSize(200, 300);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
