import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
 
public class fen extends JFrame {
	mypanel pan = new mypanel();   
	JButton bouton = new JButton("Mon premier bouton");
	public static void main(String[] args)throws Exception{
		fen fen= new fen();
		}
	
	
	  public  fen() throws Exception {
		  this.setTitle("NY time RSS reader");
		    this.setSize(600, 300);
		    this.setLocationRelativeTo(null);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		    this.setContentPane(pan); 
		    this.setVisible(true);
		  }  

}
